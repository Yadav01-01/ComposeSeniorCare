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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
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
import com.bussiness.composeseniorcare.ui.component.SharpEdgeButton
import com.bussiness.composeseniorcare.ui.component.SubmitButton
import com.bussiness.composeseniorcare.ui.component.TopHeadingText
import com.bussiness.composeseniorcare.ui.theme.Purple

@Composable
fun ProfileScreen(navController: NavHostController) {
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

                ProfileInfoItem("Name","Enter name", onNameChange = { /* Handle name change */ },
                    painterResource(id = R.drawable.name_ic), showEditIcon = true)

                Spacer(Modifier.height(5.dp))

                ValidityInfoItem("Email", "Enter email", onNameChange = { /* Handle phone change */ },
                    painterResource(id = R.drawable.email_ic))

                Spacer(Modifier.height(5.dp))

                ValidityInfoItem("Phone", "Enter phone number", onNameChange = { /* Handle phone change */ },
                    painterResource(id = R.drawable.call_ic))

                Spacer(Modifier.height(5.dp))

                ProfileInfoItem("Location","Enter location", onNameChange = { /* Handle name change */ },
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
        contentPadding = PaddingValues(horizontal = 15.dp, vertical = 1.dp),
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
    name: String,
    hint: String,
    onNameChange: (String) -> Unit,
    icon : Painter,
    modifier: Modifier = Modifier,
    isEditable: Boolean = false,
    showEditIcon: Boolean = false,
    onEditClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(top = 15.dp)
    ) {
        // Left icon in Card
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
                    contentDescription = "Name Icon",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(24.dp)
                )
            }
        }

        // Text content and input field
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp)
        ) {
            Text(
                text = name, // Or stringResource(R.string.name)
                color = Color(0xFF4E4E4E),
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.poppins)),
                modifier = Modifier.background(Color.White)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min) // So divider respects the height of content
            ) {
                BasicTextField(
                    value = hint,
                    onValueChange = onNameChange,
                    singleLine = true,
                    textStyle = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.poppins)),
                        color = Color.Black
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = if (showEditIcon) 40.dp else 0.dp)  // leave space for icon if visible
                        .align(Alignment.CenterStart),
                    cursorBrush = SolidColor(Color.Black),
                    decorationBox = { innerTextField ->
                        if (name.isEmpty()) {
                            Text(
                                text = "Enter name",
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.poppins)),
                                color = Color.Gray,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                        innerTextField()
                    }
                )

                if (showEditIcon) {
                    IconButton(
                        onClick = onEditClick,
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .size(36.dp)  // increase touch target size for better UX
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
                    color = Color.Gray,
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
    name: String,
    hint: String,
    onNameChange: (String) -> Unit,
    icon : Painter,
    modifier: Modifier = Modifier,
    isEditable: Boolean = false,
    showEditIcon: Boolean = false,
    onVerifyClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(top = 15.dp)
    ) {
        // Left icon in Card
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
                    contentDescription = "Name Icon",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(24.dp)
                )
            }
        }

        // Text content and input field
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp)
        ) {
            Text(
                text = name, // Or stringResource(R.string.name)
                color = Color(0xFF4E4E4E),
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.poppins)),
                modifier = Modifier.background(Color.White)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                // Main content layout
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 4.dp), // space above divider
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    BasicTextField(
                        value = hint,
                        onValueChange = onNameChange,
                        singleLine = true,
                        textStyle = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.poppins)),
                            color = Color.Black
                        ),
                        modifier = Modifier
                            .weight(1f) // Take all available space except for the button
                            .padding(end = 8.dp),
                        cursorBrush = SolidColor(Color.Black),
                        decorationBox = { innerTextField ->
                            Box {
                                if (hint.isEmpty()) {
                                    Text(
                                        text = "Enter name",
                                        fontSize = 12.sp,
                                        fontFamily = FontFamily(Font(R.font.poppins)),
                                        color = Color.Gray
                                    )
                                }
                                innerTextField()
                            }
                        }
                    )

                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = modifier
                            .wrapContentWidth()
                            .wrapContentHeight()
                            .clip(RoundedCornerShape(5.dp))
                            .background(color = Purple)
                            .clickable { onVerifyClick() }
                            .padding(horizontal = 10.dp)
                            .align(Alignment.CenterVertically)
                    ) {
                        Text(
                            text = "Verify",
                            fontFamily = FontFamily(Font(R.font.poppins)),
                            fontSize = 9.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                    }


                }

                // Underline below the full row (text + button)
                Divider(
                    color = Color.Gray,
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