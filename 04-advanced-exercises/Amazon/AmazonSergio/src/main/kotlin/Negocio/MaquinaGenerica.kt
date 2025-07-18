package Negocio

import AccesoADatos.HistorialCajasDAOImpleFichero

open class MaquinaGenerica {

    var identificador = 0
    var diasUtilizados = 0
    var gradoDeUtilizacion = 0.0
    var historialDeCajasTransportadas = ArrayList<Caja>()
    var cajasMaquina = ArrayList<Caja>()


    companion object{
        var contadorMaquinas = 0
        var ficheroDAO = HistorialCajasDAOImpleFichero()
    }

    init{
        contadorMaquinas++
        identificador = contadorMaquinas
    }

    open fun registrarUsoDiario(){
        diasUtilizados++
    }

    open fun agregarCajas(cajas: List<Caja>){
        for (i in cajas){
            historialDeCajasTransportadas.add(i)
            cajasMaquina.add(i)
        }
    }

    open fun agregarCaja(caja: Caja): Int { //siempre Acepta Cajas
        historialDeCajasTransportadas.add(caja)
        cajasMaquina.add(caja)

        return 1
    }

   open fun obtenerGradoUtilizacion(): Double{
        return (diasUtilizados/ CONSTANTES.TOTAL_DIAS_LABORABLES_GENERICA.toDouble()) * 100
    }

    open fun obtenerFicheroHistorialCajas(nombreFichero: String){
        try {
            ficheroDAO.GuardarFicheroHistorialCajas(nombreFichero,historialDeCajasTransportadas)
        }catch (e: Exception){}



    }

    //metodo para aagregar objetos de la bbdd a las cajas
    open fun agregarObjetos(objetos: List<Objeto>){
        for(i in cajasMaquina){
            if (i.objetosActuales.isEmpty()){
                i.addObjetos(objetos)
            }
        }
    }
}