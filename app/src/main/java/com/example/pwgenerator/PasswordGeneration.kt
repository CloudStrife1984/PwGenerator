package com.example.pwgenerator

import kotlin.random.Random

class PasswordGeneration {

    var passWord = ""
    var chars = ""
    var capitals = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    var smallLett = "abcdefghijklmnopqrstuvwxyz"
    var numbe = "0123456789"


    fun createPassWord(pwLenght: Int, capitalLetters: Boolean, smallLetters:Boolean, numbers: Boolean):String{
        if(capitalLetters){
            chars = capitals;
        }
        if(smallLetters){
            chars += smallLett
        }
        if(numbers){
            chars += numbe
        }
        if(chars == ""){
            passWord = "Ei salasanaa, tarkista valinnat"
            return passWord
        }
            for (i in 0 until pwLenght){
                var y  = Random.nextInt(0, chars.length)
                passWord += chars[y]
            }
        return passWord
    }





}