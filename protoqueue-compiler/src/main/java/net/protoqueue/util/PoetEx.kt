package net.protoqueue.util

import com.squareup.kotlinpoet.BOOLEAN
import com.squareup.kotlinpoet.BYTE
import com.squareup.kotlinpoet.CHAR
import com.squareup.kotlinpoet.DOUBLE
import com.squareup.kotlinpoet.FLOAT
import com.squareup.kotlinpoet.INT
import com.squareup.kotlinpoet.LONG
import com.squareup.kotlinpoet.SHORT
import com.squareup.kotlinpoet.TypeName

/**
 * kotlinpoet的扩展
 * Created by zhongyongsheng on 2020/5/11.
 */

/**
 * 将java的基础封装类型，改为kt的封装类型
 */
fun TypeName.toKotlinPrimitiveType() = when (this.toString()) {
    java.lang.Byte::class.java.name -> BYTE
    java.lang.Integer::class.java.name -> INT
    java.lang.Long::class.java.name -> LONG
    java.lang.Boolean::class.java.name -> BOOLEAN
    java.lang.Short::class.java.name -> SHORT
    java.lang.Character::class.java.name -> CHAR
    java.lang.Float::class.java.name -> FLOAT
    java.lang.Double::class.java.name -> DOUBLE
    //todo Array
    else -> this
}