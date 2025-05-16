package com.bussiness.composeseniorcare.ui.screen.authflow

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.bussiness.composeseniorcare.R
import com.bussiness.composeseniorcare.navigation.Routes
import com.bussiness.composeseniorcare.ui.component.EmailOrPhoneInput
import com.bussiness.composeseniorcare.ui.component.GoogleButtonWithIcon
import com.bussiness.composeseniorcare.ui.component.HeadingText
import com.bussiness.composeseniorcare.ui.component.PasswordInput
import com.bussiness.composeseniorcare.ui.component.SubmitButton
import com.bussiness.composeseniorcare.ui.theme.BackColor
import com.bussiness.composeseniorcare.ui.theme.Poppins
import com.bussiness.composeseniorcare.ui.theme.Purple

@Composable
fun LoginScreen(
    navController: NavHostController? = null,
    onLoginClick: () -> Unit = {},
    onSignUpClick: () -> Unit = { navController?.navigate(Routes.SIGN_UP) },
    onForgotPasswordClick: () -> Unit = { navController?.navigate(Routes.FORGOT_PASSWORD) },
    onGoogleLoginClick: () -> Unit = {},
) {
    var input by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEAEFF1))
    ) {
        // Top image
        Image(
            painter = painterResource(id = R.drawable.bg_img),
            contentDescription = "House Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp),
            contentScale = ContentScale.FillBounds
        )

        // "Skip" Button
        Image(
            painter = painterResource(id = R.drawable.skip_ic),
            contentDescription = "Skip Button",
            modifier = Modifier
                .background(Color.Transparent, shape = CircleShape)
                .padding(horizontal = 12.dp, vertical = 25.dp)
                .align(Alignment.TopStart)
                .clickable { /* Implement skip logic if needed */ },
        )

        // Overlapping Bottom Box
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.62f)
                .align(Alignment.BottomCenter)
                .clip(RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp))
                .border(
                    width = 2.dp,
                    color = Color(0xFF5A2A60),
                    shape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp)
                )
                .background(color = BackColor)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Top,
            ) {
                Text(
                    text = "Login",
                    modifier = Modifier
                        .padding(top = 30.dp)
                        .align(Alignment.CenterHorizontally),
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Bold,
                        color = Purple,
                        textAlign = TextAlign.Center
                    )
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Log in to your account and explore senior\nliving options tailored to your needs.",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                        color = Color(0xFF808080),
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(25.dp))

                Text(
                    text = "Account",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontFamily = Poppins,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Start
                    )
                )

                Spacer(modifier = Modifier.height(5.dp))

                EmailOrPhoneInput(
                    value = input,
                    onValueChange = { input = it }
                )

                Spacer(modifier = Modifier.height(15.dp))

                HeadingText(text = "Password")

                Spacer(modifier = Modifier.height(10.dp))

                PasswordInput(password = password, onPasswordChange = { password = it })

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "Forgot password?",
                    modifier = Modifier
                        .align(Alignment.End)
                        .clickable { onForgotPasswordClick() },
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontFamily = Poppins,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp,
                        fontStyle = FontStyle.Normal,
                    )
                )

                Spacer(modifier = Modifier.height(15.dp))

                SubmitButton(text = "Login", onClick = onLoginClick, modifier = Modifier)

                Spacer(modifier = Modifier.height(10.dp))

                Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                    Text(
                        text = "Don’t you have an account?",
                        modifier = Modifier,
                        style = MaterialTheme.typography.bodySmall.copy(
                            fontFamily = Poppins,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp,
                            fontStyle = FontStyle.Normal,
                            color = Color.Black
                        )
                    )
                    Text(
                        text = "Sign Up",
                        modifier = Modifier.clickable { onSignUpClick() },
                        style = MaterialTheme.typography.bodySmall.copy(
                            fontFamily = Poppins,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp,
                            fontStyle = FontStyle.Normal,
                            color = Color.Black,
                            textDecoration = TextDecoration.Underline
                        )
                    )
                }

                Spacer(modifier = Modifier.height(18.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Divider(
                        modifier = Modifier
                            .weight(1f)
                            .height(1.dp),
                        color = Color(0xFFD9D9D9)
                    )

                    Text(
                        text = "Or Login with",
                        modifier = Modifier.padding(horizontal = 8.dp),
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontFamily = Poppins,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 14.sp,
                            color = Color.Black
                        )
                    )

                    Divider(
                        modifier = Modifier
                            .weight(1f)
                            .height(1.dp),
                        color = Color(0xFFD9D9D9)
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                GoogleButtonWithIcon(
                    text = "Google",
                    iconRes = R.drawable.google_ic,
                    onClick = { onGoogleLoginClick() },
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(bottom = 20.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    val navController = rememberNavController()
    MaterialTheme {
        LoginScreen(
            navController = navController,
            onLoginClick = {},
            onSignUpClick = {},
            onForgotPasswordClick = {},
            onGoogleLoginClick = {}
        )
    }
}
