
object PancakeSort {

    // Función principal para ordenar la lista
    fun <T : Comparable<T>> ordenar(lista: MutableList<T>) {

        // Empezamos trabajando con toda la lista
        var tamaño = lista.size

        while (tamaño > 1) {

            // Buscamos el elemento mayor
            val posicionMayor = buscarMayor(lista, tamaño)

            // Si el mayor no está en su posición correcta
            if (posicionMayor != tamaño - 1) {

                // Llevamos el mayor al principio
                if (posicionMayor != 0) {
                    voltear(lista, posicionMayor)
                }

                // Llevamos el mayor al final
                voltear(lista, tamaño - 1)
            }

            // Reducimos la parte que queda por ordenar
            tamaño--
        }
    }

    // Busca la posición del elemento mayor
    private fun <T : Comparable<T>> buscarMayor(
        lista: MutableList<T>,
        tamaño: Int
    ): Int {

        var posicionMayor = 0

        for (i in 1 until tamaño) {
            if (lista[i].compareTo(lista[posicionMayor]) > 0) {
                posicionMayor = i
            }
        }

        return posicionMayor
    }

    // Invierte los elementos desde el inicio
    // hasta la posición indicada
    private fun <T> voltear(
        lista: MutableList<T>,
        posicion: Int
    ) {

        var inicio = 0
        var fin = posicion

        while (inicio < fin) {

            // Intercambiamos los elementos
            val temporal = lista[inicio]
            lista[inicio] = lista[fin]
            lista[fin] = temporal

            inicio++
            fin--
        }
    }
}
