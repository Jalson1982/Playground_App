package com.movies.app.presentation.popularMovies.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.movies.app.presentation.common.ExpandingText

@Composable

fun MovieDescription(title: String, overview: String, releaseDate: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        contentAlignment = Alignment.BottomStart
    ) {
        Column() {

            Text(
                text = title,
                color = Color.White,
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold
            )
            ExpandingText(
                text = overview,
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Row() {
                Text(
                    text = "Release date: ",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = releaseDate,
                    color = Color.White,
                    fontSize = 16.sp
                )
            }

        }
    }
}