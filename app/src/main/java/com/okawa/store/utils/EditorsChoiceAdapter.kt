package com.okawa.store.utils

import com.okawa.store.R
import com.okawa.store.databinding.AdapterEditorsChoiceBinding
import com.okawa.store.ui.model.StoreItemModel

class EditorsChoiceAdapter : BaseBindingAdapter<StoreItemModel, AdapterEditorsChoiceBinding>() {

    override fun layoutToInflate(viewType: Int) = R.layout.adapter_editors_choice

    override fun doOnBindViewHolder(holder: BindingViewHolder<AdapterEditorsChoiceBinding>, item: StoreItemModel?, position: Int) {
        holder.dataBinding?.image = item?.graphic
        holder.dataBinding?.name = item?.name
        holder.dataBinding?.rating = if(item?.rating == 0f) Constants.Rating.DEFAULT_RATING else item?.rating.toString()
    }
}