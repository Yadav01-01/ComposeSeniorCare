package com.bussiness.composeseniorcare.ui.screen.mainflow

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
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
import com.bussiness.composeseniorcare.ui.component.SubmitButton
import com.bussiness.composeseniorcare.ui.component.TopHeadingText
import com.bussiness.composeseniorcare.ui.theme.Purple

@Composable
fun ProfileScreen(navController: NavHostController) {

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }

    Box(
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
        // You can add a top header or image here for the 15%
        TopHeadingText(text = "Profile", onBackPress = { }, modifier = Modifier   )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.90f)
                .align(Alignment.BottomCenter)
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp, vertical = 15.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Top
            ) {
                // Profile content
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 28.dp), // Adjust as needed
                    contentAlignment = Alignment.TopCenter
                ){
                    ProfileImageWithCamera(
                        profileImage = painterResource(id = R.drawable.profile_ic_image), // your profile image
                        cameraIcon = painterResource(id = R.drawable.cam_ic),         // your camera icon
                        onCameraClick = {
                            // Open camera or gallery
                        }
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp),
                    contentAlignment = Alignment.Center
                ) {
                    EditProfileButton()
                }

                ProfileInfoItem("Name",name, onValueChange = { name = it },
                    painterResource(id = R.drawable.name_ic), showEditIcon = true)

                Spacer(Modifier.height(5.dp))

                ValidityInfoItem("Email", email, onValueChange = { email = it },
                    painterResource(id = R.drawable.email_ic))

                Spacer(Modifier.height(5.dp))

                ValidityInfoItem("Phone", phone, onValueChange = { phone = it },
                    painterResource(id = R.drawable.call_ic))

                Spacer(Modifier.height(5.dp))

                ProfileInfoItem("Location",location, onValueChange = { location = it },
                    painterResource(id = R.drawable.loc_ic), showEditIcon = true)

                Spacer(Modifier.height(80.dp))

                SubmitButton(
                    text = "Save Changes",
                    onClick = {

                    },
                    modifier = Modifier.padding(horizontal = 10.dp),
                    fontSize = 20
                )
            }
        }
    }
}

@Composable
fun ProfileImageWithCamera(
    profileImage: Painter,
    cameraIcon: Painter,
    onCameraClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.BottomEnd,
        modifier = Modifier
            .size(120.dp)
            .padding(8.dp),

    ) {
        // Circular Profile Image
        Image(
            painter = profileImage,
            contentDescription = "Profile Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .border(2.dp, Color.White, CircleShape)
        )

        // Camera Icon Overlay
        Box(
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape)
                .background(Color(0xFF5C2C4D))
                .clickable { onCameraClick() },
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = cameraIcon,
                contentDescription = "Camera Icon",
                modifier = Modifier.wrapContentSize()
            )
        }
    }
}

@Composable
fun EditProfileButton(
    onClick: () -> Unit = {}
) {
    OutlinedButton(
        onClick = onClick,
        shape = RoundedCornerShape(5.dp),
        border = BorderStroke(1.dp, Purple),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.White,
            contentColor = Purple
        ),
        contentPadding = PaddingValues(horizontal = 15.dp, vertical = 3.dp),
        modifier = Modifier.height(32.dp)
    ) {
        Text(
            text = "Edit profile",
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.poppins)),
            fontWeight = FontWeight.Normal,
            color = Purple
        )
    }
}



@Composable
fun ProfileInfoItem(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    icon: Painter,
    modifier: Modifier = Modifier,
    isEditable: Boolean = true,
    showEditIcon: Boolean = false,
    onEditClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(top = 15.dp)
    ) {
        // Left icon in a Card
        Card(
            modifier = Modifier
                .padding(2.dp)
                .wrapContentSize(),
            shape = CircleShape,
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Box(
                modifier = Modifier
                    .background(Color(0xFFF0F0F0), shape = CircleShape)
                    .padding(6.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = icon,
                    contentDescription = "Field Icon",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(24.dp)
                )
            }
        }

        // Label and input field
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp)
        ) {
            Text(
                text = label,
                color = Color(0xFF4E4E4E),
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.poppins))
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
            ) {
                BasicTextField(
                    value = value,
                    onValueChange = onValueChange,
                    singleLine = true,
                    enabled = isEditable,
                    textStyle = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.poppins)),
                        color = Color.Black
                    ),
                    cursorBrush = SolidColor(Color.Black),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = if (showEditIcon) 40.dp else 0.dp)
                        .align(Alignment.BottomStart),
                    decorationBox = { innerTextField ->
                        Box {
                            if (value.isEmpty()) {
                                Text(
                                    text = "Enter $label",
                                    fontSize = 16.sp,
                                    fontFamily = FontFamily(Font(R.font.poppins)),
                                    color = Color.Gray
                                )
                            }
                            innerTextField()
                        }
                    }
                )

                if (showEditIcon) {
                    IconButton(
                        onClick = onEditClick,
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .size(36.dp)
                            .padding(end = 4.dp, top = 4.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.edit_pen),
                            contentDescription = "Edit",
                            tint = Color.Unspecified
                        )
                    }
                }

                Divider(
                    color = Color(0xFFD4D4D4),
                    thickness = 1.dp,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .fillMaxWidth()
                )
            }
        }
    }
}


@Composable
fun ValidityInfoItem(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    icon: Painter,
    modifier: Modifier = Modifier,
    isEditable: Boolean = true,
    showEditIcon: Boolean = false,
    onVerifyClick: () -> Unit = {}
) {
    val grayColor = Color(0xFFD4D4D4)

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(top = 15.dp)
    ) {
        // Left icon
        Card(
            modifier = Modifier
                .padding(2.dp)
                .wrapContentSize(),
            shape = CircleShape,
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Box(
                modifier = Modifier
                    .background(Color(0xFFF0F0F0), shape = CircleShape)
                    .padding(6.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = icon,
                    contentDescription = "Field Icon",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(24.dp)
                )
            }
        }

        // Right side content
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp)
        ) {
            Text(
                text = label,
                color = Color(0xFF4E4E4E),
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.poppins))
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min) // Key to make content wrap tightly
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.Bottom
                ) {
                    // TextField aligned to bottom
                    BasicTextField(
                        value = value,
                        onValueChange = onValueChange,
                        singleLine = true,
                        enabled = isEditable,
                        textStyle = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.poppins)),
                            color = Color.Black
                        ),
                        cursorBrush = SolidColor(Color.Black),
                        modifier = Modifier
                            .weight(1f)
                            .align(Alignment.Bottom)
                            .padding(end = 8.dp),
                        decorationBox = { innerTextField ->
                            Box {
                                if (value.isEmpty()) {
                                    Text(
                                        text = "Enter $label",
                                        fontSize = 16.sp,
                                        fontFamily = FontFamily(Font(R.font.poppins)),
                                        color = Color.Gray
                                    )
                                }
                                innerTextField()
                            }
                        }
                    )

                    // Verify button
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .clip(RoundedCornerShape(5.dp))
                            .background(color = Purple)
                            .clickable { onVerifyClick() }
                            .padding(horizontal = 10.dp, vertical = 1.dp)
                    ) {
                        Text(
                            text = "Verify",
                            fontFamily = FontFamily(Font(R.font.poppins)),
                            fontSize = 10.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                    }
                }

                Divider(
                    color = grayColor,
                    thickness = 1.dp,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .fillMaxWidth()
                )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    val navController = rememberNavController()
    MaterialTheme {
        ProfileScreen(
            navController = navController,
        )
    }
}