package com.example

import java.time.LocalDate

enum class ShowTiming{
    morning,
    afternoon,
    evening,
    night
}

class Show(val capacity: Int, val showDetails: ShowDetails, val picture: Picture= Picture(), val seatsLeft: Int)
{
    fun setPicture( pictureName: String): Show{
        return if(capacity==seatsLeft)
            Show(capacity, showDetails, Picture(pictureName), seatsLeft)
        else throw error("Tickets already sold for this show")
    }

    fun isSeatleft(){
        if(capacity>0)
            return
        else
            throw error("Show completely booked.")
    }
}