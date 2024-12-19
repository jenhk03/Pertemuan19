interface Vehicle
{
    fun accelerate()
    fun stop()
}

enum class Direction
{
    LEFT, RIGHT
}

interface DirectionVehicle
{
    fun accelerate()
    fun stop()
    fun turn(direction: Direction)
    fun description(): String
}

interface OptionalDirectionVehicle
{
    fun turn(direction: Direction = Direction.LEFT)
}

interface SpaceVehicle
{
    fun accelerate()
    fun stop()
    {
        println("Whoa, slow down!")
    }
}

interface VehicleProperties
{
    val weight: Int
    val name: String
        get() = "Vehicle"
}

interface WheelVehicle
{
    val numberOfWheels: Int
    var wheelSize: Double
    fun accelerate()
    fun stop()
}

fun main()
{
    class Unicycle: Vehicle
    {
        var peddling = false
        override fun accelerate()
        {
            peddling = true
        }
        override fun stop()
        {
            peddling = false
        }
    }
    class OptionalDirection: OptionalDirectionVehicle
    {
        override fun turn(direction: Direction)
        {
            println(direction)
        }
    }
    val car = OptionalDirection()
    car.turn()
    car.turn(Direction.RIGHT)
    class LightFreighter: SpaceVehicle
    {
        override fun accelerate()
        {
            println("Proceed to hyperspace!")
        }
    }
    val falcon = LightFreighter()
    falcon.accelerate()
    falcon.stop()
    class Starship: SpaceVehicle
    {
        override fun accelerate()
        {
            println("Wrap factor 9 please!")
        }
        override fun stop()
        {
            super.stop()
            println("That kind of hurt!")
        }
    }
    val enterprise = Starship()
    enterprise.accelerate()
    enterprise.stop()
    class Car: VehicleProperties
    {
        override val weight: Int = 1000
    }
    class Tank: VehicleProperties
    {
        override val weight: Int
            get() = 10000
        override val name: String
            get() = "Tank"
    }
    class Bike: WheelVehicle
    {
        var peddling = false
        var brakeApplied = false
        override val numberOfWheels: Int = 2
        override var wheelSize: Double = 622.0
        override fun accelerate()
        {
            peddling = true
            brakeApplied = false
        }
        override fun stop()
        {
            peddling = false
            brakeApplied = true
        }
    }
}