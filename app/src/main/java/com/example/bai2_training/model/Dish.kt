package com.example.bai2_training.model

import android.os.Parcel
import android.os.Parcelable

data class Dish(
    val id : String? = null,
    val name : String? = null,
    val description : String? = null,
    val type : Int? = null,
    val price : Int? = null,
    val imgUrl : String? = null,
    var isChecked : Boolean? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeValue(type)
        parcel.writeValue(price)
        parcel.writeString(imgUrl)
        parcel.writeValue(isChecked)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Dish> {
        override fun createFromParcel(parcel: Parcel): Dish {
            return Dish(parcel)
        }

        override fun newArray(size: Int): Array<Dish?> {
            return arrayOfNulls(size)
        }
    }
}