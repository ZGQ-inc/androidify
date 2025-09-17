/*
 * Copyright 2025 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.developers.androidify.customize

import androidx.compose.runtime.Composable
import androidx.xr.compose.platform.LocalSpatialCapabilities
import com.android.developers.androidify.util.isAtLeastMedium

enum class CustomizeExportLayoutType {
    Compact,
    Medium,
    Spatial,
}

@Composable
fun calculateLayoutType(enableXr: Boolean = false): CustomizeExportLayoutType {
    return when {
        LocalSpatialCapabilities.current.isSpatialUiEnabled && enableXr -> CustomizeExportLayoutType.Spatial
        isAtLeastMedium() -> CustomizeExportLayoutType.Medium
        else -> CustomizeExportLayoutType.Compact
    }
}
