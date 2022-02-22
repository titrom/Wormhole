package com.example.wormhole.viewModel

import android.app.Application
import android.content.Context
import android.os.CountDownTimer
import android.view.View
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.core.os.bundleOf
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.navigation.NavController
import com.example.wormhole.BR
import com.example.wormhole.R
import com.example.wormhole.model.constants.ConstSharedPreferences
import kotlinx.coroutines.*
import kotlin.random.Random

@OptIn(DelicateCoroutinesApi::class)
class GameViewModel(
    private val app: Application,
    private val navController: NavController,
    private val motionLayout: MotionLayout
): BaseObservable(){

    private val timer = object : CountDownTimer(30000, 1000){
        override fun onTick(p0: Long) {
            timeGame = p0 / 1000
        }
        override fun onFinish() {
            finishScreen()
        }
    }

    private val settings = app.getSharedPreferences(ConstSharedPreferences.PREFS_FILE, Context.MODE_PRIVATE)


    @get: Bindable
    var timeGame: Long = 0
    set(value) {
        field = value
        notifyPropertyChanged(BR.timeGame)
    }

    @get:Bindable
    var score = 0
    set(value) {
        field = value
        notifyPropertyChanged(BR.score)
    }

    @get:Bindable
    var bestScore =
        app.resources.getString(R.string.best_score) +
            " ${settings.getString(ConstSharedPreferences.PREF_NAME, "0")}"
    set(value) {
        field = value
        notifyPropertyChanged(BR.bestScore)
    }

    init {
        timer.start()
        GlobalScope.launch(Dispatchers.Main){
            repeat(30000){
                when(Random.nextInt(1, 9)){
                    1 -> motionLayout.transitionToState(R.id.hole1)
                    2 -> motionLayout.transitionToState(R.id.hole2)
                    3 -> motionLayout.transitionToState(R.id.hole3)
                    4 -> motionLayout.transitionToState(R.id.hole4)
                    5 -> motionLayout.transitionToState(R.id.hole5)
                    6 -> motionLayout.transitionToState(R.id.hole6)
                    7 -> motionLayout.transitionToState(R.id.hole7)
                    8 -> motionLayout.transitionToState(R.id.hole8)
                    9 -> motionLayout.transitionToState(R.id.hole9)
                }
                delay(500)
            }
        }
    }


    val onClickMoles = View.OnClickListener {
        score++

    }

    private fun finishScreen(){
        if (score > settings.getString(ConstSharedPreferences.PREF_NAME, "0")!!.toInt())
            settings.edit().putString(ConstSharedPreferences.PREF_NAME, score.toString()).apply()
        val bundle = bundleOf("score" to score)
        navController.navigate(R.id.action_gameFragment_to_finishFragment, bundle)
    }
}