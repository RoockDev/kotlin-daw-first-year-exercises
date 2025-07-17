fun main() {
    println("Determinar el precio de un billete de tren, conociendo la distancia a recorrer y sabiendo\n" +
            "que si el número de días de estancia es superior a 7 y la distancia superior a 800\n" +
            "km el billete tiene una reducción del 30%. El precio por km es de 2,5 €.\n")

    var precioBillete = 0.0
    var precioKilometro = 2.5
    println("Buenos dias, me podria decir cuantos dias va a estar fuera?")
    var estancia = readln().toInt()
    println("De acuerdo, ahora necesito que me diga la distancia en KM")
    var distancia = readln().toDouble()
    precioBillete = distancia * precioKilometro

    if (estancia < 7 && distancia < 800 ){
        println("De acuerdo, serán $precioBillete euros, disfrute de su viaje!!!")
    } else if (estancia > 7 && distancia > 800){
        precioBillete = precioBillete -(precioBillete * 0.3)
        println("De acuerdo, serán $precioBillete euros, Buen viaje!!!!")

    }else{
        println("Debe de decidirse")
    }





}