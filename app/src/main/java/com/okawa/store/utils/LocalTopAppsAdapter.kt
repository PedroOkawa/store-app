package com.okawa.store.utils

import com.okawa.store.R
import com.okawa.store.databinding.AdapterLocalTopAppsBinding
import com.okawa.store.ui.model.StoreItemModel

class LocalTopAppsAdapter : BaseBindingAdapter<StoreItemModel, AdapterLocalTopAppsBinding>() {

    override fun layoutToInflate(viewType: Int) = R.layout.adapter_local_top_apps

    override fun doOnBindViewHolder(holder: BindingViewHolder<AdapterLocalTopAppsBinding>, item: StoreItemModel?, position: Int) {
        holder.dataBinding?.image = item?.icon
    }
}