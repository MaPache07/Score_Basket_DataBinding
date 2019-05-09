package com.mapache.scorebasketdatabinding.pojos

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField

class Score : ViewModel() {
    var scoreA = ObservableField<String>()
    var scoreB = ObservableField<String>()
}