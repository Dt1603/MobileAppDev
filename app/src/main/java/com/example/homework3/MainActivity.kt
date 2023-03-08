package com.example.homework3


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val animalRatings = listOf("DogRating", "CatRating", "BearRating", "RabbitRating")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rating()
    }
    fun openSecondActivity(view: View){
        val index = when(view) {
            dog_button -> 0
            cat_button -> 1
            bear_button -> 2
            else -> 3
        }

        val myIntent = Intent(this, SecondActivity::class.java)
        myIntent.putExtra("index", index)
        startActivity(myIntent)
    }
    fun rating(){
        val animalRating = listOf<TextView>(dogRating, catRating, bearRating, rabbitRating)
        val sharedPreferences = getSharedPreferences("SecondActivityData",MODE_PRIVATE)
        for ((index, element) in animalRatings.withIndex()) {
            animalRating[index].text = "Your Rating: " +
                    (sharedPreferences.getString(element,"-")?.toFloat() ?:0.0f )
        }
    }
}
