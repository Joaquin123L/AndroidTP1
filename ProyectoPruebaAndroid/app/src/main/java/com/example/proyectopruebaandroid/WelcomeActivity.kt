package com.example.proyectopruebaandroid

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

// La clase WelcomeActivity extiende AppCompatActivity, lo que la convierte en una actividad de Android.
class WelcomeActivity : AppCompatActivity() {

    // Método que se ejecuta cuando se crea la actividad.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Establece el diseño XML que se usará para esta pantalla.
        setContentView(R.layout.activity_welcome)

        // Se obtienen referencias a los elementos del layout.
        val btnContinue = findViewById<Button>(R.id.btnContinue) // Botón "Continuar"
        val radioAndroid = findViewById<RadioButton>(R.id.radioAndroid) // Opción Android
        val radioIOS = findViewById<RadioButton>(R.id.radioIOS) // Opción iOS
        val platformLogo = findViewById<ImageView>(R.id.platformLogo) // Imagen de la plataforma
        val checkOtra = findViewById<CheckBox>(R.id.checkOtra) // Casilla "Otra"
        val inputOtra = findViewById<EditText>(R.id.inputOtra) // Campo de texto para especificar otra plataforma

        // Se obtiene el grupo de radio buttons para detectar cuál opción se selecciona.
        val platformGroup = findViewById<RadioGroup>(R.id.platformGroup)

        // Cuando se selecciona una plataforma, se cambia la imagen que aparece en pantalla.
        platformGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.radioAndroid -> {
                    // Si se elige Android, se muestra el logo correspondiente.
                    platformLogo.setImageResource(R.drawable.android_logo)
                    platformLogo.visibility = View.VISIBLE
                }
                R.id.radioIOS -> {
                    // Si se elige iOS, se muestra el logo correspondiente.
                    platformLogo.setImageResource(R.drawable.ios_logo)
                    platformLogo.visibility = View.VISIBLE
                }
            }
        }

        // Cuando se marca o desmarca la casilla "Otra", se muestra u oculta el campo de texto adicional.
        checkOtra.setOnCheckedChangeListener { _, isChecked ->
            inputOtra.visibility = if (isChecked) View.VISIBLE else View.GONE
        }

        // Cuando se presiona el botón "Continuar", se muestra un mensaje de agradecimiento.
        // Luego se cierra esta actividad (vuelve a la anterior si hay una en la pila).
        btnContinue.setOnClickListener {
            Toast.makeText(this, "Gracias por completar tus datos", Toast.LENGTH_SHORT).show()
            finish() // Finaliza la actividad
        }
    }
}

