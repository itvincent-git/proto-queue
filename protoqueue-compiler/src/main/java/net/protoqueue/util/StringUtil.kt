package net.protoqueue.util

/**
 *
 * Created by zhongyongsheng on 2018/4/16.
 */
object StringUtil {

    /**
     * 首字母最小化
     * @param string
     * @return
     */
    fun decapitalize(string: String?): String? {
        if (string == null || string.length == 0) {
            return string
        }
        val c = string.toCharArray()
        c[0] = Character.toLowerCase(c[0])
        return String(c)
    }

    //    public static String stripNonJava(String string) {
    //        Arrays.stream(string.split("[^a-zA-Z0-9]")).map(s -> s.trim()).join
    //    }
}
