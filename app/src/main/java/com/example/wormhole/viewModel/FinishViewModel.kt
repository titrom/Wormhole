package com.example.wormhole.viewModel

import android.app.Application
import android.content.Context
import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.navigation.NavController
import com.example.wormhole.BR
import com.example.wormhole.R
import com.example.wormhole.model.constants.ConstSharedPreferences

class FinishViewModel(
    private val app: Application,
    val score: Int,
    private val navController: NavController
): BaseObservable() {

    private val settings = app.getSharedPreferences(ConstSharedPreferences.PREFS_FILE, Context.MODE_PRIVATE)
    @get:Bindable
    var bestScore =
        app.resources.getString(R.string.best_score) +
                " ${settings.getString(ConstSharedPreferences.PREF_NAME, "0")}"
        set(value) {
            field = value
            notifyPropertyChanged(BR.bestScore)
        }

    val onClickPlayAgain = View.OnClickListener {
        navController.navigate(R.id.action_finishFragment_to_gameFragment)
    }

    val onClickMenu = View.OnClickListener {
        navController.navigate(R.id.action_finishFragment_to_startFragment)

    }
}