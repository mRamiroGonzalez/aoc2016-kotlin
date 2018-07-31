package day4

import getContentAsStringArraySplitOnNewLine

fun part1(fileName: String): Int{
    val content = getContentAsStringArraySplitOnNewLine(fileName)
    val regex = """\[(.*?)\]""".toRegex()
    var count = 0

    content.forEach{
        val numberPart = it.replace(Regex("""\D"""), "").toInt()
        val stringPart = it.replace(Regex("""\d"""), "").replace("-","")
        val checkPart = regex.findAll(it).first().groups[1]!!.value

        val charsMap = stringPart.groupingBy{it}.eachCount()
        val sortedMap = charsMap.toList().sortedWith(compareBy({(_, value) -> -value}, { (key, _) -> key})).toMap()

        if(checkPart in sortedMap.keys.joinToString("")){
            count += numberPart
        }
    }
    return count
}

fun part2(fileName: String) : Int{
    val content = getContentAsStringArraySplitOnNewLine(fileName)

    content.forEach{
        if("north" in decode(it)){
            return it.replace(Regex("""\D"""), "").toInt()
        }
    }
    return 0
}

fun decode(entry: String) : String {
    val number = entry.replace(Regex("""\D"""), "").toInt()
    val toAdd = number.rem(26)
    var decoded = ""

    entry.toCharArray().forEach {
        var newChar = it.toInt() + toAdd
        if(newChar > 122) {
            val leftToAdd = newChar - 122
            newChar = 97 + (leftToAdd - 1)
        }
        decoded += newChar.toChar()
    }
    return decoded
}