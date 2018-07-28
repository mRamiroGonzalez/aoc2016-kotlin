import kotlin.math.absoluteValue

fun day1(filename : String) : Int {
    var x = 0
    var y = 0
    var facing = 0   // 0 -> North, 1 -> East, 2 -> South, 3 -> West

    getContentAsStringArray(filename).forEach {
        val direction = it[0]
        val distance = it.substringAfter(direction).toInt()

        println("Facing: $facing, Pos: ($x, $y), Instruction: $it")

        if(direction == 'R'){
            facing += 1
            if(facing == 4) facing = 0
        } else {
            facing -= 1
            if(facing == -1) facing = 3
        }

        when(facing) {
            0 -> y += distance
            1 -> x += distance
            2 -> y -= distance
            3 -> x -= distance
        }
    }

    return (x.absoluteValue + y.absoluteValue)
}

fun day1_2(filename: String) : Int{
    var x = 0
    var y = 0
    var facing = 0   // 0 -> North, 1 -> East, 2 -> South, 3 -> West
    var visited = mutableListOf<String>()

    getContentAsStringArray(filename).forEach {
        val direction = it[0]
        val distance = it.substringAfter(direction).toInt()

        println("Facing: $facing, Pos: ($x, $y), Instruction: $it")

        if(direction == 'R'){
            facing += 1
            if(facing == 4) facing = 0
        } else {
            facing -= 1
            if(facing == -1) facing = 3
        }

        when(facing) {
            0 -> {
                val newY = y + distance

                if(y < newY){
                    for(i in y..newY){
                        if ("$x$i" in visited) return x.absoluteValue + i.absoluteValue
                        visited.add("$x$i")
                    }
                } else {
                    for(i in y downTo newY){
                        if ("$x$i" in visited) return x.absoluteValue + i.absoluteValue
                        visited.add("$x$i")
                    }
                }
                y = newY
            }
            1 -> {
                val newX = x + distance

                if(x < newX){
                    for(i in x..newX){
                        if ("$i$y" in visited) return i.absoluteValue + y.absoluteValue
                        visited.add("$i$y")
                    }
                } else {
                    for(i in x downTo newX){
                        if ("$i$y" in visited) return i.absoluteValue + y.absoluteValue
                        visited.add("$i$y")
                    }
                }
                x = newX
            }
            2 -> {
                val newY = y - distance

                if(y < newY){
                    for(i in y..newY){
                        if ("$x$i" in visited) return x.absoluteValue + i.absoluteValue
                        visited.add("$x$i")
                    }
                } else {
                    for(i in y downTo newY){
                        if ("$x$i" in visited) return x.absoluteValue + i.absoluteValue
                        visited.add("$x$i")
                    }
                }
                y = newY
            }
            3 -> {
                val newX = x - distance

                if(x < newX){
                    for(i in x..newX){
                        if ("$i$y" in visited) return i.absoluteValue + y.absoluteValue
                        visited.add("$i$y")
                    }
                } else {
                    for(i in x downTo newX){
                        if ("$i$y" in visited) return i.absoluteValue + y.absoluteValue
                        visited.add("$i$y")
                    }
                }
                x = newX
            }
        }
        visited.removeAt(visited.size-1)
    }
    return 0
}