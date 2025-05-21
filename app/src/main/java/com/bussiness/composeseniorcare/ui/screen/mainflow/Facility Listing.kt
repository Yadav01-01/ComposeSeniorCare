package com.bussiness.composeseniorcare.ui.screen.mainflow

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.bussiness.composeseniorcare.R
import com.bussiness.composeseniorcare.data.model.Facility
import com.bussiness.composeseniorcare.ui.component.SharpEdgeButton

@Composable
fun FacilityListing(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
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

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(Color.White)

        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp)
                    .background(color = Color.White)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Top
            ) {
                SearchBarWithFilter(onClickFilter = { }, onClickSearch = { })
                Spacer(modifier = Modifier.height(15.dp))
                MapBox()
                Spacer(modifier = Modifier.height(10.dp))
                Text("Facilities",
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(R.font.poppins)),
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFEA5B60),)
                Spacer(modifier = Modifier.height(10.dp))
                FacilityView(facilitiesList)
                Spacer(modifier = Modifier.height(10.dp))
                Text("Exclusive Offers",
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(R.font.poppins)),
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFEA5B60),
                    textAlign = TextAlign.Center)
                Text("Lorem ipsum dolor sit amet consectetur. Orci\n malesuada mi et mi pellentesque tincidunt at mollis\n facilisis. Nisl eu blandit nunc parturient adipiscing\n commodo.",
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins)),
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF535353),
                    textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(10.dp))
                SharpEdgeButton("Join Now !", onClickButton = { }, buttonTextSize = 14)


            }
        }
    }
}

@Composable
fun SearchBarWithFilter(
    onClickFilter: () -> Unit,
    onClickSearch: () -> Unit) {
    Row(
        modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxWidth()
            .height(48.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xFFF3F3F3))
            .border(1.dp, Color(0xFFD9D9D9), RoundedCornerShape(10.dp)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(12.dp))

        Icon(
            painter = painterResource(id = R.drawable.location_ic),
            contentDescription = "Location",
            tint = Color.Unspecified,
            modifier = Modifier.size(20.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = "Address, City, ZIP",
            color = Color(0xFF333333),
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.poppins)),
            modifier = Modifier.weight(1f)
        )

        Icon(
            painter = painterResource(id = R.drawable.filter_ic),
            contentDescription = "Filter",
            tint = Color.Unspecified,
            modifier = Modifier
                .wrapContentSize()
                .clickable { onClickFilter() }
                .padding(end = 8.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .clip(RoundedCornerShape(topEnd = 10.dp, bottomEnd = 10.dp))
                .background(Color(0xFF5C2C4D))
                .clickable { onClickSearch() }
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Search",
                color = Color.White,
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.poppins)),
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Composable
fun MapBox(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(20.dp))
            .background(Color.White)
    ){
        Image(
            painter = painterResource(R.drawable.map_ic),
            contentDescription = "Map",
            modifier = Modifier.height(240.dp).fillMaxWidth(),
            contentScale = ContentScale.Fit
        )

    }
}

@Composable
fun FacilityView(facilities: List<Facility>) {
    LazyColumn {
        items(facilities) { facility ->
            FacilityCard(facility = facility, fromTextColor = Color(0xFFEA5B60))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FacilityListingPreview() {
    val navController = rememberNavController()
    MaterialTheme {
        FacilityListing(
            navController = navController,
        )
    }
}
