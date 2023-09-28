package com.example.firebasestorage

import androidx.compose.runtime.snapshots.SnapshotStateList

data class Upload(

    var ighandle: String?,
    var Whatsappcontact: String?,
    var Description: String?


) {
    companion object {
        fun add(c: SnapshotStateList<Upload?>?) {
            TODO("Not yet implemented")
        }
    }
}
