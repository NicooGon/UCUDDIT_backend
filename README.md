\# Intrucciones

\## Tener instalado:

- PostgreSQL versión 17
- pgAdmin 4 v8.12 (o cualquier gestor de base de datos de preferencias)
- Tener un Script en la base de datos llamado "ucuddit"
- IntelliJ IDEA: Versión 2024.2.3
- Git, para clonar el repositorio que contiene el código fuente del proyecto


\## Pasos para la instalación:

- Clonar el proyecto usando git clone <URL del repositorio>

\### Configuración y ejecución del backend:

- En postgres tener la base de datos creada con el nombre "ucuddit" y haber ejecutado el script
- Ejecuta el backend desde IntelliJ IDEA y déjalo funcionando en segundo plano para que la aplicación móvil pueda conectarse a él. Las entidades en la base de datos se crearan automaticamente al ejecutar el backend.

\## Arquitectura:

- APIs REST:  
  Son el punto de entrada del backend. Se encargan de recibir las solicitudes HTTP del cliente (como `GET`, `POST`, `PUT` o `DELETE`) y devolver las respuestas correspondientes.
  
- Controller:  
  Esta capa gestiona las solicitudes entrantes a través de las APIs. Valida los datos proporcionados y delega las tareas necesarias a los servicios correspondientes.

- Service:  
  Aquí se encuentra la lógica principal del sistema. Los servicios implementan las reglas de negocio y coordinan las acciones necesarias entre los controladores y los repositorios.

- IService:  
  Las interfaces de servicio definen los contratos que deben cumplir las clases de servicios. Esto permite un código más desacoplado y facilita la implementación de cambios o pruebas.

- Repository:  
  Es la capa que interactúa directamente con la base de datos. Realiza las operaciones CRUD (Crear, Leer, Actualizar, Eliminar) necesarias para manipular los datos.

- DTO (Data Transfer Object):  
  Los DTO son objetos diseñados para transferir datos entre las capas del sistema. Ayudan a estructurar la información de manera clara y limitan la exposición innecesaria de detalles internos.

- Mapper:  
  Esta capa convierte las entidades de la base de datos en DTOs y viceversa. Garantiza que cada capa reciba los datos en el formato adecuado, manteniendo una separación lógica entre la base de datos y el resto del sistema.


