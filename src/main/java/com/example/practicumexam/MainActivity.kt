package com.example.practicumexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    companion object {
        const val MAX_SONGS = 4
    }

    private val titles = Array(MAX_SONGS) { "" }
    private val artists = Array(MAX_SONGS) { "" }
    private val ratings = IntArray(MAX_SONGS) { 0 }
    private val comments = Array(MAX_SONGS) { "" }
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val enterButton = findViewById<Button>(R.id.enterButton)
        val clickButton = findViewById<Button>(R.id.clickButton)
        val exitAppButton = findViewById<Button>(R.id.exitAppButton)

        enterButton.setOnClickListener { showAddSongDialog() }
        clickButton.setOnClickListener { navigateToPlaylist() }
        exitAppButton.setOnClickListener { exitApp() }
    }

    private fun showAddSongDialog() {
        if (count >= MAX_SONGS) {
            Toast.makeText(this, "Playlist is full (max $MAX_SONGS songs)", Toast.LENGTH_SHORT).show()
            return
        }

        // Create a custom dialog layout programmatically
        val dialogLayout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            setPadding(50, 30, 50, 10)
        }

        // Create input fields
        val etSongTitle = EditText(this).apply {
            hint = "Song Title"
            setSingleLine(true)
        }
        val etArtistName = EditText(this).apply {
            hint = "Artist Name"
            setSingleLine(true)
        }
        val etRating = EditText(this).apply {
            hint = "Rating (1-5)"
            inputType = InputType.TYPE_CLASS_NUMBER
        }
        val etComment = EditText(this).apply {
            hint = "Comments (optional)"
        }

        // Add views to dialog layout
        dialogLayout.addView(etSongTitle)
        dialogLayout.addView(etArtistName)
        dialogLayout.addView(etRating)
        dialogLayout.addView(etComment)

        AlertDialog.Builder(this)
            .setTitle("Enter Song Details")
            .setView(dialogLayout)
            .setPositiveButton("Add") { _, _ ->
                val title = etSongTitle.text.toString().trim()
                val artist = etArtistName.text.toString().trim()
                val rating = etRating.text.toString().toIntOrNull() ?: 0
                val comment = etComment.text.toString().trim()

                if (title.isEmpty() || artist.isEmpty()) {
                    Toast.makeText(this, "Please enter both title and artist", Toast.LENGTH_SHORT).show()
                    return@setPositiveButton
                }

                if (rating !in 1..5) {
                    Toast.makeText(this, "Rating must be between 1-5", Toast.LENGTH_SHORT).show()
                    return@setPositiveButton
                }

                // Store the song details
                titles[count] = title
                artists[count] = artist
                ratings[count] = rating
                comments[count] = comment
                count++

                Toast.makeText(this, "Added: $title", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    private fun navigateToPlaylist() {
        val intent = Intent(this, MainActivity2::class.java).apply {
            putExtra("titles", titles)
            putExtra("artists", artists)
            putExtra("ratings", ratings)
            putExtra("comments", comments)
            putExtra("count", count)
        }
        startActivity(intent)
    }

    private fun exitApp() {
        AlertDialog.Builder(this)
            .setTitle("Exit App")
            .setMessage("Are you sure you want to exit?")
            .setPositiveButton("Yes") { _, _ -> finishAffinity() }
            .setNegativeButton("No", null)
            .show()
    }
}