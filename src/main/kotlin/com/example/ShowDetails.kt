package com.example

import java.time.LocalDate

class ShowDetails (val showDate: LocalDate, val showTiming: ShowTiming){

    fun isDateValid(){
        if(showDate>LocalDate.now().plusDays(7))
            throw error("Date out of bound.")
    }
}