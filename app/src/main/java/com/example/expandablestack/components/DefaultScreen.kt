package com.example.expandablestack.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import com.example.expandablestack.utils.sdp

@Composable
fun DefaultScreen(
    image: Painter,
    location: String,
    isFavorite: Boolean,
    onFavoriteClick: () -> Unit,
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(8.sdp))
    ) {
        Image(
            painter = image,
            contentDescription = "Jetpack",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .align(Alignment.BottomCenter)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black),
                        startY = 0f,
                        endY = Float.POSITIVE_INFINITY
                    )
                )
        )
        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(16.sdp)
        ) {
            MainText(text = location)
            Spacer(modifier = Modifier.height(8.sdp))
            SecondaryText(text = "Book a vacation to Maldives now for your well deserved holiday")
            Spacer(modifier = Modifier.height(16.sdp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 24.sdp)
            ) {
                IconButton(onFavoriteClick = onFavoriteClick, isFavorite)
                Spacer(modifier = Modifier.width(8.sdp))
                PrimaryButton(label = "Book now") {
                    onButtonClick()
                }
            }
        }
    }
}
