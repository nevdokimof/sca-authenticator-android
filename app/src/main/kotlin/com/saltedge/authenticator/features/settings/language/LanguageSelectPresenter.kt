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
package com.saltedge.authenticator.features.settings.language

import android.content.Context
import com.saltedge.authenticator.model.repository.PreferenceRepositoryAbs
import com.saltedge.authenticator.tool.currentAppLocaleName
import com.saltedge.authenticator.tool.getAvailableLocalizations
import com.saltedge.authenticator.tool.localeCodeToName

class LanguageSelectPresenter(
    private val appContext: Context,
    private val preferences: PreferenceRepositoryAbs
) : LanguageSelectContract.Presenter {

    private var availableLocales = appContext.getAvailableLocalizations().sorted()
    override var viewContract: LanguageSelectContract.View? = null
    override var availableLanguages: Array<String> =
        availableLocales.map { it.localeCodeToName() }.toTypedArray()
    override var currentItemIndex: Int =
        availableLanguages.indexOf(appContext.currentAppLocaleName())

    override fun onOkClick() {
        viewContract?.closeView()
        if (appContext.currentAppLocaleName() != availableLanguages[currentItemIndex]) {
            preferences.currentLocale = availableLocales[currentItemIndex]
            viewContract?.applyChanges()
        }
    }
}
