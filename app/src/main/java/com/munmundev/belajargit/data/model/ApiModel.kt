package com.munmundev.belajargit.data.model

import com.google.gson.annotations.SerializedName

//class ApiModel (
//    @SerializedName("no")
//    val no: String,
//
//    @SerializedName("nama")
//    val nama: String,
//
//    @SerializedName("alamat")
//    val alamat: String,
//
//    @SerializedName("nomor")
//    val nomor: String
//)

class ApiModel (
    @SerializedName("id_user")
    val id_user: String,

    @SerializedName("nama")
    val nama: String,

    @SerializedName("status")
    val status: String,

    @SerializedName("user_id")
    val user_id: String,

    @SerializedName("pass_id")
    val pass_id: String
)