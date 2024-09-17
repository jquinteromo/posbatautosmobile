package com.example.myapplication

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMain3Binding
import java.io.ByteArrayOutputStream

class MainActivity3 : AppCompatActivity() {

    private lateinit var binding: ActivityMain3Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.addCar.setOnClickListener {
            val imageDrawable = binding.imageview.drawable
            val bitmap = (imageDrawable as BitmapDrawable).bitmap

            val stream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
            val byteArray = stream.toByteArray()


            val textreferenc = binding.referenceProduct.text.toString()
            val priceProductInfo = binding.priceProduct.text.toString().toDouble()

            val intent = Intent(this, MainActivity5::class.java)
            intent.putExtra("key_reference", textreferenc)
            intent.putExtra("key_price", priceProductInfo)
            intent.putExtra("key_image",byteArray)


            startActivity(intent)
        }



        binding.showShoppingcar.setOnClickListener {


            val inputs = arrayOf("uno", "dos")
            for (numero in inputs.indices) {
                Log.d("MiApp", "  ${inputs.get(numero)}")
            }

            val intent = Intent(this, MainActivity5::class.java)
            startActivity(intent)
        }
    }


}