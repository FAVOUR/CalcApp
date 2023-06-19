package com.example.simplecalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.NonNull
//import com.example.simplecalc.ApiClient.retrofit
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    var Operand1 by Delegates.notNull<Double>()
    var Operand2 by Delegates.notNull<Double>()
    lateinit var calculator: Calculator



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val okay = BuildConfig.BUILD_TYPE
//        print("okay $okay")
//        val hold = retrofit

        calculator= Calculator()

        add.setOnClickListener {
            assignOperands()
            try {
                operation_result_text_view.text= performOperation(Operation.ADD).toString()

            }catch (e:Throwable){
                Toast.makeText(this,e.message,Toast.LENGTH_SHORT).show()

            }
        }
        subtract.setOnClickListener {
            assignOperands()
            try {
                operation_result_text_view.text=performOperation(Operation.SUBTRACT).toString()
        }catch (e:Throwable){
            Toast.makeText(this,e.message,Toast.LENGTH_SHORT).show()

        }
        }
        multiply.setOnClickListener {
            assignOperands()
            try{
                operation_result_text_view.text=performOperation(Operation.MULTIPLY).toString()
        }catch (e:Throwable){
            Toast.makeText(this,e.message,Toast.LENGTH_SHORT).show()

        }
        }

        divide.setOnClickListener {
            assignOperands()
            try{
                operation_result_text_view.text= performOperation(Operation.DIVIDE).toString()
        }catch (e:Throwable){
            Toast.makeText(this,e.message,Toast.LENGTH_SHORT).show()

        }
        }




    }

    fun assignOperands (){
        val _operand1=operand1.text.toString()
        val _operand2=operand2.text.toString()
        try {



        if(!((_operand1).isNullOrEmpty()) && !((_operand2.isNullOrEmpty())))
        {
           Operand1=_operand1.toDouble()
            Operand2=_operand2.toDouble()
        }
        else{
            Toast.makeText(this,"Your Input is empty",Toast.LENGTH_SHORT).show()
        }

        }catch (e:Throwable){

            Toast.makeText(this,e.message,Toast.LENGTH_SHORT).show()

        }


    }

    fun performOperation(operation:Operation):Double {
        var outcome by Delegates.notNull<Double>()
            when (operation) {

                Operation.ADD -> {
                    outcome = Operand1 + Operand2
                }

                Operation.MULTIPLY -> {
                    outcome = Operand1 * Operand2
                }

                Operation.SUBTRACT -> {
                    outcome = Operand1 - Operand2
                }

                Operation.DIVIDE -> {
                    outcome = Operand1 / Operand2
                }
            }

            return outcome

        }


    enum class Operation{
        ADD,SUBTRACT,DIVIDE,MULTIPLY
    }
}
