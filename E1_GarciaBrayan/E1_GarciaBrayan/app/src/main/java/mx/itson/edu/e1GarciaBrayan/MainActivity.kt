package mx.itson.edu.e1GarciaBrayan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var totalCantidad: Float = 0.0f
    var porcentajeTotal: Float = 0.0f
    var porcentajeSeleccionado: Float = 0.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etPrecioOriginal: EditText = findViewById(R.id.etPrecioOriginal)
        val btn10 : Button = findViewById(R.id.btn10)
        val btn15 : Button = findViewById(R.id.btn15)
        val btn20 : Button = findViewById(R.id.btn20)
        val btn25 : Button = findViewById(R.id.btn25)
        val btn30 : Button = findViewById(R.id.btn30)
        val btn40 : Button = findViewById(R.id.btn40)
        val btnTip : Button = findViewById(R.id.btnTip)
        val btnDiscount : Button = findViewById(R.id.btnDiscount)
        var tvPorcentaje : TextView = findViewById(R.id.tvPorcentaje)
        var tvTotal : TextView = findViewById(R.id.tvTotal)

        val buttons = listOf(btn10, btn15, btn20, btn25, btn30, btn40)

        buttons.forEach { button ->
            button.setOnClickListener {
                val precioOriginal = etPrecioOriginal.text.toString().toFloatOrNull()
                if (precioOriginal != null) {
                    buttons.forEach { it.isActivated = false }
                    button.isActivated = true
                    porcentajeSeleccionado = button.text.toString().replace("%", "").toFloat() / 100
                    porcentajeTotal = precioOriginal * porcentajeSeleccionado
                    tvPorcentaje.text = "%.2f".format(porcentajeTotal)
                }
            }
        }

        btnTip.setOnClickListener {
            val precioOriginal = etPrecioOriginal.text.toString().toFloatOrNull()
            if (precioOriginal != null) {
                totalCantidad = precioOriginal + porcentajeTotal
                tvTotal.text = "%.2f".format(totalCantidad)
            }
        }

        btnDiscount.setOnClickListener {
            val precioOriginal = etPrecioOriginal.text.toString().toFloatOrNull()
            if (precioOriginal != null) {
                totalCantidad = precioOriginal - porcentajeTotal
                tvTotal.text = "%.2f".format(totalCantidad)
            }
        }

    }
}

