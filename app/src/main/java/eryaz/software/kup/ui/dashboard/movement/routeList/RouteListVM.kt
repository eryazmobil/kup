package eryaz.software.kup.ui.dashboard.movement.routeList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import eryaz.software.kup.R
import eryaz.software.kup.data.api.utils.onError
import eryaz.software.kup.data.api.utils.onSuccess
import eryaz.software.kup.data.models.dto.RouteDto
import eryaz.software.kup.data.models.dto.WarningDialogDto
import eryaz.software.kup.data.persistence.SessionManager
import eryaz.software.kup.data.repositories.OrderRepo
import eryaz.software.kup.ui.base.BaseViewModel

class RouteListVM(private val repo: OrderRepo) : BaseViewModel() {

    private val _routeList = MutableLiveData<List<RouteDto?>>(emptyList())
    val routeList: LiveData<List<RouteDto?>> = _routeList

    val search = MutableLiveData("")

    fun searchList() = search.switchMap { query ->
        MutableLiveData<List<RouteDto?>>().apply {
            value = filterData(query)
        }
    }

    private fun filterData(query: String): List<RouteDto?> {
        val dataList = _routeList.value.orEmpty()

        val filteredList = dataList.filter { data ->
            data?.code?.contains(query, ignoreCase = true) ?: true
        }
        return filteredList
    }

    fun fetchRouteList() {
        executeInBackground(_uiState) {
            repo.getRouteList(
                SessionManager.warehouseId
            ).onSuccess {
                if (it.isEmpty()) {
                    _routeList.value = emptyList()
                    showWarning(
                        WarningDialogDto(
                            title = stringProvider.invoke(R.string.route_not_founded),
                            message = stringProvider.invoke(R.string.list_is_empty)
                        )
                    )
                }
                _routeList.value = it

            }.onError { _, _ ->
                _routeList.value = emptyList()

            }
        }
    }
}