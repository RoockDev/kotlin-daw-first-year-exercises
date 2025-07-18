package Negocio

class MaquinaObjetoPeligroso: MaquinaGenerica {

    var historialCajaDeObjetoPeligroso = ArrayList<Caja>()

    constructor()

    override fun agregarCajas(cajas: List<Caja>) {
        super.agregarCajas(cajas)
    }



    override fun agregarCaja(caja: Caja): Int { //Devuelve 0 si rechaza y 1 si acepta
        var cajaProcesada = 1

        if(caja.tieneObjetoPeligroso()){
            historialCajaDeObjetoPeligroso.add(caja)
            historialDeCajasTransportadas.add(caja)
        }else{
            historialDeCajasTransportadas.add(caja)
        }

        return cajaProcesada
    }


}