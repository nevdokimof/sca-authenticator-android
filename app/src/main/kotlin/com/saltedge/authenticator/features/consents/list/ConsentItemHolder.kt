/*
 * This file is part of the Salt Edge Authenticator distribution
 * (https://github.com/saltedge/sca-authenticator-android).
 * Copyright (c) 2020 Salt Edge Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 3 or later.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 *
 * For the additional permissions granted for Salt Edge Authenticator
 * under Section 7 of the GNU General Public License see THIRD_PARTY_NOTICES.md
 */
package com.saltedge.authenticator.features.consents.list

import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat.getColor
import androidx.recyclerview.widget.RecyclerView
import com.saltedge.authenticator.R
import com.saltedge.authenticator.features.consents.common.ConsentItemViewModel
import com.saltedge.authenticator.interfaces.ListItemClickListener
import com.saltedge.authenticator.tools.inflateListItemView

class ConsentItemHolder(parent: ViewGroup, private val listener: ListItemClickListener?) :
    RecyclerView.ViewHolder(parent.inflateListItemView(R.layout.view_item_consent)) {

    private val titleView = itemView.findViewById<TextView>(R.id.titleView)
    private val subTitleView = itemView.findViewById<TextView>(R.id.subTitleView)
    private val listItemView = itemView.findViewById<RelativeLayout>(R.id.listItemView)
    private val dateView = itemView.findViewById<TextView>(R.id.dateView)
    private val description = listItemView.context.getString(R.string.consents_expires_in)

    init {
        itemView.setOnClickListener {
            if (adapterPosition > RecyclerView.NO_POSITION)
                listener?.onListItemClick(itemIndex = adapterPosition)
        }
    }

    fun bind(item: ConsentItemViewModel) {
        titleView.text = item.tppName
        subTitleView.text = item.consentTypeDescription

        val consentExpiresString = SpannableStringBuilder("$description ${item.expiresAt}")
        consentExpiresString.apply {
            setSpan(ForegroundColorSpan(getColor(listItemView.context, R.color.secondary_text)),
                consentExpiresString.indexOf(description, 0),
                description.length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            setSpan(ForegroundColorSpan(getColor(listItemView.context, R.color.red)),
                consentExpiresString.indexOf(item.expiresAt, 0),
                consentExpiresString.length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }
        dateView.text = consentExpiresString
    }
}
