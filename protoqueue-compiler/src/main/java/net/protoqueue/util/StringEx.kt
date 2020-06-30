package net.protoqueue.util

import java.util.regex.Pattern

/**
 * 字符串扩展
 * Created by zhongyongsheng on 2020/6/30.
 */
/**
 * 寻找子串出现的次数
 */
fun CharSequence.findSubStringCount(subString: CharSequence): Int {
    val pattern = Pattern.compile(subString.toString())
    val matcher = pattern.matcher(this)
    var count = 0
    while (matcher.find()) {
        count++
    }
    return count
}