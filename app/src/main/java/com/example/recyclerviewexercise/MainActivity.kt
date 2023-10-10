package com.example.recyclerviewexercise

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewexercise.adapters.RvWisataAdapter
import com.example.recyclerviewexercise.databinding.ActivityMainBinding
import com.example.recyclerviewexercise.model.WisataModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: RvWisataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        setRvAdapter()
    }

    private fun init() {
        binding.rvExample.layoutManager = LinearLayoutManager(this@MainActivity)
    }

    private fun setRvAdapter() {
        val dataList: MutableList<WisataModel> = mutableListOf()

        nameWisata().forEachIndexed { index, name ->
            dataList.add(WisataModel(imageWisata().get(index), name, descWisata()[index]))
        }
        Log.d("ISI DATANYA ", dataList.toString())
        adapter = RvWisataAdapter(dataList, this@MainActivity)
        binding.rvExample.adapter = adapter
    }

    private fun nameWisata(): Array<String> = resources.getStringArray(R.array.data_name)
    private fun descWisata(): Array<String> = resources.getStringArray(R.array.data_description)

    private fun imageWisata(): List<Int> = listOf(
        R.drawable.pura_besakih,
        R.drawable.kepulauan_derawan,
        R.drawable.taman_laut_bunaken,
        R.drawable.pantai_parai_tenggiri,
        R.drawable.nusa_dua_bali,
        R.drawable.gunung_rinjani,
        R.drawable.danau_toba,
        R.drawable.nusa_penida
    )
}