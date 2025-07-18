package DAO

import Modelo.Estadistica

interface EstadisticaDAO {

    fun actualizaGanado(userMail:String):Boolean
    fun actualizaPerdido(userMail: String):Boolean
    fun insertarEstadisticas(userMail: String,partidas:Int,ganadas:Int):Boolean
    fun getEstadisticaByMail(userMail: String):Estadistica?
}