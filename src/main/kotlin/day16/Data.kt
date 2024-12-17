package day16

val testData = """
###############
#.......#....E#
#.#.###.#.###.#
#.....#.#...#.#
#.###.#####.#.#
#.#.#.......#.#
#.#.#####.###.#
#...........#.#
###.#.#####.#.#
#...#.....#.#.#
#.#.#.###.#.#.#
#.....#...#.#.#
#.###.#.#.#.#.#
#S..#.....#...#
###############
""".trimIndent().split("\n")

val testData2 = """
#################
#...#...#...#..E#
#.#.#.#.#.#.#.#.#
#.#.#.#...#...#.#
#.#.#.#.###.#.#.#
#...#.#.#.....#.#
#.#.#.#.#.#####.#
#.#...#.#.#.....#
#.#.#####.#.###.#
#.#.#.......#...#
#.#.###.#####.###
#.#.#...#.....#.#
#.#.#.#####.###.#
#.#.#.........#.#
#.#.#.#########.#
#S#.............#
#################
""".trimIndent().split("\n")

val data = """
#############################################################################################################################################
#.#.....#...#...........#...........#.....#.......#.......#.....#...............#.........#.....#...#.....#.......#........................E#
#.#.###.#.#.#.###.###.#.###.#.###.###.#.#.#.#.###.#####.#.#.###.###.###.#####.###.#####.#.#.#.#.###.#.#.#.###.###.#.###.#.#.###.#######.###.#
#.....................#.....#.#...#...#.#.#.#...#...#...#.#...#...#.#.......#.....#...#.#.#.#.#...#...#.#...#...#.#...#.#.#.#...#.....#.....#
#.#.#.#########.#.#.###########.#.#.###.#.#.###.###.#.###.###.###.#.###.#.#.#########.#.#.#.#.###.#.###.###.###.#.###.#.#.#.#.#.#.#.#.#.#####
#.#.#.......#...#...#...................#.#...#...#...#.#.....#.#.#...#.#.#.....#.....#.#.#.#...#.#...#...#.....#.#...#...#...#...#.#.#...#.#
#.#.#.#####.#.###.#.#.#.#.#.#.###.#####.###.#####.#####.#######.#.###.#.#.#####.###.#.#.###.###.#.#####.#.#######.#.###########.###.#####.#.#
#.#.#...#...#.#...#.#.#...#.#...#.#.....#.........................#...#.#...#.#.....#.#.....#...#...............#.#.#...#.......#...#.....#.#
#.#.###.#####.#.#.#.#.#####.###.#.#.#####.#.#.#####.###.#########.#.###.###.#.###.###########.#.#######.###.#.#.#.#.#.#.#.#.###.#.#.#.#####.#
#.#.....#.....#.#.#.#.#...#...#...#.........#.#...#...#...........#...#...#.#.#...#...........#.........................#.#.#.#...#.#.......#
#.#.###.#.#####.###.#.#.#.#.#.#.#.#########.#.###.###.#########.#####.#####.#.#.###.###########.###.#.#.#####.#####.###.###.#.#.###.#######.#
#.............#.....#.#.#.#.#.#.#.....#...#...#.....#.#.......#.....#.....#.#...#.#...#...#...#...#...#.....#.#.......#.....................#
#.#.#####.#.#.#######.#.###.#.#.#.###.#.#.#.###.#####.#.#####.#.#########.#.#.###.###.#.###.#.#.#.###.#.#.#.#.###########.#.#.#.#.#.#.###.###
#...#...#...#.#.........#...#.....#...#.#...#.......#.#...#.#.#.......#.#...#.#.....#.#.#...#...#.#...#.#.#.#.#.......#...#.#...#.....#...#.#
#.#.#.#.###.#.#.#########.#####.#.#.###.#.#.#######.#.#.#.#.#.#.###.#.#.#.###.#####.#.#.#.#####.#.#.###.#.#.#.#.#####.#.###.###.#.#####.###.#
#.#...#.....#.#...#.....#...#.......#.....#...#.....#.#...#...#...#.#.....#.........#.#...#.......#.#...#.#.#...#...#.#...#.....#.#.........#
#.#.#######.#.###.#.#.#.###.#.###.###.#####.#.#.###.#.###.#.#######.#####.#.###.#####.#.###.#######.#####.#.#####.#.#.###.#.###.###.#.#.#.#.#
#.#...#.....#...#...#.#...#.....#...#.......#.#...#.#.....#.......#.#...#.#...#.#.....#.#...#.....#.......#.#.....#.#.....#...#.#...#.#.#.#.#
#.#.###.###.#.#.#.#.#.###.#####.#.#.#########.#.#.###############.#.#.#.#####.#.#.#####.#.###.###.#########.#####.#.#########.#.#.###.#.#.#.#
#.....#...#...#.....#...#...#.#.#.#...........#.#...#.....#.......#...#.....#...#.#...#.#.#.....#.........#.....#.#.#.....#...#...#.#...#.#.#
#.###.###.#.#.#.###.###.###.#.#.#.###.#.#######.###.#.#.#.#.#.#.###.#####.#.###.#.#.###.#.#.#######.#.#.#######.#.#.#.###.#.#######.#######.#
#...#.....#.#.#.#.......#.#.#...#...#.#.#.........#...#.....#.#.#.......#.#...#.#.#.#...#...#.....#...#.........#.#.#...#.#.#.....#.......#.#
#.#.#####.#.#.#.#.#####.#.#.#.###.#.###.#.###########.#.###.#.#.#.#####.#.#.#.#.#.#.#.#####.#.###.#.#.#######.#.#.###.###.#.###.#.#.#####.#.#
#.#...#...#.#.#.#.#.......#.#.#...#.#...#.#.....#...#.#.#.....#.........#.#.#...#.#.#.#.....#.#.#...#.........#...#...#...#.....#...#...#...#
#.#.###.###.#.###.#.#.#.###.#.#####.#.###.#####.#.#.###.#.#####.#.#####.#.#.#####.#.#.#.#.###.#.#####.###.#####.###.###.#############.#.#.#.#
#.#.#...#...#.....#.#.#.#...#.#.....#.#.....#...#.#.....#.....#...#...#.#...#...#.#.#.#.#.#...#.....#...#.....#.#...#.#.......#.....#.#...#.#
#.###.###.###.#####.#.###.###.#.###.#.#####.#.###.#####.#########.#.###.#####.#.#.#.#.###.#.###.###.#.#.###.#.#.#.###.#####.###.#.###.#.#.#.#
#.......#.....#.....#...#.#...#...#.#...#.....#...#.....#...#.....#.........#.#...#.#.....#.#...#.#...#.#...#...#.........#.....#.....#.#.#.#
#.#.###.#####.#.#.###.#.#.#.#.###.#####.#.#####.###.#####.#.#.###########.###.#####.###.###.#.###.#####.#.#.#############.#############.#.#.#
#...#...#...#.#.#...#.#...#.....#...#...#.#.#...#...#.....#...#.......#.....#.#.#.......#...#.........#.....#...........#.#...#.......#.....#
#.###.#.#.#.#.#.###.#.###.#####.###.#.###.#.#.###.###.#############.#.#.#.#.#.#.#.#####.#.###########.#####.#.#######.#.#.#.#.#######.###.###
#.#...#.#...#...#...#.........#.....#...#...#.#.....#...#.....#.....#.#...#.#.....#.....#.........#...#...#.#.#.#.....#.#...#.......#.......#
#.#.#.#.#.###.#.#.###########.#####.###.#####.#.#######.#.###.#.#####.#.#.#.#.###.#.###.###.#####.#.###.#.###.#.#.#####.###########.#.#.#.###
#.#.#.#...#...#.#.....#...#.....#.....#...#...#.#...#...#...#...#.#...#.#.#.#...#.#.#.#.......#.#.#.#...#.......#.#.#...#...#.....#.#.#.....#
#.###.#.###.#.#######.###.#.#.#.#.#######.#.###.#.#.#.###.#.###.#.#.###.#.#.#.#.###.#.###.###.#.#.###.###########.#.#.#.#.#.#.#.###.#.###.#.#
#...#.#.#...#.......#...#.#.#...#.#.......#...#.#.#.#.....#.....#.......#.#...#.#...#.#...#.#...#.....#.#.....#...#.#.#...#.#.#.#...#.#...#.#
###.#.###.#########.###.#.#.#.#.#.#.#######.#.###.#.#####.#.###.###.###.#.#.#.#.#.###.#.###.###.#######.#.#.###.###.#.###.#.#.#.#.###.###.#.#
#.#...#...#...#.....#...#...#.#.#.#.#...#...#.....#.....#.#...#...#...#.#.#.#.#...#...#.#...#.#...#...#...#.#...#.....#...#.#.#.#...#.....#.#
#.###.#.#####.#.#####.###.###.#.#.#.#.#.#.###########.#.#.#######.###.#.#.#.#.#####.#.#.#.#.#.###.#.###.###.#.###.#####.###.#.#####.#####.#.#
#.....#.#.....#.#.....#...#...#...#.#.#.#...#.......#.#...#...#...#.#.#.#.#...#...#.#.#.#.#...#...#.......#.#.#.#.......#.................#.#
#.#####.#.#.#.#.###.###.#.#.#######.#.#.###.#.#####.#####.#.#.#.###.#.###.#.#.#.#.#.#.#.#.#####.#####.#####.#.#.#.#########.###.#####.###.#.#
#.#.....#.#.#.#.....#.#...#.#...#...#.#.#...#...#...#...#...#.....#.......#.#.#.#.#.#.#.#...#...#...#.#...#.#.#...#...........#.#.......#...#
#.#.#.#####.#.#.#####.#.###.#.#.#.###.#.#.#####.#.###.#.#####.###.#########.#.#.#.###.#.#.#.#.###.#.#.#.#.#.#.#####.#########.#.#########.###
#.#.#.#...#.#.#.......#.#...#.#.#.....#.#.#.#...#.....#...#.#...#...#.......#...#.#...#.#.#.......#.#.#.....#.#.....#.......#.#.....#...#...#
#.#.###.#.#.###.#####.#.#.###.#.#######.#.#.#.#.#########.#.###.#.#.###.#########.#.#.#.#####.#####.###.#####.#.###########.#.#.###.#.#.#.#.#
#.#.#...#.#.....#...#...#...#.#.#...#...#...#.#.#...#.#...#...#.#.#...#.#.......#...#.#.#...#.#...#.#...#...#...#.........#.#.....#...#...#.#
#.#.#.###.#.#####.#########.#.#.#.#.#.#.###.#.###.#.#.#.#####.#.#####.#.#.#.###.#####.#.#.#.###.#.#.#.###.#.###.#.#.#####.#.###.#.#######.#.#
#...#.#...#...#.......#.....#.#.#.#...#.#...#.....#.#...#.....#.......#.#.#...#.......#...#.....#.#.#.#...#...#.#.#.#.....#...#...#.....#.#.#
#.###.#.#.###.#####.###.#####.#.#.#####.#.#.#######.#.###.#.###########.#.###.#######.#.#########.#.#.#.#####.#.###.#.#######.#.#.###.#.#.#.#
#...#.#.....#.#...#...#.#.....#.#.......#.#.........#.#...#.#.......#...#.#.#...#.....#.......#...#...#.#...#.#.....#.........#.#.....#.#.#.#
#.#.#.#####.#.#.#.###.#.#.#####.#####.#.#.###########.###.###.#.#.#.#.###.#.###.#####.###.#####.#.#####.#.#.#.#########.#.#.###.#.#######.#.#
#.#.#.#...#.#.#.#...#...#.....#...#.#.#.#...#.......#...#.........#.#.#.#.....#.....#...#.#...#.#.#.......#.#...#.....#.#.#...#...........#.#
###.#.#.#.#.#.#.###.#.#######.###.#.#.#####.#.#####.###.#######.#.###.#.#####.#####.###.#.#.#.#.#.#.#.#####.###.#.###.#.#####.#.#########.#.#
#...#.#.........#...#.........#.....#.....#.#.#...#...#.......#.#.....#...........#...#.#.#.#.#.#.#.#...#.#.#...#...#.#...#...#.............#
#.###.#.#.#.#####.#####.###########.#####.#.###.#.#.#########.###.#.#.###########.###.#.###.#.#.###.#.#.#.#.#.#####.#.###.#.###.#.#######.#.#
#.......#.#...#...#.....#...#...#.#.#...#.#.....#.#.#.........#.....#.......#...#.#.#.#.#...#...#...#.#.#...#.#.....#...#.#.#...#.#.....#.#.#
#####.#.###.#.#.###.#.#.#.#.#.#.#.#.###.#.#####.#.#.#.#####.###.###.#######.#.#.#.#.#.#.#.#####.#.###.#.#####.#.#.#######.#.#.#.#.#.###.#.#.#
#...#.#...#.#.#.#...#.#.#.#.#.#.#...#...#.#...#...#.#.#.....#...#.#...#.....#.#.#.#.#.#.#.....#.#...#.#.#.....#.#.........#...#.#.#.#.#.#.#.#
#.#.###.#.###.#.###.#.###.#.#.#.#.###.#.#.#.#.#.###.#.###.#.###.#.###.#####.#.###.#.#.#.###.#.###.###.#.#.#####.#.#########.###.#.#.#.#.#.#.#
#.#.....#...#.#.....#.....#.#.#.#.....#.#.....#...#.......#.#...#...#.....#.#.......#.#.....#.#...#...#...#...#.#.........#.....#...#.#.#...#
#.#########.#.#############.#.#.#############.###.#.#######.#.###.#.#####.#.#######.#.#.###.#.#.###.#######.#.#.#.#######.#####.###.#.#.#.###
#...#.....#...#.....#.......#.#.#.............#.#.#.#...#.....#...#.....#.#.....#...#.#.#...#...#...#.......#.#.#.#...#...#.........#.#.#.#.#
###.#.###.#####.###.#.#.#####.#.#.###########.#.#.###.#.###########.###.#.#####.#####.#.#.###.###.###.###.#####.#.#.#.#.#######.###.#.#.#.#.#
#...#.#.....#.....#.#.........#.#...#.#.....#...#...#.#.#.........#.#...#...#.........#.#.#...#...#.#.#.#.......#.#...........#...#.#.#.#...#
#.###.#.###.#.###.#############.#.#.#.#.###.###.###.#.#.#.#######.#.#######.###########.#.###.#.###.#.#.#########.#.#########.###.#.#.#.#.#.#
#...#.#...#.#.#.#.#...........#.#.#.#.#.#...........#.#...#.....#.#.......#...#...#.....#...#.#.#...#...#.........#.....#...#...#.#...#.#.#.#
#.#.#####.###.#.#.#.###.#####.#.###.#.#.#.###.#.#.###.#####.###.#.#####.#.###.###.#.###.###.#.#.###.###.#.#.#######.###.#.#.###.#.#.#.#.#.#.#
#.#.....#...#...#...#.#...#...#.....#.#.#.#...#.#.....#...#...#.#.....#.#...#.#...#...#...#.#.#...#.#...#.#...#...#...#...#...#.#.....#.#...#
#.#####.#.#.###.#####.#.#.#.#########.#.#.#####.#######.#.#.###.#####.###.#.#.#.#####.###.#.#.###.#.#.#######.#.#####.#######.#.###.#.#.#.###
#.....#.#.#.....#.....#...#.......#.....#.........#.....#...#...#...#...#.#.#.#...#...#...#.#...#.#.#.#.......#.#.....#.....#.#.....#.#.....#
#####.#.#.#######.###.#.###########.#############.#.#######.#.#.#.#.###.#.###.#.#.#.###.###.#####.#.#.#.###.###.#.#####.#.###.#.###.#######.#
#.#...#.#.....#.....#.#...........#.#...#.....#...#...#.....#.#.#.#...#.#.....#.#...#.#.....#.....#.#.#...#...#...#.....#.#.......#.....#...#
#.#.###.#####.#######.###########.#.#.#.#.###.#.#####.#.###.#.###.###.###.#####.#####.#######.#####.#.###.#.#.#.#####.#.#.#.###.###.###.#.###
#...#...#.#...#.........#.........#.#.#.#.#.#.#.#.....#...#.#...#.........#.#...#.......#.....#.....#.#...#.#...#...#...#.#.........#...#...#
#####.###.#.###.#######.#.#######.#.#.###.#.#.#.#.#.###.#.#.###.###.#.###.#.#.###.#######.#.###.###.#.#.#####.#.#.#.#####.#####.###.#.#####.#
#...#.#...#.....#...#...#...#.....#.#...#...#.#.#.....#.#.#.#.#...#.#.#...#.#...#.........#.#.....#.#.#.#...#.....#...#...........#.#.....#.#
#.#.#.#.#.#.#####.#.#.#####.#######.###.###.#.#######.#.#.#.#.###.#.#.#.###.###.###########.#.###.###.#.#.#.#########.#.#######.###.#####.#.#
#.#...#.#.#.....#.#.#.#...#.......#...#...#.#.#.......#...#.#...#...#...#...#.#.............#.#...#...#...#.....#...#.#.....#.....#.....#.#.#
#.#####.#.#.#.###.#.#.###.#######.###.###.#.#.#.#######.###.#.###########.#.#.#################.###.#####.#####.#.###.#####.#.#.#.#.#.#.#.#.#
#.#...#.#.#.#.....#.#.....#.....#.........#.#.#.#.......#.....#.........#.#.....#.........#.........#...#.....#.#...#.......#...#.#.#.#.#.#.#
#.#.#.###.#.#######.#####.###.#.###########.#.#.#.#####.#######.#####.#.#.#######.#######.#.#.###.###.#.#######.#.#.###.#######.#.#.#.###.#.#
#...#.#...#.........#...#...#.#...#...#.....#...#...#...#...#...#.....#.#.#.....#.......#...#.....#...#.........#.#.....#.....#.#.#.#...#...#
#####.#.###.###.#.#.###.###.#.#.#.#.###.#############.###.#.#.###.#####.#.#.###.#######.###########.#####.#.###.#######.#.###.#.#.#.###.###.#
#.....#.#.......#.#...#.#...#.#.#...#...#.#.......#...#...#.#.#.#.........#...#.......#.........#.....#...#.#...#.....#.....#.#.#...#.....#.#
#.#####.#.#.#.###.###.#.#.###.#.###.#.###.#.#.###.#.###.###.#.#.#####.#######.#######.###.#####.###.#.#.###.#.#.#.###.###.#.#.#.###.#.#.#.#.#
#.#.....#.#...#.#...#...#...#.#.#.#.#.......#.#...#...#.#...#...#...#.......#.#.....#.........#.#.....#.....#.#...#.#.......#.#...#.#.#...#.#
#.###.#.#.#####.###.###.###.###.#.#.#.#####.#.#.###.#.#.#.#.###.#.#########.#.#.#.#.#########.#.#.###########.#####.#########.#.###.#.###.#.#
#...#.#.#.#.#.....#.#...#...#...#.#.#.....#.#.....#.#...#.#...#.#.#.......#...#.#.#.........#.#.#.......#.....#.............#...#...#.#.#.#.#
#.#.#.#.#.#.#.###.#.#.###.###.###.#.#####.###.###.#.#####.###.#.#.#.###.#.#####.#.#######.#.#.#.#.#####.#.#########.###########.#.#.#.#.#.#.#
#.#.#.#...#...#...#.#...#.#...#.#...#...#.....#.....#...#...#.#.#.#.#...#.#...........#.#.#.#...#...#.#.#.#.......#.............#.#...#...#.#
#.#.#.#####.###.#.#.###.#.#.###.#.###.#.#######.###.###.###.###.#.#.#.#####.#########.#.#.#.#####.#.#.#.#.#.#####.###########.#.#.#.#####.#.#
#.............#.#.#.#...#...#...#.#...#.#.....#.#.#...#...#.....#.#.#.......#.......#...#.............#...#...#.#.........#...#.#.#.....#.#.#
#.#.#.#.#.#####.#.#.###.#####.###.#.###.###.###.#.###.###.#######.#.#########.#####.#################.#######.#.#########.#.###.#.#.###.#.#.#
#.#.#.#.#.....#...#.................#.....#.#...#.....#.........#...#.....#...#.............#.....#...........#.....#...#.#.#.....#...#.#.#.#
###.#.#.#####.###.#########.#####.#######.#.#.###.#####.#######.###.#.#.###.###############.#.#.#.#.###########.#.###.#.#.#.#.#.###.#.#.#.#.#
#...#...#...#.........#...#.#.....#.....#...#.#.#.....#.......#...#...#.#...#.....#.......#...#...#...#...#.....#.....#.....#.#.....#.#.#.#.#
#.#######.#######.#####.#.###.###.#.###.#####.#.###.#.###.#.#.###.#####.#.#.#.###.#.#.#########.#####.#.#.###.#####.#######.#.#.#.#.#.#.#.#.#
#.....#.#.......#.#.....#.#...#.#.#.#.#.....#.#.#...#.#...#.#...#...#.#.#.....#...#.#.........#...#...#.#...#.#...#.......#.#.#.#.....#.#.#.#
#.###.#.#.#####.#.#.#####.#.###.#.#.#.#####.#.#.#.#.#.#.#.#####.###.#.#.#######.###.#######.#####.#####.###.#.#.#.#######.#.#.#.###.###.###.#
#.#.#.#.#...#.#...#...#.#.#.#...#...#...#...#...#.#...#.#.#...#.....#...#...#...#...#...#...#...#.....#...#.#.#.#.#.....#...#.....#...#...#.#
#.#.#.#.###.#.#######.#.#.#.#.#.#######.#.###.#.#.#.###.###.#.#####.#.#####.#.###.#####.#.###.#.#####.###.#.###.#.#.###.###.###.#.#.#####.#.#
#...#.#.#...#.......#...#...#.#.........#.....#.....#...#...#.....#.#.......#.#.#.....#.#.....#.....#.#...#.....#.#.#...#...#...#.#.#.....#.#
###.#.#.#.###.#.###.###.#############.#############.###.#.#######.#.#########.#.#####.#.###########.#.#.#########.#.#.###.#.#.#.#.###.#####.#
#...#.#...#.#.....#.#...#.#.........#.............#...#...#...#...#...........#.........#...#.....#.#...#...#...#...#.....#.#.#.#...#.......#
#####.#.###.#.###.###.###.#.#.#####.#######.#####.###.#####.#.#.###.###########.#######.###.#.###.#.#####.#.#.###########.#.#.#.###.#.#######
#.....#...#.....#...#.#.#...#.#...#...#.....#.#...#.#.#.....#.#...#.....#.......#...#.#...#.#.#.#.#.......#...#.........#.#.#.#.#...#...#...#
#.#######.#########.#.#.#.###.#.#.###.#.#####.#.###.#.#.#####.###.###.###.#####.#.#.#.###.#.#.#.#.#.###.#######.###.#####.#.###.#.#####.#.#.#
#...#...#...........#.#.#...#...#.......#.....#.#...#...#...#...#...#.#...#...#.#...#.....#.#.#.#.#...#.#...#...#...#.....#.....#.#.#...#.#.#
#.#.#.#.#.#.#########.#.###.###.#########.###.#.#.#######.#.###.###.#.#.###.#.###.#.###.###.#.#.#.###.###.#.#.###.#.#.#########.#.#.#.###.#.#
#.#...#.#.#.........#.#...#...#...#.....#...#.#.#.........#...#.#...#...#...#.....#...#...#.....#...#.#...#.....#.#.#.#.....#.#.#.....#.....#
#.#####.#.#######.#.#.###.###.###.#.###.###.###.#######.#####.#.#.#######.#.#########.###.#####.#.#.#.#.#########.#.#.#.###.#.#.#.#####.###.#
#.....#.#.......#.#.#...#...#...#.....#...#...#.#.......#.....#...#.....#.#.........#...#.....#.#.#.#.....#.......#.#...#...#...#.......#...#
#.#####.#######.#.#.###.###.###.#########.#.#.#.#.#####.#####.#####.###.#.#.###.#######.#.#.#.###.#.#####.#.#######.#####.#######.#######.#.#
#.#.....#.....#.#.#...#...#.....#.........#.#...#.#...#.#...#.#.....#.#...#.#.#.......#.#.........#...#.....#...#...#.#...#.....#.#...#...#.#
###.#######.###.#.###.###.#.#####.#########.#.###.###.#.#.#.#.#.#####.#####.#.#####.#.#.#############.#.#.###.#.#.###.#.###.###.#.#.#.#.###.#
#...............#.#...#...#.....#.#.#.......#.......#...#.#.#.#.#...#.....#.#.....#.#.#...#.........#.#.#.....#.#.#...#...#.#.#.#...#...#...#
#.###.#.#.###.###.#.###.#####.#.#.#.#.#######.#.###.#####.#.#.#.#.#.#.###.#.#.###.#.#####.#.#######.###.#.#.###.#.#.#.###.#.#.#.#####.#######
#.....#.#.....#...#...#.....#.#...#.#.....#...#.#...#.....#.#...#.#.#.#...#.#...#.#.....#.#...#.....#...#.#...#.#.#.#...#...#.#.....#.......#
#.#####.#.###########.#####.#.#####.#####.###.#.#.###.#####.#####.#.#.#.#.#.#.###.###.###.###.#####.#.###.###.###.#.#.#######.#####.#.#####.#
#.#.#...#.........#.....#...#.#.............#.#.#...#.#...#.#.....#...#.#.#.#.#.....#.............#...#.#.#.#...#.#.#.....#.......#.#.......#
#.#.#.#.#########.#.#####.###.#.#.#####.###.#.#.###.#.#.#.#.###########.#.#.###.###.#########.#.#.#####.#.#.###.#.#.###.#.###.#####.#.#####.#
#...#...#...#...#...#.....#...#.#.....#...#.#...#.#.#.#.#.#.......#.....#...#...#.....#.....#.#.#.#...........#...#...#.#...#.....#...#.#...#
#######.#.#.#.#.###.#.#####.#.#######.#.#.#.#.###.#.#.#.#########.#.###.#.###.###.#####.###.###.#.#.#############.#####.###.#.###.###.#.#.###
#.......#.#...#.....#.#...#.#.#.....#.#.#...#.....#.....#.........#.#.#.#.#...#...#.....#.#.....#.#.#.......#...#.......#.#.#...#.#.....#.#.#
#.#####.#.###.#######.#.#.###.#.###.#.#.#.###.###########.#.#######.#.#.#.#.#.#.###.#####.#######.###.#####.#.#.#######.#.#.###.#.#.#.###.#.#
#...................#...#.....#.#.....#.#.#.............#...........#...#.....#...#.............#...#.....#.#.#...#.....#.#.#...#.#.#.#...#.#
#.#.###.###.###.###.#########.#.###.#.###.#####.#######.#.#.#.###.#########.#####.#######.#.#.#.###.#####.#.#.###.###.#.#.#.#.###.#.#.#.###.#
#.....#.#...#...#.#.#.......#.#...#...#...#...#...#...#.#...#...#...........#.....#.#.....#.#.#.#.....#...#.....#.#...#...#.....#...#.#.#...#
#.###.#.#.###.###.#.#.###.#.#.#.#.#.###.###.#.###.#.#.#.###.###########.#.#.#.#####.#.#.###.#.#.#.###.#.#########.#.#########.#.#####.#.#.###
#.#.#.#.....#.....#.............#...#...#...#.....#.#...#...#.........#.#...#.#...#...................#.#.....#...#...........#.#...#.#.#...#
#.#.#.#.#####.#.#.#.###.#.#.#.#.###.#.###.###.#.#####.###.#.#.#######.###.#.#.#.#.#.#.#######.#####.#.#.#####.#.#########.#.#.#.#.#.#.#.#.#.#
#...#.#.....#...#.#.#...............#.#...#...#.#...#.#...#.#.....#.#...#.#.#.#.#.#.#.....#.....#...#...................#.#.#.#.#.#.#.#.#.#.#
###.#.#.###.#####.#.#.###.#.#.###.#.#.#.#.#.#.#.#.#.#.#.###.#####.#.###.#.#.#.#.#.#.#####.#####.#.###########.###.#.###.#.#.#.#.#.#.#.#.###.#
#.#.#...#.....#...#.....#.#.#...#.#...#.#...#.#.#.#.#...#.#...#.............#.............#.....#...#.......#...#.#.#...#.#.......#...#...#.#
#.#.#####.###.#.#########.#.#.#.#.#.#######.#.###.#.#####.#.#.#.###.#.#####.#######.#.#####.#######.#.#.###.###.#.#.#.#.#####.#####.#.###.#.#
#.#...#.......#.....#.#.....#.#.#.#.......#.......#.......................#.........#.#.....#...#...#.#.#.....#.#.#.#.#.#.......#...#.....#.#
#.###.#.###.#######.#.#.#####.#.#.#.#.###.#.#########.#####.#.#.#.#.#####.#.#########.#.#.###.#.#.###.#.###.#.#.#.#.#.###.###.#.#####.#####.#
#.........#.#.....#...#...............#...#.........#.#...#...#.#.#...#.#.....#.....#.#.#.#...#...#...#...#...#.#.#.#...#.....#...#...#.....#
#.#####.#.###.#.#####.###.#.###.###.###.###########.#.#.#.#####.###.#.#.#.#.#.#.###.#.#.#.#.#######.#####.#.###.#.#.#.#.#####.###.#.#######.#
#S......#.....#.........#.....#.........#...........#...#...........#...#...#.....#.....#.#.............#.......#.....#.........#...........#
#############################################################################################################################################
""".trimIndent().split("\n")