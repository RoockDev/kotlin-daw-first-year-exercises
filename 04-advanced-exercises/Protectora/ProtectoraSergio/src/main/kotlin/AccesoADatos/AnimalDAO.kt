package AccesoADatos

import org.example.Animal

interface AnimalDAO {
    fun getAllAnimales(): List<Animal>
}