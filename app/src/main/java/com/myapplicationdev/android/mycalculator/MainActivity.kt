package com.myapplicationdev.android.mycalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var value = 0.0
    var total = 0.0
    var operator = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun btnOnClick(view: View){
        val btnSelected = view as Button
        if (tvCount.text.toString().equals("0")){
            when (btnSelected.id){
                btn1.id  -> tvCount.text = "1"
                btn2.id  -> tvCount.text = "2"
                btn3.id  -> tvCount.text = "3"
                btn4.id  -> tvCount.text = "4"
                btn5.id  -> tvCount.text = "5"
                btn6.id  -> tvCount.text = "6"
                btn7.id  -> tvCount.text = "7"
                btn8.id  -> tvCount.text = "8"
                btn9.id  -> tvCount.text = "9"
            }
        } else {
            when (btnSelected.id){
                btn0.id  -> tvCount.text = tvCount.text.toString() + "0"
                btn1.id  -> tvCount.text = tvCount.text.toString() + "1"
                btn2.id  -> tvCount.text = tvCount.text.toString() + "2"
                btn3.id  -> tvCount.text = tvCount.text.toString() + "3"
                btn4.id  -> tvCount.text = tvCount.text.toString() + "4"
                btn5.id  -> tvCount.text = tvCount.text.toString() + "5"
                btn6.id  -> tvCount.text = tvCount.text.toString() + "6"
                btn7.id  -> tvCount.text = tvCount.text.toString() + "7"
                btn8.id  -> tvCount.text = tvCount.text.toString() + "8"
                btn9.id  -> tvCount.text = tvCount.text.toString() + "9"
                btnDec.id ->tvCount.text = tvCount.text.toString() + "."
                btnAC.id -> tvCount.text = "0"
            }
        }
    }

    fun btnOpOnClick(view: View){
        if (tvCount.text.toString().isEmpty()){
            Toast.makeText(this, "Please enter a digit", Toast.LENGTH_SHORT).show()
        } else {
            value = tvCount.text.toString().toDouble()
            tvCount.text = ""
            val btnOpSelected = view as Button
            when (btnOpSelected.id){
                btnPlus.id -> operator = "+"
                btnDivide.id -> operator = "/"
                btnMin.id -> operator = "-"
                btnMul.id -> operator = "*"
                btnMod.id -> value = value / 100
            }

            if (operator.equals("")){
                tvCount.text = "$value"
            }
        }
    }

    fun btnEqOnClick(view: View){
        if (tvCount.text.toString().isEmpty()){
            Toast.makeText(this, "Please enter a digit", Toast.LENGTH_SHORT).show()

        } else {
            if (operator.equals("+")){
                total = value + tvCount.text.toString().toDouble()
            } else if (operator.equals("-")){
                total = value - tvCount.text.toString().toDouble()
            } else if (operator.equals("/")){
                total = value / tvCount.text.toString().toDouble()
            } else {
                total = value * tvCount.text.toString().toDouble()
            }
            operator = ""
            tvCount.text = "$total"
            value = total
        }
    }

    fun btnPNOnClick(view: View){
        if (tvCount.text.toString().isEmpty()){
            Toast.makeText(this, "Please enter a digit", Toast.LENGTH_SHORT).show()

        } else {
            var pnValue = tvCount.text.toString().toDouble()
            if (pnValue < 0) {
                pnValue = pnValue + (-pnValue) + (-pnValue)
            } else {
                pnValue = pnValue - pnValue - pnValue
            }

            tvCount.text = "$pnValue"
        }
    }
}
