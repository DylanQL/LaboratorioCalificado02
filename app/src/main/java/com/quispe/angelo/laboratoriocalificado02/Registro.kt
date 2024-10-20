package com.quispe.angelo.laboratoriocalificado02

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Registro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        // Recibir los datos del Intent
        val nombreCliente = intent.getStringExtra("nombre_cliente")
        val numeroCliente = intent.getStringExtra("numero_cliente")
        val productos = intent.getStringExtra("productos")
        val ciudad = intent.getStringExtra("ciudad")
        val direccion = intent.getStringExtra("direccion")

        // Mostrar los datos en los TextView
        findViewById<TextView>(R.id.tvNombreCliente).text = nombreCliente
        findViewById<TextView>(R.id.tvNumeroCliente).text = numeroCliente
        findViewById<TextView>(R.id.tvProductos).text = productos
        findViewById<TextView>(R.id.tvUbicacion).text = "$ciudad, $direccion"

        // Funcionalidad para el icono LLAMAR
        val iconLlamar = findViewById<ImageView>(R.id.iconLlamar)
        iconLlamar.setOnClickListener {
            val intentLlamar = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$numeroCliente")
            }
            startActivity(intentLlamar)
        }

        // Funcionalidad para el icono WhatsApp
        val iconWhatsApp = findViewById<ImageView>(R.id.iconWhatsApp)
        iconWhatsApp.setOnClickListener {
            val mensaje = "Hola $nombreCliente, tus productos: $productos están en camino a la dirección: $direccion."
            val numeroFormateado = numeroCliente?.replace(" ", "") ?: "" // Remover espacios si tiene

            // Crear la URL de WhatsApp con el número y el mensaje
            val url = "https://wa.me/$numeroFormateado?text=${Uri.encode(mensaje)}"

            val intentWSP = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(url)
            }
            startActivity(intentWSP)
        }

        // Funcionalidad para el icono MAPS (Google Maps)
        val iconMaps = findViewById<ImageView>(R.id.iconMaps)
        iconMaps.setOnClickListener {
            val intentMaps = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("geo:0,0?q=${Uri.encode("$direccion, $ciudad")}")
            }
            startActivity(intentMaps)
        }

        // Ajuste de insets para pantalla con bordes redondeados
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
