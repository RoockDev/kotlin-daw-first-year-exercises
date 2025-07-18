class Factoria {
    companion object {

        fun crearCivilizacionAleatoria(): Civilizacion {
            return Civilizacion()
        }

        fun crearCivilizacionEspagnola(): Civilizacion {
            return Civilizacion(Civilizaciones.ESPANOLA)
        }

        fun crearCivilizacionBizantina(): Civilizacion {
            return Civilizacion(Civilizaciones.BIZANTINA)
        }

        fun crearAldeanoAlatorio(): Aldeano {
            return Aldeano()
        }

        fun crearAldeanoEspagnol(): Aldeano {
            return Aldeano(Factoria.crearCivilizacionEspagnola())
        }

        fun crearAldeanoBizantino(): Aldeano {
            return Aldeano(Factoria.crearCivilizacionBizantina())
        }

        fun crearMina(): Mina {
            return Mina()
        }
    }
}