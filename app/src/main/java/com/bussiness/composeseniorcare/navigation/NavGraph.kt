package com.bussiness.composeseniorcare.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bussiness.composeseniorcare.ui.screen.MainScreen
import com.bussiness.composeseniorcare.ui.screen.SplashScreen
import com.bussiness.composeseniorcare.ui.screen.authflow.CreatePasswordScreen
import com.bussiness.composeseniorcare.ui.screen.authflow.ForgotPasswordScreen
import com.bussiness.composeseniorcare.ui.screen.authflow.LoginScreen
import com.bussiness.composeseniorcare.ui.screen.authflow.SignUpScreen
import com.bussiness.composeseniorcare.ui.screen.authflow.VerifyOTP

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.SPLASH) {
        composable(Routes.SPLASH) {
            SplashScreen(navController)
        }
        composable(Routes.LOGIN) {
            LoginScreen(navController)
        }
        composable(Routes.FORGOT_PASSWORD) {
            ForgotPasswordScreen(navController)
        }

        composable(Routes.VERIFY_OTP) {
            VerifyOTP(navController)
        }
        composable(Routes.CREATE_PASSWORD) {
            CreatePasswordScreen(
                navController = navController,
                onLoginClick = {},
                onSignUpClick = {}
            )
        }
        composable(Routes.SIGN_UP) {
            val checkedState = remember { mutableStateOf(false) }

            SignUpScreen(
                navController = navController,
                onLoginClick = { navController.navigate(Routes.LOGIN) },
                onTermsClick = { /* navigate or show Terms */ },
                onPrivacyClick = { /* navigate or show Privacy */ },
                checked = checkedState.value,
                onCheckedChange = { checkedState.value = it }
            )
        }

        composable(Routes.MAIN_SCREEN){
            MainScreen(navController)
        }


    }
}
