package day2

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
    fun day2() {
        File(testFileName).writeText("ULL\nRRDDD\nLURDL\nUUUUD")
        Assertions.assertEquals(1985, part1(testFileName))
    }

    @Test
    fun day2_2() {
        File(testFileName).writeText("ULL\nRRDDD\nLURDL\nUUUUD")
        Assertions.assertEquals("5DB3", part1(testFileName))
    }
}