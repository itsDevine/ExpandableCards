package com.example.expandablestack.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.expandablestack.ui.theme.colorDark
import com.example.expandablestack.ui.theme.transparentBlack
import com.example.expandablestack.utils.sdp

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun StackColumn(isVisible: Boolean) {
    AnimatedVisibility(
        visible = isVisible,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it })
    ) {
        var stackSelected by remember { mutableStateOf(1) }
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(transparentBlack)
            ) {
                Spacer(modifier = Modifier.height(24.sdp))
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    MainText(text = "Book now")
                }
                Spacer(modifier = Modifier.height(16.sdp))
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(
                        color = colorDark,
                        shape = RoundedCornerShape(8.sdp, 8.sdp, 0.sdp, 0.sdp)
                    )
            ) {
                SelectLocationCard(expanded = stackSelected == 0) {
                    stackSelected = 0
                }
                SelectDateCard(expanded = stackSelected == 1) {
                    stackSelected = 1
                }
                SelectMembersCard(expanded = stackSelected == 2) {
                    stackSelected = 2
                }
                PaymentCard(expanded = stackSelected == 3) {
                    stackSelected = 3
                }
            }
        }
    }
}