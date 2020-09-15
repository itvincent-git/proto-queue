package net.protoqueue

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * 代理方式生成[ProtoQueue]单例
 * Created by zhongyongsheng on 2020/6/23.
 */
class ProtoQueueSingletonCreator<T : ProtoQueue<*, *>>(val sender: ProtoSender, val intercepter: ProtoIntercepter?) :
    ReadOnlyProperty<Any, T> {
    @Volatile
    private var _value: T? = null

    // final field is required to enable safe publication of constructed instance
    private val lock = this

    override fun getValue(thisRef: Any, property: KProperty<*>): T {
        val _v1 = _value
        if (_v1 !== null) {
            return _v1
        }

        return synchronized(lock) {
            val _v2 = _value
            if (_v2 !== null) {
                _v2
            } else {
                val typedValue = init(thisRef)
                _value = typedValue
                typedValue
            }
        }
    }

    //使用反射外部类型来创建对象
    private fun init(ref: Any): T {
        val outerClass = ref.javaClass.declaringClass
            ?: throw IllegalArgumentException("protoQueueCreator is not in ProtoQueue.Companion: ${ref.javaClass}")
        val implementation: T =
            getGeneratedImplementation(outerClass, IMPL_SUFFIX)
        implementation.init(sender, intercepter)
        return implementation
    }

    private fun <T> getGeneratedImplementation(cls: Class<*>, suffix: String): T {
        val fullPackage = cls.getPackage()?.name ?: throw RuntimeException("$cls package is null")
        val name = cls.canonicalName ?: throw RuntimeException("$cls canonicalName is null")
        val postPackageName =
            if (fullPackage.isEmpty()) name else name.substring(fullPackage.length + 1)
        val implName = postPackageName.replace('.', '_') + suffix
        return try {
            val aClass = Class.forName(
                if (fullPackage.isEmpty()) implName else "$fullPackage.$implName") as Class<T>
            aClass.newInstance()
        } catch (e: ClassNotFoundException) {
            throw RuntimeException("cannot find implementation for ${cls.canonicalName}.$implName does not exist")
        } catch (e: IllegalAccessException) {
            throw RuntimeException("Cannot access the constructor ${cls.canonicalName}")
        } catch (e: InstantiationException) {
            throw RuntimeException("Failed to create an instance of ${cls.canonicalName}")
        }
    }

    companion object {
        private const val IMPL_SUFFIX = "_Impl"
    }
}

/**
 * 更快捷的创建[ProtoQueue]的方法
 */
fun <T : ProtoQueue<*, *>> protoQueueCreator(sender: ProtoSender, intercepter: ProtoIntercepter? = null):
    ReadOnlyProperty<Any, T> =
    ProtoQueueSingletonCreator(sender, intercepter)