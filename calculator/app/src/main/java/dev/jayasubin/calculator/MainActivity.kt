package dev.jayasubin.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.lang.ArithmeticException

class MainActivity : AppCompatActivity() {
    private var inputView:TextView?=null
    private var endWithDecimal:Boolean=false
    private  var endWithNum:Boolean=false
    private var hasOperator:Boolean=false
    private  var hasSign:Boolean=false
    private var hasSomething:Boolean=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputView=findViewById(R.id.math_view)
    }

    fun onNumClick(view:View){
        if(!hasSomething) inputView?.text=""

        inputView?.append((view as Button).text)
        endWithNum=true
        hasSomething=true
        endWithDecimal=false
    }

    fun onClearClick(view:View){
        inputView?.text="0"
        endWithDecimal=false
        endWithNum=false
        hasOperator=false
        hasSign=false
    }

    fun onDecimal(view: View){
        if(!endWithDecimal&&endWithNum){
            inputView?.append(".")
            endWithDecimal=true
            endWithNum=false
        }
    }

    fun onOperator(view:View){
        val curOp=(view as Button).text

        if(!hasOperator&&endWithNum){
            inputView?.append(curOp)

            hasOperator=true
            endWithNum=false
            hasSign=false
            endWithDecimal=false
            hasSomething=true
        }
    }

    fun onCalculate(view: View){
        var answer="0"

        if(endWithNum&&hasOperator){
            var expressionString=inputView?.text.toString()
            var prefix:String=""

            try{
                if(expressionString.startsWith("-")) {
                    prefix="-"
                    expressionString = expressionString.substring(1)
                }

                val parts= expressionString.split("+","-","x","/")

                val firstArg=parts[0].toDouble()
                val secondArg=parts[1].toDouble()

                if(expressionString.contains("+")){
                    answer=(firstArg+secondArg).toString()

                }else if(expressionString.contains("-")){
                    answer=(firstArg-secondArg).toString()

                }else if(expressionString.contains("x")){
                    answer=(firstArg*secondArg).toString()

                }else if(expressionString.contains("/")){
                    answer=(firstArg/secondArg).toString()

                }
            }catch(e:ArithmeticException){
                println(e)
            }
        }
        inputView?.text=answer

        hasOperator=false
    }
}