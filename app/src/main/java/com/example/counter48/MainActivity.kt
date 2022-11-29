package com.example.counter48

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.counter48.databinding.ActivityMainBinding
import com.example.counter48.presenter.Presenter
import com.example.counter48.view.CounterView

class MainActivity : AppCompatActivity(),CounterView {

    lateinit var binding: ActivityMainBinding
    var presenter = Presenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClicker()
        presenter.attachView(this)
    }

    private fun initClicker() {
        with(binding) {
            btnPlus.setOnClickListener {
                presenter.increment()
            }
        }
    }


    override fun updateCount(count: Int) {
        binding.tvResult.text = count.toString()
    }

    override fun showToast() {
        Toast.makeText(this,"Поздравляем",Toast.LENGTH_SHORT).show()
    }

    override fun getColor() {
        binding.tvResult.setBackgroundColor(Color.GREEN)
    }
}