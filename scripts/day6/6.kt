package day6

import getContentAsStringArraySplitOnNewLine

fun part1(fileName: String): String{

    val input = getContentAsStringArraySplitOnNewLine(fileName)
    val nbChar = input[0].length
    val tab = mutableMapOf<Int,MutableMap<Char, Int>>()
    var code = ""

    for(i in 0 until nbChar){
        tab[i] = mutableMapOf()
    }

    for (i in 0 until input.size){
        if(!tab.containsKey(i)){
            tab[i] = mutableMapOf()
        }
        for (j in 0 until nbChar){
            val currentChar = input[i][j]
            if (tab[j]!!.containsKey(currentChar)){
                tab[j]!![currentChar] = tab[j]!!.getValue(currentChar) + 1
            } else {
                tab[j]!![currentChar] = 1
            }
        }
    }

    tab.forEach {
        if(it.value.isNotEmpty()){
            val sorted = it.value.toList().sortedWith(compareBy { (_, value) -> -value})
            code += sorted[0].first
            println(code)
        }
    }
    return code
}

fun part2(fileName: String): String{

    val input = getContentAsStringArraySplitOnNewLine(fileName)
    val nbChar = input[0].length
    val tab = mutableMapOf<Int,MutableMap<Char, Int>>()
    var code = ""

    for(i in 0 until nbChar){
        tab[i] = mutableMapOf()
    }

    for (i in 0 until input.size){
        if(!tab.containsKey(i)){
            tab[i] = mutableMapOf()
        }
        for (j in 0 until nbChar){
            val currentChar = input[i][j]
            if (tab[j]!!.containsKey(currentChar)){
                tab[j]!![currentChar] = tab[j]!!.getValue(currentChar) + 1
            } else {
                tab[j]!![currentChar] = 1
            }
        }
    }

    tab.forEach {
        if(it.value.isNotEmpty()){
            val sorted = it.value.toList().sortedWith(compareBy { (_, value) -> value})
            code += sorted[0].first
            println(code)
        }
    }
    return code
}