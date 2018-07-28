import java.io.File

fun getContentAsString(filename : String) : String{
    return File(filename).readText()
}

fun getContentAsStringArray(filename : String) : List<String>{
    return getContentAsString(filename).replace(" ", "").split(",")
}