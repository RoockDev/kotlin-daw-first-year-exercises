class Factoria {
    companion object {
        fun devuelveUnaRuta(): RutasTuristicas {
            var ruta = RutasTuristicas()
            var lugarIntroducido = (Constantes.MINIMOLUGARES..Constantes.MAXIMOLUGARES).random()
            when (lugarIntroducido) {
                1 -> ruta.agregarLugar(Museo())
                2 -> ruta.agregarLugar(Parque())
                3 -> ruta.agregarLugar(Monumento())
            }
            return ruta
        }

        fun devuelveGuiaConUnaRuta(): Guia {
            var guia = Guia()
            guia.agregarRuta(devuelveUnaRuta())
            return guia
        }

        fun devuelveGuiaConVariasRutas(): Guia {
            var guia = Guia()
            for (i in Constantes.RUTAMINIMAS..Constantes.RUTASMAXIMAS) {
                guia.agregarRuta(devuelveUnaRuta())
            }
            return guia
        }
    }
}