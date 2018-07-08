fun counts(word: String): MutableMap<Char, Int> {
    return word.toLowerCase().toCharArray().fold(mutableMapOf()) { acc, c ->
        if (acc.contains(c)) {
            acc[c] = acc[c]!! + 1
        } else {
            acc[c] = 1
        }
        acc
    }
}

fun main(args: Array<String>) {
    val list = listOf("Tokyo", "London", "Rome", "Donlon", "Kyoto", "Paris")
    val set: MutableSet<String> = mutableSetOf()
    println(list.foldIndexed(mutableListOf<MutableList<String>>()) { index, acc, word ->
        if (!set.contains(word)) {
            val l = list.foldIndexed(mutableListOf<String>()) { index1, acc1, word1 ->
                if (index != index1) {
                    if (counts(word) == counts(word1)) {
                        acc1.add(word)
                        acc1.add(word1)
                        set.add(word1)
                    }
                }
                acc1
            }
            if (l.isEmpty()) {
                acc.add(mutableListOf(word))
            } else {
                acc.add(l)
            }
        }
        acc
    })
}