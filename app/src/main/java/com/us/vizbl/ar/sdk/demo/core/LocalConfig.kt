package com.us.vizbl.ar.sdk.demo.core


data class LocalConfig(
    val objectId: String,
    val showObjectPanel: Boolean = false,

    val enableTips: Boolean = false,
    val enableScreenshot: Boolean = false,
    val enableMultipleObjects: Boolean = false,
    val enableQRScan: Boolean = false,

    val enableTapToSelect: Boolean = true,
    val enableMove: Boolean = true,
    val enableRotation: Boolean = true
)