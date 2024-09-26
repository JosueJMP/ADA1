package ADA1

import java.io.File

class CotizacionesReader(private val rutaArchivo: String) {

    fun leerCotizaciones(): Map<String, List<String>> {
        val archivo = File(rutaArchivo)

        // Verificar si el archivo existe
        if (!archivo.exists()) {
            throw IllegalArgumentException("El archivo en la ruta proporcionada no existe: $rutaArchivo")
        }

        // Continuar con la lectura del archivo si existe
        val mapaColumnas = mutableMapOf<String, MutableList<String>>()
        val lineas = archivo.readLines()

        if (lineas.isNotEmpty()) {
            val encabezados = lineas.first().split(";")
            encabezados.forEach { mapaColumnas[it] = mutableListOf() }

            lineas.drop(1).forEach { linea ->
                val valores = linea.split(";")
                for (i in valores.indices) {
                    mapaColumnas[encabezados[i]]?.add(valores[i])
                }
            }
        }

        return mapaColumnas
    }
}