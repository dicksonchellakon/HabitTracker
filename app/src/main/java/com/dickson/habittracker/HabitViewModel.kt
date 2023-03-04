package com.dickson.habittracker

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.toSet
import java.util.Random

class HabitViewModel(
  private val savedStateHandle: SavedStateHandle
) : ViewModel() {

  //MutabelStateFlow
  //private val _color = MutableStateFlow(0xFFFFFFFF)
  //val color = _color.asStateFlow()
  //private val _habitsList = MutableStateFlow<ArrayList>()
  //val habitlist = _habitsList.asStateFlow()


  val color = savedStateHandle.getStateFlow("color", 0xFFFFFFFF)
  fun generateColor() {
    val color = kotlin.random.Random.nextLong(0xFFFFFFFF)
    savedStateHandle["color"] = color
  }


}