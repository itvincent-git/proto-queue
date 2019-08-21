package net.protoqueue.rpc.desc

import com.google.protobuf.DescriptorProtos
import java.lang.StringBuilder

/**
 *
 *
 *
 * @author linmin1 on 2019-08-20.
 *
 */
object DescUtil {
    /**
     * 获取默认类名
     */
    fun getClassNameFromFdpName(fdpName: String): String {
        val name = fdpName.replace(".proto", "")
        val result = StringBuilder()
        val a = name.split("_".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        for (s in a) {
            if (!name.contains("_")) {
                result.append(s)
                continue
            }
            result.append(s.substring(0, 1).toUpperCase())
            result.append(s.substring(1).toLowerCase())
        }
        return result.toString()
    }
}

public fun DescriptorProtos.FileDescriptorProto.readPackageName(): String {
    return if (this.options.hasJavaPackage()) {
        this.options.javaPackage
    } else {
        this.`package`
    } + ".nano"
}

fun DescriptorProtos.FileDescriptorProto.readOutClassName(): String {
    return if (this.options.hasJavaOuterClassname()) {
        this.options.javaOuterClassname
    } else {
        DescUtil.getClassNameFromFdpName(this.name)
    }
}