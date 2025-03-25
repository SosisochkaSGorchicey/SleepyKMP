package com.core.navigation

import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator

fun Navigator.pushSingle(screen: Screen) =
    if (!this.items.contains(screen)) this.push(screen) else Unit
