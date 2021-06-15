package me.androidbox.data.service

// https://app.sportdataapi.com

// https://app.sportdataapi.com/api/v1/soccer/players?apikey=a3077d20-5b3c-11eb-9967-9f0839e532f7&country_id=42


object Endpoints {
    const val BASE_URL = "https://app.sportdataapi.com"
    const val SPORTS_API = "/api/v1/soccer/"
    const val PLAYERS_BY_COUNTY_ID = "${SPORTS_API}players"
}