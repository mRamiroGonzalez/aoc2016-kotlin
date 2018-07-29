package day2

import getContentAsStringArraySplitOnNewLine

fun part1(filename: String): Int{

//    0,0    1,0     2,0
//    0,1    1,1     2,1
//    0,2    1,2     2,2

    var code = ""
    var coord = ""
    var x = 1
    var y = 1

    getContentAsStringArraySplitOnNewLine(filename).forEach { line ->
//        println(line)
        line.forEach { char ->
            when(char) {
                'U' -> {
                    if (y > 0){
                        y -= 1
                    }
                }
                'R' -> {
                    if (x < 2) {
                        x += 1
                    }
                }
                'D' -> {
                    if (y < 2) {
                        y += 1
                    }
                }
                'L' -> {
                    if (x > 0){
                        x -= 1
                    }
                }
            }
            coord = "$x,$y"
//            println(coord)
        }
        when(coord){
            "0,0" -> code += 1
            "1,0" -> code += 2
            "2,0" -> code += 3
            "0,1" -> code += 4
            "1,1" -> code += 5
            "2,1" -> code += 6
            "0,2" -> code += 7
            "1,2" -> code += 8
            "2,2" -> code += 9
        }
//        println(code)
    }
    return code.toInt()
}

fun part2(filename: String): String{
    var code = ""
    var coord = ""
    var x = 0
    var y = 2
    val allowedCoord = listOf(
                          "2,0",
                   "1,1", "2,1", "3,1",
            "0,2", "1,2", "2,2", "3,2", "4,2",
                   "1,3", "2,3", "3,3",
                          "2,4"
    )

    getContentAsStringArraySplitOnNewLine(filename).forEach { line ->
//        println(line)
        line.forEach { char ->
            when(char) {
                'U' -> {
                    val new_y = y -1
                    if ("$x,$new_y" in allowedCoord) {
                        y = new_y
                    }
                }
                'R' -> {
                    val new_x = x +1
                    if ("$y,$new_x" in allowedCoord) {
                        x = new_x
                    }
                }
                'D' -> {
                    val new_y = y +1
                    if ("$x,$new_y" in allowedCoord) {
                        y = new_y
                    }
                }
                'L' -> {
                    val new_x = x -1
                    if ("$y,$new_x" in allowedCoord) {
                        x = new_x
                    }
                }
            }
            coord = "$x,$y"
//            println(coord)
        }
//        println(coord)
        when(coord){
            "2,0" -> code += "1"
            "1,1" -> code += "2"
            "2,1" -> code += "3"
            "3,1" -> code += "4"
            "0,2" -> code += "5"
            "1,2" -> code += "6"
            "2,2" -> code += "7"
            "3,2" -> code += "8"
            "4,2" -> code += "9"
            "1,3" -> code += "A"
            "2,3" -> code += "B"
            "3,3" -> code += "C"
            "2,4" -> code += "D"
        }
//        println(code)
    }
    return code
}