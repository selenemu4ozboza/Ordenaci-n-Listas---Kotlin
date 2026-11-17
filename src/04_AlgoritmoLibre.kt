
object BubbleSort {

    // Función principal para ordenar la lista
    fun <T : Comparable<T>> ordenar(lista: MutableList<T>) {

        val tamaño = lista.size

        // Recorremos la lista varias veces
        for (i in 0 until tamaño - 1) {

            var intercambio = false

            // Comparamos los elementos consecutivos
            for (j in 0 until tamaño - i - 1) {

                // Si están desordenados, los intercambiamos
                if (lista[j].compareTo(lista[j + 1]) > 0) {

                    val temporal = lista[j]
                    lista[j] = lista[j + 1]
                    lista[j + 1] = temporal

                    intercambio = true
                }
            }

            // Si no hubo intercambios, ya está ordenada
            if (!intercambio) {
                break
            }
        }
    }
}
