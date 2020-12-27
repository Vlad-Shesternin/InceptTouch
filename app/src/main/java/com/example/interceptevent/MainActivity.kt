package com.example.interceptevent

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.interceptevent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Binding
    private lateinit var binding: ActivityMainBinding

    // Components
    private lateinit var adapter: RecyclerAdapter

    // Components UI
    private lateinit var root: MyMotionLayout
    private lateinit var btn: Button
    private var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initComponentsUI()
        initListeners()
        initRecycler()
    }

    // ==============================
    //    Init Components UI
    // ==============================
    private fun initComponentsUI() {
        binding.also {
            root = it.root
            btn = it.btn
        }
    }

    // ==============================
    //    Init Listeners
    // ==============================
    private fun initListeners() {
        btn.setOnClickListener {
            adapter.setValue("${++i}")
        }
    }

    // ==============================
    //    Init Recycler
    // ==============================
    private fun initRecycler() {
        adapter = RecyclerAdapter()
        binding.recycle.adapter = adapter
    }
}

