// Generate by protoqueue-rpc, don't edit this file please
package com.woohoo.app.common.protocol.nano

import com.woohoo.app.common.protocol.nano.WhSvcCommonKt.ResponseHeaderKt
import com.woohoo.app.common.protocol.nano.WhSvcTacit.Answer
import com.woohoo.app.common.protocol.nano.WhSvcTacit.AnswerReq
import com.woohoo.app.common.protocol.nano.WhSvcTacit.AnswerRes
import com.woohoo.app.common.protocol.nano.WhSvcTacit.FinishTacitNotifyInfo
import com.woohoo.app.common.protocol.nano.WhSvcTacit.GetTacitBasicInfoReq
import com.woohoo.app.common.protocol.nano.WhSvcTacit.GetTacitBasicInfoRes
import com.woohoo.app.common.protocol.nano.WhSvcTacit.NextQuestionNotifyInfo
import com.woohoo.app.common.protocol.nano.WhSvcTacit.Question
import com.woohoo.app.common.protocol.nano.WhSvcTacit.QuestionResult
import com.woohoo.app.common.protocol.nano.WhSvcTacit.StartTacitNotifyInfo
import com.woohoo.app.common.protocol.nano.WhSvcTacit.TacitTitleReq
import com.woohoo.app.common.protocol.nano.WhSvcTacit.TacitTitleRes
import com.woohoo.app.common.protocol.nano.WhSvcTacit.UserAnswer
import com.woohoo.app.common.protocol.nano.WhSvcTacit.UserAnswerNotifyInfo
import com.woohoo.app.common.protocol.nano.WhSvcTacitKt.AnswerKt
import com.woohoo.app.common.protocol.nano.WhSvcTacitKt.AnswerReqKt
import com.woohoo.app.common.protocol.nano.WhSvcTacitKt.AnswerResKt
import com.woohoo.app.common.protocol.nano.WhSvcTacitKt.FinishTacitNotifyInfoKt
import com.woohoo.app.common.protocol.nano.WhSvcTacitKt.GetTacitBasicInfoReqKt
import com.woohoo.app.common.protocol.nano.WhSvcTacitKt.GetTacitBasicInfoResKt
import com.woohoo.app.common.protocol.nano.WhSvcTacitKt.NextQuestionNotifyInfoKt
import com.woohoo.app.common.protocol.nano.WhSvcTacitKt.QuestionKt
import com.woohoo.app.common.protocol.nano.WhSvcTacitKt.QuestionResultKt
import com.woohoo.app.common.protocol.nano.WhSvcTacitKt.StartTacitNotifyInfoKt
import com.woohoo.app.common.protocol.nano.WhSvcTacitKt.TacitTitleReqKt
import com.woohoo.app.common.protocol.nano.WhSvcTacitKt.TacitTitleResKt
import com.woohoo.app.common.protocol.nano.WhSvcTacitKt.UserAnswerKt
import com.woohoo.app.common.protocol.nano.WhSvcTacitKt.UserAnswerNotifyInfoKt
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.MutableList
import kotlin.collections.mutableListOf

class WhSvcTacitKt {
    class AnswerReqKt(
        var roundId: String? = null,
        var questionId: Long? = null,
        var answerId: Long? = null,
        var questionOrder: Int? = null
    ) {
        fun convertToMessage(): AnswerReq {
            val message = AnswerReq()
            message.roundId = roundId
            message.questionId = questionId ?: 0L
            message.answerId = answerId ?: 0L
            message.questionOrder = questionOrder ?: 0
            return message
        }
    }

    class AnswerResKt(
        var header: ResponseHeaderKt? = null
    ) {
        fun convertToMessage(): AnswerRes {
            val message = AnswerRes()
            message.header = header?.convertToMessage()
            return message
        }
    }

    class TacitTitleReqKt(
        var targetUid: Long? = null
    ) {
        fun convertToMessage(): TacitTitleReq {
            val message = TacitTitleReq()
            message.targetUid = targetUid ?: 0L
            return message
        }
    }

    class TacitTitleResKt(
        var header: ResponseHeaderKt? = null,
        var matchDegree: Long? = null,
        var title: String? = null
    ) {
        fun convertToMessage(): TacitTitleRes {
            val message = TacitTitleRes()
            message.header = header?.convertToMessage()
            message.matchDegree = matchDegree ?: 0L
            message.title = title
            return message
        }
    }

    class GetTacitBasicInfoReqKt(
        var roundId: String? = null
    ) {
        fun convertToMessage(): GetTacitBasicInfoReq {
            val message = GetTacitBasicInfoReq()
            message.roundId = roundId
            return message
        }
    }

    class GetTacitBasicInfoResKt(
        var header: ResponseHeaderKt? = null,
        var roundId: String? = null,
        var questionCount: Int? = null
    ) {
        fun convertToMessage(): GetTacitBasicInfoRes {
            val message = GetTacitBasicInfoRes()
            message.header = header?.convertToMessage()
            message.roundId = roundId
            message.questionCount = questionCount ?: 0
            return message
        }
    }

    class QuestionKt(
        var questionId: Long? = null,
        var questionOrder: Int? = null,
        var remainMs: Int? = null,
        var type: Int? = null,
        var content: String? = null,
        var answers: MutableList<AnswerKt> = mutableListOf()
    ) {
        fun convertToMessage(): Question {
            val message = Question()
            message.questionId = questionId ?: 0L
            message.questionOrder = questionOrder ?: 0
            message.remainMs = remainMs ?: 0
            message.type = type ?: 0
            message.content = content
            message.answers = answers.map { it.convertToMessage() }.toTypedArray()
            return message
        }
    }

    class AnswerKt(
        var answerId: Long? = null,
        var content: String? = null
    ) {
        fun convertToMessage(): Answer {
            val message = Answer()
            message.answerId = answerId ?: 0L
            message.content = content
            return message
        }
    }

    class UserAnswerKt(
        var uid: Long? = null,
        var answerId: Long? = null
    ) {
        fun convertToMessage(): UserAnswer {
            val message = UserAnswer()
            message.uid = uid ?: 0L
            message.answerId = answerId ?: 0L
            return message
        }
    }

    class QuestionResultKt(
        var questionId: Long? = null,
        var userAnswers: MutableList<UserAnswerKt> = mutableListOf(),
        var showMs: Long? = null,
        var questionOrder: Int? = null
    ) {
        fun convertToMessage(): QuestionResult {
            val message = QuestionResult()
            message.questionId = questionId ?: 0L
            message.userAnswers = userAnswers.map { it.convertToMessage() }.toTypedArray()
            message.showMs = showMs ?: 0L
            message.questionOrder = questionOrder ?: 0
            return message
        }
    }

    class StartTacitNotifyInfoKt(
        var roundId: String? = null,
        var questionCount: Int? = null,
        var question: QuestionKt? = null
    ) {
        fun convertToMessage(): StartTacitNotifyInfo {
            val message = StartTacitNotifyInfo()
            message.roundId = roundId
            message.questionCount = questionCount ?: 0
            message.question = question?.convertToMessage()
            return message
        }
    }

    class NextQuestionNotifyInfoKt(
        var roundId: String? = null,
        var preQuestionResult: QuestionResultKt? = null,
        var nextQuestion: QuestionKt? = null
    ) {
        fun convertToMessage(): NextQuestionNotifyInfo {
            val message = NextQuestionNotifyInfo()
            message.roundId = roundId
            message.preQuestionResult = preQuestionResult?.convertToMessage()
            message.nextQuestion = nextQuestion?.convertToMessage()
            return message
        }
    }

    class UserAnswerNotifyInfoKt(
        var roundId: String? = null,
        var questionId: Long? = null,
        var uid: Long? = null
    ) {
        fun convertToMessage(): UserAnswerNotifyInfo {
            val message = UserAnswerNotifyInfo()
            message.roundId = roundId
            message.questionId = questionId ?: 0L
            message.uid = uid ?: 0L
            return message
        }
    }

    class FinishTacitNotifyInfoKt(
        var roundId: String? = null,
        var matchDegree: Long? = null,
        var title: String? = null
    ) {
        fun convertToMessage(): FinishTacitNotifyInfo {
            val message = FinishTacitNotifyInfo()
            message.roundId = roundId
            message.matchDegree = matchDegree ?: 0L
            message.title = title
            return message
        }
    }

    interface QuestionTypeKt {
        companion object {
            val Unknown: Int = 0

            val TEXT: Int = 1

            val IMG: Int = 2
        }
    }
}

fun AnswerReq.convertToDataObject(): AnswerReqKt {
    val o = AnswerReqKt()
    o.roundId = roundId
    o.questionId = questionId
    o.answerId = answerId
    o.questionOrder = questionOrder
    return o
}

fun AnswerRes.convertToDataObject(): AnswerResKt {
    val o = AnswerResKt()
    o.header = header?.convertToDataObject()
    return o
}

fun TacitTitleReq.convertToDataObject(): TacitTitleReqKt {
    val o = TacitTitleReqKt()
    o.targetUid = targetUid
    return o
}

fun TacitTitleRes.convertToDataObject(): TacitTitleResKt {
    val o = TacitTitleResKt()
    o.header = header?.convertToDataObject()
    o.matchDegree = matchDegree
    o.title = title
    return o
}

fun GetTacitBasicInfoReq.convertToDataObject(): GetTacitBasicInfoReqKt {
    val o = GetTacitBasicInfoReqKt()
    o.roundId = roundId
    return o
}

fun GetTacitBasicInfoRes.convertToDataObject(): GetTacitBasicInfoResKt {
    val o = GetTacitBasicInfoResKt()
    o.header = header?.convertToDataObject()
    o.roundId = roundId
    o.questionCount = questionCount
    return o
}

fun Question.convertToDataObject(): QuestionKt {
    val o = QuestionKt()
    o.questionId = questionId
    o.questionOrder = questionOrder
    o.remainMs = remainMs
    o.type = type
    o.content = content
    o.answers = answers.mapTo(ArrayList(answers.size)) { it.convertToDataObject() }
    return o
}

fun Answer.convertToDataObject(): AnswerKt {
    val o = AnswerKt()
    o.answerId = answerId
    o.content = content
    return o
}

fun UserAnswer.convertToDataObject(): UserAnswerKt {
    val o = UserAnswerKt()
    o.uid = uid
    o.answerId = answerId
    return o
}

fun QuestionResult.convertToDataObject(): QuestionResultKt {
    val o = QuestionResultKt()
    o.questionId = questionId
    o.userAnswers = userAnswers.mapTo(ArrayList(userAnswers.size)) { it.convertToDataObject() }
    o.showMs = showMs
    o.questionOrder = questionOrder
    return o
}

fun StartTacitNotifyInfo.convertToDataObject(): StartTacitNotifyInfoKt {
    val o = StartTacitNotifyInfoKt()
    o.roundId = roundId
    o.questionCount = questionCount
    o.question = question?.convertToDataObject()
    return o
}

fun NextQuestionNotifyInfo.convertToDataObject(): NextQuestionNotifyInfoKt {
    val o = NextQuestionNotifyInfoKt()
    o.roundId = roundId
    o.preQuestionResult = preQuestionResult?.convertToDataObject()
    o.nextQuestion = nextQuestion?.convertToDataObject()
    return o
}

fun UserAnswerNotifyInfo.convertToDataObject(): UserAnswerNotifyInfoKt {
    val o = UserAnswerNotifyInfoKt()
    o.roundId = roundId
    o.questionId = questionId
    o.uid = uid
    return o
}

fun FinishTacitNotifyInfo.convertToDataObject(): FinishTacitNotifyInfoKt {
    val o = FinishTacitNotifyInfoKt()
    o.roundId = roundId
    o.matchDegree = matchDegree
    o.title = title
    return o
}
