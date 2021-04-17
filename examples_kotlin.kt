#1.1.

data class Person(val name: String,
                 val age: Int? = null)

fun main(){
    val persons = listOf(Person("Alice"),
    					Person("Bob", age = 29))

    val oldest = persons.maxByOrNull {it.age ?: 0}
    println("The oldest is: $oldest")
}
==============================================

fun findAlice() = findPerson { it.name == "Alice" }
fun findBob() = findPerson { it.name == "Bob" }

==============================================

fun renderPersonList(persons: Collection<Person>) =
  createHTML().table {
    for (person in persons) {
      tr {
        td { +person.name}
        td { +person.age}
      }
    }
  }

==============================================

object CountryTable : IdTable() {
  val name = varchar("name", 250).uniqueIndex()
  val iso = varchar ("iso", 2).uniqueIndex()
}

class Country(id: EntityID) : Entity(id) {
  var name: String Ьу CountryTable.name
  var iso: String Ьу CountryTable.iso
}

val russia = Country.find {
  CountryTable.iso.eq("ru")
}.first()

println(russia.name)

==============================================

verticalLayout {
  val name = editText()
  button("Say Hello") {
      onClick { toast("Hello, ${name.text}!")}
    }
}

==============================================

В простейшем случае скомпилировать код из
командной строки можно с помощью командbl kotlinc, а запустить - ко­мандой java:

kotlinc <исходнblй файл или каталог> -include-runtime -d <имя jаr-файла>
java -jar <имя jаr-файла>

==============================================
#2.1.
fun main() {
    println("Hello, world!")
}

==============================================

fun main(){
    fun max(a: Int, b: Int): Int {
	return if (a > b) a else b
	}
    println(max(1, 2))
}
----------------------
fun main(){
    fun max(a: Int, b: Int): Int = if (a > b) a else b

    println(max(13, 2))
}
----------------------
fun main(){
    fun max(a: Int, b: Int) = if (a > b) a else b

    println(max(13, 27))
}

==============================================
val question = "The Ultimate Question of Life, the Universe, and Everything."
val answer = 42
val answer: Int = 42
==============================================
val message: String
if (canPerformOperation()) {
message = "Success"
// ... вblполнить операцию
}
else {
message = "Failed"
}
==============================================
val languages = arrayListOf("Java")
languages.add("Kotlin")
==============================================
#2.2.
fun main(args: Array<String>) {
	val name = if (args.size > 0) args[0] else "Kotlin"
  println("Hello, $name!")
}
==============================================
fun main(args: Array<String>) {
	if (args.size > 0) {
		println("Hello, ${args[0]}!")
	}
}
==============================================
fun main(args: Array<String>) {
println("Hello, ${if (args.size > 0) args[0] else "someone"}!")
}
==============================================
#2.3.
/* Java */
public class Person {
  private final String name;

  public Person(String name) {
    this.name = name;
  }
  public String getName() {
    return name;
  }
}
----------------------
#2.4.
fun main(args: Array<String>) {
	class Person(val name: String)
}
==============================================
#2.5.
#2.7.
class Person(
    val name: String,
    var isMarried: Boolean
)

fun main(args: Array<String>) {
    val person = Person("Bob", true)
    println(person.name)
    println(person.isMarried)
}
==============================================
package ch02.ex2_2_CustomAccessors

class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() {
            return height == width
        }
}

fun main(args: Array<String>) {
    val rectangle = Rectangle(41, 43)
    println(rectangle.isSquare)
}
==============================================
package geometry.shapes

import java.util.Random

class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() = height == width
}

fun createRandomRectangle(): Rectangle {
    val random = Random()
    return Rectangle(random.nextInt(), random.nextInt())
}
==============================================
package geometry.example

import geometry.shapes.createRandomRectangle

fun main(args: Array<String>) {
    println(createRandomRectangle().isSquare)
}
==============================================
package ch02.colors

enum class Color {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}
==============================================
package ch02.ex3_1_DeclaringEnumClasses

enum class Color(
        val r: Int, val g: Int, val b: Int
) {
    RED(255, 0, 0), ORANGE(255, 165, 0),
    YELLOW(255, 255, 0), GREEN(0, 255, 0), BLUE(0, 0, 255),
    INDIGO(75, 0, 130), VIOLET(238, 130, 238);

    fun rgb() = (r * 256 + g) * 256 + b
}

fun main(args: Array<String>) {
    println(Color.BLUE.rgb())
}
==============================================
package ch02.ex3_2_1_WhenEnums

enum class Color {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}

fun getMnemonic(color: Color) =
    when (color) {
        Color.RED -> "Richard"
        Color.ORANGE -> "Of"
        Color.YELLOW -> "York"
        Color.GREEN -> "Gave"
        Color.BLUE -> "Battle"
        Color.INDIGO -> "In"
        Color.VIOLET -> "Vain"
    }

fun main(args: Array<String>) {
    println(getMnemonic(Color.BLUE))
}
==============================================
package ch02.GetWarmth

enum class Color {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}

fun getWarmth(color: Color) = when(color) {
    Color.RED, Color.ORANGE, Color.YELLOW -> "warm"
    Color.GREEN -> "neutral"
    Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold"
}

fun main(args: Array<String>) {
    println(getWarmth(Color.ORANGE))
}
==============================================
package ch02.ex3_2_3_WhenEnums2

import ch02.colors.Color
import ch02.colors.Color.*

fun getWarmth(color: Color) = when(color) {
    RED, ORANGE, YELLOW -> "warm"
    GREEN -> "neutral"
    BLUE, INDIGO, VIOLET -> "cold"
}

fun main(args: Array<String>) {
    println(getWarmth(Color.ORANGE))
}
==============================================
package ch02.ex3_3_UsingWhenWithArbitraryObjects

import ch02.colors.Color
import ch02.colors.Color.*

fun mix(c1: Color, c2: Color) =
        when (setOf(c1, c2)) {
            setOf(RED, YELLOW) -> ORANGE
            setOf(YELLOW, BLUE) -> GREEN
            setOf(BLUE, VIOLET) -> INDIGO
            else -> throw Exception("Dirty color")
        }

fun main(args: Array<String>) {
    println(mix(BLUE, YELLOW))
}
==============================================
enum class Color {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}

fun mix(c1: Color, c2: Color) =
        when (setOf(c1, c2)) {
            setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
            setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
            setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO
            else -> throw Exception("Dirty color")
        }

fun main() {
    println(mix(Color.BLUE, Color.YELLOW))
}
==============================================
package ch02.ex3_4_WhenWithoutArument

import ch02.colors.Color
import ch02.colors.Color.*

fun mixOptimized(c1: Color, c2: Color) =
    when {
        (c1 == RED && c2 == YELLOW) ||
        (c1 == YELLOW && c2 == RED) ->
            ORANGE

        (c1 == YELLOW && c2 == BLUE) ||
        (c1 == BLUE && c2 == YELLOW) ->
            GREEN

        (c1 == BLUE && c2 == VIOLET) ||
        (c1 == VIOLET && c2 == BLUE) ->
            INDIGO

        else -> throw Exception("Dirty color")
    }

fun main(args: Array<String>) {
    println(mixOptimized(BLUE, YELLOW))
}
==============================================
==============================================
==============================================
==============================================
==============================================
==============================================
==============================================
==============================================
==============================================
==============================================
