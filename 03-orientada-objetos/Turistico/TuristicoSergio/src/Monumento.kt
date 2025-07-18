class Monumento : Lugar_Turistico {
    var fechaConstruccion = ""
    var nombreArquitecto = ""
    private var idMonumento = 1

    companion object {

        private var contador = 1
    }

    constructor() {
        idMonumento = contador
        contador++
        nombre = NombreObjetos.MONUMENTO.name + idMonumento

    }

    constructor(nombre: String, precio: Int, valoracion: Int, fechaC: String, nomArquic: String) {
        this.nombre = NombreObjetos.MONUMENTO.name + nombre
        this.precio = precio
        this.valoracion = valoracion
        this.fechaConstruccion = fechaC
        this.nombreArquitecto = nombreArquitecto
        contador++
    }

    constructor(fechaC: String, nomArquic: String) {
        idMonumento = contador
        contador++
        nombre = NombreObjetos.MONUMENTO.name + idMonumento
        this.fechaConstruccion = fechaC
        this.nombreArquitecto = nomArquic

    }

    open override fun calculaMediaCalidad(): Double {
        var mediaLugar = super.calculaMediaCalidad() // llama el metodo de ligar_turistico
        return if (mediaLugar == 0.0) 1.0 else mediaLugar // si retorna 0 devuelve 1
    }

    override fun toString(): String {
        return "Monumento(nombre = ${nombre}, precio= ${precio}, valoracion = ${valoracion}, mediaCalidad=${calculaMediaCalidad()})"
    }


}