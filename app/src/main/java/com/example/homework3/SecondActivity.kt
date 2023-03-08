package com.example.homework3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RatingBar
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    val animalNames = listOf("Dog", "Cat", "Bear", "Rabbit")
    val animalRatings = listOf("DogRating", "CatRating", "BearRating", "RabbitRating")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val index = intent.getIntExtra("index", 0)
        val sharedPreferences = getSharedPreferences("SecondActivityData",MODE_PRIVATE)
        ratingBar.rating = sharedPreferences.getString(animalRatings[index],"0.0")?.toFloat() ?: 0.0f
        val animalImages =
            listOf(R.drawable.dog, R.drawable.cat, R.drawable.bear, R.drawable.rabbit)
        animalImageView.setImageResource(animalImages[index])
        animalName.text = animalNames[index]
    }
    fun ratingAnimal(view: View){
        val rBar = findViewById<RatingBar>(R.id.ratingBar)
            val button = findViewById<Button>(R.id.save_button)
                val msg = rBar.rating.toString()
        val RatingIndex = intent.getIntExtra("index", 0)

        val sharedPreferences = getSharedPreferences("SecondActivityData",MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(animalRatings[RatingIndex], msg)
        editor.apply()
        finish() // Remove the second activity from the stack so that the first activity
    }
}