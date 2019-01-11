package com.github.medavox.ipa

import com.github.medavox.ipa.Manner.*
import com.github.medavox.ipa.Place.*

enum class Manner {
    STOP_PLOSIVE,
    NASAL,
    FRICATIVE,
    APPROXIMANT,
    TAP_OR_FLAP,
    TRILL,
    LATERAL_FRICATIVE,
    LATERAL_APPROXIMANT,
    LATERAL_TAP_FLAP,
}

enum class Place {
    //labial
    BILABIAL,
    LABIODENTAL,

    //coronal
    DENTAL,
    ALVEOLAR,
    POST_ALVEOLAR,
    RETROFLEX,

    //dorsal
    PALATAL,
    VELAR,
    UVULAR,

    //laryngeal
    PHARYNGEAL_EPIGLOTTAL,
    GLOTTAL
}

/**Only place-manner articulations represented by a single symbol are listed here.
 * articulations which require a diacritic to describe (eg voiceless bilabial nasal, ̥m)
 * may be constructed using these plus the appropriate diacritic.
 *
 * todo: have an optional array of diacritics used, and include these diacritic-combos*/
enum class PulmonicConsonants(ipaSymbol:String,
                              placeOfArticulation:Place,
                              mannerOfArticulation:Manner,
                              voiced:Boolean=false) {
    //not all of these combinations are valid consonants

    //TODO: encode sounds judged impossible-to-produce.
    // All others may be written using a combination of a symbol below & some diacritic mark(s)

    //BILABIALS
    //=========
    VOICELESS_BILABIAL_STOP_PLOSIVE("p", BILABIAL, STOP_PLOSIVE, false),
    VOICED_BILABIAL_STOP_PLOSIVE("b", BILABIAL, STOP_PLOSIVE, true),


    //VOICELESS_BILABIAL_NASAL("̥m", BILABIAL, NASAL),
    VOICED_BILABIAL_NASAL("m", BILABIAL, NASAL, true),

    VOICELESS_BILABIAL_FRICATIVE("ɸ", BILABIAL, FRICATIVE),
    VOICED_BILABIAL_FRICATIVE("β", BILABIAL, FRICATIVE, true),

    //these are blank on the IPA chart; maybe they can be represented using an existing character + a diacritic?
    //VOICELESS_BILABIAL_APPROXIMANT("", BILABIAL, APPROXIMANT),
    //VOICED_BILABIAL_APPROXIMANT("", BILABIAL, APPROXIMANT, true),

    //VOICELESS_BILABIAL_TAP_OR_FLAP("", BILABIAL, TAP_OR_FLAP),
    //VOICED_BILABIAL_TAP_OR_FLAP("", BILABIAL, TAP_OR_FLAP, true),

    //VOICELESS_BILABIAL_TRILL("̥ʙ", BILABIAL, TRILL),
    VOICED_BILABIAL_TRILL("ʙ", BILABIAL, TRILL, true),

    //judged to be impossible
    //VOICELESS_BILABIAL_LATERAL_FRICATIVE("", BILABIAL, LATERAL_FRICATIVE),
    //VOICED_BILABIAL_LATERAL_FRICATIVE("", BILABIAL, LATERAL_FRICATIVE, true),

    //VOICELESS_BILABIAL_LATERAL_APPROXIMANT("", BILABIAL, LATERAL_APPROXIMANT),
    //VOICED_BILABIAL_LATERAL_APPROXIMANT("", BILABIAL, LATERAL_APPROXIMANT, true),

    //VOICELESS_BILABIAL_LATERAL_TAP_FLAP("", BILABIAL, LATERAL_TAP_FLAP),
    //VOICED_BILABIAL_LATERAL_TAP_FLAP("", BILABIAL, LATERAL_TAP_FLAP, true),

    //LABIO-DENTALS
    //=============
    //VOICELESS_LABIODENTAL_STOP_PLOSIVE("̪p", LABIODENTAL, STOP_PLOSIVE),
    //VOICED_LABIODENTAL_STOP_PLOSIVE("̪b", LABIODENTAL, STOP_PLOSIVE, true),

    //VOICELESS_LABIODENTAL_NASAL("", LABIODENTAL, NASAL),//blank
    VOICED_LABIODENTAL_NASAL("ɱ", LABIODENTAL, NASAL, true),

    VOICELESS_LABIODENTAL_FRICATIVE("f", LABIODENTAL, FRICATIVE),
    VOICED_LABIODENTAL_FRICATIVE("v", LABIODENTAL, FRICATIVE, true),

    VOICELESS_LABIODENTAL_APPROXIMANT("̥ʋ", LABIODENTAL, APPROXIMANT),
    VOICED_LABIODENTAL_APPROXIMANT("ʋ", LABIODENTAL, APPROXIMANT, true),

    //VOICELESS_LABIODENTAL_TAP_OR_FLAP("", LABIODENTAL, TAP_OR_FLAP),//blank
    VOICED_LABIODENTAL_TAP_OR_FLAP("ⱱ", LABIODENTAL, TAP_OR_FLAP, true),

    //blank on IPA chart
    //VOICELESS_LABIODENTAL_TRILL("", LABIODENTAL, TRILL),
    //VOICED_LABIODENTAL_TRILL("", LABIODENTAL, TRILL, true),

    //judged to be impossible
    //VOICELESS_LABIODENTAL_LATERAL_FRICATIVE("", LABIODENTAL, LATERAL_FRICATIVE),
    //VOICED_LABIODENTAL_LATERAL_FRICATIVE("", LABIODENTAL, LATERAL_FRICATIVE, true),

    //VOICELESS_LABIODENTAL_LATERAL_APPROXIMANT("", LABIODENTAL, LATERAL_APPROXIMANT),
    //VOICED_LABIODENTAL_LATERAL_APPROXIMANT("", LABIODENTAL, LATERAL_APPROXIMANT, true),

    //VOICELESS_LABIO_DENTAL_LATERAL_TAP_FLAP("", LABIODENTAL, LATERAL_TAP_FLAP),
    //VOICED_LABIO_DENTAL_LATERAL_TAP_FLAP("", LABIODENTAL, LATERAL_TAP_FLAP, true),

    VOICELESS_DENTAL_FRICATIVE("θ", DENTAL, FRICATIVE),
    VOICED_DENTAL_FRICATIVE("ð", DENTAL, FRICATIVE, true),

    //ALVEOLARS
    //=========
    VOICELESS_ALVEOLAR_STOP_PLOSIVE("t", ALVEOLAR, STOP_PLOSIVE),
    VOICED_ALVEOLAR_STOP_PLOSIVE("d", ALVEOLAR, STOP_PLOSIVE, true),

    VOICED_ALVEOLAR_NASAL("n", ALVEOLAR, NASAL, true),

    VOICELESS_ALVEOLAR_FRICATIVE("s", ALVEOLAR, FRICATIVE),
    VOICED_ALVEOLAR_FRICATIVE("z", ALVEOLAR, FRICATIVE, true),

    VOICED_ALVEOLAR_APPROXIMANT("ɹ", ALVEOLAR, APPROXIMANT, true),

    VOICED_ALVEOLAR_TAP_OR_FLAP("ɾ", ALVEOLAR, TAP_OR_FLAP, true),

    VOICED_ALVEOLAR_TRILL("r", ALVEOLAR, TRILL, true),

    VOICELESS_ALVEOLAR_LATERAL_FRICATIVE("ɬ", ALVEOLAR, LATERAL_FRICATIVE),
    VOICED_ALVEOLAR_LATERAL_FRICATIVE("ɮ", ALVEOLAR, LATERAL_FRICATIVE, true),

    VOICED_ALVEOLAR_LATERAL_APPROXIMANT("l", ALVEOLAR, LATERAL_APPROXIMANT, true),

    VOICED_ALVEOLAR_LATERAL_TAP_FLAP("ɺ", ALVEOLAR, LATERAL_TAP_FLAP, true),

    //POST-ALVEOLARS
    //==============
    VOICELESS_POST_ALVEOLAR_FRICATIVE("ʃ", POST_ALVEOLAR, FRICATIVE),
    VOICED_POST_ALVEOLAR_FRICATIVE("ʒ", POST_ALVEOLAR, FRICATIVE, true),

    //RETROFLEXES
    //===========
    VOICELESS_RETROFLEX_STOP_PLOSIVE("ʈ", RETROFLEX, STOP_PLOSIVE),
    VOICED_RETROFLEX_STOP_PLOSIVE("ɖ", RETROFLEX, STOP_PLOSIVE, true),

    VOICED_RETROFLEX_NASAL("ɳ", RETROFLEX, NASAL, true),

    VOICELESS_RETROFLEX_FRICATIVE("ʂ", RETROFLEX, FRICATIVE),
    VOICED_RETROFLEX_FRICATIVE("ʐ", RETROFLEX, FRICATIVE, true),

    VOICED_RETROFLEX_APPROXIMANT("ɻ", RETROFLEX, APPROXIMANT, true),

    VOICED_RETROFLEX_TAP_OR_FLAP("ɽ", RETROFLEX, TAP_OR_FLAP, true),

    //VOICELESS_RETROFLEX_TRILL("", RETROFLEX, TRILL),//blank
    //VOICED_RETROFLEX_TRILL("", RETROFLEX, TRILL, true),//blank

    //blank
    //VOICELESS_RETROFLEX_LATERAL_FRICATIVE("", RETROFLEX, LATERAL_FRICATIVE),
    //VOICED_RETROFLEX_LATERAL_FRICATIVE("", RETROFLEX, LATERAL_FRICATIVE, true),

    VOICED_RETROFLEX_LATERAL_APPROXIMANT("ɭ", RETROFLEX, LATERAL_APPROXIMANT, true),

    //PALATALS
    //========
    VOICELESS_PALATAL_STOP_PLOSIVE("c", PALATAL, STOP_PLOSIVE),
    VOICED_PALATAL_STOP_PLOSIVE("ɟ", PALATAL, STOP_PLOSIVE, true),

    VOICED_PALATAL_NASAL("ɲ", PALATAL, NASAL, true),

    VOICELESS_PALATAL_FRICATIVE("ç", PALATAL, FRICATIVE),
    VOICED_PALATAL_FRICATIVE("ʝ", PALATAL, FRICATIVE, true),

    VOICED_PALATAL_APPROXIMANT("j", PALATAL, APPROXIMANT, true),

    VOICED_PALATAL_LATERAL_APPROXIMANT("ʎ", PALATAL, LATERAL_APPROXIMANT, true),

    //VELARS
    //======
    VOICELESS_VELAR_STOP_PLOSIVE("k", VELAR, STOP_PLOSIVE),
    VOICED_VELAR_STOP_PLOSIVE("ɡ", VELAR, STOP_PLOSIVE, true),

    VOICED_VELAR_NASAL("ŋ", VELAR, NASAL, true),

    VOICELESS_VELAR_FRICATIVE("x", VELAR, FRICATIVE),
    VOICED_VELAR_FRICATIVE("ɣ", VELAR, FRICATIVE, true),

    VOICED_VELAR_APPROXIMANT("ɰ", VELAR, APPROXIMANT, true),

    VOICED_VELAR_LATERAL_APPROXIMANT("ʟ", VELAR, LATERAL_APPROXIMANT, true),

    //UVULARS
    //=======
    VOICELESS_UVULAR_STOP_PLOSIVE("q", UVULAR, STOP_PLOSIVE),
    VOICED_UVULAR_STOP_PLOSIVE("ɢ", UVULAR, STOP_PLOSIVE, true),

    VOICED_UVULAR_NASAL("ɴ", UVULAR, NASAL, true),

    VOICELESS_UVULAR_FRICATIVE("χ", UVULAR, FRICATIVE),
    VOICED_UVULAR_FRICATIVE("ʁ", UVULAR, FRICATIVE, true),

    VOICED_UVULAR_TRILL("ʀ", UVULAR, TRILL, true),

    //PHARYNGEALS/EPIGLOTTALS
    //=======================
    VOICELESS_PHARYNGEAL_EPIGLOTTAL_STOP_PLOSIVE("ʡ", PHARYNGEAL_EPIGLOTTAL, STOP_PLOSIVE),

    VOICELESS_PHARYNGEAL_EPIGLOTTAL_FRICATIVE("ħ", PHARYNGEAL_EPIGLOTTAL, FRICATIVE),
    VOICED_PHARYNGEAL_EPIGLOTTAL_FRICATIVE("ʕ", PHARYNGEAL_EPIGLOTTAL, FRICATIVE, true),

    VOICELESS_PHARYNGEAL_EPIGLOTTAL_TRILL("ʜ", PHARYNGEAL_EPIGLOTTAL, TRILL),
    VOICED_PHARYNGEAL_EPIGLOTTAL_TRILL("ʢ", PHARYNGEAL_EPIGLOTTAL, TRILL, true),

    //GLOTTALS
    //========
    VOICELESS_GLOTTAL_STOP_PLOSIVE("ʔ", GLOTTAL, STOP_PLOSIVE),

    VOICELESS_GLOTTAL_FRICATIVE("h", GLOTTAL, FRICATIVE),
    VOICED_GLOTTAL_FRICATIVE("ɦ", GLOTTAL, FRICATIVE, true),
}