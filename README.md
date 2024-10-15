# javaCRUD

## Descripción
Un proyecto de Java para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) con una base de datos MySQL. Este proyecto sigue una estructura de capas para la organización del código y está diseñado para ser una aplicación de consola.

## Estructura del Proyecto
La estructura del proyecto es la siguiente:

- `main`: Contiene la clase principal para iniciar la aplicación.
- `model`: Define las clases que representan las entidades de la base de datos.
- `repository`: Contiene las clases para interactuar con la base de datos.
- `util`: Herramientas y utilidades que apoyan la funcionalidad del proyecto.
- `view`: Lógica para mostrar la información en consola.
- `resources`: Archivos de configuración y otros recursos.
- `test`: Pruebas unitarias.

## Tecnologías Utilizadas
- Java 8+
- MySQL
- Maven
- [Apache Commons DBCP2](https://commons.apache.org/proper/commons-dbcp/)
- [Dotenv para Java](https://github.com/cdimascio/java-dotenv)

## Instalación
1. Clona el repositorio:
   ```bash
   git clone https://github.com/dromerof/javaCRUD.git

2. Instalar dependencias y compilar el proyecto:
   ```bash
   mvn clean install

3. Configura las variables de entorno necesarias para la conexión con la API:
   - Renombra el archivo `.example.env` a `.env`.
   - Abre el archivo .env y agrega tus credenciales de la API y la URL base:
   ```bash
    DB_URL=jdbc:mysql://localhost:3306/nombre_de_tu_base_de_datos
    DB_USER=tu_usuario
    DB_PASSWORD=tu_contraseña
   
4. Inicia la aplicación ejecutando la clase `Main` para empezar a utilizar.

# Licencia
Este proyecto está bajo la licencia MIT.




