package classesAndInheritance

open class Shape {

    open val vertexCount: Int = 0

    val borderColor: String get() = "black"

    open fun draw() {
        println("I am a shape")
    }
}

class Circle : Shape() {
    override fun draw() {
        println("I am a special shape, I am a circle with ${vertexCount} vertex")
    }
    val fillColor: String get() = super.borderColor
}

class Rectangle : Shape() {

    override val vertexCount: Int = 4

    val fillColor: String get() = super.borderColor

    override fun draw() {
        println("I am a special shape, I am a rectangle with ${vertexCount} vertex")
    }
}

class Polygon : Shape() {
    override var vertexCount: Int = 0

    val fillColor: String get() = super.borderColor

    override fun draw() {
        println("I am a special shape, I am a polygon with ${vertexCount} vertex")
    }
}

abstract class AbstractShape: Shape() {
    val fillColor: String get() = super.borderColor
    override abstract fun draw()
}

interface ShapeI {
    fun draw() { // interface members are 'open' by default
        println("I am a shape interface")
    }
}


class Square : Shape(), ShapeI {
    // The compiler requires draw() to be overridden:
    override fun draw() {
        super<Shape>.draw() // call to Shape.draw()
        super<ShapeI>.draw() // call to ShapeI.draw()
    }
}

open class Base(val name: String) {

    init { println("Initializing Base") }

    open val size: Int =
        name.length.also { println("Initializing size in Base: $it") }
}

class Derived(
    name: String,
    val lastName: String
) : Base(name.capitalize().also { println("Argument for Base: $it") }) {

    init { println("Initializing Derived") }

    override val size: Int =
        (super.size + lastName.length).also { println("Initializing size in Derived: $it") }
}




fun main() {
    Shape().draw()
    Circle().draw()
    Rectangle().draw()
    Polygon().draw()
    Square().draw()
    Derived("hello","world")
}
