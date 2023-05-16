package com.example.expandablestack.screens

import android.os.Build
import androidx.activity.compose.BackHandler
import androidx.annotation.RequiresApi
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import com.example.expandablestack.components.DefaultScreen
import com.example.expandablestack.R
import com.example.expandablestack.components.StackColumn

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen() {
    var isFav by remember { mutableStateOf(false) }
    var isVisible by remember { mutableStateOf(false) }
    BackHandler {
        if (isVisible) isVisible = false
    }
    DefaultScreen(
        image = painterResource(id = R.drawable.maldives),
        location = "Maldives",
        isFavorite = isFav,
        onFavoriteClick = { isFav = !isFav },
        onButtonClick = { isVisible = !isVisible })
    StackColumn(isVisible = isVisible)
}