package eryaz.software.kup.ui.dashboard.settings.changePassword

import androidx.lifecycle.LiveData
import eryaz.software.kup.data.api.utils.onSuccess
import eryaz.software.kup.data.models.remote.request.ChangePasswordRequest
import eryaz.software.kup.data.repositories.UserRepo
import eryaz.software.kup.ui.base.BaseViewModel
import eryaz.software.kup.util.CombinedStateFlow
import eryaz.software.kup.util.SingleLiveEvent
import eryaz.software.kup.util.extensions.isValidPassword
import kotlinx.coroutines.flow.MutableStateFlow

class ChangePasswordVM (private val repo: UserRepo) : BaseViewModel() {

    val oldPassword = MutableStateFlow("")
    val newPassword = MutableStateFlow("")
    val againPassword = MutableStateFlow("")

    private val _wasChangePassword = SingleLiveEvent<Boolean>()
    val wasChangedPassword: LiveData<Boolean> = _wasChangePassword

    val loginEnable = CombinedStateFlow(oldPassword, newPassword, againPassword) {
        oldPassword.value.isValidPassword() && newPassword.value.isValidPassword()
                && againPassword.value.isValidPassword()
    }

    val passwordMatching = CombinedStateFlow(newPassword, againPassword) {
        newPassword.value == againPassword.value
    }

    fun changePassword() = executeInBackground() {
        val request = ChangePasswordRequest(
            oldPassword = oldPassword.value,
            newPassword = newPassword.value
        )
        repo.changePassword(request).onSuccess {
            _wasChangePassword.value = true
        }
    }


}
