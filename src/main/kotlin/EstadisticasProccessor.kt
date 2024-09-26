package ADA1

import java.io.File

class EstadisticasProcessor {

    fun calcularYGuardarEstadisticas(cotizaciones: Map<String, List<String>>, rutaSalida: String) {
        val salida = File(rutaSalida).bufferedWriter()

        // Escribir encabezados
        salida.write("Columna;Mínimo;Máximo;Media\n")

        // Procesar cada columna en el diccionario
        for ((columna, valores) in cotizaciones) {
            // Convertir los valores a números si es posible
            val numeros = valores.mapNotNull { it.toDoubleOrNull() }

            if (numeros.isNotEmpty()) {
                val minimo = numeros.minOrNull()
                val maximo = numeros.maxOrNull()
                val media = numeros.average()

                // Escribir cada fila en el CSV
                salida.write("$columna;$minimo;$maximo;$media\n")
            }
        }

        salida.close()
    }
}