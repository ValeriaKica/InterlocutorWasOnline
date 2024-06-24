fun main() {
    val seconds = 18000
    val timeAgo = getTimeAgo(seconds)
    println(timeAgo)
}

fun getMinuteForm(minutes: Int): String {
    return when {
        minutes % 10 == 1 && minutes != 11 -> "минуту"
        minutes % 10 in 2..4 && (minutes < 10 || minutes > 20) -> "минуты"
        else -> "минут"
    }
}

fun getHoursFrom(hours: Int): String {
    return when {
        hours % 10 == 1 && hours != 11 -> "час"
        hours % 10 in 2..4 && (hours < 10 || hours > 20) -> "часа"
        else -> "часов"
    }
}

fun getTimeAgo(seconds: Int): String {
    return when {
        seconds in 0..60 -> "был(а) только что"
        seconds in 61 until 60 * 60 -> {
            val minutes = seconds / 60
            "был(а) $minutes ${getMinuteForm(minutes)} назад"
        }

        seconds in 60 * 60 + 1 until 24 * 60 * 60 -> {
            val hours = seconds / (60 * 60)
            "был(а) $hours ${getHoursFrom(hours)} назад"
        }

        seconds in 24 * 60 * 60 until 2 * 24 * 60 * 60 -> "был(а) вчера"
        seconds in 2 * 24 * 60 * 60 until 3 * 24 * 60 * 60 -> "был(а) позавчера"
        else -> "был(а) давно"
    }
}