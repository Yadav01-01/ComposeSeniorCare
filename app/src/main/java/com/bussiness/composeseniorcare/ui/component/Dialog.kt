package com.bussiness.composeseniorcare.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.bussiness.composeseniorcare.R
import com.bussiness.composeseniorcare.ui.theme.Purple

@Composable
fun LoginSuccessDialog(
    onDismiss: () -> Unit,
    onOkayClick: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        ) {
            Surface(
                shape = RoundedCornerShape(20.dp),
                color = Color.White,
                tonalElevation = 8.dp
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(24.dp)
                ) {
                    // Close icon
                    Image(
                        painter = painterResource(id = R.drawable.cross_ic),
                        contentDescription = "Close",
                        modifier = Modifier
                            .wrapContentSize()
                            .align(Alignment.End)
                            .clickable { onDismiss() }
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // Success Icon Circle
                    Image(
                        painter = painterResource(id = R.drawable.tick_ic),
                        contentDescription = "Success Icon",

                    )


                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Login successfully",
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semi_bold))
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        onClick = onOkayClick,
                        colors = ButtonDefaults.buttonColors(containerColor = Purple),
                        shape = RoundedCornerShape(6.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Okay", color = Color.White, fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_semi_bold)))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginSuccessDialog() {
    val open = remember { mutableStateOf(true) }

    if (open.value) {
        LoginSuccessDialog(
            onDismiss = { open.value = false },
            onOkayClick = { open.value = false }
        )
    }
}
