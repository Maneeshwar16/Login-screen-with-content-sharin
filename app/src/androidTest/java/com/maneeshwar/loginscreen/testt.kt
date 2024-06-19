package com.maneeshwar.loginscreen

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.navigation.compose.rememberNavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NavigationTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testLoginScreenNavigation() {
        composeTestRule.setContent {
            navigaton()
        }

        composeTestRule.onNodeWithText("Hey Welcome").assertExists()
        composeTestRule.onNodeWithText("Login to your Account").assertExists()

        composeTestRule.onNodeWithText("Username").performTextInput("testuser")
        composeTestRule.onNodeWithText("Password").performTextInput("password")
        composeTestRule.onNodeWithText("Name").performTextInput("John")

        composeTestRule.onNodeWithText("Login").performClick()

        composeTestRule.onNodeWithText("Hi John").assertExists()
    }

    @Test
    fun testSocialMediaNavigation() {
        composeTestRule.setContent {
            navigaton()
        }

        composeTestRule.onNodeWithText("Hey Welcome").assertExists()

        composeTestRule.onNodeWithContentDescription("Fb icon").performClick()

        composeTestRule.onNodeWithContentDescription("Google icon").performClick()

    }
}
