
fun main() {

    // Ejecutamos los cinco algoritmos de ordenación
    ejecutarAlgoritmo("QUICKSORT")
    ejecutarAlgoritmo("PANCAKE SORT")
    ejecutarAlgoritmo("MERGESORT")
    ejecutarAlgoritmo("BUBBLE SORT")
    ejecutarAlgoritmo("INSERTION SORT")
}

// Función que ordena una lista y mide el tiempo
fun <T : Comparable<T>> medirOrdenacion(
    nombreLista: String,
    listaOriginal: MutableList<T>,
    ordenar: (MutableList<T>) -> Unit
) {

    // Creamos una copia para no modificar la lista original
    val lista = listaOriginal.toMutableList()

    // Mostramos la lista antes de ordenarla
    println("\nLISTA ORIGINAL DE $nombreLista:")
    println(listaOriginal)

    // Iniciamos la medición del tiempo
    val inicio = System.nanoTime()

    // Ejecutamos el algoritmo de ordenación
    ordenar(lista)

    // Calculamos el tiempo empleado
    val tiempo = System.nanoTime() - inicio

    // Mostramos la lista ordenada
    println("\nLISTA ORDENADA DE $nombreLista:")
    println(lista)

    // Mostramos el tiempo de ejecución
    println("Tiempo: $tiempo ns")

    // Comprobamos que la lista está ordenada
    var correcto = true

    for (i in 0 until lista.size - 1) {
        if (lista[i].compareTo(lista[i + 1]) > 0) {
            correcto = false
            break
        }
    }

    println("Ordenación correcta: $correcto")
}

// Función que ejecuta cada algoritmo
// con las dos listas de datos
fun ejecutarAlgoritmo(nombre: String) {

    println("\n========== $nombre ==========")

    // Seleccionamos el algoritmo para los vehículos
    val ordenarVehiculos: (MutableList<String>) -> Unit =
        when (nombre) {
            "QUICKSORT" -> QuickSort::ordenar
            "PANCAKE SORT" -> PancakeSort::ordenar
            "MERGESORT" -> MergeSort::ordenar
            "BUBBLE SORT" -> BubbleSort::ordenar
            "INSERTION SORT" -> InsertionSort::ordenar
            else -> throw IllegalArgumentException(
                "Algoritmo desconocido: $nombre"
            )
        }

    // Seleccionamos el algoritmo para los números
    val ordenarNumeros: (MutableList<Int>) -> Unit =
        when (nombre) {
            "QUICKSORT" -> QuickSort::ordenar
            "PANCAKE SORT" -> PancakeSort::ordenar
            "MERGESORT" -> MergeSort::ordenar
            "BUBBLE SORT" -> BubbleSort::ordenar
            "INSERTION SORT" -> InsertionSort::ordenar
            else -> throw IllegalArgumentException(
                "Algoritmo desconocido: $nombre"
            )
        }

    // Ordenamos la lista de vehículos
    medirOrdenacion(
        "VEHÍCULOS",
        GenerarDatos.obtenerVehiculos(),
        ordenarVehiculos
    )

    // Ordenamos la lista de números
    medirOrdenacion(
        "NÚMEROS",
        GenerarDatos.obtenerNumeros(),
        ordenarNumeros
    )
}
