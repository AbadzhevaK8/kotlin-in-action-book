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

==============================================

==============================================

==============================================
