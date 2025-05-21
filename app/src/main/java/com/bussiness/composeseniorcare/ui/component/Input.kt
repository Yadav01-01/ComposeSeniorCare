package com.bussiness.composeseniorcare.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bussiness.composeseniorcare.R
import com.bussiness.composeseniorcare.ui.theme.BackColor
import com.bussiness.composeseniorcare.ui.theme.Poppins
import com.bussiness.composeseniorcare.ui.theme.Purple
import com.bussiness.composeseniorcare.util.ErrorMessage



@Composable
fun EmailOrPhoneInput(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String = ErrorMessage.EMAIL_OR_PHONE,
    placeholder: String = ErrorMessage.EMAIL_OR_PHONE
) {
    var isError by remember { mutableStateOf(false) }

    fun validate(input: String): Boolean {
        val isEmail = android.util.Patterns.EMAIL_ADDRESS.matcher(input).matches()
        val isPhone = android.util.Patterns.PHONE.matcher(input).matches()
        return isEmail || isPhone
    }


    OutlinedTextField(
        value = value,
        onValueChange = {
            onValueChange(it)
            isError = !validate(it) && it.isNotEmpty()
        },
        label = { Text(label) },
        placeholder = { Text(placeholder) },
        isError = isError,
        singleLine = true,
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(10.dp),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Done
        ),
        trailingIcon = {
            if (isError) {
                Image(
                    painter = painterResource(id = R.drawable.mail_ic_),
                    contentDescription = "Error",
                )
            }
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = if (isError) MaterialTheme.colorScheme.error else Color(0xFFD0D0D0),
            unfocusedBorderColor = if (isError) MaterialTheme.colorScheme.error else Color(0xFFD0D0D0),
            errorBorderColor = MaterialTheme.colorScheme.error,
            focusedContainerColor = BackColor,
            unfocusedContainerColor = BackColor,
            errorContainerColor = BackColor
        )
    )
}


@Composable
fun HeadingText(
    modifier: Modifier = Modifier,
    text: String = ""
) {
    Text(
        text = text,
        modifier = modifier,
        style = MaterialTheme.typography.bodyMedium.copy(
            fontFamily = Poppins,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            fontSize = 16.sp,
            textAlign = TextAlign.Start
        )
    )
}

@Composable
fun PasswordInput(
    password: String,
    onPasswordChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String = "Password",
    placeholder: String = "Enter your password"
) {
    var passwordVisible by remember { mutableStateOf(false) }

    // Validation checks
    val hasMinLength = password.length >= 8
    val hasUpperCase = password.any { it.isUpperCase() }
    val hasSpecialChar = password.any { !it.isLetterOrDigit() }
    val hasNumber = password.any { it.isDigit() }

    val isValid = hasMinLength && hasUpperCase && hasSpecialChar && hasNumber
    val isError = password.isNotEmpty() && !isValid

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = BackColor)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 2.dp,
                    color = if (isError) MaterialTheme.colorScheme.error else Color(0xFFD0D0D0),
                    shape = MaterialTheme.shapes.small
                )
        ) {
            TextField(
                value = password,
                onValueChange = onPasswordChange,
                placeholder = { Text(placeholder) },
                singleLine = true,
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                isError = isError,
                modifier = Modifier.fillMaxWidth(),  // fill width inside the bordered Box
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent, // remove default underline indicator
                    unfocusedIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent
                ),
                trailingIcon = {
                    val image = if (passwordVisible)
                        Icons.Default.Visibility
                    else
                        Icons.Default.VisibilityOff

                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            imageVector = image,
                            contentDescription = if (passwordVisible) "Hide password" else "Show password",
                            tint = if (isError) MaterialTheme.colorScheme.error else Color.Gray
                        )
                    }
                }
            )
        }

        if (isError) {
            Column(modifier = Modifier.padding(top = 4.dp)) {
                if (!hasMinLength) Text("At least 8 characters", color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.bodySmall)
                if (!hasUpperCase) Text("At least one uppercase letter", color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.bodySmall)
                if (!hasNumber) Text("At least one number", color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.bodySmall)
                if (!hasSpecialChar) Text("At least one special character", color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}

@Composable
fun SubmitButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Purple,
    textColor: Color = Color.White
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = textColor
        ),
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            fontFamily = Poppins
        )
    }
}

@Composable
fun GoogleButtonWithIcon(
    text: String,
    @DrawableRes iconRes: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    textColor: Color = Purple,
    borderColor: Color = Purple
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier.fillMaxWidth().height(50.dp),
        border = BorderStroke(1.dp, borderColor),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.Transparent,
            contentColor = textColor
        ),
        shape = RoundedCornerShape(10.dp)
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier.size(20.dp),
            tint = Color.Unspecified // for keeping original icon color
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = Poppins
        )
    }
}


@Composable
fun OtpInputField(
    otpText: String,
    onOtpTextChange: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        repeat(6) { index ->
            val char = otpText.getOrNull(index)?.toString() ?: ""
            Box(
                modifier = Modifier
                    .height(40.dp)
                    .width(45.dp)
                    .border(
                        width = 2.dp,
                        color = Color(0xFFD0D0D0),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .background(Color(0xFFE6F3F2), shape = RoundedCornerShape(10.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = char,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }

    // Hidden input field to capture text
    BasicTextField(
        value = otpText,
        onValueChange = {
            if (it.length <= 6 && it.all { char -> char.isDigit() }) {
                onOtpTextChange(it)
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(2.dp) // practically invisible
            .alpha(0f) // fully transparent
            .focusable()
    )
}

@Composable
fun CompareFacilityCard(
    imageRes: Int,
    buttonText: String = "Select Facility",
    onChangeClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(end = 5.dp),
        shape = RoundedCornerShape(5.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE9E9E9)),
        border = null // No stroke
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "Facility Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp),
                contentScale = ContentScale.Crop
            )

            Button(
                onClick = onChangeClick,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF000000)), // or your color
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier
                    .align(Alignment.Center)
                    .height(20.dp),
                contentPadding = PaddingValues(horizontal = 5.dp, vertical = 0.dp)
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







