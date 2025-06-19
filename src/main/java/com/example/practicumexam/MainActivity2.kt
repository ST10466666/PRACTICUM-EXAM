package com.example.practicumexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import java.lang.StringBuilder

class MainActivity2 : AppCompatActivity() {

    //STEP 1: Hard-playlist of 4 songs
    private val titles = arrayOf("Burning Blue", "I have Nothing", "Easy on me", "Me,Myself & I")
    private val artists = arrayOf("Mariah the Scientist", "Whitney Houston", "Adele", "Beyonce")
    private val ratings = intArrayOf(5, 3, 2, 4)
    private val comments = arrayOf("Perfect for lover girls", "Great for late-night drives", "Not my style", "uplifts the mood!")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val displaySongs = findViewById<Button>(R.id.displaySongs)
        val ratingSongs = findViewById<Button>(R.id.ratingSongs)
        val returnButton = findViewById<Button>(R.id.returnButton)

        // Set click listeners for buttons
        displaySongs.setOnClickListener {
            showSongList()
        }

        ratingSongs.setOnClickListener {
            showAverageRating()
        }

        returnButton.setOnClickListener {
            finish() // Close this activity and return to previous one
        }
    }

    //STEP 2: LOOP THROUGH SONGS AND SHOW DETAILS
    private fun showSongList() {
        val sb = StringBuilder()
        for (i in titles.indices) {
            sb.appendLine("Title: ${titles[i]}")
            sb.appendLine("Artists: ${artists[i]}")
            sb.appendLine("Rating: ${ratings[i]}/5")
            if (comments[i].isNotBlank()) {
                sb.appendLine("Comment: \"${comments[i]}\"")
            }
            sb.appendLine("----------")
        }
        AlertDialog.Builder(this)
            .setTitle("Your 4 Songs")
            .setMessage(sb.toString())
            .setPositiveButton("OK", null)
            .show()
    }

    //STEP 3: LOOP TO CALCULATE AVERAGE
    private fun showAverageRating() {
        var sum = 0
        for (r in ratings) {
            sum += r
        }
        val avg = sum.toDouble() / ratings.size
        AlertDialog.Builder(this)
            .setTitle("Average Rating")
            .setMessage("Average: %.2f".format(avg))
            .setPositiveButton("OK", null)
            .show()
    }
}