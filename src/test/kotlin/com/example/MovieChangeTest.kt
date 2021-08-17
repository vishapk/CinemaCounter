package com.example

import io.kotest.assertions.show.show
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.time.LocalDate

class MovieChangeTest: StringSpec ({

    "should return the ticket number of booked ticket" {

        val showDetails = ShowDetails(LocalDate.now().plusDays(3), ShowTiming.morning)
        val showDetails2 = ShowDetails(LocalDate.now().plusDays(3), ShowTiming.evening)
        val shows = listOf(Show(100, showDetails, Picture("DDLJ"), 100),
            Show(100, showDetails2, Picture("ZNMD"), 100))
        val cinema = Cinema(shows)

        cinema.getPictureName(showDetails) shouldBe "DDLJ"
        cinema.getPictureName(showDetails2) shouldBe "ZNMD"
    }

})