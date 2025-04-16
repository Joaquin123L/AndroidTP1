package com.example.proyectopruebaandroid

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

// La clase RegisterActivity hereda de AppCompatActivity, permitiendo que sea una pantalla de Android.
class RegisterActivity : AppCompatActivity() {

    // Método que se ejecuta al crear la actividad.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Establece el layout XML que se usará en esta pantalla.
        setContentView(R.layout.activity_register)

        // Se obtienen referencias a los elementos del layout.
        val name = findViewById<EditText>(R.id.inputName) // Campo para el nombre
        val email = findViewById<EditText>(R.id.inputEmail) // Campo para el correo
        val password = findViewById<EditText>(R.id.inputPassword) // Campo para la contraseña
        val repeatPassword = findViewById<EditText>(R.id.inputRepeatPassword) // Campo para repetir contraseña
        val registerButton = findViewById<Button>(R.id.btnRegister) // Botón de registro

        // Acciones cuando se presiona el botón de "Registrarse"
        registerButton.setOnClickListener {
            // Se extraen los textos ingresados en los campos
            val nameText = name.text.toString()
            val emailText = email.text.toString()
            val passwordText = password.text.toString()
            val repeatPasswordText = repeatPassword.text.toString()

            // Validación de los datos ingresados:

            // Si el nombre o el correo están vacíos
            if (nameText.isEmpty() || emailText.isEmpty()) {
                Toast.makeText(this, "Nombre y correo no pueden estar vacíos", Toast.LENGTH_SHORT).show()
            }
            // Si la contraseña tiene menos de 6 caracteres
            else if (passwordText.length < 6) {
                Toast.makeText(this, "La contraseña debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show()
            }
            // Si las contraseñas no coinciden
            else if (passwordText != repeatPasswordText) {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            }
            // Si todo está correcto
            else {
                Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()

                // Redirigir al usuario a la pantalla de inicio de sesión (MainActivity)
                startActivity(Intent(this, MainActivity::class.java))

                // Cierra la actividad actual para que no vuelva con "Atrás"
                finish()
            }
        }
    }
}

