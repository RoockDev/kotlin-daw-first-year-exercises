# 🧱🎮 Ejercicio: Videojuego de Temática LEGO - Simulación de Seres Vivos

## Enunciado del Problema

La empresa planea lanzar una temática de piezas completamente nueva. Para probar su potencial, el equipo de marketing propone un videojuego. Si el juego tiene éxito, se procederá a la fabricación masiva de las piezas.

El juego simula un mundo con diferentes tipos de seres vivos, sus interacciones y la resolución de tareas.

### Componentes del Mundo y sus Características:

#### 1. Seres Vivos (Base)

* **Características Básicas:**
    * **Esperanza de vida:** Máximo 120 años.
    * **Nombre:** Identificador del ser vivo.
* **Funcionalidades:**
    * **Estado de Vida:** Deben ser capaces de analizar y comunicar si están:
        * **Muy Vivos:** Si les quedan más de 20 años hasta su esperanza de vida.
        * **Al Borde de la Muerte:** Si les quedan 5 años o menos hasta su esperanza de vida.
        * **Muertos:** Si ya han superado su edad máxima.
    * **Información:** Un método que devuelva un mensaje con todos sus parámetros.

#### 2. Mujeres

* **Heredan de Seres Vivos.**
* **Características Adicionales:**
    * **Edad.**
    * **Índice de Inteligencia.**
* **Funcionalidades:**
    * **Análisis de Tareas:** Al recibir una tarea, analizan si es adecuada para su edad y si tienen la inteligencia necesaria para realizarla. Siempre comunican si son capaces o no.

#### 3. Mujeres Guerreras

* **Heredan de Mujeres.**
* **Características Adicionales:**
    * **Fuerza.**
    * **Utensilios:** Pueden llevar y almacenar utensilios como hacha, cuchillo, pistola, fuego.
* **Funcionalidades:**
    * **Resolución de Tareas:** Además de los análisis de mujer, si la tarea es de fuerza, solo pueden superarla si tienen fuerza suficiente.
    * **Incapacidad para tareas no de fuerza:** Si la tarea NO es de fuerza, nunca podrán superarla.
    * **Integración con animales:** Si una guerrera tiene animales, la fuerza de estos animales se suma a su propia fuerza para resolver tareas.

#### 4. Mujeres Sanadoras

* **Heredan de Mujeres.**
* **Funcionalidades:**
    * Pueden hacerse cargo de **cualquier ser vivo**.
    * Pueden **aumentar la esperanza de vida** del ser vivo tratado en un año por cada tratamiento.
    * Son **incapaces de resolver tareas de fuerza**.

#### 5. Animales

* **Heredan de Seres Vivos.**
* **Características Adicionales:**
    * **Fuerza.**
    * **Estado de Pertenencia:** Puede ser **libre** o pertenecer a una **mujer guerrera**.
* **Funcionalidades:**
    * No pueden resolver tareas.
    * Se puede consultar a una mujer guerrera para saber si tiene animales.
    * Se puede consultar al animal para saber si es libre, pero **nunca podrá saber a qué guerrera pertenece** consultándolo directamente a él.

### Propuesta de Juego de Marketing 

La simulación del juego es la siguiente:

1.  **Tablero de Juego:**
    * Al construir una instancia del tablero, este será el encargado de crear **dos equipos**.
    * Cada equipo tendrá **X mujeres guerreras**.
    * El tablero será el encargado de ejecutar todos los métodos del juego.

2.  **Creación de Mujeres Guerreras:**
    * Sus características se obtendrán de una **base de datos**.
    * La función para extraer las guerreras de la base de datos debe estar **generalizada** para especificar cuántas guerreras sacar.

3.  **Retos:**
    * Los retos se crearán a partir de una **factoría de construcción de retos** (esta factoría se proporciona).
    * La factoría devolverá los **X retos necesarios**.

4.  **Resolución de Retos:**
    * El tablero comprobará si los guerreros de cada equipo son capaces de resolver el reto que les corresponde.
    * Al primer guerrero de cada equipo le corresponde el primer reto, y así sucesivamente.
    * Si el guerrero es capaz de resolver el reto, se **guardará** el resultado. Si no lo resuelve, no se realiza ninguna acción.

5.  **Programa Principal:**
    * Jugará **Y veces** al juego.
    * Al finalizar las Y jugadas, guardará la información de los **ganadores en un fichero**.
    * Posteriormente, leerá esa información del fichero y la **escribirá por consola**.

6.  **Control de Parámetros X e Y:**
    * En el programa principal, la clase **`Dado`** decidirá el valor de **X** (número de mujeres guerreras por equipo/retos) e **Y** (número de veces que se juega) antes de que el juego comience.

---