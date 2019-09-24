package classesAndInheritance


class Student1 constructor(firstName: String, lastName: String, age: Short, email: String)

// If the primary constructor does not have any annotations or visibility modifiers, the constructor keyword can be omitted:
class Student2(firstName: String, lastName: String, age: Short, email: String)

// Use initializer blocks to initialize an instance
class Student3(firstName: String, lastName: String, age: Short, email: String) {
    init {
        val name = lastName.toUpperCase()
        println("instance of Student3: { firstName: $firstName , lastName: $name , age: $age , email: $email }");
    }

}

// Concise syntax for declaring properties and initializing them from the primary constructor
class Student4(val firstName: String, val lastName: String, val age: Short, val email: String) // read-only (val)
class Student5(var firstName: String, var lastName: String, var age: Short, var email: String) // mutable (var)

// secondary constructor
class Department1 {
    var students: MutableList<Student4> = mutableListOf<Student4>()
    constructor(student: Student4) {
        students.add(student)
    }
}

//delegation of secondary constructor
class Department2(val name: String) {
    var students: MutableList<Student4> = mutableListOf<Student4>()
    constructor(name: String, student: Student4) : this(name){
        students.add(student)
    }
}




fun main() {
    val student1 = Student1("Mohammed", "lekmiti", 27, "lekmiti1992@gmail.com")
    val student2 = Student2("Mohammed", "lekmiti", 27, "lekmiti1992@gmail.com")
    val student3 = Student3("Mohammed", "lekmiti", 27, "lekmiti1992@gmail.com")
    val student4 = Student4("Mohammed", "lekmiti", 27, "lekmiti1992@gmail.com")
    val student5 = Student5("Mohammed", "lekmiti", 27, "lekmiti1992@gmail.com")
    val department1 = Department1(student4)
    val department2 = Department2("departement2", student4)
  }