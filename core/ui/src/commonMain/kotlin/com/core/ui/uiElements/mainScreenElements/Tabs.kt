package com.core.ui.uiElements.mainScreenElements

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import cafe.adriel.voyager.transitions.SlideTransition
import com.core.navigation.SharedScreen
import com.core.navigation.screen
import com.core.ui.Res
import com.core.ui.balance
import com.core.ui.bell
import com.core.ui.flower_dark_face_small
import org.jetbrains.compose.resources.DrawableResource

enum class Tabs(
    val imageRes: DrawableResource,
    val tab: Tab
) {
    Content(
        imageRes = Res.drawable.balance,
        tab = ContentTab
    ),
    Home(
        imageRes = Res.drawable.flower_dark_face_small,
        tab = HomeTab
    ),
    Notification(
        imageRes = Res.drawable.bell,
        tab = NotificationTab
    )
}

object ContentTab : Tab {
    override val key: ScreenKey = Tabs.Content.name

    @Composable
    override fun Content() {
        Navigator(SharedScreen.ContentRoute.screen()) {
            SlideTransition(navigator = it)
        }
    }

    override val options: TabOptions
        @Composable
        get() {
            return remember {
                TabOptions(index = 0u, title = "")
            }
        }
}

object HomeTab : Tab {
    override val key: ScreenKey = Tabs.Home.name

    @Composable
    override fun Content() {
        Navigator(SharedScreen.HomeRoute.screen()) {
            SlideTransition(navigator = it)
        }
    }

    override val options: TabOptions
        @Composable
        get() {
            return remember {
                TabOptions(index = 1u, title = "")
            }
        }
}

object NotificationTab : Tab {
    override val key: ScreenKey = Tabs.Notification.name

    @Composable
    override fun Content() {
        Navigator(SharedScreen.NotificationsRoute.screen()) {
            SlideTransition(navigator = it)
        }
    }

    override val options: TabOptions
        @Composable
        get() {
            return remember {
                TabOptions(index = 2u, title = "")
            }
        }
}
