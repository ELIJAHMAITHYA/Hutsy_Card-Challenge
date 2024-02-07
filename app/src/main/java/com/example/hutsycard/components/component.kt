package com.example.hutsycard.components

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hutsycard.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Preview(showBackground = true)
@Composable
fun Usercard(
    modifier: Modifier = Modifier,
) {
    var expanded by remember {
        mutableStateOf(false)
    }
    val startColor = Color.Blue
    val endColor = Color.Green
    val borderColor by animateColorAsState(
        if (expanded) endColor else startColor,
        animationSpec = tween(
            durationMillis = 2000,
            delayMillis = 100,
            easing = LinearEasing
        ), label = ""
    )
    Card(
        modifier = Modifier
            .padding(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray,
        ),
        border = BorderStroke(3.dp, borderColor),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(10.dp),
    ) {


        var visible by remember {
            mutableStateOf(false)
        }
        val boxSize: Dp by animateDpAsState(
            targetValue = if (expanded && visible) 250.dp else 100.dp,
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {

            Box(
                modifier = Modifier
                    .size(boxSize)
                    .fillMaxSize()
                    .padding(2.dp)
                    .clip(CircleShape)
                    .background(
                        brush = remember {
                            Brush.linearGradient(
                                colors = listOf(
                                    Color.Green,
                                    Color.Blue,
                                    Color.Red,
                                    Color.Yellow,
                                    Color.Green
                                ),
                                start = Offset(0f, 0f),
                                end = Offset(100f, 100f)
                            )
                        },
                        shape = CircleShape
                    )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.paul),
                    contentDescription = "Paul",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(boxSize)
                        .fillMaxSize()
                        .padding(2.dp)
                        .clip(CircleShape),
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Paul Scholles",
                modifier = Modifier,
                style = TextStyle.Default.copy(
                    color = Color.Black
                ),
                fontWeight = FontWeight.Bold
            )
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Filled.Email,
                    contentDescription = "Email",
                    modifier = Modifier
                        .size(24.dp),
                )
                Text(
                    text = "paulscholles254@gmail.com",
                    modifier = Modifier,
                    style = TextStyle.Default.copy(
                        color = Color.Black
                    ),
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize
                )
            }
            Button(
                onClick = {
                    visible = !visible
                    expanded = !expanded

                },
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = "Show Profile")
            }
            AnimatedVisibility(
                visible = visible,
                enter = fadeIn() + slideInHorizontally(),
                exit = fadeOut() + slideOutHorizontally(),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = stringResource(id = R.string.profile_desc))
                    Spacer(modifier = Modifier.height(16.dp))
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .graphicsLayer(shape = CircleShape)
                            .background(Color.White, CircleShape),
                        contentAlignment = Alignment.Center

                    ) {
                        IconButton(
                            onClick = {
                                visible = !visible
                            },
                            modifier = Modifier.size(48.dp),
                        ) {
                            Icon(
                                Icons.Filled.Clear,
                                contentDescription = "clear",
                                tint = Color.Black
                            )
                        }
                    }
                }
            }
        }
    }
}
