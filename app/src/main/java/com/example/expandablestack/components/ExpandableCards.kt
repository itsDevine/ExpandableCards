package com.example.expandablestack.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.expandablestack.R
import com.example.expandablestack.ui.theme.colorDark
import com.example.expandablestack.ui.theme.colorPrimary
import com.example.expandablestack.ui.theme.colorWhite
import com.example.expandablestack.utils.sdp
import java.util.*

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SelectLocationCard(expanded: Boolean, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween()
            ),
        backgroundColor = Color.Transparent,
        onClick = onClick
    ) {
        var location by remember { mutableStateOf("Choose Location") }
        Column(
            modifier = Modifier
                .padding(16.sdp)
                .fillMaxWidth()
        ) {
            ButtonText(text = "location")

            Spacer(modifier = Modifier.height(16.sdp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Default.LocationOn,
                    contentDescription = "Location Icon",
                    tint = colorWhite,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                SecondaryText(text = location)
            }
            Spacer(modifier = Modifier.height(8.sdp))

            if (
                expanded
            ) {
                SecondaryText(text = "       :\n       to\n       :")
                Spacer(modifier = Modifier.height(8.sdp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        Icons.Default.LocationOn,
                        contentDescription = "Location Icon",
                        tint = colorWhite,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    SecondaryText(text = "Maldives")
                }

                Spacer(modifier = Modifier.height(24.sdp))
                PrimaryButton("current Location", {
                    location = "Bengaluru, India"
                })
                Spacer(modifier = Modifier.height(150.sdp))
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SelectDateCard(expanded: Boolean, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(),
        backgroundColor = colorDark,
        elevation = 4.sdp,
        onClick = onClick
    ) {
        var startDate by remember { mutableStateOf("start date") }
        var endDate by remember { mutableStateOf("End date") }
        Column(
            modifier = Modifier
                .background(shape = RoundedCornerShape(16.sdp), color = colorPrimary)
                .padding(16.sdp)
                .fillMaxWidth()
        ) {
            ButtonText(text = "choose dates")
            Spacer(modifier = Modifier.height(16.sdp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Default.DateRange,
                    contentDescription = "Location Icon",
                    tint = colorWhite,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                SecondaryText(text = startDate)
            }
            Spacer(modifier = Modifier.height(8.sdp))
            if (expanded) {
                SecondaryText(text = "       :\n       to\n       :")
                Spacer(modifier = Modifier.height(8.sdp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        Icons.Default.DateRange,
                        contentDescription = "Location Icon",
                        tint = colorWhite,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    SecondaryText(text = endDate)
                }
                Spacer(modifier = Modifier.height(24.sdp))
                PrimaryButton2("Pick Date", {
                    startDate = "16-05-2023"
                    endDate = "21-05-2023"
                })
                Spacer(modifier = Modifier.height(160.sdp))
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SelectMembersCard(expanded: Boolean, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(),
        backgroundColor = colorDark,
        elevation = 4.sdp,
        onClick = onClick
    ) {
        var adults by remember { mutableStateOf(1) }
        var children by remember { mutableStateOf(1) }
        Column(
            modifier = Modifier
                .background(shape = RoundedCornerShape(16.sdp), color = colorDark)
                .padding(16.sdp)
                .fillMaxWidth()
        ) {
            ButtonText(text = "choose dates")
            Spacer(modifier = Modifier.height(16.sdp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Default.Person,
                    contentDescription = "Location Icon",
                    tint = colorWhite,
                    modifier = Modifier.size(18.sdp)
                )
                Spacer(modifier = Modifier.width(8.sdp))
                SecondaryText(text = "$adults adults")
            }

            Spacer(modifier = Modifier.height(24.sdp))
            if (expanded) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    NumberSelectButton(num = 1, selected = adults == 1) { adults = 1 }
                    NumberSelectButton(num = 2, selected = adults == 2) { adults = 2 }
                    NumberSelectButton(num = 3, selected = adults == 3) { adults = 3 }
                    NumberSelectButton(num = 4, selected = adults == 4) { adults = 4 }
                    NumberSelectButton(num = 5, selected = adults == 5) { adults = 5 }
                }

                Spacer(modifier = Modifier.height(30.sdp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        Icons.Default.Person,
                        contentDescription = "Location Icon",
                        tint = colorWhite,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    SecondaryText(text = "$children children")
                }
                Spacer(modifier = Modifier.height(24.sdp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    NumberSelectButton(num = 1, selected = children == 1) { children = 1 }
                    NumberSelectButton(num = 2, selected = children == 2) { children = 2 }
                    NumberSelectButton(num = 3, selected = children == 3) { children = 3 }
                    NumberSelectButton(num = 4, selected = children == 4) { children = 4 }
                    NumberSelectButton(num = 5, selected = children == 5) { children = 5 }
                }
                Spacer(modifier = Modifier.height(180.sdp))
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PaymentCard(expanded: Boolean, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(),
        backgroundColor = colorDark,
        elevation = 4.sdp,
        onClick = onClick
    ) {
        Column(
            modifier = Modifier
                .background(shape = RoundedCornerShape(16.sdp), color = colorPrimary)
                .padding(16.sdp)
                .fillMaxWidth()
        ) {
            ButtonText(text = "Payment")
            Spacer(modifier = Modifier.height(16.sdp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Filled.Add,
                    contentDescription = "Location Icon",
                    tint = colorWhite,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                SecondaryText(text = "Pay using Scanner")
            }
            Spacer(modifier = Modifier.height(24.sdp))
            if (expanded) {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(150.sdp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.scanner),
                        contentDescription = ""
                    )
                }
                Spacer(modifier = Modifier.height(24.sdp))
                PrimaryButton2(label = "Pay Now") {

                }
                Spacer(Modifier.fillMaxHeight())
            }
        }
    }
}