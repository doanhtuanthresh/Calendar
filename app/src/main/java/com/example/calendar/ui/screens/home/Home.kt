package com.example.calendar.ui.screens.home

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Air
import androidx.compose.material.icons.filled.InvertColors
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calendar.R

@Preview
@Composable
fun HomeScreen(viewModel: HomeViewModel = viewModel()) {
    LaunchedEffect(Unit) {
        viewModel.fetchWeather()
    }

    val city = viewModel.city
    val date = viewModel.date
    val temperature = viewModel.temperature
    val description = viewModel.description
    val wind = viewModel.windSpeed
    val humidity = viewModel.humidity

    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.background_weather),
                contentScale = ContentScale.Crop
            )
    ) {

        Icon(
            painter = painterResource(id = R.drawable.ic_sun),
            contentDescription = null,
            modifier = Modifier
                .size(160.dp)
                .offset(x = 98.dp, y = 149.dp),
            tint = Color.Unspecified
        )

        // 📍 Thành phố + icon
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .offset(x = 24.dp, y = 24.dp)
        ) {
            Icon(Icons.Default.LocationOn, contentDescription = null, tint = Color.White)

            Spacer(modifier = Modifier.width(20.dp))

            Text(
                text = city,
                color = Color.White,
                style = TextStyle(
                    fontSize = 22.25.sp,
                    fontWeight = FontWeight.Bold,
                ),
                modifier = Modifier.padding(start = 4.dp)
            )
        }

        Icon(
            painter = painterResource(id = R.drawable.ic_notification),
            contentDescription = "Notification",
            tint = Color.White,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .size(75.dp)
                .padding(24.dp)
        )


        Card(
            modifier = Modifier
                .offset(y = 310.dp)
                .padding(horizontal = 24.dp)
                .fillMaxWidth()
                .height(310.dp),
            shape = RoundedCornerShape(19.dp),
            elevation = CardDefaults.cardElevation(0.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.3f))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = date,
                    style = MaterialTheme.typography.labelMedium,
                    color = Color.White,
                )

                Text(
                    text = temperature,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 64.sp,
                        color = Color.White,
                        shadow = Shadow(
                            color = Color.Black.copy(alpha = 0.25f),
                            offset = Offset(2f, 2f),
                            blurRadius = 6f
                        )
                    ),
                    modifier = Modifier.padding(top = 8.dp)
                )

                Text(
                    text = description,
                    style = MaterialTheme.typography.titleMedium.copy(fontSize = 20.sp),
                    color = Color.White,
                    modifier = Modifier.padding(top = 8.dp)
                )

                Spacer(modifier = Modifier.height(24.dp))
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            Icons.Default.Air,
                            contentDescription = null,
                            tint = Color.White
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Wind",
                            color = Color.White,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.offset(x = 5.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = wind,
                            color = Color.White,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.offset(x = 15.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            Icons.Default.InvertColors,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.offset(x = -12.dp))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Hum",
                            color = Color.White,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.offset(x = -5.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = humidity,
                            color = Color.White,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.offset(x = 5.dp)
                        )
                    }
                }
            }
        }

        // 🔘 Forecast button
        Button(
            onClick = { /* TODO */ },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 32.dp)
                .fillMaxWidth(0.7f)
                .height(48.dp),
            shape = RoundedCornerShape(24.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White)
        ) {
            Text(text = "Forecast report", color = Color(0xFF2196F3))
        }
    }
}

