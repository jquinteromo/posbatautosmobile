package com.example.myapplication


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //utilizamos sqlite y bindding
    private lateinit var dbHelper: SqliteDTB
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//inflamos la actividad
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //accedemos desde la clase sqlite alos elementos de esta actividad
        dbHelper = SqliteDTB(this)


        //creamos ele vento ques ejecuta al dar cick en el boton
        binding.CustomButton.setOnClickListener {

            //capturamos con bnding el valor de los campos de texto y utilizamos el metodo inseratar datos
            if (binding.email.text.isNotBlank() && binding.password.text.isNotBlank()) {
                dbHelper.insertarDatos(
                    binding.email.text.toString(),
                    binding.password.text.toString()
                )
                binding.email.text.clear()
                binding.password.text.clear()

                //toast verificar que si se guaradaron los datosa
                Toast.makeText(this, "datos guardados", Toast.LENGTH_SHORT).show()

                //si se guardan los datos me manda a una nueva actividad
                val intent = Intent(this, MainActivity3::class.java)
                startActivity(intent)
            } else {
                //toast notifica que los datos no han sido guardados
                Toast.makeText(this, "datos no guardados", Toast.LENGTH_SHORT).show()
            }
        }
    }
}