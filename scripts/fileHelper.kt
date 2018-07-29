import java.io.File

fun getContentAsString(filename : String) : String{
    return File(filename).readText()
}

fun getContentAsStringArraySplitOnComma(filename : String) : List<String>{
    return getContentAsString(filename).replace(" ", "").split(",")
}

fun getContentAsStringArraySplitOnNewLine(filename : String) : List<String>{
    return File(filename).readLines()
}