package day7

import getContentAsStringArraySplitOnNewLine

fun part1(fileName: String): Int {

    val lineHasASequence = Regex("""(.)(.)\2\1""")
    var count = 0

    getContentAsStringArraySplitOnNewLine(fileName).forEach {
        var ok = false

        if(lineHasASequence.containsMatchIn(it)){
            ok = true
        }

        lineHasASequence.findAll(it).forEach stopLine@ { match ->
            val sequence = match.value
            val sequenceIsBetweenBrackets = Regex("""\[[^\]]*$sequence[^\[]*\]""")
            val sequenceIsAAAA = Regex("""(.)\1\1\1""")
            if(sequenceIsBetweenBrackets.containsMatchIn(it)){
                ok = false
                return@stopLine
            }
            if (sequenceIsAAAA.containsMatchIn(sequence)){
                ok = false
                return@stopLine
            }
        }


        if(ok){
            count += 1
            println(it)
        }
    }
    return count
}

fun part2(fileName: String){

}