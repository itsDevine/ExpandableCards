package com.example.expandablestack.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.expandablestack.ui.theme.colorPrimary
import com.example.expandablestack.ui.theme.colorWhite
import com.example.expandablestack.utils.textSdp

@Composable
fun MainText(text: String) {
    Text(
        text = text,
        style = TextStyle(
            color = colorWhite,
            fontSize = 24.textSdp,
            fontWeight = FontWeight.Bold
        )
    )
}

@Composable
fun SecondaryText(text: String) {
    Text(
        text = text,
        style = TextStyle(
            color = colorWhite,
            fontSize = 18.textSdp,
            fontWeight = FontWeight.Light
        )
    )
}

@Composable
fun ButtonText(text: String) {
    Text(
        text = text,
        style = TextStyle(
            color = colorWhite,
            fontSize = 18.textSdp,
            fontWeight = FontWeight.SemiBold
        )
    )
}

@Composable
fun ButtonText2(text: String) {
    Text(
        text = text,
        style = TextStyle(
            color = colorPrimary,
            fontSize = 18.textSdp,
            fontWeight = FontWeight.SemiBold
        )
    )
}