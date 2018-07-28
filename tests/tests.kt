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
    fun day1_1() {
        File(testFileName).writeText( "R5, L5, R5, R3")
        assert(day1(testFileName) == 12)
        File(testFileName).delete()
    }

    @Test
    fun day1_2(){
        File(testFileName).writeText("R8, R4, R4, R8")
        Assertions.assertEquals(4, day1_2(testFileName))
        File(testFileName).delete()
    }
}