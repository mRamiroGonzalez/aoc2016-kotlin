package day4

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
        File(testFileName).writeText( "" +
                "aaaaa-bbb-z-y-x-123[abxyz]\n" +
                "a-b-c-d-e-f-g-h-987[abcde]\n" +
                "not-a-real-room-404[oarel]\n" +
                "totally-real-room-200[decoy]")
        Assertions.assertEquals(1514, day4.part1(testFileName))
    }
}