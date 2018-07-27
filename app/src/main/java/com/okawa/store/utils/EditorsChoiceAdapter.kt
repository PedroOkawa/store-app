package com.okawa.store.utils

import com.okawa.store.R
import com.okawa.store.databinding.AdapterEditorsChoiceBinding
import com.okawa.store.ui.model.StoreItemModel

class EditorsChoiceAdapter : BaseBindingAdapter<StoreItemModel, AdapterEditorsChoiceBinding>() {

    override fun layoutToInflate(viewType: Int) = R.layout.adapter_editors_choice

    override fun doOnBindViewHolder(holder: BindingViewHolder<AdapterEditorsChoiceBinding>, item: StoreItemModel?, position: Int) {
        holder.dataBinding?.image = item?.graphic
    }
}