
object QuickSort {

    // Función que inicia la ordenación
    fun <T : Comparable<T>> ordenar(lista: MutableList<T>) {
        if (lista.size > 1) {
            quickSort(lista, 0, lista.size - 1)
        }
    }

    // Divide la lista en partes más pequeñas
    private fun <T : Comparable<T>> quickSort(
        lista: MutableList<T>,
        inicio: Int,
        fin: Int
    ) {
        if (inicio < fin) {

            // Buscamos la posición correcta del pivote
            val pivote = particionar(lista, inicio, fin)

            // Ordenamos los elementos de la izquierda
            quickSort(lista, inicio, pivote - 1)

            // Ordenamos los elementos de la derecha
            quickSort(lista, pivote + 1, fin)
        }
    }

    // Coloca los elementos menores a la izquierda
    // y los mayores a la derecha del pivote
    private fun <T : Comparable<T>> particionar(
        lista: MutableList<T>,
        inicio: Int,
        fin: Int
    ): Int {

        // Elegimos el último elemento como pivote
        val pivote = lista[fin]
        var i = inicio - 1

        for (j in inicio until fin) {

            if (lista[j].compareTo(pivote) <= 0) {
                i++

                // Intercambiamos los elementos
                val temporal = lista[i]
                lista[i] = lista[j]
                lista[j] = temporal
            }
        }

        // Colocamos el pivote en su posición
        val temporal = lista[i + 1]
        lista[i + 1] = lista[fin]
        lista[fin] = temporal

        return i + 1
    }
}
