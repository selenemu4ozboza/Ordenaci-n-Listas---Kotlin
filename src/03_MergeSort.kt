
object MergeSort {

    // Función principal que inicia la ordenación
    fun <T : Comparable<T>> ordenar(lista: MutableList<T>) {

        if (lista.size > 1) {
            mergeSort(lista, 0, lista.size - 1)
        }
    }

    // Divide la lista en dos partes
    private fun <T : Comparable<T>> mergeSort(
        lista: MutableList<T>,
        inicio: Int,
        fin: Int
    ) {

        if (inicio < fin) {

            // Calculamos la posición central
            val medio = inicio + (fin - inicio) / 2

            // Ordenamos la mitad izquierda
            mergeSort(lista, inicio, medio)

            // Ordenamos la mitad derecha
            mergeSort(lista, medio + 1, fin)

            // Unimos las dos mitades ordenadas
            mezclar(lista, inicio, medio, fin)
        }
    }

    // Mezcla dos partes de la lista en orden
    private fun <T : Comparable<T>> mezclar(
        lista: MutableList<T>,
        inicio: Int,
        medio: Int,
        fin: Int
    ) {

        // Creamos copias de ambas mitades
        val izquierda = lista.subList(inicio, medio + 1).toList()
        val derecha = lista.subList(medio + 1, fin + 1).toList()

        var i = 0
        var j = 0
        var k = inicio

        // Comparamos los elementos de ambas mitades
        while (i < izquierda.size && j < derecha.size) {

            if (izquierda[i].compareTo(derecha[j]) <= 0) {
                lista[k] = izquierda[i]
                i++
            } else {
                lista[k] = derecha[j]
                j++
            }

            k++
        }

        // Copiamos los elementos restantes
        while (i < izquierda.size) {
            lista[k] = izquierda[i]
            i++
            k++
        }

        while (j < derecha.size) {
            lista[k] = derecha[j]
            j++
            k++
        }
    }
}
