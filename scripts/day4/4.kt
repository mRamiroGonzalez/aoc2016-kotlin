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

fun part2(fileName: String){

}