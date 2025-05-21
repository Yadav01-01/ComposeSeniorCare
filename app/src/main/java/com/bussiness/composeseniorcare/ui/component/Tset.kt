package com.bussiness.composeseniorcare.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import coil.compose.AsyncImage
import com.bussiness.composeseniorcare.R
import com.bussiness.composeseniorcare.data.model.Facility
import com.bussiness.composeseniorcare.data.model.Provider
import com.bussiness.composeseniorcare.ui.screen.mainflow.FacilityTextHeading
import com.bussiness.composeseniorcare.ui.screen.mainflow.FacilityTitleText
import com.bussiness.composeseniorcare.ui.theme.Purple

//@Composable
//fun FeaturedProvidersSection(
//    providers: List<Provider>,
//    onProfileClick: (Provider) -> Unit
//) {
//    Column(modifier = Modifier.padding(16.dp)) {
//        Text(
//            text = stringResource(id = R.string.feature_provider),
//            fontFamily = FontFamily(Font(R.font.poppins_bold)),
//            fontSize = 24.sp,
//            color = Color.Black
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        LazyColumn(
//            verticalArrangement = Arrangement.spacedBy(12.dp)
//        ) {
//            items(providers) { provider ->
//                ProviderCard(
//                    provider = provider,
//                    onProfileClick = { onProfileClick(provider) },
//                    onCallClick = { /* Handle call click */ }
//                )
//            }
//        }
//    }
//}
//
//@Composable
//fun ProviderCard(
//    provider: Provider,
//    onProfileClick: () -> Unit,
//    onCallClick: () -> Unit
//) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(5.dp),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        // Profile Image
//        AsyncImage(
//            model = provider.imageUrl,
//            contentDescription = null,
//            modifier = Modifier
//                .size(120.dp)
//                .clip(RoundedCornerShape(5.dp)),
//            contentScale = ContentScale.Crop
//        )
//
//        Spacer(modifier = Modifier.width(5.dp))
//
//        Column(
//            modifier = Modifier
//                .weight(1f)
//                .padding(end = 8.dp)
//        ) {
//            Text(
//                text = provider.name,
//                fontSize = 12.sp,
//                fontWeight = FontWeight.Bold,
//                fontFamily = FontFamily(Font(R.font.poppins_bold)),
//                color = Purple,
//                maxLines = 1,
//                overflow = TextOverflow.Ellipsis
//            )
//
//            Text(
//                text = provider.description,
//                fontSize = 11.sp,
//                color = Color(0xFF535353),
//                maxLines = 2,
//                overflow = TextOverflow.Ellipsis
//            )
//
//            Spacer(modifier = Modifier.height(2.dp))
//
//            Row(verticalAlignment = Alignment.CenterVertically) {
//                Text(
//                    text = "Location:",
//                    fontSize = 12.sp,
//                    color = Purple,
//                    fontWeight = FontWeight.SemiBold
//                )
//                Spacer(modifier = Modifier.width(2.dp))
//                Text(
//                    text = provider.location,
//                    fontSize = 11.sp,
//                    color = Color(0xFF535353)
//                )
//            }
//
//            Row(verticalAlignment = Alignment.CenterVertically) {
//                Text(
//                    text = "Services:",
//                    fontSize = 13.sp,
//                    color = Purple,
//                    fontWeight = FontWeight.SemiBold
//                )
//                Spacer(modifier = Modifier.width(2.dp))
//                Text(
//                    text = provider.services,
//                    fontSize = 11.sp,
//                    color = Color(0xFF535353),
//                    maxLines = 1,
//                    overflow = TextOverflow.Ellipsis
//                )
//            }
//
//            Row(verticalAlignment = Alignment.CenterVertically) {
//                Text(
//                    text = "Website:",
//                    fontSize = 13.sp,
//                    color = Purple,
//                    fontWeight = FontWeight.SemiBold
//                )
//                Spacer(modifier = Modifier.width(2.dp))
//                Text(
//                    text = provider.website,
//                    fontSize = 11.sp,
//                    color = Color(0xFF535353),
//                    maxLines = 1,
//                    overflow = TextOverflow.Ellipsis
//                )
//            }
//
//            Spacer(modifier = Modifier.height(4.dp))
//
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(28.dp)
//                    .clip(RoundedCornerShape(6.dp))
//                    .background(color = Purple)
//                    .clickable { onProfileClick() },
//                contentAlignment = Alignment.Center
//            ) {
//                Text(
//                    text = "View Profile",
//                    color = Color.White,
//                    fontSize = 12.sp,
//                    fontWeight = FontWeight.SemiBold
//                )
//            }
//        }
//
//        IconButton(
//            onClick = onCallClick,
//            modifier = Modifier
//                .wrapContentSize()
//                .align(Alignment.Top)
//        ) {
//            Image(
//                painter = painterResource(id = R.drawable.phone_ic),
//                contentDescription = "Call"
//            )
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun ProviderCardPreview() {
//    val sampleProvider = Provider(
//        name = "Dr. Jane Smith",
//        description = "Experienced elder care specialist with 10+ years of service.",
//        location = "Los Angeles, CA",
//        services = "Home visits, Medication assistance",
//        website = "www.drjanesmithcare.com",
//        imageUrl = "https://via.placeholder.com/150" // Use a valid image URL for preview
//    )
//
//    ProviderCard(
//        provider = sampleProvider,
//        onProfileClick = {},
//        onCallClick = {}
//    )
//}

@Composable
fun FacilityCard(
    facility: Facility,
    modifier: Modifier = Modifier,
    showRating: Boolean = true,
    showBookmark: Boolean = true,
    onBookmarkClick: ((Facility) -> Unit)? = null,
    onCardClick: ((Facility) -> Unit)? = null,
    cornerRadius: Dp = 12.dp,
    cardElevation: Dp = 4.dp
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
                    modifier = Modifier.fillMaxSize()
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    if (showRating) {
                        Surface(
                            color = Color.White,
                            shape = RoundedCornerShape(5.dp),
                            shadowElevation = 2.dp
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
                                    modifier = Modifier.wrapContentSize(),
                                    tint = Color.Unspecified
                                )
                            }
                        }
                    }

                    if (showBookmark) {
                        Icon(
                            painter = painterResource(
                                id = if (facility.isBookmarked) R.drawable.select_bm else R.drawable.bookmark_
                            ),
                            contentDescription = "Bookmark",
                            modifier = Modifier
                                .wrapContentSize()
                                .clickable { onBookmarkClick?.invoke(facility) },
                            tint = Color.Unspecified
                        )
                    }
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


@Preview(showBackground = true)
@Composable
fun FacilityCardPreview() {
    val sampleFacility = Facility(
        imageResId = R.drawable.banner_bg, // Replace with a valid drawable
        name = "Lorem ipsum",
        location = "City, State, Country",
        services = "Assisted Living, Memory Care",
        price = "$25.9",
        rating = "4.8",
        isBookmarked = true
    )

    FacilityCard(facility = sampleFacility)
}
