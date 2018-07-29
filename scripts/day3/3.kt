package day3

import java.io.File

fun part1(filename: String): Int {
    var numberOfTriangles = 0

    getContentOfFile(filename).forEach {
        if(it[0] + it[1] > it[2] && it[1] + it[2] > it[0] && it[2] + it[0] > it[1]){
            numberOfTriangles ++
        }
    }
    return numberOfTriangles
}

fun part2(filename: String): Int{
    var numberOfTriangles = 0
    val content = getContentOfFile(filename)

    for (i in 0 until content.size step 3){
        if(content[i][0] + content[i+1][0] > content[i+2][0] && content[i+1][0] + content[i+2][0] > content[i][0] && content[i+2][0] + content[i][0] > content[i+1][0]) {
            numberOfTriangles ++
        }
        if(content[i][1] + content[i+1][1] > content[i+2][1] && content[i+1][1] + content[i+2][1] > content[i][1] && content[i+2][1] + content[i][1] > content[i+1][1]) {
            numberOfTriangles ++
        }
        if(content[i][2] + content[i+1][2] > content[i+2][2] && content[i+1][2] + content[i+2][2] > content[i][2] && content[i+2][2] + content[i][2] > content[i+1][2]) {
            numberOfTriangles ++
        }
    }

    return numberOfTriangles
}

fun getContentOfFile(fileName : String): MutableList<List<Int>> {
    val lines = File(fileName).readLines()
    val cleanedLines = mutableListOf<List<Int>>()

    lines.forEach {
        cleanedLines.add(it
                .trim()
                .replace("   ", " ")
                .replace("  ", " ")
                .split(" ")
                .map { it.trim().toInt() })
    }
    return cleanedLines
}