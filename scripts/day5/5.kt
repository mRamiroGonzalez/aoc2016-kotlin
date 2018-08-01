package day5

import getContentAsString
import java.security.MessageDigest

fun part1(fileName: String): String {
    val input = getContentAsString(fileName)
    println(input)

    var code = ""
    var i = 0

    while (code.length < 8){
        val hashed = getMd5for(input + i)
        if (hashed.startsWith("00000")){
            code += hashed[5]
        }
        i++
    }
    return code
}

fun part2(fileName: String): String{
    val input = getContentAsString(fileName)
    println(input)

    val code = "        ".toCharArray()
    var i = 0

    while (' ' in code){
        val hashed = getMd5for(input + i)
        if (hashed.startsWith("00000")){
            println(hashed)
            val hashedCharArray = hashed.toCharArray()
            val place = hashedCharArray[5]
            val charCode = hashedCharArray[6]

            if (place.toInt() in 48..55){
                if(code[place.toString().toInt()] == ' '){
                    code[place.toString().toInt()] = charCode
                    println(code.joinToString(""))
                }
            }
        }
        i++
    }
    println("Number of iterations: $i")
    return code.joinToString("")
}

fun getMd5for(toHash: String): String {
    val md = MessageDigest.getInstance("MD5")
    val digested = md.digest(toHash.toByteArray())
    return digested.joinToString("") {
        String.format("%02x", it)
    }
}