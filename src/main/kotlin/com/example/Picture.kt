package com.example

class Picture(private var pictureName: String = "N/A") {

    fun getPictureName() = pictureName

    fun setPictureName(name: String) {
        this.pictureName = name
    }

    fun doesPictureExist(){
        if( pictureName=="N/A")
            throw error("No information available about movie name")
        else
            return
    }
}