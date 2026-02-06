package com.example.pocketshopper

import android.net.Uri
import java.util.UUID

class User(
    private var name: String,
    private var profilePicture: Uri? = null,
) {
    private var uid: UUID = UUID.randomUUID()

    fun changeName(newName: String) {
        name = newName
    }

    fun uploadProfilePicture(imageIdentifier: Uri) {
        profilePicture = imageIdentifier
    }
}