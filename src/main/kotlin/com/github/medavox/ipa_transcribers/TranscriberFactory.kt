package com.github.medavox.ipa_transcribers

import com.github.medavox.ipa_transcribers.spanish.SpanishIpaRuleBased

/**Provides instances that each transcribe a specific language and orthography to IPA.*/
object TranscriberFactory {

    /**Get an [IpaTranscriber] instance for the specified language.
     * @param language the language to get an [IpaTranscriber] instance for.
     * If there is no [IpaTranscriber] implementation available for the specified language,
     * A dummy implementation is returned which only returns empty sets.*/
    fun getTranscriberForLang(language: Language): IpaTranscriber {
        return when(language) {
            Language.English -> EnglishIpaCambridge()
            Language.Spanish -> SpanishIpaRuleBased()
            else -> UselessDefaultIpaTranscriber()
        }
    }
    private class UselessDefaultIpaTranscriber: IpaTranscriber {
        override fun transcribeToIpa(nativeText: String): Set<Variant> {
            return setOf()
        }
    }
}