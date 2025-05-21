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
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
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
import com.bussiness.composeseniorcare.ui.theme.Purple

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
        isBookmarked = true
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
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Top
            ) {
                SearchBar()
                Spacer(modifier = Modifier.height(15.dp))
                BannerSection()
                Spacer(modifier = Modifier.height(15.dp))
                ExploreFacilitiesSection(facilities)
                Spacer(modifier = Modifier.height(15.dp))
                FacilityList(facilitiesList)
                Spacer(modifier = Modifier.height(15.dp))
                FeaturedProvidersSection(providers = featuredFacilityList){ selectedProvider ->

                }


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
    Row(
        modifier = Modifier
            .padding(top = 20.dp)
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

        Text(
            text = "Search for location",
            color = Color(0xFF333333),
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.poppins))
        )

        Spacer(modifier = Modifier.weight(1f))

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .clip(RoundedCornerShape(topEnd = 10.dp, bottomEnd = 10.dp))
                .background(Color(0xFF5C2C4D)) // Purple color
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
            text = "Explore Facilities",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            fontFamily = FontFamily(Font(R.font.poppins_bold))
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
            Spacer(modifier = Modifier.height(4.dp))
            FacilityTitleText("Location : " , facility.location)
            Spacer(modifier = Modifier.height(4.dp))
            FacilityTitleText("Services : " , facility.services)
            Spacer(modifier = Modifier.height(4.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Text(
                    text = "From : " +facility.price,
                    fontSize = 16.sp,
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


// 3. FacilityList Composable
@Composable
fun FacilityList(facilities: List<Facility>) {
    LazyColumn {
        items(facilities) { facility ->
            FacilityCard(facility = facility, fromTextColor = Color(0xFFEA5B60))
        }
    }
}


@Composable
fun FeaturedProvidersSection(
    providers: List<Provider>,
    onProfileClick: (Provider) -> Unit
) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = stringResource(id = R.string.feature_provider),
            fontFamily = FontFamily(Font(R.font.poppins_bold)),
            fontSize = 24.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
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
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Profile Image
        AsyncImage(
            model = provider.imageUrl,
            contentDescription = null,
            modifier = Modifier
                .size(120.dp)
                .clip(RoundedCornerShape(5.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(5.dp))

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp)
        ) {
            Text(
                text = provider.name,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.poppins_bold)),
                color = Purple,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = provider.description,
                fontSize = 11.sp,
                color = Color(0xFF535353),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(2.dp))

            // Location
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Location:",
                    fontSize = 12.sp,
                    color = Purple,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.width(2.dp))
                Text(
                    text = provider.location,
                    fontSize = 11.sp,
                    color = Color(0xFF535353)
                )
            }

            // Services
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Services:",
                    fontSize = 13.sp,
                    color = Purple,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.width(2.dp))
                Text(
                    text = provider.services,
                    fontSize = 11.sp,
                    color = Color(0xFF535353),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            // Website
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Website:",
                    fontSize = 13.sp,
                    color = Purple,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.width(2.dp))
                Text(
                    text = provider.website,
                    fontSize = 11.sp,
                    color = Color(0xFF535353),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            // View Profile Button
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(28.dp)
                    .clip(RoundedCornerShape(6.dp))
                    .background(color = Purple)
                    .clickable { onProfileClick() },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "View Profile",
                    color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }

        // Call Icon
        IconButton(
            onClick = onCallClick,
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.Top)
        ) {
            Image(
                painter = painterResource(id = R.drawable.phone_ic),
                contentDescription = "Call",
            )
        }
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
