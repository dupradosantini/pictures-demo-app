package com.example.picturesdemoapp.ui.common

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.picturesdemoapp.model.UnsplashImage
import com.example.picturesdemoapp.model.Urls
import com.example.picturesdemoapp.model.User
import com.example.picturesdemoapp.model.UserLinks

@Composable
fun ListContent(items: LazyPagingItems<UnsplashImage>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(
            items,
            key = { it.id }
        ) { unsplashImage ->
            unsplashImage?.let { UnsplashItem(unsplashImage = it) }
        }
    }
}

@Composable
fun UnsplashItem(unsplashImage: UnsplashImage) {
    val context = LocalContext.current
    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier
            .clickable {
                val browserIntent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://unsplash.com/@${unsplashImage.user}?utm_source=PicturesDemoApp&utm_medium=referral")
                )
                startActivity(context, browserIntent, null)
            }
            .height(300.dp)
            .fillMaxWidth()
    ){
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(unsplashImage.urls.regular)
                .crossfade(1000)
                .build(),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            placeholder = painterResource(id = com.example.picturesdemoapp.R.drawable.ic_launcher_foreground),
            error= painterResource(id = com.example.picturesdemoapp.R.drawable.ic_launcher_foreground),
            contentScale = ContentScale.Crop
        )
        Surface(
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth()
                .alpha(0.5f),
            color = Color.Black
        ) {
            Row(
                modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 6.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = buildAnnotatedString {
                        append("Photo by ")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)){
                            append(unsplashImage.user.username)
                        }
                        append(" on Unsplash")
                    },
                    color = Color.White,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                LikeCounter(
                    modifier = Modifier.weight(3f),
                    painter = painterResource(id = com.example.picturesdemoapp.R.drawable.baseline_thumb_up_24),
                    likes = "${unsplashImage.likes}"
                )
            }
        }

    }
}

@Composable
fun LikeCounter(
    modifier: Modifier,
    painter: Painter,
    likes: String
){
    Row(
        modifier = modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painter,
            contentDescription = "Like Icon",
            tint = Color(0xFFFFFFE0)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = likes,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
@Preview
fun UnsplashImagePreview(){
    UnsplashItem(
        unsplashImage = UnsplashImage(
            "someId",
            Urls("not an url"),
            100,
            User(
                UserLinks("someUrl"),
                "Someone"
            )
        )
    )
}
