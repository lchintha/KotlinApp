package com.vrcmicrotech.kotlinapp.model

import com.google.gson.annotations.SerializedName

data class Repos(
    val items: ArrayList<Repository>
)

data class Repository(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("full_name")
    val fullName: String = "",
    @SerializedName("owner")
    val owner: Owner = Owner("")
)

data class Owner(
    @SerializedName("avatar_url")
    val url: String = ""
)
