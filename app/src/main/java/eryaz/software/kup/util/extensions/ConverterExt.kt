package eryaz.software.kup.util.extensions

import eryaz.software.kup.R
import eryaz.software.kup.data.enums.LanguageType

fun LanguageType.getDrawableRes() = when (this) {
    LanguageType.AZ -> R.drawable.ic_az
    LanguageType.EN -> R.drawable.ic_en
    LanguageType.RU -> R.drawable.ic_ru
    LanguageType.AR -> R.drawable.ic_ar
    LanguageType.TR -> R.drawable.ic_tr
}
