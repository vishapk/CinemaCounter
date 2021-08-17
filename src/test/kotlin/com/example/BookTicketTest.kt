package com.example

import io.kotest.assertions.show.show
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.time.LocalDate

class BookTicketTest: StringSpec ({

    "should return the ticket number of booked ticket" {

        val showDetails = ShowDetails(LocalDate.now().plusDays(3), ShowTiming.morning)
        val shows = listOf(Show(100, showDetails, Picture("ZNMD"), 100))
        val cinema = Cinema(shows)

        val (newCinema, ticket) = cinema.bookTicket(showDetails)
        val (newCinema2, ticket2) = newCinema.bookTicket(showDetails)
        newCinema.getSeatsLeft(showDetails) shouldBe 99
        newCinema2.getSeatsLeft(showDetails) shouldBe 98

        if (ticket != null) {
            ticket.seatNumber shouldBe 100
        }

        if (ticket2 != null) {
            ticket2.seatNumber shouldBe 99
        }
    }
    "should throw error since date out of bound" {

        val showDetails = ShowDetails(LocalDate.now().plusDays(31), ShowTiming.morning)
        val shows = listOf(Show(100, showDetails, Picture("ZNMD"), 100))
        val cinema = Cinema(shows)

        val exception = shouldThrow<IllegalStateException> {
            cinema.bookTicket(showDetails)
        }
        exception.message shouldBe "Date out of bound."

    }

    "should throw error if the show doesn't contain information" {

        val showDetails = ShowDetails(LocalDate.now().plusDays(3), ShowTiming.morning)
        val shows = listOf(Show(100, showDetails, Picture(), 100))
        val cinema = Cinema(shows)

        val exception = shouldThrow<IllegalStateException> {
            cinema.bookTicket(showDetails)
        }
        exception.message shouldBe "No information available about movie name"

    }

})