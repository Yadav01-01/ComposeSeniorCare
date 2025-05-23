package com.bussiness.composeseniorcare.ui.screen.mainflow

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.bussiness.composeseniorcare.R
import com.bussiness.composeseniorcare.data.model.Facility
import com.bussiness.composeseniorcare.ui.theme.Purple

@Composable
fun CompareFacilities(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.statusBars.asPaddingValues())
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFFFFFFF),
                        Color(0xFF5C2C4D),
                        Color(0xFF5C2C4D)
                    )
                )
            )
    ) {
        CustomTopAppBar(showCredit = false)

        // Bounded container
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(Color.White)
        ) {
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 0.dp, vertical = 0.dp),
                verticalArrangement = Arrangement.Top,
                modifier = Modifier.fillMaxSize()
            ) {
                item {
                    Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp, vertical = 15.dp)) {
                        CompareCard(
                            imageRes = R.drawable.genac_ic,
                            onChangeClick = { /*...*/ },
                            modifier = Modifier.weight(1f)
                        )
                        CompareCard(
                            imageRes = R.drawable.genac_ic,
                            onChangeClick = { /*...*/ },
                            modifier = Modifier.weight(1f)
                        )
                    }

                    Text(
                        text = stringResource(id = R.string.compare_facilty),
                        fontSize = 24.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
                        modifier = Modifier.padding(top = 10.dp, start = 15.dp, end = 15.dp)
                    )
                }

                items(listOf(
                    Triple(R.string.name_of_society, "lorem ipsum", "lorem ipsum"),
                    Triple(R.string.provider_information, "John Deo", "Tom"),
                    Triple(R.string.floor, "10th of 21 Floors", "2nd Floors"),
                    Triple(R.string.status, "Immediately", "Immediately"),
                    Triple(R.string.furnished_status, "Semi", "fully"),
                    Triple(R.string.year_built, "2006", "2010"),
                    Triple(R.string.garage, "1", "0"),
                    Triple(
                        R.string.overview,
                        "Lorem ipsum dolor sit amet consectetur. Sollicitudin aliquam donec morbi risus pellentesque.donec morbi risus pellentesque.donec morbi risus pellentesque. ",
                        "Lorem ipsum dolor sit amet consectetur. Sollicitudin aliquam donec morbi risus pellentesque.donec morbi risus pellentesque.donec morbi risus pellentesque. "
                    ),
                    Triple(R.string.amenities, "Lorem,  ipsum,  dolor, amet.", "Lorem,  ipsum,  dolor, amet.")
                )) { (labelRes, val1, val2) ->
                    CompareRow(stringResource(id = labelRes), val1, val2)
                }

                item {
                    Text(
                        text = "Download Brochure",
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = Color(0xFFF3F3F3))
                            .padding(10.dp),
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily(Font(R.font.poppins)),
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = Color.Black
                    )

                    DownloadButtonRow(
                        isVisible = true,
                        onDownload1Click = { /* download PDF 1 */ },
                        onDownload2Click = { /* download PDF 2 */ }
                    )

                    Spacer(Modifier.height(15.dp))

                    Text(
                        text = stringResource(id = R.string._under_line_fetaure_fac),
                        fontSize = 24.sp,
                        color = Color(0xFFEA5B60),
                        fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
                        modifier = Modifier.padding(top = 10.dp, start = 15.dp, end = 15.dp),
                        style = TextStyle(textDecoration = TextDecoration.Underline)
                    )


                    FeaturedFacilityList(
                        facilities = facilitiesList,
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(max = 300.dp) //  constrain height!
                    )

                }
            }
        }
    }
}


@Composable
fun CompareCard(
    modifier: Modifier = Modifier,
    imageRes: Int,
    buttonText: String = "Select Facility",
    onChangeClick: () -> Unit,
) {
    Card(
        modifier = modifier
            .padding(end = 5.dp)
            .height(170.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE9E9E9))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(170.dp)
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "Facility Image",
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Button(
                onClick = onChangeClick,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5C2C4D)),
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier
                    .align(Alignment.Center)
                    .height(20.dp),
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 0.dp)
            ) {
                Text(
                    text = buttonText,
                    fontSize = 9.sp,
                    color = Color.White,
                    fontFamily = FontFamily(Font(R.font.poppins)),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}


@Composable
fun CompareRow(
    title: String,
    value1: String,
    value2: String,
    backgroundColor: Color = Color(0xFFF3F3F3) // light gray background
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = title,
            modifier = Modifier
                .fillMaxWidth()
                .background(backgroundColor)
                .padding(10.dp),
            textAlign = TextAlign.Center,
            fontFamily = FontFamily(Font(R.font.poppins)),
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color.Black
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 6.dp, vertical = 2.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = value1.ifEmpty { "-" },
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.poppins)),
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = Color.Black
            )
            Text(
                text = value2.ifEmpty { "-" },
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.poppins)),
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = Color.Black
            )
        }


    }
}


@Composable
fun DownloadButtonRow(
    modifier: Modifier = Modifier,
    isVisible: Boolean = false,
    onDownload1Click: () -> Unit = {},
    onDownload2Click: () -> Unit = {}
) {
    if (isVisible) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 35.dp, vertical = 2.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = onDownload1Click,
                modifier = Modifier
                    .weight(1f)
                    .wrapContentHeight()
                    .padding(end = 9.dp),
                colors = ButtonDefaults.buttonColors(
                    Purple,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(20.dp), // adjust based on your `@drawable/download_btn_bg`
                elevation = ButtonDefaults.buttonElevation(4.dp)
            ) {
                Text(
                    text = "Download",
                    fontFamily = FontFamily(Font(R.font.poppins)),
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center
                )
            }

            Button(
                onClick = onDownload2Click,
                modifier = Modifier
                    .weight(1f)
                    .wrapContentHeight(             )
                    .padding(start = 9.dp),
                colors = ButtonDefaults.buttonColors(
                    Purple,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(20.dp),
                elevation = ButtonDefaults.buttonElevation(4.dp)
            ) {
                Text(
                    text = "Download",
                    fontFamily = FontFamily(Font(R.font.poppins)),
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun FacilityTextHeading(text : String){
    Text(
        text = text,
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily(Font(R.font.poppins)),
        color = Purple,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun FacilityTitleText(boldHeading : String , text : String){
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = boldHeading,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
            color = Purple,
        )

        Text(
            text = text,
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily(Font(R.font.poppins)),
        )
    }
}

@Composable
fun FeaturedFacilityList(
    facilities: List<Facility>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(facilities) { facility ->
            FacilityCard(
                facility = facility,
                showRating = false,
                showBookmark = true,
                onBookmarkClick = { /*...*/ },
                onCardClick = {},
                fromTextColor = Color(0xFF5C2C4D)
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun CompareFacilitiesPreview() {
    val navController = rememberNavController()
    CompareFacilities(navController = navController)
}