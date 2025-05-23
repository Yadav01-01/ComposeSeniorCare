package com.bussiness.composeseniorcare.ui.screen.mainflow

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.bussiness.composeseniorcare.R
import com.bussiness.composeseniorcare.data.model.Facility
import com.bussiness.composeseniorcare.data.model.PosterItem
import com.bussiness.composeseniorcare.data.model.Provider
import com.bussiness.composeseniorcare.navigation.Routes
import com.bussiness.composeseniorcare.ui.theme.Purple
import com.bussiness.composeseniorcare.ui.theme.Readish

val facilities = List(5) {
    PosterItem(R.drawable.poster,"Assisted Living", "Lorem ipsum dolor sit amet, consectetur adipiscing elit")
}

val facilitiesList = List(2) {
    Facility(
        imageResId = R.drawable.banner_bg, // Replace with a valid drawable
        name = "Lorem ipsum",
        location = "City, State, Country",
        services = "Assisted Living, Memory Care",
        price = "$25.9",
        rating = "4.8",
        isBookmarked = false
    )
}

private val featuredFacilityList = List(2) {
    Provider(
        "Mathew John",
        "Experienced caregiver with passion for memory care.",
        "City, State, Country",
        "Assisted Living, Memory Care",
        "www.abc.com",
        "https://via.placeholder.com/150"
    )
}



@Composable
fun HomeScreen(navController: NavHostController) {
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
        CustomTopAppBar()

        // Main content
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(Color.White)
                .padding(horizontal = 15.dp, vertical = 15.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            item { SearchBar() }
            item { BannerSection() }
            item { ExploreFacilitiesSection(facilities) }
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(color = Color.Black, fontWeight = FontWeight.Bold)) {
                                append("Featured ")
                            }
                            withStyle(style = SpanStyle(color = Readish, fontWeight = FontWeight.Bold)) {
                                append("Facilities")
                            }
                        },
                        fontSize = 24.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semi_bold))
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Text(
                        text = "See all+",
                        textDecoration = TextDecoration.Underline,
                        fontSize = 10.sp,
                        color = Color.Black,
                        fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
                        modifier = Modifier.clickable {
                            navController.navigate(Routes.FACILITY_LISTING)
                        }
                    )
                }
            }
            item {
                FeaturedFacilityList(
                    facilities = facilitiesList,
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(max = 300.dp)
                )
            }
            item {
                FeaturedProvidersSection(
                    providers = featuredFacilityList,
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(max = 300.dp), onProfileClick = { })
            }

        }
    }
}


@Composable
fun CustomTopAppBar(showCredit: Boolean = true) {
    val statusBarPadding = WindowInsets.statusBars.asPaddingValues()

    Surface(
        shape = RoundedCornerShape(10.dp),
        color = Color.White,
        shadowElevation = 8.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = statusBarPadding.calculateTopPadding(),
                start = 16.dp,
                end = 16.dp,
                bottom = 8.dp
            )
            .height(50.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu",
                tint = Color(0xFF4B2E56),
                modifier = Modifier.size(24.dp)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Box(
                modifier = Modifier
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_arce),
                    contentDescription = "GenAcre Logo",
                    modifier = Modifier.height(28.dp)
                )
            }

            if (showCredit) {
                CreditsText(modifier = Modifier.padding(start = 8.dp))
            }
        }
    }
}


@Composable
fun CreditsText(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .wrapContentSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {
        Icon(
            painter = painterResource(id = R.drawable.twemoji_coin),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier.size(16.dp)
        )

        Spacer(modifier = Modifier.width(5.dp))

        Text(
            text = "Credits : 5",
            color = Color(0xFFEA5B60),
            fontSize = 12.sp,
            fontFamily = FontFamily(Font(R.font.jakarta_sans)),
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.widthIn(max = 70.dp)
        )
    }
}

@Composable
fun SearchBar() {
    var searchText by remember { mutableStateOf("") }

    Row(
        modifier = Modifier
            .padding(top = 5.dp)
            .fillMaxWidth()
            .height(48.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xFFF3F3F3))
            .border(width = 1.dp, color = Color(0xFFD9D9D9), shape = RoundedCornerShape(10.dp)),
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

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            contentAlignment = Alignment.CenterStart
        ) {
            BasicTextField(
                value = searchText,
                onValueChange = { searchText = it },
                singleLine = true,
                textStyle = TextStyle(
                    color = Color(0xFF333333),
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins))
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp)
            )

            if (searchText.isEmpty()) {
                Text(
                    text = "Search for location",
                    color = Color.Gray,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins))
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .clip(RoundedCornerShape(topEnd = 10.dp, bottomEnd = 10.dp))
                .background(Color(0xFF5C2C4D))
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
fun BannerSection() {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .fillMaxWidth()
            .background(color = Color.Gray)
            .height(180.dp)
    ) {

        Image(
            painter = painterResource(id = R.drawable.banner_bg),
            contentDescription = "Banner",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop

        )
        // Use Coil for image
        Text(
            text = "Explore trusted senior living facilities\n tailored to your needs. Search, compare,\n and connect effortlessly today!",
            modifier = Modifier.align(Alignment.Center).padding(10.dp),
            textAlign = TextAlign.Center,
            color = Color.White,
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),

            )
    }
}
@Composable
fun ExploreFacilitiesSection(facilities: List<PosterItem>) {
    Column(modifier = Modifier) {
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Black, fontWeight = FontWeight.Bold)) {
                    append("Explore ")
                }
                withStyle(style = SpanStyle(color = Readish, fontWeight = FontWeight.Bold)) {
                    append("Facilities")
                }
            },
            fontSize = 24.sp,
            fontFamily = FontFamily(Font(R.font.poppins_semi_bold))
        )


        Spacer(modifier = Modifier.height(8.dp))

        LazyRow {
            items(facilities) { facility ->
                Column(
                    modifier = Modifier
                        .padding(end = 5.dp)
                        .width(145.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.White)
                ) {
                    Image(
                        painter = painterResource(id = facility.imageResId),
                        contentDescription = facility.title,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(145.dp)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
                    )

                    Column(modifier = Modifier.padding(top = 2.dp)) {
                        Text(
                            text = facility.title,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
                            color = Color(0xFFD2265B),
                            fontSize = 14.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )

                        Spacer(modifier = Modifier.height(2.dp))

                        Text(
                            text = facility.description,
                            fontWeight = FontWeight.Normal,
                            fontFamily = FontFamily(Font(R.font.poppins)),
                            color = Color(0xFF535353),
                            fontSize = 12.sp,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
        }
    }
}



@Composable
fun FacilityCard(
    facility: Facility,
    modifier: Modifier = Modifier,
    showRating: Boolean = true,
    showBookmark: Boolean = true,
    onBookmarkClick: ((Facility) -> Unit)? = null,
    onCardClick: ((Facility) -> Unit)? = null,
    cornerRadius: Dp = 12.dp,
    cardElevation: Dp = 4.dp,
    fromTextColor : Color
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable(enabled = onCardClick != null) { onCardClick?.invoke(facility) }
    ) {
        Card(
            shape = RoundedCornerShape(cornerRadius),
            elevation = CardDefaults.cardElevation(defaultElevation = cardElevation),
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Image(
                    painter = painterResource(id = facility.imageResId),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                )

                // Rating (if shown)
                if (showRating) {
                    Surface(
                        color = Color.White,
                        shape = RoundedCornerShape(5.dp),
                        shadowElevation = 2.dp,
                        modifier = Modifier
                            .padding(8.dp)
                            .align(Alignment.TopStart)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        ) {
                            Text(
                                text = facility.rating,
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_semi_bold))
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Icon(
                                painter = painterResource(id = R.drawable.star1),
                                contentDescription = "star icon",
                                tint = Color.Unspecified
                            )
                        }
                    }
                }

                // Bookmark (always topEnd if shown)
                if (showBookmark) {
                    Icon(
                        painter = painterResource(
                            id = if (facility.isBookmarked) R.drawable.select_bm else R.drawable.bookmark_
                        ),
                        contentDescription = "Bookmark",
                        modifier = Modifier
                            .padding(8.dp)
                            .align(Alignment.TopEnd)
                            .clickable { onBookmarkClick?.invoke(facility) },
                        tint = Color.Unspecified
                    )
                }
            }

        }

        Column(modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 8.dp)) {
            FacilityTextHeading(facility.name)
//            Spacer(modifier = Modifier.height(2.dp))
            FacilityTitleText("Location : " , facility.location)
//            Spacer(modifier = Modifier.height(2.dp))
            FacilityTitleText("Services : " , facility.services)
//            Spacer(modifier = Modifier.height(2.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Text(
                    text = "From : " +facility.price,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
                    color = Color(0xFFEA5B60)
                )

                Icon(
                    painter = painterResource(R.drawable.arrow_ic),
                    contentDescription = "arrow icon",
                    Modifier.wrapContentSize()
                )
            }
        }
    }
}




@Composable
fun FeaturedProvidersSection(
    providers: List<Provider>,
    onProfileClick: (Provider) -> Unit,
    modifier: Modifier
) {
    Column(modifier) {
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Black, fontWeight = FontWeight.Bold)) {
                    append("Featured ")
                }
                withStyle(style = SpanStyle(color = Readish, fontWeight = FontWeight.Bold)) {
                    append("Providers")
                }
            },
            fontFamily = FontFamily(Font(R.font.poppins_bold)),
            fontSize = 24.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            items(providers) { provider ->
                ProviderCard(
                    provider = provider,
                    onProfileClick = { onProfileClick(provider) },
                    onCallClick = { /* Handle call click */ }
                )
            }
        }
    }
}

@Composable
fun ProviderCard(
    provider: Provider,
    onProfileClick: () -> Unit,
    onCallClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp) // Fixed height for both image and content
            .padding(horizontal = 0.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Profile Image
        AsyncImage(
            model = provider.imageUrl,
            error = painterResource(id = R.drawable.image_ic_fet),
            contentDescription = null,
            modifier = Modifier
                .size(150.dp) // Fixed size
                .clip(RoundedCornerShape(5.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(6.dp))

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(), // Match height of the row/image
            verticalArrangement = Arrangement.SpaceBetween // Even spacing inside
        ) {
            Text(
                text = provider.name,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.poppins_bold)),
                color = Purple,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = provider.description,
                fontSize = 9.sp,
                fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
                color = Color(0xFF535353),
                maxLines = 2,
                lineHeight = 11.sp,
                overflow = TextOverflow.Ellipsis
            )

            InfoRow(label = "Location:", value = provider.location)
            InfoRow(label = "Services:", value = provider.services)
            InfoRow(label = "Website:", value = provider.website)

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(25.dp)
                    .clip(RoundedCornerShape(3.dp))
                    .background(Purple)
                    .clickable { onProfileClick() },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "View Profile",
                    color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily(Font(R.font.poppins_semi_bold))
                )
            }
        }

        IconButton(
            onClick = onCallClick,
            modifier = Modifier
                .size(28.dp)
                .padding(start = 4.dp)
                .align(Alignment.Top)
        ) {
            Image(
                painter = painterResource(id = R.drawable.phone_ic),
                contentDescription = "Call"
            )
        }
    }
}

@Composable
fun InfoRow(label: String, value: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = label,
            fontSize = 9.sp,
            fontWeight = FontWeight.SemiBold,
            color = Purple,
            lineHeight = 15.sp,
            maxLines = 1,
            fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.width(2.dp))
        Text(
            text = value,
            fontSize = 9.sp,
            lineHeight = 15.sp,
            color = Color(0xFF535353),
            fontFamily = FontFamily(Font(R.font.poppins)),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}




@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    val navController = rememberNavController()
    MaterialTheme {
        HomeScreen(navController = navController)
    }
}
