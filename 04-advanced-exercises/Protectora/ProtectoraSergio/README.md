# 🐾 Ejercicio: Sistema de Gestión para la Protectora de Animales 

## Enunciado del Problema

La protectora de animales quiere realizar un pequeño programa informático para automatizar parte de su sistema de gestión de la información.

### Requisitos Generales del Sistema

* La protectora acoge animales perdidos o abandonados, proporcionándoles refugio, alimentación y asistencia sanitaria.
* Se consideran dos tipos de animales: **perros** y **gatos**.
* Cada animal tiene un nombre único para identificación en campañas y trámites (apadrinamiento, acogida, adopción).
* De todos los animales se debe conocer: sexo (macho/hembra), edad (en años), si son sociables con las personas, y si están apadrinados.
* **Para perros:** se necesita conocer su raza, tamaño (en kg), si pertenecen a la categoría PPP (Perros Potencialmente Peligrosos) y si necesitan tratamiento para la leishmania.
* **Para gatos:** interesa conocer si están esterilizados.
* Los animales pueden recibir solicitudes de acogida y adopción, con un máximo de 20 solicitudes por animal.
* Cada solicitud incluye un tipo (0-acogida, 1-adopción) y el email de la persona interesada.
* La protectora asume gastos veterinarios, que incluyen tratamientos específicos para perros (leishmania, vacuna de la rabia, sedación para PPP no sociables) y gatos (control del celo para no esterilizadas).
* Si el animal está apadrinado, los gastos veterinarios son asumidos por los padrinos.
* Se realizan campañas de esterilización para gatas, con colaboración de una clínica veterinaria de la que interesa conocer nombre, teléfono y precio de esterilización.
* La alimentación es el mayor gasto; la comida de gatos es donada.
* La comida de perros cachorros (0-18 meses) es donada.
* Para perros adultos, se estima la cantidad de pienso seco diario según el tamaño: pequeños (≤15 kg) 200 gr, medianos (>15 kg y ≤25 kg) 300 gr, grandes (>25 kg) 1.5% de su peso.
* Toda la interacción con el sistema debe ser a través de un menú de opciones.

### Ejercicios a Realizar

1.  **Ejercicio 1:** Realizar la estructura necesaria para implementar la protectora en orientación a objetos en Kotlin.
2.  **Ejercicio 2:** Mostrar toda la información de los animales de la protectora (se proporcionará un fichero SQL con la información).
3.  **Ejercicio 3:** Permitir la realización de una solicitud de adopción o acogida de un animal. Esta solicitud se guardará en un fichero con el nombre del animal.
4.  **Ejercicio 4:** Calcular el coste de los gastos veterinarios previstos anuales que debería asumir la protectora, considerando los animales recogidos al momento de la consulta. Este gasto se guardará en la tabla "gastofecha" de la base de datos.
5.  **Ejercicio 5:** Calcular la estimación de la cantidad de pienso de perro adulto (en kg) para una semana, considerando los animales en la protectora al momento de la consulta. Esta información se guardará en un fichero serializable utilizando una clase `CantidadKg`.

### Observaciones Adicionales

* El programa no distinguirá entre mayúsculas y minúsculas.
* Se debe manejar la validación de entrada para opciones de menú y datos numéricos.
* Se debe controlar que no se registren más de 20 solicitudes por animal.

---