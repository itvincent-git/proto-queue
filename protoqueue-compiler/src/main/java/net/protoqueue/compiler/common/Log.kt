package net.protoqueue.compiler.common

import javax.annotation.processing.Messager
import javax.lang.model.element.Element
import javax.tools.Diagnostic

/**
 * apt日志
 * Created by zhongyongsheng on 2018/4/14.
 */
class Log(private val messager: Messager) {

    fun debug(element: Element, msg: String, vararg args: Any) {
        messager.printMessage(Diagnostic.Kind.NOTE, safeFormat(msg, *args), element)
    }

    fun debug(msg: String, vararg args: Any) {
        messager.printMessage(Diagnostic.Kind.NOTE, safeFormat(msg, *args))
    }

    fun warn(element: Element, msg: String, vararg args: Any) {
        messager.printMessage(Diagnostic.Kind.WARNING, safeFormat(msg, *args), element)
    }

    fun warn(msg: String, vararg args: Any) {
        messager.printMessage(Diagnostic.Kind.WARNING, safeFormat(msg, *args))
    }

    fun error(element: Element, msg: String, vararg args: Any) {
        messager.printMessage(Diagnostic.Kind.ERROR, safeFormat(msg, *args), element)
    }

    fun error(msg: String, vararg args: Any) {
        messager.printMessage(Diagnostic.Kind.ERROR, safeFormat(msg, *args))
    }

    private fun safeFormat(msg: String, vararg args: Any): String {
        return try {
            String.format(msg, *args) + "\r\n" //加上日志才会能换行
        } catch (e: Exception) {
            msg
        }
    }
}
