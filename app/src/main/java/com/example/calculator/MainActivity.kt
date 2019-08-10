package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonListener(view: View) {
        val value = (view as AppCompatButton).text.toString()
        var formulaStr = formula.text.toString()
        var result: Double
        when (value) {
            "="  -> {
                try {
                    val expression = ExpressionBuilder(formulaStr).build()
                    result = expression.evaluate()
                } catch (e: Exception) {
                    result = "0.0".toDouble()
                }
                formulaStr = result.toString()
            }
            "Del" -> {
                val stringLength = formulaStr.length;
                if(stringLength != 0) {
                    formulaStr = formulaStr.substring(0,stringLength -1)
                }
            }
            else -> {
                formulaStr = formulaStr  + value
            }
        }
        formula.text = formulaStr
    }
}
