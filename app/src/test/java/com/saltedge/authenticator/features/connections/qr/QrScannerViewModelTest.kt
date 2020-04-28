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
package com.saltedge.authenticator.features.connections.qr

import com.saltedge.authenticator.R
import com.saltedge.authenticator.testTools.TestAppTools
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class QrScannerViewModelTest {

    private lateinit var viewModel: QrScannerViewModel

    @Before
    fun setUp() {
        viewModel = QrScannerViewModel(
            appContext = TestAppTools.applicationContext
        )
    }

    /**
     * Test onViewClick when click on closeImageView
     */
    @Test
    @Throws(Exception::class)
    fun onViewClickTestCase1() {
        viewModel.onViewClick(R.id.closeImageView)

        assertNotNull(viewModel.closeActivity.value)
    }

    /**
     * Test onViewClick when click on unknown id
     */
    @Test
    @Throws(Exception::class)
    fun onViewClickTestCase2() {
        viewModel.onViewClick(-1)

        assertNotNull(viewModel.closeActivity.value)
    }
}
