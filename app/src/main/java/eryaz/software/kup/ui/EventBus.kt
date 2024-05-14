package eryaz.software.kup.ui

import eryaz.software.kup.util.SingleLiveEvent

object EventBus {
    val navigateToSplash = SingleLiveEvent<Boolean>()
}
