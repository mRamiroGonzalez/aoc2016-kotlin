package day5

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
        File(testFileName).writeText( "abc")
        Assertions.assertEquals("18f47a30", day5.part1(testFileName))
    }

    @Test
    fun part2(){
        File(testFileName).writeText( "abc")
        Assertions.assertEquals("05ace8e3", day5.part2(testFileName))
    }

    @Test
    fun hashMd5(){
        Assertions.assertEquals("00000155f8105dff7f56ee10fa9b9abd", day5.getMd5for("abc3231929"))
        Assertions.assertEquals("900150983cd24fb0d6963f7d28e17f72", day5.getMd5for("abc"))
    }
}