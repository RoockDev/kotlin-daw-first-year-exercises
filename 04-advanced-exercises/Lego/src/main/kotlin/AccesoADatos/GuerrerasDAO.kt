package AccesoADatos

import Negocio.MujerGuerrera

interface GuerrerasDAO {




    fun getAllGuerreras():List<MujerGuerrera>
    fun getRandomGuerreras(cantidad:Int): List<MujerGuerrera>
}

