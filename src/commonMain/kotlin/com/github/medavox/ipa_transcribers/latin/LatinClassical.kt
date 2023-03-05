package com.github.medavox.ipa_transcribers.latin;

import com.github.medavox.ipa_transcribers.CompletionStatus
import com.github.medavox.ipa_transcribers.RuleBasedTranscriber;
import com.github.medavox.ipa_transcribers.latin.LatinScriptCommonalities;
/**
 * Classical Latin has a relatively consistent spelling system that can be used to extract pronunciation with a fairly
 * high degree of certainty. This particular transcriber will be based on the reconstruction as proposed by Dr. Andrea
 * Calabrese. The main difference between this and the W. Sidney Allen reconstruction is the vowel system. The former
 * does not have lax and tense vowel distinction, while the latter does. See paper for more info:
 * https://drive.google.com/file/d/1xA73h_R647YZf7fp8saeRAP68x6qHa2U/view
 *
 * This transcriber will use macrons to mark long vowels and maintain a distinction between /w/ and /v/ with <v>
 * and <u>, and /j/ and /i/ with <j> and <i>.
 */
object LatinClassical: RuleBasedTranscriber() {
    override val completionStatus: CompletionStatus
        get() = TODO("Not yet implemented")

    override fun transcribe(nativeText: String): String {
        TODO("Not yet implemented")
    }

}