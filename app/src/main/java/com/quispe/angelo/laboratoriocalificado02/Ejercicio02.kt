package com.quispe.angelo.laboratoriocalificado02

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Ejercicio02 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio02)

        // Referencia a los EditText y al Button
        val etNombreCliente = findViewById<EditText>(R.id.etNombreCliente)
        val etNumeroCliente = findViewById<EditText>(R.id.etNumeroCliente)
        val etProductos = findViewById<EditText>(R.id.etProductos)
        val etCiudad = findViewById<EditText>(R.id.etCiudad)
        val etDireccion = findViewById<EditText>(R.id.etDireccion)
        val btnRegistrar = findViewById<Button>(R.id.btnRegistrar)

        btnRegistrar.setOnClickListener {
            // Validar que todos los campos estén llenos
            if (etNombreCliente.text.isEmpty() || etNumeroCliente.text.isEmpty() ||
                etProductos.text.isEmpty() || etCiudad.text.isEmpty() || etDireccion.text.isEmpty()) {
                Toast.makeText(this, "Por favor, llena todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                // Si todos los campos están llenos, redirige a la pantalla de registro
                val intent = Intent(this, Registro::class.java).apply {
                    putExtra("nombre_cliente", etNombreCliente.text.toString())
                    putExtra("numero_cliente", etNumeroCliente.text.toString())
                    putExtra("productos", etProductos.text.toString())
                    putExtra("ciudad", etCiudad.text.toString())
                    putExtra("direccion", etDireccion.text.toString())
                }
                startActivity(intent)
            }
        }

        // Ajuste de insets para pantalla con bordes redondeados
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
