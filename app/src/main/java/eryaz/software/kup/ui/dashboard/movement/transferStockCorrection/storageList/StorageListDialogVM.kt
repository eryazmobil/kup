package eryaz.software.kup.ui.dashboard.movement.transferStockCorrection.storageList

import eryaz.software.kup.data.api.utils.onSuccess
import eryaz.software.kup.data.models.dto.StorageDto
import eryaz.software.kup.data.persistence.SessionManager
import eryaz.software.kup.data.repositories.UserRepo
import eryaz.software.kup.ui.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class StorageListDialogVM(
    private val userRepo: UserRepo,
) : BaseViewModel() {

    private val _storageList = MutableStateFlow(listOf<StorageDto>())
    val storageList = _storageList.asStateFlow()

    init {
        getStorageListByWarehouse()
    }

    fun getStorageListByWarehouse() = executeInBackground(_uiState) {
        userRepo.getStorageListByWarehouse(
            warehouseId = SessionManager.warehouseId
        ).onSuccess {
            _storageList.emit(it)
        }
    }
}