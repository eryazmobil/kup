package eryaz.software.kup.util.adapter.dashboard.viewHolders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import eryaz.software.kup.data.models.dto.DashboardDetailItemDto
import eryaz.software.kup.databinding.ItemDashboardDetailListBinding
import eryaz.software.kup.util.bindingAdapter.setOnSingleClickListener
import eryaz.software.kup.util.extensions.onChanged

class DashboardDetailVH (val binding: ItemDashboardDetailListBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(dto: DashboardDetailItemDto, onItemClick :(
        (DashboardDetailItemDto)->Unit)) {
        binding.dto = dto
        dto.hasPermission.onChanged {
            binding.root.alpha = if (it) 1f else 0.5f
            binding.root.isEnabled = it
        }
        binding.root.setOnSingleClickListener {
            onItemClick(dto)
        }
    }
    companion object {
        fun from(parent: ViewGroup): DashboardDetailVH {
            val binding = ItemDashboardDetailListBinding.inflate(
                LayoutInflater.from(parent.context), parent, false)
            return DashboardDetailVH(binding)
        }
    }

}