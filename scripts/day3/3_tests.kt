package day3

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
        File(testFileName).writeText( "  5  10  25\n  5  10   25")
        Assertions.assertEquals(0, day3.part1(testFileName))
    }

    @Test
    fun part1_2() {
        File(testFileName).writeText( "  5  5  5\n  3  4   5")
        Assertions.assertEquals(2, day3.part1(testFileName))
    }

    @Test
    fun part2() {
        File(testFileName).writeText( "" +
                "  1  10  1\n" +
                "  2  10   2\n" +
                "  3  10   3")
        Assertions.assertEquals(1, day3.part2(testFileName))
    }
}