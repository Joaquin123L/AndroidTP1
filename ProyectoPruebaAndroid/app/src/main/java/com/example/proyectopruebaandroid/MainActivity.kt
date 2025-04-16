package com.example.proyectopruebaandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity



// La clase MainActivity hereda de AppCompatActivity, lo que le permite ser una actividad de Android.
class MainActivity : AppCompatActivity() {

    // Método que se ejecuta cuando se crea la actividad.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Establece el diseño (layout) que se va a usar para esta actividad.
        setContentView(R.layout.activity_main)

        // Se obtiene una referencia al botón de login usando su ID en el layout.
        val loginButton = findViewById<Button>(R.id.btnLogin)

        // Se define lo que ocurre cuando se hace clic en el botón de login.
        loginButton.setOnClickListener {
            // Se obtienen los textos ingresados por el usuario en los campos de usuario y contraseña.
            val username = findViewById<EditText>(R.id.inputUsername).text.toString()
            val password = findViewById<EditText>(R.id.inputPassword).text.toString()

            // Se verifica si el usuario y la contraseña coinciden con los valores definidos ("Juan Torres" y "1234utn").
            if (username == "Juan Torres" && password == "1234utn") {
                // Si los datos son correctos, se crea una intención para pasar a la pantalla de bienvenida.
                val intent = Intent(this, WelcomeActivity::class.java)

                // Se le pasa el nombre del usuario a la nueva actividad usando "putExtra".
                intent.putExtra("nombre", username)

                // Se inicia la nueva actividad (pantalla de bienvenida).
                startActivity(intent)
            } else {
                // Si los datos no coinciden, se muestra un mensaje de error.
                Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show()
            }
        }

        // Se obtiene una referencia al TextView que funciona como enlace al registro.
        val registerLink = findViewById<TextView>(R.id.linkRegister)

        // Se define lo que ocurre cuando se hace clic en el enlace de registro.
        registerLink.setOnClickListener {
            // Se inicia la actividad de registro (RegisterActivity).
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}
