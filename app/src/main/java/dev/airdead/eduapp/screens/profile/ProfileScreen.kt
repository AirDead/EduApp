package dev.airdead.eduapp.screens.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.airdead.eduapp.modules.userstorage.UserData
import org.koin.compose.koinInject

@Composable
fun ProfileScreen() {
    val appUser = koinInject<UserData>()

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top = 20.dp)
    ) {
        Text(
            text = "Hello, ${appUser.currentUser?.name}",
            fontSize = 24.sp,
            color = Color.White,
            modifier = Modifier.padding(top = 20.dp, start = 20.dp, end = 20.dp)
        )
    }
}