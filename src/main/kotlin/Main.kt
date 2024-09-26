package ADA1

fun main() {
    val rutaArchivo = "C:/Users/Josue/Desktop/Ejercicio2/src/main/resources/cotizacion.csv"
    val rutaSalida = "C:/Users/Josue/Desktop/Ejercicio2/src/main/resources/salida.csv"

    // Crear instancia de la clase que lee cotizaciones
    val lector = CotizacionesReader(rutaArchivo)
    val cotizaciones = lector.leerCotizaciones()

    // Imprimir las cotizaciones leídas por consola
    println("Cotizaciones leídas del archivo:")
    cotizaciones.forEach { (clave, valores) ->
        println("$clave: ${valores.joinToString(", ")}")
    }

    // Crear instancia de la clase que procesa estadísticas
    val procesador = EstadisticasProcessor()
    val estadisticas = procesador.calcularYGuardarEstadisticas(cotizaciones, rutaSalida)


    println("Estadísticas calculadas y guardadas en $rutaSalida")
}
