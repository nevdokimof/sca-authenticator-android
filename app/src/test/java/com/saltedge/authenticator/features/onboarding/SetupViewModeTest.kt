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
package com.saltedge.authenticator.features.onboarding

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class SetupViewModeTest {

    @Test
    @Throws(Exception::class)
    fun valuesTest() {
        assertThat(
            SetupViewMode.values(),
            equalTo(
                arrayOf(
                    SetupViewMode.INPUT_PASSCODE,
                    SetupViewMode.ALLOW_BIOMETRICS,
                    SetupViewMode.ALLOW_NOTIFICATIONS,
                    SetupViewMode.COMPLETE
                )
            )
        )
    }

    @Test
    @Throws(Exception::class)
    fun valueOfTest() {
        assertThat(SetupViewMode.valueOf("INPUT_PASSCODE"), equalTo(SetupViewMode.INPUT_PASSCODE))
        assertThat(
            SetupViewMode.valueOf("ALLOW_BIOMETRICS"),
            equalTo(SetupViewMode.ALLOW_BIOMETRICS)
        )
        assertThat(
            SetupViewMode.valueOf("ALLOW_NOTIFICATIONS"),
            equalTo(SetupViewMode.ALLOW_NOTIFICATIONS)
        )
        assertThat(SetupViewMode.valueOf("COMPLETE"), equalTo(SetupViewMode.COMPLETE))
    }
}
