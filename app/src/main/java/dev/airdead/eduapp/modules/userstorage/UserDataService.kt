package dev.airdead.eduapp.modules.userstorage

import dev.airdead.eduapp.modules.userstorage.models.User

class UserDataService : UserData {
    override var currentUser: User? = null
}