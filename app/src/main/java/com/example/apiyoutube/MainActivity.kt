package com.example.apiyoutube

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : YouTubeBaseActivity() {
    companion object {
        val VIDEO_ID : String = "0lapF4DQPKQ";
        val YOUTUBE_API_KEY : String = "AIzaSyAR53BYVF8QWFCmpSJQFKDL9bLQdhPkTJE";
    }

    lateinit var  youtubePlayerInit : YouTubePlayer.OnInitializedListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUI()

    }

    private fun initUI() {
        youtubePlayerInit = object : YouTubePlayer.OnInitializedListener {
            override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {
                Toast.makeText(applicationContext, "Kesalahan", Toast.LENGTH_SHORT).show()
            }

            override fun onInitializationSuccess( p0: YouTubePlayer.Provider?, youTubePlayer: YouTubePlayer, p2: Boolean) {
                youTubePlayer.loadVideo(VIDEO_ID)

            }
        }
        button.setOnClickListener(View.OnClickListener { v ->
            youtubePlayer.initialize(YOUTUBE_API_KEY, youtubePlayerInit)
        })
    }
}

