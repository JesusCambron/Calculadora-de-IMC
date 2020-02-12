package myhealthapp.jesus.cambron.myhealthapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val peso: EditText = findViewById(R.id.weight) as EditText
        val altura: EditText = findViewById(R.id.height) as EditText
        val calcular:Button = findViewById(R.id.calculate) as Button
        val imc:TextView = findViewById(R.id.imc) as TextView
        val rango:TextView = findViewById(R.id.range) as TextView

        /*
        IMC < 18.5 por debajo de tu peso
        18.5 y 24.9 saludable
        25 y 29.9 sobrepeso
        30 y 39.9 obesidad
        +40 obesidad
         */

        calcular.setOnClickListener {
            var p:Float = peso.text.toString().toFloat()
            var a:Float = altura.text.toString().toFloat()
            var imc2:Float = p/(a*a)

            imc.setText("$imc2")

            if(imc2 < 18.5) {
                rango.setText("Por debajo de tu peso")
                rango.setBackgroundResource(R.color.greenish)
            } else if (imc2 < 25) {
                rango.setText("Saludable")
                rango.setBackgroundResource(R.color.green)
            } else if (imc2 < 30) {
                rango.setText("SobrePeso")
                rango.setBackgroundResource(R.color.yellow)
            } else if(imc2 < 40) {
                rango.setText("Obesidad")
                rango.setBackgroundResource(R.color.orange)
            } else {
                rango.setText("Obesidad Morbida")
                rango.setBackgroundResource(R.color.red)
            }
        }
    }
}
