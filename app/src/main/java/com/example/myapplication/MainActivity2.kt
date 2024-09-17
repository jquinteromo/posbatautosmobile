package com.example.myapplication


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMain2Binding


class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        val doublePriceReceived = intent.getDoubleExtra("Key_DoublePrecie", 0.0)
        val formattedPrice = String.format("%.2f", doublePriceReceived)
        val priceComplet = "$ $formattedPrice"

        binding.searchOrder.setOnClickListener {
            val orderId = binding.orderId.text.toString()

            if (orderId == "22") {
                binding.idOrder.setText("22")
                binding.date.setText("10/17/2025")
                binding.state.setText("cancelado")
                binding.billing.setText("completa")
                binding.total.setText(priceComplet)
            }


        }
    }
}
