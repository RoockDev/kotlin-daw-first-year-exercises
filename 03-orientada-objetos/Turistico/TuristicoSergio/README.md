# 🌍 Ejercicio: Simulación de Empresa Turística

## Enunciado del Problema

Una empresa nos pide una aplicación genérica para intentar venderla a las ciudades turísticas.

La aplicación tendrá lugares turísticos. Estos lugares suelen tener un nombre, un precio de la entrada (de 0 a 100 €), además pueden ser de varios tipos turístico (por ejemplo, "museo", "parque", "monumento", etc.) y también tienen una valoración (del 0 al 10).

De los lugares turísticos se puede querer saber la media de calidad, que se calcula dividiendo el precio por la valoración. Si se produce una excepción se devolverá 0.

Los museos tienen una temática (por ejemplo, "arte", "historia", "ciencia", etc.), tienen el número de salas del museo, los parques tienen el número de atracciones y el número de juegos. Los monumentos tienen fecha de construcción, el nombre del arquitecto. La media de calidad en monumentos es distinta, en lugar de retornar un 0 devuelve un 1 al producirse una excepción. En parque se calcula la media, dividiendo las atracciones por el precio y en museo el precio por el número de salas. Si se produce un error en estas dos se devuelve 0.

Se pueden crear rutas turísticas, las cuales pueden tener un número indeterminado de lugares turísticos que se decidirán al crear la ruta. Las rutas tienen un nombre que se les dará al crear la ruta. De las rutas turísticas se debe saber en todo momento cuántas rutas se han creado y también se debe saber si ya están terminadas. Una ruta turística está terminada cuando tiene todos sus lugares turísticos.

De las rutas turísticas se puede consultar en todo momento el precio medio de sus sitios turísticos. Se calculará en tiempo de ejecución, no se almacena.

De los guías se debe saber en todo momento si ya tiene todas sus rutas. Se decidirá las rutas que va a tener en el momento de la creación.

Para el programa principal se pide una simulación para la creación de la infraestructura para una cantidad de guías `n` (en nuestro caso `n=2`).

Los datos para crear todo lo necesario se crearán de forma automatizada y genérica (Ejemplo para los monumentos, el nombre, MON1, MON2, MON7, ...).

La salida por pantalla, será el guía con sus rutas turísticas y estas con sus lugares turísticos y sus datos.

---