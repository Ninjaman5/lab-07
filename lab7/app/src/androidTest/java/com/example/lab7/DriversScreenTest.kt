package com.example.lab7
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DriversScreenTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun driverstest() {
        // navigate to drivers screen
        composeTestRule
            .onNodeWithTag("driverButton")
            .performClick()

        // verify drivers screen
        composeTestRule
            .onNodeWithText("FormulaZero Drivers")
            .assertExists()

        // enter driver name
        composeTestRule
            .onNodeWithTag("driverInput")
            .performTextInput("Charles")

        // add driver
        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        // verify the driver appears
        composeTestRule
            .onNodeWithText("Charles")
            .assertExists()

        // clear drivers
        composeTestRule
            .onNodeWithTag("clearDriversButton")
            .performClick()

        // verify the driver disappears
        composeTestRule
            .onNodeWithText("Charles")
            .assertDoesNotExist()

        // return back to homescreen
        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        // verify return to home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }
}