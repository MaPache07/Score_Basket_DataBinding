package com.mapache.scorebasketdatabinding

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.mapache.scorebasketdatabinding.databinding.ActivityMainBinding
import com.mapache.scorebasketdatabinding.pojos.Score

class MainActivity : AppCompatActivity() {

    lateinit var score : Score

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        score = ViewModelProviders.of(this).get(Score::class.java)

        if(score.scoreA.get() == null) score.scoreA.set("0")
        if(score.scoreB.get() == null) score.scoreB.set("0")

        var binding : ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.score = score
    }

    fun scorePlus(view : View){
        when(view.id){
            R.id.teamA_1 -> score.scoreA.set((score.scoreA.get()!!.toInt()+1).toString())
            R.id.teamA_2 -> score.scoreA.set((score.scoreA.get()!!.toInt()+2).toString())
            R.id.teamA_3 -> score.scoreA.set((score.scoreA.get()!!.toInt()+3).toString())
            R.id.teamB_1 -> score.scoreB.set((score.scoreB.get()!!.toInt()+1).toString())
            R.id.teamB_2 -> score.scoreB.set((score.scoreB.get()!!.toInt()+2).toString())
            R.id.teamB_3 -> score.scoreB.set((score.scoreB.get()!!.toInt()+3).toString())
        }
    }

    fun resetScore(view: View){
        score.scoreA.set("0")
        score.scoreB.set("0")
    }
}
