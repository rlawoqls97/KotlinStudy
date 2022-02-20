package com.example.prjgo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

// 새로 만들어보는 것
@kotlinx.android.parcel.Parcelize
data class Model(
    var profile: Int,
    var name: String
) : Parcelable