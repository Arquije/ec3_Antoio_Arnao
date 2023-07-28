package com.antonio.ec3_dam2_antonio_arnao.model

data class PlayersResponse(
    val data: List<Player>
)

data class Player(
    val id: Int,
    val first_name: String,
    val last_name: String,
    val position: String,
    val imagen: String,
    val team: Team
)

data class Team(
    val id: Int,
    val abbreviation: String,
    val city: String,
    val conference: String,
    val division: String,
    val full_name: String,
    val name: String
)


