package com.bussiness.composeseniorcare.ui.intro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bussiness.composeseniorcare.R
import com.bussiness.composeseniorcare.ui.theme.Purple
import com.google.accompanist.pager.*

data class OnboardingData(val imageRes: Int, val title: String, val description: String)

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnboardingScreen() {
    val pagerState = rememberPagerState()
    val onboardingItems = listOf(
        OnboardingData(R.drawable.onb_img1, "Lorem Ipsum", "Lorem Ipsum is simply dummy text of the printing and typesetting industry."),
        OnboardingData(R.drawable.onb_img2, "Stay Connected", "Keep in touch with your loved ones easily."),
        OnboardingData(R.drawable.onb_img3, "Get Started", "Let's begin your journey with us.")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEAF9F9)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            count = onboardingItems.size,
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { page ->
            OnboardingCard(onboardingItems[page])
        }

//        CustomPagerIndicator(pagerState)
    }
}

@Composable
fun OnboardingCard(data: OnboardingData, onSkipClick: () -> Unit = {}) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE6F3F2))
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Top image with Skip button
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.55f)
                    .background(Color(0xFFE6F3F2))
            ) {
                Image(
                    painter = painterResource(id = data.imageRes),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(
                            RoundedCornerShape(
                                topStart = 20.dp,
                                topEnd = 20.dp,
                                bottomStart = 20.dp
                            )
                        )
                )

                IconButton(
                    onClick = onSkipClick,
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(start = 15.dp, top = 25.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.skip_ic),
                        contentDescription = "Skip",
                        tint = Color.Unspecified
                    )
                }
            }

            // Bottom content area
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.45f)
                    .background(Color(0xFFE6F3F2))
                    .padding(10.dp)
            ) {
                // Icon row (dummy icons, replace if needed)
                Row(
                    modifier = Modifier
                        .padding(start = 8.dp, top = 15.dp, bottom = 10.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Icon(Icons.Default.Home, contentDescription = null, tint = Color(0xFF5C2C4D))
                    Icon(Icons.Default.Home, contentDescription = null, tint = Color(0xFF5C2C4D))
                    Icon(Icons.Default.Home, contentDescription = null, tint = Color(0xFF5C2C4D))
                }

                Text(
                    text = data.title.uppercase(),
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontSize = 25.sp,
                        color = Purple,
                        fontFamily = FontFamily(Font(R.font.poppins)),
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .padding(start = 8.dp, top = 48.dp)
                )


                Text(
                    text = data.description,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontSize = 16.sp,
                        color = Color(0xFF444444),
                        fontFamily = FontFamily(Font(R.font.poppins)),
                        fontWeight = FontWeight.Normal
                    ),
                    modifier = Modifier
                        .padding(start = 8.dp, end = 80.dp, top = 10.dp)
                )
            }
        }

        // Side curve and purple bar overlay
        Image(
            painter = painterResource(id = R.drawable.side_curv_bar),
            contentDescription = "Side curve",
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .fillMaxHeight()
                .align(Alignment.CenterEnd)
        )


    }
}

@Composable
fun CustomPagerIndicator(
    totalDots: Int,
    selectedIndex: Int,
    modifier: Modifier = Modifier,
    activeColor: Color = Color(0xFF5F2A44), // Dark plum fill
    borderColor: Color = Color(0xFF5F2A44), // Same for border
    spacing: Dp = 12.dp,
    size: Dp = 16.dp,
    cornerRadius: Dp = 4.dp
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(spacing),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        repeat(totalDots) { index ->
            Box(
                modifier = Modifier
                    .size(size)
                    .clip(RoundedCornerShape(cornerRadius))
                    .background(
                        color = if (index == selectedIndex) activeColor else Color.Transparent
                    )
                    .border(
                        width = 2.dp,
                        color = borderColor,
                        shape = RoundedCornerShape(cornerRadius)
                    )
            )
        }
    }
}





@Preview(showBackground = true)
@Composable
fun OnboardingScreenPreview() {
    OnboardingScreen()
}
