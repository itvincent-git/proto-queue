package net.protoqueue.rpc.gen.util

/**
 * 文件写入工具
 * Created by zhongyongsheng on 2019-11-14.
 */
class GenUtil {
    companion object {

        /**
         * 将带下划线的字符串改成驼峰式
         */
        fun underlineToHump(src: String): String {
            if (src.contains("_")) {
                var result = ""
                src.splitToSequence("_").forEachIndexed { index, s ->
                    result += if (index == 0) {
                        s
                    } else {
                        s.capitalize()
                    }
                }
                return result
            } else {
                return src
            }
        }
    }
}