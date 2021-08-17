package com.example

class Cinema( val listShows: List<Show>) {

    fun bookTicket(showDetail: ShowDetails): Pair<Cinema, Ticket?>{

        val show = listShows.first { it.showDetails==showDetail }

        showDetail.isDateValid()
        show.picture.doesPictureExist()
        show.isSeatleft()

        val ticket= Ticket(show.seatsLeft, show.showDetails)
        val updatedShowList=updateShowList(show, show.showDetails)
        val updatedCinema= Cinema(updatedShowList)

        return Pair(updatedCinema, ticket)
    }

    fun updateShowList(show: Show, showDetails: ShowDetails): List<Show>{

        val updatedShowList = listShows.toMutableList()

        updatedShowList.remove(show)
        updatedShowList.add(
            Show(
                show.capacity,
                showDetails,
                show.picture,
                show.seatsLeft-1
            )
        )
        return updatedShowList.toList()
    }

    private fun addPictureToShowList(picture: Picture, showDetails: ShowDetails): List<Show>{

        val updateShowList = listShows.toMutableList()
        val show= listShows.first{ it.showDetails==showDetails}
        updateShowList.add(
            Show(
                show.capacity,
                showDetails,
                picture,
                show.capacity
            )
        )
        return updateShowList.toList()
    }

    fun getSeatsLeft(showDetails: ShowDetails): Int{
        return listShows.first{ it.showDetails==showDetails}.seatsLeft
    }

    fun getPictureName(showDetails: ShowDetails): String{

        showDetails.isDateValid()
        if(listShows.filter{ it.showDetails==showDetails}.isEmpty())
            return "N/A"
        else return listShows.first{ it.showDetails==showDetails}.picture.getPictureName()
    }

    fun setPictureName(showDetails: ShowDetails, pictureName:String): Cinema{

        showDetails.isDateValid()
        return if(listShows.filter{ it.showDetails==showDetails}.isEmpty())
            this
        else Cinema(addPictureToShowList(Picture(pictureName),showDetails))
    }

}