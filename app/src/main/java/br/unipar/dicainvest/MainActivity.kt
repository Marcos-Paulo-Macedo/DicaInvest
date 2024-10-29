package br.unipar.dicainvest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        findViewById<Button>(R.id.btnCulturas).setOnClickListener {
            navigateToCulturas()
        }

        findViewById<Button>(R.id.btnFinancas).setOnClickListener {
            navigateToFinancas()
        }

        findViewById<Button>(R.id.btnCalendario).setOnClickListener {
            navigateToCalendario()
        }

        findViewById<Button>(R.id.btnRelatorios).setOnClickListener {
            navigateToRelatorios()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun navigateToCulturas() {
        val intent = Intent(this, CulturasActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToFinancas() {
        val intent = Intent(this, FinancasActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToCalendario() {
        val intent = Intent(this, CalendarioActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToRelatorios() {
        val intent = Intent(this, RelatoriosActivity::class.java)
        startActivity(intent)
    }
}