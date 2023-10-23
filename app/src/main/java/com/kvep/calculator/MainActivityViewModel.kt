package com.kvep.calculator

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    var total: Double = 0.0
    private var num1: String = ""
    private var num2: String = ""
    private var operator: String = ""
    private var addDecimal: Boolean = false

    var isOperationClicked: Boolean = false


    var inputText = MutableLiveData<String>("")

    init {
        total = 0.0

    }

    fun getNumber(num: String) {
        if (!isOperationClicked) {
            inputText.value = inputText.value + num

            num1 = inputText.value!!
        } else {
            inputText.value = inputText.value + num

            num2=inputText.value!!
        }



    }

    fun getOperator(oper: String) {

        isOperationClicked = true
        operator = oper
        inputText.value = ""

        addDecimal = false
        Log.i("num1",num1)
    }

    fun showAnswer() {
        isOperationClicked=false
        Log.i("num1 in =",num1)
        Log.i("num2 in =",num2)
        var firstNumber = num1.toDoubleOrNull()
        var secondNumber = num2.toDoubleOrNull()

        if (firstNumber != null && secondNumber != null) {

            total = when (operator) {

                "+" -> firstNumber + secondNumber
                "-" -> firstNumber - secondNumber
                "*" -> firstNumber * secondNumber
                "/" -> firstNumber / secondNumber

                else -> {0.0}
            }
            inputText.value = total.toString()
            num1=inputText.value!!

        }



        total = 0.0



    }

    fun clearAll() {
        num1 = ""
        num2 =""
        total = 0.0
        addDecimal = false
        inputText.value = ""

        isOperationClicked=false


    }

    fun setDecimal() {
        if (!addDecimal&&inputText.value!!.isNotBlank()) {
            inputText.value = inputText.value + "."

            addDecimal = true
        }
    }
}