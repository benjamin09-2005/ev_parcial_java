# Proyecto Microservicios - Level Up

## Requisitos
- Java JDK 21
- IntelliJ IDEA
- Maven (incluido en IntelliJ)

## Instalación y ejecución

1. Abrir IntelliJ IDEA.
2. Seleccionar "Get from VCS" o "Clone Repository".
3. Clonar el repositorio:
   https://github.com/xxxxx

4. Una vez abierto el proyecto, ir a:
   File > Project Structure

   Verificar:
   - Project SDK: 21
   - Language Level: 21

5. Esperar a que Maven descargue las dependencias automáticamente.
   (Si no ocurre, presionar "Reload Maven Project")

6. Ejecutar cada microservicio desde su clase principal:
   `DemoApplication.java`

## Puertos de los microservicios

- Usuarios: http://localhost:8081
- Reportes: http://localhost:8082
- Pedidos: http://localhost:8083
- Pagos: http://localhost:8084
- Notificaciones: http://localhost:8085
- Productos/Categorías: http://localhost:8086

## Base de datos (H2)

Cada microservicio utiliza una base de datos en memoria H2.

Acceso desde navegador:
http://localhost:{PUERTO}/h2-console

Ejemplo:
http://localhost:8082/h2-console

Credenciales:
- JDBC URL: jdbc:h2:mem:{nombre_db}
- Usuario: sa
- Password: (vacío)

## Pruebas de endpoints

Se pueden probar con Postman usando método GET:

Ejemplo:
http://localhost:8082/api/reportes

Respuesta esperada:
- 200 OK
- Lista JSON (vacía o con datos)

También se pueden probar operaciones:
- POST (crear)
- PUT (actualizar)
- DELETE (eliminar)

## Notas

- Cada microservicio es independiente y debe ejecutarse por separado.
- Las bases de datos se reinician al detener la aplicación.
