🪙 Conversor de Monedas - Challenge Alura Latam
Este proyecto es un Conversor de Monedas desarrollado como parte del programa Oracle Next Education (ONE). Es una aplicación de consola escrita en Java que permite realizar conversiones de divisas de manera rápida y sencilla, obteniendo los datos en tiempo real a través de una API externa.

📝 Descripción
El objetivo principal de este desafío fue poner en práctica conceptos fundamentales de programación:

Consumo de servicios web (APIs).

Manipulación de datos en formato JSON.

Programación Orientada a Objetos (POO) en Java.

Gestión de archivos y persistencia de datos.

🚀 Funcionalidades
El programa ofrece un menú interactivo con las siguientes opciones de conversión:

Dólar (USD) a Peso Argentino (ARS)

Peso Argentino (ARS) a Dólar (USD)

Dólar (USD) a Real Brasileño (BRL)

Real Brasileño (BRL) a Dólar (USD)

Dólar (USD) a Peso Colombiano (COP)

Peso Colombiano (COP) a Dólar (USD)

Al elegir la opción 7 (Salir), el sistema genera automáticamente un archivo llamado consultas.json que contiene el historial de todas las conversiones realizadas durante la sesión.

🛠️ Tecnologías y Librerías
Java 17+: Lenguaje base del proyecto.

Gson (Google): Utilizada para la conversión de objetos Java a formato JSON y viceversa.

HttpClient: Para realizar las peticiones GET a la API de tasas de cambio.

ExchangeRate-API: Fuente de datos para las tasas de cambio actualizadas.

Maven: Gestor de dependencias del proyecto.

📂 Estructura del Proyecto
El código está organizado en paquetes para facilitar su mantenimiento:

com.alura.conversor.modelos: Contiene el Record Moneda, encargado de recibir los datos estructurados de la API.

com.alura.conversor.consultas: Incluye la lógica de conexión (ConsultaMoneda) y la lógica de guardado de archivos (GeneradorDeArchivo).

com.alura.conversor.principal: Contiene la clase Principal, donde se ejecuta el menú y la lógica de interacción con el usuario.

💻 Instalación y Uso
Clonar el repositorio.

Abrir el proyecto en un IDE (recomendado IntelliJ IDEA).

Importar las dependencias de Maven desde el archivo pom.xml.

Ejecutar la clase Principal.java.

Ingresar la opción deseada y el monto a convertir.

Proyecto desarrollado para el Challenge de Alura Latam / ONE.
