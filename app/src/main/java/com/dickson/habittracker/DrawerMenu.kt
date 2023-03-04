package com.dickson.habittracker

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DrawerHeader() {
  Box(
    modifier = Modifier
      .fillMaxWidth()
      .padding(10.dp),
    contentAlignment = Alignment.Center
  ) {
    Text(text = "Header", fontSize = 40.sp)
  }
}

@Composable
fun DrawerBody(
  items: List<MenuItem>,
  modifier: Modifier = Modifier,
  itemTextStyle: androidx.compose.ui.text.TextStyle = androidx.compose.ui.text.TextStyle(fontSize = 18.sp),
  onItemClick : (MenuItem) -> Unit
  ) {
  
  LazyColumn(modifier) {
    items(items) { item ->
      Box(
        modifier = Modifier
          .fillMaxWidth()
          .clickable {
            onItemClick(item)
          }
      ) {
        Icon(imageVector = item.icon, contentDescription = null)
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = item.title, style = itemTextStyle)
      }
    } 
  }

}