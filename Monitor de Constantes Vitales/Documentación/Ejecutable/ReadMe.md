# 📋 Archivo de ejecución: 
Guión de Comandos para Ejecutar Directamente el Programa

<hr><br><br><br>

### Compilar el programa
###### Transforma el código fuente (.kt) en un archivo ejecutable (.jar) que contiene el bytecode de la JVM.
```bash
kotlinc Monitorización_Alertado.kt -include-runtime -d Monitorización_Alertado.jar
```

<br>

### Ejecutar el programa
###### Inicia la instancia del proceso en la máquina virtual, activando el paradigma multihilo.
```bash
java -jar Monitorización_Alertado.jar
```

<br>

### Alternativa: Ejecutar directamente
```bash
kotlinc -script Monitorización_Alertado.kt
```

<br>

### Estructura de comandos VS Code (Powershell)
###### Pasos secuenciales para evitar errores de reconocimiento de términos en la terminal:
1. Limpiar: ```cls```
2. Compilar: ```kotlinc Incidencia.kt -include-runtime -d Incidencia.jar```
3. Lanzar: ```java -jar Incidencia.jar```

<br>

### Requisitos Previos/Mínimos del Entorno
#### Software y Variables de Sistema Requerido
- **Kotlin Compiler (kotlinc)**: Debe estar configurado en el PATH del sistema.
- **JDK (Java Development Kit)**: Versión 11 o superior para dar soporte al entorno de ejecución.
- **Terminal**: Powershell o CMD integrado en VS Code.

#### Verificación de Estados del Sistema
###### Antes de la ejecución, asegurar que los servicios están listos:
1. Descargar e instalar [Kotlin](https://kotlinlang.org/docs/command-line.html)
2. Descargar e instalar [JDK](https://www.oracle.com/java/technologies/downloads/)
3. Verificar instalación:
```bash
kotlinc -version
java -version
```

<br>

### Argumentación del Proceso de Ejecución
###### Este guion no solo lanza el código, sino que gestiona el ciclo de vida de la aplicación conforme a los fundamentos de la materia:
1. Creación. (el compilador genera el proceso padre)
2. Ejecución. [la JVM asigna los hilos (Threads) a los núcleos de la CPU (Paralelismo Real)]
3. Sincronización. [el uso de la terminal garantiza que los flujos de entrada/salida (E/S) se muestren de forma coherente y cronológica]

<br>

### Navegación/Ubicación del proyecto
```bash
cd c:\Users\YourUserName\Downloads\Monitor de Constantes Vitales
```
