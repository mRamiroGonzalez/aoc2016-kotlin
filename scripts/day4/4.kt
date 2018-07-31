package day4

import getContentAsStringArraySplitOnNewLine

fun part1(fileName: String): Int{
    val content = getContentAsStringArraySplitOnNewLine(fileName)
    val regex = """[a-z]+[0-9]+""".toRegex()
    var count = 0

    content.forEach{
        val cleanedInput = it.replace("-", "")

        val matches = regex.findAll(cleanedInput)
        val numberPart = matches.first().value.replace(Regex("""\D"""),"")
        val stringPart = matches.first().value.replace(Regex("""\d+"""),"")
        val checkPart = cleanedInput.replace(regex, "").replace("[\\[\\]]".toRegex(),"")

        //println("$it \n -> $numberPart + $stringPart + $checkPart")

        val charsMap = stringPart.groupingBy{it}.eachCount()
        val sortedMap = charsMap.toList().sortedWith(compareBy({(_, value) -> -value}, { (key, _) -> key})).toMap()

        if(checkPart in sortedMap.keys.joinToString("")){
            count += numberPart.toInt()
        }
    }
    return count
}

fun part2(fileName: String) : Int{
    val content = getContentAsStringArraySplitOnNewLine(fileName)

    content.forEach{
        val decoded = decode(it)
        if("north" in decoded){
            return it.replace(Regex("""\D"""), "").toInt()
        }
    }
    return 0
}

fun decode(entry: String) : String {
    val number = entry.replace(Regex("""\D"""), "").toInt()
    val sentence = entry.replace(Regex("""\d+"""), "")
    val toAdd = number.rem(26)
    var decoded = ""

    sentence.toCharArray().forEach {
        if(it.isLetter()) {
            var newChar = it.toInt() + toAdd
            if(newChar > 122) {
                val leftToAdd = newChar - 122
                newChar = 97 + (leftToAdd - 1)
            }
            decoded += newChar.toChar()
        } else {
            decoded += " "
        }
    }
    return decoded.trim()
}