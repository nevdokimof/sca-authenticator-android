/*
 * This file is part of the Salt Edge Authenticator distribution
 * (https://github.com/saltedge/sca-authenticator-android).
 * Copyright (c) 2019 Salt Edge Inc.
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
package com.saltedge.authenticator.features.main

import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.saltedge.authenticator.widget.fragment.FabState

fun FloatingActionButton.updateState(newState: FabState) {
    Log.d("some", "updateState")
    val currentState: FabState = tag as? FabState ?: FabState.NO_ACTION
    when {
        (newState === currentState) -> {
            Log.d("some", "refreshCurrentState")

            refreshCurrentState(newState)
        }
        (newState === FabState.NO_ACTION) -> {
            Log.d("some", "hideFabView")

            hideFabView()
        }
        (currentState === FabState.NO_ACTION) -> {
            Log.d("some", "showFabView")

            showFabView()
        }

    }
    tag = newState
}

private fun FloatingActionButton.refreshCurrentState(newState: FabState) {
    if (newState !== FabState.NO_ACTION) show() else hide()
}

private fun FloatingActionButton.hideFabView() {
    hide()
}

private fun FloatingActionButton.showFabView() {
    show()
}
