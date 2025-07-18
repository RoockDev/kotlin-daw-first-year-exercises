package Negocio

import org.example.Perro
import java.io.Serializable

data class CantidadKG(
    val perrosAdultos: List<Perro>,
    val cantidadTotal: Double
): Serializable{

    override fun toString(): String {
        return super.toString()
    }

}
