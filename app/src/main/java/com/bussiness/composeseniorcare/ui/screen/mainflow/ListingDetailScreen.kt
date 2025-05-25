package com.bussiness.composeseniorcare.ui.screen.mainflow

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.size.Size
import com.bussiness.composeseniorcare.R
import com.bussiness.composeseniorcare.ui.theme.Purple

@Composable
fun ListingDetail(navController: NavHostController) {

    val imageList = listOf(
        R.drawable.detail_map_ic,
        R.drawable.banner_bg,
        R.drawable.onb_img1,
        R.drawable.onb_img2,
        R.drawable.onb_img3,
        R.drawable.detail_map_ic,
        R.drawable.image_3,
        R.drawable.detail_map_ic
    )

    var selectedImage by remember { mutableStateOf(imageList.first()) }
    var isBookmarked by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color.White,
                        Color(0xFF5C2C4D),
                        Color(0xFF5C2C4D)
                    )
                )
            )
    ) {
        CustomTopAppBar(showCredit = false)

        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(Color.White)
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                ImageBox(selectedImage)
                Spacer(modifier = Modifier.height(16.dp))
                ImageSlider(imageList = imageList) {
                    selectedImage = it
                }
                Spacer(modifier = Modifier.height(24.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding( vertical = 4.dp)
                ) {
                    Text(
                        text = "Name Of Society",
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semi_bold))
                    )

                    Spacer(Modifier.weight(1f))

                    Icon(
                        painter = painterResource(
                            id = if (isBookmarked) R.drawable.select_bm else R.drawable.vector_bookmark
                        ),
                        contentDescription = if (isBookmarked) "Bookmarked" else "Bookmark",
                        tint = Color.Unspecified,
                        modifier = Modifier
                            .size(24.dp)
                            .clickable { isBookmarked = !isBookmarked }
                    )
                }
                Spacer(Modifier.height(2.dp))
                TextSection(title = "lorem ipsum lorem ipsumlorem\n ipsumlorem ipsum", modifier = Modifier.padding(bottom = 8.dp), fontSize = 12, fontFamily = FontFamily(Font(R.font.poppins)))
                Divider(Modifier.height(1.dp), color = Purple)
                Spacer(Modifier.height(8.dp))
                TextSection("Facility ID: W1254689", modifier = Modifier, fontSize = 16, fontFamily = FontFamily(Font(R.font.poppins_semi_bold)))
                Spacer(Modifier.height(5.dp))
                TextSection("Floor: 10th of 21 Floors", modifier = Modifier, fontSize = 12, fontFamily = FontFamily(Font(R.font.poppins)))
                Spacer(Modifier.height(5.dp))
                TextSection("Status: Immediately", modifier = Modifier, fontSize = 12, fontFamily = FontFamily(Font(R.font.poppins)))
                Spacer(Modifier.height(5.dp))
                TextSection("Furnished Status: lorem ipsum", modifier = Modifier, fontSize = 12, fontFamily = FontFamily(Font(R.font.poppins)))
                Spacer(Modifier.height(5.dp))
                TextSection("Year Built: 2006", modifier = Modifier, fontSize = 12, fontFamily = FontFamily(Font(R.font.poppins)))
                Spacer(Modifier.height(5.dp))
                Row {
                    TextSection("Garage: 1", modifier = Modifier, fontSize = 12, fontFamily = FontFamily(Font(R.font.poppins)))
                    Spacer(Modifier.weight(1f))

                }

                Spacer(Modifier.height(5.dp))
            }
        }
    }
}

@Composable
fun ImageBox(selectedImage : Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(Color.LightGray)
    ) {
        Image(
            painter = painterResource(selectedImage),
            contentDescription = "Main Detail Image",
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun ImageSlider(imageList: List<Int>, onImageClick: (Int) -> Unit) {

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 0.dp, vertical = 0.dp)
    ) {
        items(imageList) { imageRes ->
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "Thumbnail Image",
                modifier = Modifier
                    .size(75.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.LightGray)
                    .clickable { onImageClick(imageRes) },
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun TextSection(title: String, modifier: Modifier = Modifier,fontSize : Int,fontFamily: FontFamily) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium,
        modifier = modifier,
        fontSize = fontSize.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
        color = Color.Black
    )
}

@Preview(showBackground = true)
@Composable
fun ListingDetailScreenPreview() {
    val navController = rememberNavController()
    MaterialTheme {
        ListingDetail(navController = navController)
    }
}
