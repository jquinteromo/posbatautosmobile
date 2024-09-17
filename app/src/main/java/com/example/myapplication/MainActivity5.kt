package com.example.myapplication

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.Activity5Binding


class MainActivity5 : AppCompatActivity() {
    private lateinit var binding: Activity5Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = Activity5Binding.inflate(layoutInflater)
        setContentView(binding.root)


        val referenceReceived = intent.getStringExtra("key_reference")
        binding.receivedText.text = referenceReceived


        val priceRecived = intent.getDoubleExtra("key_price", 0.0)
        val formattedPrice = String.format("%.2f", priceRecived)
        val priceComplet = "$ $formattedPrice"
        val receivePriceTextView = binding.receivePrice
        receivePriceTextView.text = priceComplet


        val receivedImage = intent.getByteArrayExtra("key_image")
        val bitmap = BitmapFactory.decodeByteArray(receivedImage, 0, receivedImage!!.size)
        binding.imageview.setImageBitmap(bitmap)


        var countSet = 1
        binding.counter.text = String.format("%d", countSet)


        val originalPrice = priceRecived
        val btnAdd = binding.imageButton3
        val btnSubtract = binding.imageButton4

        val button = listOf(btnAdd, btnSubtract)
        button.forEach { button ->
            button.setOnClickListener {
                when (button) {
                    btnAdd -> {
                        countSet += 1
                        binding.counter.text = String.format("%d", countSet)

                        val updatedPrice = originalPrice * countSet
                        receivePriceTextView.text = String.format("%.2f", updatedPrice)


                        val intent = Intent(this, MainActivity2::class.java)
                        intent.putExtra("Key_DoublePrecie", updatedPrice)

                        if (countSet > 9) {
                            Toast.makeText(this, "No se pueden agregar más productos", Toast.LENGTH_SHORT).show()
                            countSet = 9
                            binding.counter.text = String.format("%d", 9)
                        }
                    }
                    btnSubtract -> {
                        if (countSet > 1) {
                            countSet -= 1
                            binding.counter.text = String.format("%d", countSet)

                            val updatedPrice = originalPrice * countSet
                            receivePriceTextView.text = String.format("%.2f", updatedPrice)
                        }
                    }
                }
            }
        }

        binding.sendBill.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("Key_DoublePrecie", originalPrice * countSet)
            startActivity(intent)
        }
    }
}
