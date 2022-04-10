package com.ericg.pagingmovies.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ericg.pagingmovies.R
import com.ericg.pagingmovies.data.Movie
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun MovieItem(
   movie: Movie
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        val image = "https://image.tmdb.org/t/p/w780/${movie.path}"
        CoilImage(
            imageModel = image,
            circularReveal = CircularReveal(duration = 1000),
            shimmerParams = ShimmerParams(
                baseColor = Color.DarkGray,
                highlightColor = Color.LightGray,
                durationMillis = 350,
                dropOff = 0.65F,
                tilt = 20F
            ),
            previewPlaceholder = R.drawable.place_holder,
            modifier = Modifier
                .padding(all = 8.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .height(250.dp), contentScale = ContentScale.Crop
        )

        Text(
            text = movie.title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}