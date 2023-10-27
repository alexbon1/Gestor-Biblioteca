# Biblioteca Virtual - README

## Objetivo del Programa
Este programa es una Biblioteca Virtual que permite gestionar préstamos de libros y buscar libros en una biblioteca. Su objetivo es proporcionar a los usuarios una herramienta para administrar préstamos de libros y buscar información sobre libros disponibles en la biblioteca.

## Clases Explicadas
### BusquedaLibros
La clase `BusquedaLibros` es una ventana de la aplicación que permite a los usuarios buscar información sobre libros en la biblioteca. Los principales componentes y métodos incluyen:

- **Búsqueda de Libros:** Los usuarios pueden ingresar un término de búsqueda y realizar consultas para encontrar libros en la biblioteca.
- **Tabla de Resultados:** Los resultados de búsqueda se muestran en una tabla que incluye información sobre los libros, como título, autor y disponibilidad.
- **Botón de Prestamos:** Un botón que permite a los usuarios cambiar a la ventana de "Prestamos" para gestionar préstamos de libros.

### Prestamos
La clase `Prestamos` es otra ventana de la aplicación que permite a los usuarios gestionar préstamos de libros. Los componentes y métodos más destacados incluyen:

- **Agregar Préstamo:** Los usuarios pueden agregar un préstamo proporcionando información sobre el usuario, el libro y la fecha de entrega. El programa valida los datos antes de agregar el préstamo a la lista.
- **Buscar Préstamos:** Los usuarios pueden buscar préstamos existentes utilizando un campo de búsqueda.
- **Devolver Préstamos:** Los usuarios pueden marcar préstamos como devueltos y eliminar las entradas correspondientes.
- **Cargar/Guardar Préstamos:** Los préstamos se almacenan en un archivo para mantener un registro y se cargan al iniciar la aplicación.

## Método Principal
La clase `Principal` contiene el método principal `main`, que inicia la aplicación. Además, proporciona métodos para cambiar entre las ventanas de "BusquedaLibros" y "Prestamos", lo que permite a los usuarios alternar entre las funcionalidades de búsqueda y préstamo de libros.

## Uso de la Aplicación
- Al iniciar la aplicación, se muestra la ventana de "BusquedaLibros", donde los usuarios pueden buscar información sobre libros en la biblioteca.
- Desde la ventana de "BusquedaLibros", los usuarios pueden cambiar a la ventana de "Prestamos" para gestionar préstamos de libros.
- Desde la ventana de "Prestamos", los usuarios pueden agregar préstamos, buscar y devolver préstamos, y ver una lista de préstamos existentes.

## Requisitos
Este programa se ha desarrollado en Java y utiliza la biblioteca Swing para la interfaz de usuario. Para ejecutar la aplicación, asegúrate de tener una máquina virtual de Java (JVM) instalada.

## Contribuciones
Si deseas contribuir a este proyecto, ¡te damos la bienvenida! Siéntete libre de realizar sugerencias, correcciones o mejoras y enviar tus contribuciones a través de solicitudes de extracción.

---

¡Disfruta de la Biblioteca Virtual y del proceso de gestión de libros y préstamos! Si tienes alguna pregunta o necesitas ayuda, no dudes en ponerte en contacto con el equipo de desarrollo.
