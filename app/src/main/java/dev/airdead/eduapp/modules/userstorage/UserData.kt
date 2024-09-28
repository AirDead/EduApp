package dev.airdead.eduapp.modules.userstorage

import dev.airdead.eduapp.modules.userstorage.models.User

interface UserData {
    var currentUser: User?

    fun login(user: User) {
        currentUser = user
    }

    fun logout() {
        currentUser = null
    }

    fun setClassroom(classroom: Int) {
        currentUser?.classNumber = classroom
    }

    fun isLogged() = currentUser != null
    fun isClassSelected() = currentUser?.classNumber != null
}