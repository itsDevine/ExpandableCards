package com.example.expandablestack.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.expandablestack.ui.theme.colorPrimary
import com.example.expandablestack.ui.theme.colorWhite
import com.example.expandablestack.utils.sdp

@Composable
fun PrimaryButton(label: String, onButtonClick: () -> Unit) {
    Button(
        onClick = { onButtonClick() },
        modifier = Modifier
            .height(48.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(backgroundColor = colorPrimary)
    ) {
        ButtonText(text = label)
    }
}

@Composable
fun PrimaryButton2(label: String, onButtonClick: () -> Unit) {
    Button(
        onClick = { onButtonClick() },
        modifier = Modifier
            .height(48.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(backgroundColor = colorWhite)
    ) {
        ButtonText2(text = label)
    }
}

@Composable
fun IconButton(onFavoriteClick: () -> Unit, isFavorite: Boolean) {
    Button(
        onClick = { onFavoriteClick() },
        modifier = Modifier
            .size(48.sdp),
        colors = ButtonDefaults.buttonColors(backgroundColor = colorPrimary)
    ) {
        Icon(
            imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
            contentDescription = "Favorite",
            tint = if (isFavorite) colorWhite else colorWhite
        )
    }
}

@Composable
fun NumberSelectButton(num: Int, selected: Boolean, onSelect: () -> Unit) {
    Box(
        modifier = Modifier
            .size(24.sdp)
            .background(shape = CircleShape, color = if (selected) colorPrimary else colorWhite)
            .clickable(onClick = onSelect),
        contentAlignment = Alignment.Center
    ) {
        if (selected) ButtonText(text = num.toString()) else ButtonText2(text = num.toString())
    }
}