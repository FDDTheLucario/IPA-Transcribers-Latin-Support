package com.github.medavox.ipa_transcribers.latin;

import com.github.medavox.ipa_transcribers.*
import com.github.medavox.ipa_transcribers.latin.LatinScriptCommonalities;
import com.github.medavox.ipa_transcribers.latin.LatinScriptCommonalities.latinBaseRules
import com.github.medavox.ipa_transcribers.latin.SpanishPeninsular.processWithRules

/**
 * Classical Latin has a relatively consistent spelling system that can be used to extract pronunciation with a fairly
 * high degree of certainty. This particular transcriber will be based on the reconstruction as proposed by Dr. Andrea
 * Calabrese. The main difference between this and the W. Sidney Allen reconstruction is the vowel system. The former
 * does not have lax and tense vowel distinction, while the latter does. See paper for more info:
 * https://drive.google.com/file/d/1xA73h_R647YZf7fp8saeRAP68x6qHa2U/view
 *
 * This transcriber will use macrons to mark long vowels and maintain a distinction between /w/ and /v/ with v
 * and u, and /j/ and /i/ with j and i.
 *
 * When there is a Greek loanword with chi, theta, or phi, this will use the educated aspirate sounds.
 */
object LatinClassical: RuleBasedTranscriber() {

    val alphabet = "aābcdeēfghiījlmnoōpqrstuūvxyȳz";

    const val unvoicedConsonants = "pthcgsf";
    const val voicedConsonants = "bdgzmnqpr";
    const val consonants = unvoicedConsonants + voicedConsonants;

    const val shortVowels = "aeiouy";
    const val longVowels = "āēīōūȳ";
    const val vowels = shortVowels + longVowels;


    override val completionStatus: CompletionStatus = CompletionStatus.IN_PROGRESS;

    val rules = listOf<IRule>(
        // greek loan specifics
        Rule("ch[${vowels}]","kʰ", 2),
        Rule("ph[${vowels}]", "pʰ", 2),
        Rule("th[${vowels}]", "tʰ", 2),
        Rule("z", "z̠ː", 1),

        // the s in latin is always retracted
        Rule("s", "s̠", 1),

        // short vowels
        Rule("e", "e̝", 1),
        Rule("o", "o̝", 1),
        Rule("y", "y", 1),
        // long vowels
        Rule("ā", "aː", 1),
        Rule("ē", "e̝ː", 1),
        Rule("ī", "iː", 1),
        Rule("ō", "o̝ː", 1),
        Rule("ū", "uː", 1),
        Rule("ȳ", "yː", 1),

        // digraphs
        Rule("gn", "ŋn", 2),

        Rule("r", "ɾ", 1),
        // geminated consonants
        Rule("rr", "rː", 2),
        Rule("ll", "lː", 2),
        Rule("cc", "kː", 2),
        Rule("mm", "mː", 2),
        Rule("nn", "nː", 2),
        Rule("dd", "tː", 2),
        Rule("gg", "gː", 2),
        Rule("tt", "tː", 2),
        Rule("ff", "fː", 2),
        Rule("pp", "pː", 2),
        Rule("ss", "s̠ː", 2),

        // nasalize final m
        Rule("[${vowels}]m\\b", "\$1̃"),
        Rule("x", "ks̠", 1),

        // diphthongs

        Rule("ae", "ae̝̯", 2),
        Rule("au", "au̯", 2),
        Rule("oe", "o̝e̝̯", 2),

        // r == rr when word initial
        LookbackRule("r", "^r", "rː", 1),

    ) + latinBaseRules.filter { with(it.unconsumedMatcher) {
        this != Regex("k") &&
        this != Regex("w") &&
        this != Regex("v")
    } };

     override fun transcribe(nativeText: String): String {
        return nativeText.lowercase().processWithRules(rules, reportAndSkip);
    }
}