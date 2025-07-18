package Modelo

data class Usuario(var email:String,var nombre:String,var apellidos:String,var edad:String,var password:String,
    var rol:Rol = Rol.ESTANDAR)
