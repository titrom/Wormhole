package com.example.wormhole.viewModel

import android.app.Application
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.navigation.NavController
import com.example.wormhole.BR
import com.example.wormhole.R
import com.example.wormhole.model.constants.ConstSharedPreferences.PREFS_FILE
import com.example.wormhole.model.constants.ConstSharedPreferences.PREF_NAME

class StartViewModel(
    private val app: Application,
    private val navController: NavController
): BaseObservable() {

    private val settings = app.getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE)
    @get:Bindable
    var bestScore: String = app.resources.getString(R.string.best_score) +
            " ${settings.getString(PREF_NAME, "0")}"
    set(value) {
        field = value
        notifyPropertyChanged(BR.bestScore)
    }



    val onClickStartGame = View.OnClickListener {
        navController.navigate(R.id.action_startFragment_to_gameFragment)
    }
}