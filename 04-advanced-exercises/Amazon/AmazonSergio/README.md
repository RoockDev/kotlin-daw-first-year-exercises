# 📦🚚 Ejercicio: Simulación de Planta Logística

## Enunciado del Problema

La empresa busca mejorar su zona de logística y ha encargado el desarrollo de un simulador de su planta logística. Este ejercicio se basa en una clase `Caja` preexistente (del ejercicio anterior, si aplica), a la cual se le pueden añadir atributos o métodos adicionales según sea necesario.

### Componentes de la Simulación:

#### 1. Máquinas de Transporte

Existen tres tipos de máquinas de transporte:

* **Máquina Genérica de Transporte de Cajas (MGC):**
    * Tienen un **identificador**.
    * Registran su **grado de utilización**: de 0% (no utilizada) a 100% (utilizada todos los 25 días laborables del mes).
    * Cada vez que se usa en un día, se anota. Puede proporcionar su grado de utilización en cualquier momento.
    * Llevan un **historial** de todas las cajas transportadas, que puede ser exportado a un **fichero de texto** bajo demanda, conteniendo la información de las cajas transportadas.

* **Máquinas de Cajas Grandes (MCG):**
    * Heredan las características de las Máquinas Genéricas.
    * Pueden trabajar hasta **28 días al mes**.
    * Mantienen un histórico de las cajas transportadas.
    * Al recibir una caja, verifican su **peso**:
        * Si el peso es **superior a 100**, la aceptan para transporte.
        * Si el peso es **igual o inferior a 100**, la rechazan mecánicamente (deben devolver un cero al comprobar el peso para activar el desecho).

* **Máquinas de Objetos Peligrosos (MOP):**
    * También son Máquinas Genéricas.
    * Admiten **cualquier tipo de caja**, pero tienen un manejo especial para cajas con objetos peligrosos.
    * Si una caja contiene **objetos peligrosos**, la guarda en su historial específico de "cajas de objetos peligrosos".
    * Además, estas cajas con objetos peligrosos se guardan en un **fichero serializable** llamado `"Fichero Peligroso"` para su posterior recuperación.

#### 2. Objetos en las Cajas

* Los **objetos** que se cargan en las cajas se obtienen de una **base de datos**.
* Durante la simulación, debe ser posible **modificar los valores de los objetos**, aunque la clave del objeto no es modificable.
* Se requiere una **interfaz gráfica** para permitir esta modificación en la simulación.

#### 3. Funcionalidades Adicionales

* **Generación de Ficheros de Historial:**
    * La simulación debe permitir **generar los ficheros de texto** con el historial de las máquinas genéricas.
    * Antes de la creación, se preguntará el **nombre del fichero**.
    * Se podrá **seleccionar la máquina** de la que se desea generar el historial.
    * Esta funcionalidad solo se probará para las **máquinas MCG** y solo funcionará después de haber realizado la primera simulación. (Las MCG no se guardan en base de datos; la elección de cómo mantener su estado es del desarrollador).

### Simulación Central 

La propuesta básica de Amazon para la simulación es la siguiente:

* Se simulará un **mes de trabajo de 28 días**.
* Para la simulación, se crearán:
    * **Dos máquinas MCG**.
    * **Una máquina Genérica**.
    * **Una máquina MOP**.
    * Estas máquinas serán creadas mediante una **factoría de máquinas**, que asegure su correcta instanciación.
* **Simulación por días:**
    * Cada día, se creará un conjunto aleatorio de **entre 1 y 3 cajas** mediante una **factoría de creación de cajas**.
    * Estas cajas estarán cargadas con sus respectivos **objetos**. Se pide poder crear los objetos a través de otra **factoría de objetos** (recordando que los objetos provienen de la base de datos y pueden ser modificados).
    * Todas las cajas creadas se simularán como si fueran **cargadas en todas las máquinas** existentes, y cada máquina realizará sus operaciones correspondientes (desechar, guardar en historial, serializar, etc.). Esta parte de la simulación debe ser implementada con el **código más eficiente posible**.
* La simulación se lanzará desde una **interfaz gráfica** mediante un botón.

#### Interfaz Gráfica

* La interfaz debe incluir una pantalla para **visualizar los objetos peligrosos** que se han guardado en el archivo `"Fichero Peligroso"`. Amazon desea ver estos objetos peligrosos en una tabla de usuario.

#### Salida por Consola

Durante la simulación, se escribirá por la consola de IntelliJ la siguiente información:

* Si una caja es **desechada por peso** por una MCG.
* Si una caja contiene **productos peligrosos** y es detectada por una MOP.
* Las **características de la caja** que se va a utilizar para la simulación.

---
