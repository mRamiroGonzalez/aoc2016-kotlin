import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.File

class Tests {

    private val testFileName = "temp.txt"

    @BeforeEach
    fun clean(){
        File(testFileName).delete()
    }

    @Test
    fun day1_1() {
        File(testFileName).writeText("R2, L3")
        assert(day1(testFileName) == 5)
        File(testFileName).delete()

        File(testFileName).writeText("R2, R2, R2")
        assert(day1(testFileName) == 2)
        File(testFileName).delete()

        File(testFileName).writeText( "R5, L5, R5, R3")
        assert(day1(testFileName) == 12)
        File(testFileName).delete()
    }

    @Test
    fun day1_2(){
        File(testFileName).writeText("R8, R4, R4, R8")
        Assertions.assertEquals(4, day1_2(testFileName))
    }
}