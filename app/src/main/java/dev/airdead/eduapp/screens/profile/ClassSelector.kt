package dev.airdead.eduapp.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.airdead.eduapp.R
import dev.airdead.eduapp.app.elements.ActionButton
import dev.airdead.eduapp.app.elements.AppIcon
import dev.airdead.eduapp.app.ext.appTheme
import dev.airdead.eduapp.modules.navigator.NavService
import dev.airdead.eduapp.modules.userstorage.UserData
import org.koin.compose.koinInject

@Composable
fun ClassSelector() {
    val appUser = koinInject<UserData>()
    val navigator = koinInject<NavService>()
    var expanded by remember { mutableStateOf(false) }
    var selectedClass by remember { mutableIntStateOf(11) }
    val classes = (1..12).map { it.toString() }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        AppIcon()
        Spacer(modifier = Modifier.weight(0.4f))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(420.dp)
                .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                .background(appTheme.secondary)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 110.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Choose your class",
                    color = appTheme.onPrimary,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .height(70.dp)
                        .padding(top = 20.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .border(2.dp, appTheme.onPrimary, RoundedCornerShape(12.dp))
                        .clickable { expanded = true }
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp, vertical = 12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = selectedClass.toString(),
                            color = appTheme.onPrimary,
                            fontSize = 20.sp
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.arrow),
                            contentDescription = "Dropdown Icon",
                            tint = appTheme.onPrimary,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                ) {
                    classes.forEach { classOption ->
                        DropdownMenuItem(
                            text = { Text(classOption, color = appTheme.onPrimary) },
                            onClick = {
                                selectedClass = classOption.toInt()
                                expanded = false
                            }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                ActionButton(
                    text = "Continue",
                    backgroundColor = appTheme.onSecondary,
                    textColor = Color.White,
                    height = 50,
                    onClick = {
                        appUser.setClassroom(selectedClass)
                        navigator.animateNavigate("profile", "classSelector", 1)
                    }
                )
            }
        }
    }
}