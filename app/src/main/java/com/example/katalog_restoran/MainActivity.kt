package com.example.katalog_restoran

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvHeroes: RecyclerView
    private val list = ArrayList<Restaurant>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        rvHeroes = findViewById(R.id.rv_heroes)
        rvHeroes.setHasFixedSize(true)

        list.addAll((getListRestaurants()))
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> { showAuthor() }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListRestaurants(): ArrayList<Restaurant> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listRestaurant = ArrayList<Restaurant>()
        for (i in dataName.indices) {
            val restaurant = Restaurant(
                dataName[i],
                dataDescription[i],
                dataPhoto.getResourceId(i, -1)
            )
            listRestaurant.add(restaurant)
        }
        return listRestaurant
    }

    private fun showRecyclerList() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val listRestaurantAdapter = ListRestaurantAdapter(list)
        rvHeroes.adapter = listRestaurantAdapter

        listRestaurantAdapter.setOnItemClickCallback(object : ListRestaurantAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Restaurant) {
                showSelectedRestaurant(data)
            }
        })
    }

    private fun showSelectedRestaurant(data: Restaurant) {
        val intentToDetail = Intent(this@MainActivity, DetailActivity::class.java)
        intentToDetail.putExtra("DATA", data)
        startActivity(intentToDetail)
    }
    private fun showAuthor() {
        val intentToAbout = Intent(this@MainActivity, AboutActivity::class.java)
        startActivity(intentToAbout)
    }
}