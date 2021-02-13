package me.androidbox.data.service

import io.reactivex.rxjava3.core.Single
import me.androidbox.data.entities.PlayerDataEntity
import me.androidbox.service.Endpoints
import retrofit2.http.GET
import retrofit2.http.Query

interface FootballServices {

    @GET(Endpoints.PLAYERS_BY_COUNTY_ID)
    fun getListOfPlayersByCountryId(
            @Query("apikey") apiKey: String,
            @Query("counter_id") countryId: Int) : Single<PlayerDataEntity>
}
