package com.example.heroeslist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.heroeslist.databinding.ActivityHeroesListBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class HeroesListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHeroesListBinding

    companion object {
        val TAG = "HeroesListActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeroesListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /*
        *  TODO: Make an item_hero.xml layout and fill in the layout folder
        *  TODO: Make the root element a constraint layout
        *  TODO: Make some textview for the ranking, name, and desc
        *  TODO: Make a HeroAdapter.kt class modeled after the CustomAdapter from the documentation
        */

        val inputStream = resources.openRawResource(R.raw.heroes)
        val jsonText = inputStream.bufferedReader().use {
            it.readText()
        }
        val gson = Gson()
        val hType = object : TypeToken<List<Hero>>() { }.type
        val heroes = gson.fromJson<List<Hero>>(jsonText, hType)
        Log.d(TAG, "onCreate: ${heroes.toString()}")

    }


}