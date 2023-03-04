package com.dickson.habittracker

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener
import kotlinx.coroutines.launch

@Composable
fun AppTopBar(
  onNavigationIconClick: () -> Unit
) {
  TopAppBar(
    title = { Text( stringResource(id = R.string.app_name)) },
    backgroundColor = MaterialTheme.colors.primary,
    contentColor = MaterialTheme.colors.onPrimary,
    navigationIcon = {
      IconButton(
        onClick = onNavigationIconClick
      ) {
        Icon(Icons.Filled.Menu, contentDescription = "Localized description")
      }
    }
  )
}