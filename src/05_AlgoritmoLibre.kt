
object InsertionSort {

    // Función principal para ordenar la lista
    fun <T : Comparable<T>> ordenar(lista: MutableList<T>) {

        // Empezamos desde el segundo elemento
        for (i in 1 until lista.size) {

            // Guardamos el elemento que vamos a colocar
            val actual = lista[i]

            // Posición del elemento anterior
            var j = i - 1

            // Desplazamos los elementos mayores
            // una posición hacia la derecha
            while (j >= 0 && lista[j].compareTo(actual) > 0) {

                lista[j + 1] = lista[j]
                j--
            }

            // Insertamos el elemento en su posición
            lista[j + 1] = actual
        }
    }
}
