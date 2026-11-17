
import kotlin.random.Random

object GenerarDatos {

    // Lista de 40 vehículos diferentes
    val vehiculosOriginales: MutableList<String> = mutableListOf(
        "Toyota", "Ford", "BMW", "Audi", "Mercedes",
        "Seat", "Renault", "Peugeot", "Citroen", "Opel",
        "Volkswagen", "Honda", "Hyundai", "Kia", "Nissan",
        "Mazda", "Volvo", "Fiat", "Jeep", "Tesla",
        "Porsche", "Ferrari", "Lamborghini", "Skoda",
        "Suzuki", "Mitsubishi", "Subaru", "Lexus",
        "Jaguar", "Land Rover", "Mini", "Dacia",
        "Alfa Romeo", "Bentley", "Bugatti", "Chevrolet",
        "Dodge", "Chrysler", "Cadillac", "Maserati"
    )

    // Generador con semilla fija para obtener
    // siempre los mismos números al ejecutar
    private val generador = Random(12345)

    // Lista de 100 números aleatorios sin repetir
    val numerosOriginales: MutableList<Int> =
        mutableListOf<Int>().apply {
            while (size < 100) {
                val numero = generador.nextInt(1, 10001)

                if (!contains(numero)) {
                    add(numero)
                }
            }
        }

    // Devuelve una copia de la lista de vehículos
    fun obtenerVehiculos(): MutableList<String> {
        return vehiculosOriginales.toMutableList()
    }

    // Devuelve una copia de la lista numérica
    fun obtenerNumeros(): MutableList<Int> {
        return numerosOriginales.toMutableList()
    }
}
