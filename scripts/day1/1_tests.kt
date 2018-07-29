package day1

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

class Tests {
    private val testFileName = "temp.txt"

    @AfterEach
    fun clean(){
        File(testFileName).delete()
    }

    @Test
    fun part1() {
        File(testFileName).writeText( "R5, L5, R5, R3")
        Assertions.assertEquals(12, part1(testFileName))
    }

    @Test
    fun part2(){
        File(testFileName).writeText("R8, R4, R4, R8")
        Assertions.assertEquals(4, part2(testFileName))
    }
}