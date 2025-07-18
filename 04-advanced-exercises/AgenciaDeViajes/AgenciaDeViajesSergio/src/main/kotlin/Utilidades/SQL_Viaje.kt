package Utilidades

object SQL_Viaje {
    val getView="SELECT usuario.nombre,destinos.nombre,fecha_viaje,pagado FROM viaje JOIN destinos ON id_destino = destinos.id  JOIN usuario ON id_usuario=usuario.id ORDER BY fecha_viaje;"
}