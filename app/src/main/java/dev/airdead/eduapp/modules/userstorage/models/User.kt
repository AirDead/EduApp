package dev.airdead.eduapp.modules.userstorage.models

data class User(
    val name: String,
    val email: String,
    var classNumber: Int? = null,
    var dayStrike: Int = 0
)