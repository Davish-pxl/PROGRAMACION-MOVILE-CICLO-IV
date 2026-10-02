package com.tecsup.tecsupstore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.tecsup.tecsupstore.navigation.AppNavigation
import com.tecsup.tecsupstore.ui.theme.TecsupStoreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TecsupStoreTheme {
                AppNavigation()
            }
        }
    }
}