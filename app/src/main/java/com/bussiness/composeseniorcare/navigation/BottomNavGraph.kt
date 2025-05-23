package com.bussiness.composeseniorcare.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bussiness.composeseniorcare.data.model.Facility
import com.bussiness.composeseniorcare.ui.screen.mainflow.CompareFacilities
import com.bussiness.composeseniorcare.ui.screen.mainflow.FacilityListing
import com.bussiness.composeseniorcare.ui.screen.mainflow.HomeScreen
import com.bussiness.composeseniorcare.ui.screen.mainflow.ListingDetail
import com.bussiness.composeseniorcare.ui.screen.mainflow.ProfileScreen
import com.bussiness.composeseniorcare.ui.screen.mainflow.SavedFacilities


@Composable
fun BottomNavGraph(
    navController: NavHostController,
    savedFacilities: List<Facility>
) {
    NavHost(navController, startDestination = Routes.HOME_SCREEN) {
        composable(Routes.HOME_SCREEN) { HomeScreen(navController) }
        composable(Routes.COMPARE_FACILITY) { CompareFacilities(navController) }
        composable(Routes.SAVED_FACILITIES) { SavedFacilities(navController,savedFacilities) }
        composable(Routes.PROFILE_SCREEN) { ProfileScreen(navController) }
        composable(Routes.FACILITY_LISTING) { FacilityListing(navController) }
        composable(Routes.LISTING_DETAIL) { ListingDetail(navController) }
    }
}
