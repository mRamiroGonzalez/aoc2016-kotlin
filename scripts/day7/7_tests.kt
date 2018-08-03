package day7

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
        File(testFileName).writeText("" +
                "abba[mnop]qrst\n" +                // 1
                "abcd[bddb]xyyx\n" +
                "aaaa[qwer]tyui\n" +
                "ioxxoj[asdfgh]zxcvbn\n" +          // 2
                "aze[qsabbcv]azeabbarty\n" +        // 3
                "aze[aze]abba\n" +                  // 4
                "aze[abba]azeabba\n" +
                "azeabbaaze[aaaa]aze[abba]\n" +
                "aze[aze]abba[aze]aze")             // 5
        Assertions.assertEquals(5, day7.part1(testFileName))
    }
}


