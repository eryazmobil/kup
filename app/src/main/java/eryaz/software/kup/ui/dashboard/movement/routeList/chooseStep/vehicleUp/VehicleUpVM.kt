package eryaz.software.kup.ui.dashboard.movement.routeList.chooseStep.vehicleUp

import eryaz.software.kup.R
import eryaz.software.kup.data.api.utils.onError
import eryaz.software.kup.data.api.utils.onSuccess
import eryaz.software.kup.data.models.dto.ErrorDialogDto
import eryaz.software.kup.data.models.dto.VehiclePackageDto
import eryaz.software.kup.data.repositories.OrderRepo
import eryaz.software.kup.ui.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class VehicleUpVM(
    val repo: OrderRepo,
    val vehicleID: Int,
    val routeID: Int
) : BaseViewModel() {

    private val _packageList = MutableStateFlow(listOf<VehiclePackageDto>())
    val packageList = _packageList.asStateFlow()

    val packageCode = MutableStateFlow("")
    val deliveredNameTxt = MutableStateFlow("")
    val vehicleDownSuccess = MutableStateFlow(false)

    init {
        getOrderHeaderRouteList()
    }

    fun createOrderHeaderRoute() {
        executeInBackground {
            repo.updateOrderHeaderRoute(
                code = packageCode.value,
                shippingRouteId = routeID,
                deliveredPerson = deliveredNameTxt.value
            ).onSuccess {
                vehicleDownSuccess.emit(true)
                getOrderHeaderRouteList()
            }.onError { message, _ ->
                ErrorDialogDto(
                    title = stringProvider.invoke(R.string.error),
                    message = message
                )
            }.also {
                packageCode.emit("")
                deliveredNameTxt.emit("")
            }
        }
    }

    fun getOrderHeaderRouteList() {
        executeInBackground(showProgressDialog = true) {
            repo.getOrderHeaderRouteList(
                shippingRouteId = routeID
            ).onSuccess {
                if (it.isNotEmpty()) {
                    _packageList.emit(it)
                }
            }
        }
    }
}