package com.bussiness.composeseniorcare.ui.screen.mainflow

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.bussiness.composeseniorcare.R

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFFFFFFF),
                        Color(0xFF5C2C4D),
                        Color(0xFF5C2C4D)
                    )
                )
            )
    ) {
        CustomTopAppBar()
    }
}

@Composable
fun CustomTopAppBar() {
    Surface(
        shape = RoundedCornerShape(10.dp),
        color = Color.White,
        shadowElevation = 8.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
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

            Spacer(modifier = Modifier.weight(1f))

            Image(
                painter = painterResource(id = R.drawable.logo_arce), // Replace with your actual image name
                contentDescription = "GenAcre Logo",
                modifier = Modifier
                    .height(28.dp) // adjust height to fit well
            )

            Spacer(modifier = Modifier.weight(1f))


        }
    }
}

@Composable
fun CreditsText(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .wrapContentSize()
            .padding(end = dimensionResource(id = R.dimen._10sdp)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.twemoji_coin),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier
                .size(16.dp) // Or adjust to your icon size
        )

        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen._3sdp)))

        Text(
            text = stringResource(id = R.string.credits_5),
            color = Color(0xFFEA5B60),
            fontSize = dimensionResource(id = R.dimen._9ssp).value.sp,
            fontFamily = FontFamily(Font(R.font.jakarta_sans)),
            textAlign = TextAlign.Center,
            modifier = Modifier.widthIn(max = dimensionResource(id = R.dimen._70sdp)),
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
