# 🧩 Estructura del programa: Monitor de Constantes Vitales
### Modelo de Comunicación clásico: Sensor [Productor (cliente)] – Sensor [Consumidor (servidor)]
    Productores → Cola segura → Consumidores

<hr><br><br><br><br>

# 🧠 Conceptos/Fundamentos técnicos y teóricos aplicados
### Concurrencia y Multitarea
    Thread { ... } / Executors
###### Permite la ejecución simultánea de múltiples tareas (captura de datos y análisis de alertas) sin bloquear la interfaz de usuario o el sistema principal.

<br>

### Sincronización y Estados
    LinkedBlockingQueue<Int>()
###### Esta estructura de datos gestiona la coordinación mediante:
1. Bloqueo Automático. (el Monitor pasa a estado bloqueado si no hay datos, evitando el desperdicio de recursos del sistema y la CPU)
2. Exclusión Mutua. (evita accesos simultáneos peligrosos al recurso compartido, garantizando la seguridad de los datos)
3. Control de Flujo. (gestiona la transición entre los estados de Listo y En ejecución de los hilos de forma eficiente)

<br>

### Seguridad e Integridad
    Métodos put() y take()
###### Al ser una cola "Thread-Safe", protege la información contra:
1. Condición de Carrera (Race Condition). (impide que dos procesos modifiquen o lean el pulso del paciente de forma conflictiva)
2. Corrupción de Datos. (asegura que el mensaje del emisor llegue íntegro al receptor, cumpliendo con los principios de seguridad informática)

<br>

### Comunicación y Distribución (Modelo Cliente-Servidor)
| Parte        | Representa             | Función en el Sistema Salud                                         |
|--------------|------------------------|---------------------------------------------------------------------|
| Productores  | Clientes / Sensores    | Generan el flujo de datos (Constantes vitales).                     |
| Cola         | Canal / Red            | Medio de comunicación Full-Duplex para el transporte de señales.    |
| Consumidores | Servidor / Servicio    | Proceso en segundo plano que monitoriza y dispara alertas.          |
