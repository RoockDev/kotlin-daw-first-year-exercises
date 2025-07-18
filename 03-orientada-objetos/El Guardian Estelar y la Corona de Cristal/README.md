# 🌟 Ejercicio: El Guardián Estelar y la Corona de Cristal

## Enunciado del Problema

"El Guardián Estelar y la Corona de Cristal" es una historia creada en 1994 sobre un héroe galáctico que protege el equilibrio del cosmos.La trama sigue al Guardián Estelar en su lucha contra un grupo de temibles adversarios que desean controlar el poder de los cristales cósmicos.

"La Corona de Cristal, con su poder supremo, domina a los seis cristales sombríos." 

Se quiere realizar un videojuego basado en esta historia, y nosotros somos los encargados de su desarrollo.

Para la simulación, se han definido Entidades, las cuales pueden ser de varios tipos: personaje principal, personaje secundario, criatura alienígena, artefacto, estructura, decorado o fondo. Las Entidades son todos los elementos que aparecen en las ilustraciones de la historia y que se han seleccionado para formar parte del escenario del juego. Un grupo de desarrolladores ha analizado la historia y ha decidido qué Entidades aparecerán en el juego. Por ejemplo, las Entidades podrían ser un cristal, el Guardián Estelar, una criatura voladora o un trono espacial. Todas las Entidades cuentan con un método `representarse`, que muestra en pantalla su tipo. Por defecto, las Entidades son de tipo personaje secundario.

El juego consiste en que el Guardián Estelar debe enfrentarse a los adversarios que buscan la Corona de Cristal. Los cristales básicos tienen un color (solamente rojo, azul, verde y púrpura) y un número de orden correlativo.El primer cristal creado tendrá el número 1, el segundo el número 2, y así sucesivamente. Si un adversario encuentra un cristal púrpura, se convierte en un Maestro de Cristales y lo guarda celosamente.Los adversarios tienden a almacenar todos sus cristales juntos.

La Corona de Cristal es el origen de todos los cristales (excepto de sí misma) y su número de orden es siempre el 1. Tiene la capacidad de localizar "x" (todos) los cristales púrpura y los "y" primeros cristales básicos. En el juego, solo existe una única Corona de Cristal.

Los cristales púrpura tienen una energía que oscila entre 1 y 50, generada aleatoriamente al crearse. Solo pueden existir "x" ($x=6$) cristales púrpura en el juego.Si ya se han creado los seis y se intenta generar otro, simplemente no se produce y en su lugar se genera un cristal básico.

El Guardián Estelar es el personaje principal. Cada vez que se enfrenta a un Maestro de Cristales, genera una energía aleatoria entre 1 y 50.Registra todas las energías que ha generado.

El juego continuará mientras que el Guardián Estelar siga con vida (tiene una resistencia de 500) o hasta que haya conseguido los seis cristales púrpuras.

En cada ciclo del juego, pueden aparecer entre uno y tres nuevos adversarios (hasta un máximo de 100 en total), cuya misión es recolectar cristales. Cada vez que un adversario encuentra un cristal, lo guarda, con un límite de "x" ($x=5$) cristales. Los adversarios tienen un 65% de probabilidades de encontrar un cristal y, entre estos, hay un 2% de probabilidad de que sea un cristal púrpura.Si un adversario encuentra un cristal púrpura, evoluciona y se convierte en un Maestro de Cristales.

En cada ciclo, el Guardián Estelar revisa aleatoriamente al menos al 50% de los adversarios existentes. Si se encuentra con un Maestro de Cristales, luchan; si el Guardián gana, le arrebata el cristal y el Maestro de Cristales vuelve a ser un adversario normal. Si pierde, su resistencia disminuye en función de la energía del cristal púrpura.Con el resto de los adversarios no interactúa directamente, solo se muestran en pantalla con un mensaje indicando los cristales que han reunido.

---