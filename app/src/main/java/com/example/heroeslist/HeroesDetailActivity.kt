package com.example.heroeslist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.heroeslist.databinding.ActivityHeroesDetailBinding

class HeroesDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHeroesDetailBinding

    companion object {
        val EXTRA_HERO = "The hero"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeroesDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val hero = intent.getParcelableExtra<Hero>(EXTRA_HERO)
        binding.textViewHeroDetailName.text = hero?.name
        binding.textViewHeroDetailDesc.text = hero?.description
        binding.textViewHeroDetailSp.text = hero?.superpower
        binding.textViewHeroDetailRanking.text = hero?.ranking.toString()
        binding.imageViewHeroDetailImage.setImageDrawable(
            getDrawable(resources.getIdentifier(hero?.image,"drawable", packageName))
        )
    }
}