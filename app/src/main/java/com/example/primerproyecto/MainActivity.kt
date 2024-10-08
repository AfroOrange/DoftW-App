package com.example.primerproyecto

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    // Declare variables
    private lateinit var mensaje: TextView
    private lateinit var rgSemana: RadioGroup
    private lateinit var listado: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize controls and list
        initControles()
        initListado()
        mostrarMensaje()
    }

    private fun initControles() {
        mensaje = findViewById(R.id.tvWelcomeMessage)
        rgSemana = findViewById(R.id.rgSemana)
    }

    private fun initListado() {
        listado = findViewById(R.id.spinner)
        val datosLista = arrayOf("Mañana", "Tarde", "Noche") // Correct array initialization

        // Use proper ArrayAdapter initialization with context, layout, and data
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, datosLista)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        listado.adapter = adapter
        listado.setSelection(0)
    }

    private fun mostrarMensaje() {
        rgSemana.setOnCheckedChangeListener { group, checkedId ->
            val rbSeleccionado: RadioButton = findViewById(checkedId) // Get selected RadioButton
            val saludo = getString(R.string.mensajeSaludo) // Fetch string resource
            mensaje.text = "$saludo ${rbSeleccionado.text}" // Set the message
        }
    }
}
