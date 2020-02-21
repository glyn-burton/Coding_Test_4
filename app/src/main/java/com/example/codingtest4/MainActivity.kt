package com.example.codingtest4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import java.util.*
import kotlin.math.abs


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val test = "Hello(My name{ is} Bryan ) Hallbit []"
        val strTest = "cowcatcow"
        val strTwoTest = "catcowcat"

        val sortedIntArray = intArrayOf(-9,-1,2,3,8)
        val differentArray = sortedSquaredArray(sortedIntArray)


        Log.d("TAG", "Are there n number of sub-strings? "+strCopies(strTest,"cow",1).toString())

        Log.d("TAG", "Are the parenthesis and brackets correct? " + stringParenthesisBracketChecker(test).toString())

        Log.d("TAG","The sorted squared array: "+ Arrays.toString(differentArray))
    }

    /*
    Create a program which checks if the string has the correct order of parenthesis/brackets.
    ({})[] = true, []{]}[ = false
     */

    fun stringParenthesisBracketChecker(subject:String):Boolean{
        val correctString = charArrayOf('(','{','}',')','[',']')
        val checking = subject.toCharArray()
        var countTracker = 0

        for (i in 0 until checking.size){

            when (checking[i]){

                '(' -> {
                    if (checking[i] != correctString[countTracker]){

                        return false

                    }
                    else{
                        countTracker++

                    }
                }

                '{' -> {
                    if (checking[i] != correctString[countTracker]){

                        return false
                    }
                    else{
                        countTracker++
                    }
                }
                '}' -> {
                    if (checking[i] != correctString[countTracker]){
                        return false
                    }
                    else{
                        countTracker++
                    }
                }
                ')' -> {
                    if (checking[i] != correctString[countTracker]){
                        return false
                    }
                    else{
                        countTracker++
                    }
                }

                '[' -> {
                    if (checking[i] != correctString[countTracker]){

                        return false
                    }
                    else{
                        countTracker++
                    }
                }

                ']' -> {
                    if (checking[i] != correctString[countTracker]){

                        return false
                    }
                    else{
                        countTracker++

                    }

                }



            }

        }
        return true

    }


    /*

    Given a string and a non-empty substring sub, compute recursively if at least n copies of sub appear in the string somewhere,
    possibly with overlapping. N will be non-negative.
      strCopies("catcowcat", "cat", 2) → true
      strCopies("catcowcat", "cow", 2) → false
      strCopies("catcowcat", "cow", 1) → true
     */

    fun strCopies(str: String, substring: String, numberOf: Int): Boolean {

        return func(str, substring) == numberOf
    }

    private fun func(str: String, sub: String): Int {
        val lengthOfString = str.length
        val lengthofSub = sub.length
        if (lengthOfString < lengthofSub) return 0
        return if (str.substring(0, lengthofSub) == sub)
            1 + func(str.substring(1), sub)
        else
            func(str.substring(1), sub)
    }

    /*
    Given a sorted array of int (both negative and positive values possible),
    write an equation that will square each value in the array and return a sorted array as well.
    This must have a O(n) time complexity (so no resort)
     */

    fun sortedSquaredArray(arryint:IntArray):IntArray{
        var sortedArray = IntArray(arryint.size)
        sortedArray = arryint
        Log.d("TAG",sortedArray.contentToString())

        for (i in arryint.indices)
        {
            if(i < (arryint.size-1))

                if(abs(arryint[i]) > abs(arryint[i + 1]))
            {
                    var temporaryNum = arryint[i]
                    arryint[i] = arryint[i+1]
                    arryint[i+1] = temporaryNum

            }
            sortedArray[i] = Math.pow(sortedArray[i].toDouble(),2.0).toInt()

        }
        return sortedArray


    }


}
