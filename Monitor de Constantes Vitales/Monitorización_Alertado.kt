// "Monitorización_Alertado.kt" 
    /**
     * Programa escrito en el lenguaje de programación Kotlin que simula un sistema de monitorización y alertado para la gestión de incidencias. El programa utiliza conceptos de concurrencia para permitir que múltiples productores (clientes) generen incidencias y múltiples consumidores (servidores) procesen esas incidencias de manera simultánea.
     * A continuación, se explican las partes principales del código:
     *    1. Recibir datos de un sensor (Frecuencia cardíaca).
     *    2. Analizar datos para detectar anomalías.
     *    3. Mostrar interfaz al personal sanitario sin "congelarse".
     */



// Importa de la biblioteca/librería "util.concurrent" el paquete "LinkedBlockingQueue". Para hacer uso de una implementación de cola bloqueante basada en una lista enlazada, que permite almacenar elementos de manera segura entre hilos de ejecución (threads). Además de ser útil para la comunicación entre productores y consumidores.
import java.util.concurrent.LinkedBlockingQueue

/**
 * Declara una variable inmutable "colaConstantes" de tipo "LinkedBlockingQueue<Int>" y la inicializa con una instancia de "LinkedBlockingQueue()".
 *     Esta variable se utiliza para almacenar constantes enteras de manera segura entre hilos de ejecución (threads). Recurso compartido seguro (Thread-Safe).
 */
val colaConstantes = LinkedBlockingQueue<Int>()

/**
 * Define la función/método principal ("main()") del programa.
 *    Es el punto de entrada del programa, donde se ejecutará el código para gestionar las incidencias.
 */
fun main(){
    // ========== TAREA 1 ==========
        /**
         * Simulación de Sensor (Productor)
         * 
         * 1. Se define un hilo llamado "hiloSensor" que se encargará de simular la captura de datos de un sensor de frecuencia cardíaca.
         *    2. Este hilo se ejecutará de manera continua (bucle condicional de tipo "while"), generando datos de pulso cardíaco aleatorios (usando la función "random"), dentro de un rango específico (50 a 150 bpm) y enviándolos a la cola "colaConstantes" para su posterior análisis por parte del monitor de alertas.
         *        3. El hilo utilizará el método "put()" para insertar esos datos en la cola, lo que permitirá una espera coordinada y bloqueante hasta que haya espacio disponible en la cola para insertar nuevos datos. Además, se simula un tiempo de espera de dos segundos (2s o 2000 ms) entre cada captura de datos para representar el tiempo que tarda el sensor en capturar y enviar los datos.
         */
    val hiloSensor = Thread {
        while (true) {
            /**
             * Utiliza el método "put()".
             * Declara una variable inmutable "pulso" y le asigna a un valor aleatorio generado por la función "random" dentro de un rango comprendido entre 50 y 150 (ambos incluidos).
             * 
             * Este método bloquea el hilo si la cola está vacía. Realiza una espera coordinada para recibir el "dato" de la cola (bloqueante), espera hasta que haya un dato disponible para ser procesado. En este caso, el "dato" representa el pulso cardíaco capturado por el sensor, que se analizará para detectar posibles anomalías en el ritmo cardíaco del paciente. Este "dato" representa el pulso cardíaco capturado por el sensor.
             */
            val pulso = (50..150).random()

            colaConstantes.put(pulso)   // Envía dato a la cola.

            // Imprime un mensaje por pantalla indicando que el sensor ha capturado el pulso del paciente, mostrando el valor de este en bpm (latidos por minuto).
            println("Sensor: Pulso del paciente capturado ($pulso bpm).")

            // Forzamos la espera de dos segundos (2s o 2000ms) para simular el tiempo que tarda el sensor en capturar y enviar los datos.
            Thread.sleep(2000)
        }
    }

    // ========== TAREA 2 ==========
        /**
         * Simulación de Monitor de Alertas (Consumidor)
         * 
         * 1. Se define un hilo llamado "hiloAlerta" que se encargará de analizar los datos capturados por el sensor para detectar posibles anomalías en el ritmo cardíaco del paciente.
         *    2. Este hilo se ejecutará de manera continua (bucle condicional de tipo "while"), esperando datos en la cola "colaConstantes" y procesándolos para determinar si el ritmo cardíaco del paciente es anormal o estable.
         *        3. El hilo utilizará el método "take()" para extraer esos datos de la cola, lo que permitirá una espera coordinada y bloqueante hasta que haya datos disponibles para ser procesados.
         */
    val hiloAlerta = Thread {
        while (true) {
            /**
             * Utiliza el método "take()".
             * Declara una variable inmutable "dato" y la asigna al resultado de "colaConstantes.take()".
             * 
             * Este método bloquea el hilo si la cola está vacía. Realiza una espera coordinada para recibir el "dato" de la cola (bloqueante), espera hasta que haya un dato disponible para ser procesado. En este caso, el "dato" representa el pulso cardíaco capturado por el sensor, que se analizará para detectar posibles anomalías en el ritmo cardíaco del paciente. Este "dato" representa el pulso cardíaco capturado por el sensor.
             */
            val dato = colaConstantes.take()
            
            if (dato > 100) {
                // Imprime un mensaje por pantalla indicando que se ha detectado una anomalía en el ritmo cardíaco del paciente. Muestra el valor del pulso capturado. En este caso, se considera que un pulso superior a 100 bpm indica taquicardia o anomalías en el pulso cardíaco.
                println("¡ALERTA!: Ritmo cardíaco del paciente anormal. Taquicardia detectada ($dato bpm).")
            } else 
                // Imprime un mensaje por pantalla indicando que el estado del paciente es estable. Muestra el valor del pulso capturado.
                println("Monitor: Estado del paciente estable.")
        }
    }

    // Inicia las tareas de forma coordinada.
        /**
         * Utiliza el método "start()".
         * 
         * El método "start" se llama en ambos hilos ("hiloSensor" y "hiloAlerta") para iniciar su ejecución. Esto hace que ambos hilos pasen a estado "Listo" y luego a "En ejecución", permitiendo que el sensor capture datos y el monitor de alertas procese esos datos de manera simultánea.
         *    1. "hiloSensor.start()": Inicia el hilo del sensor, que comenzará a capturar datos de pulso y enviarlos a la cola.
         *    2. "hiloAlerta.start()": Inicia el hilo del monitor de alertas, que comenzará a esperar datos en la cola y a procesarlos para detectar posibles anomalías en el pulso cardíaco.
         */
    hiloSensor.start()
    hiloAlerta.start()
}