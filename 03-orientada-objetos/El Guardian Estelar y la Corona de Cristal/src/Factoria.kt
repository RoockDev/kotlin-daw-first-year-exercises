class Factoria {
    companion object {
        fun crearCristalBasico(): Cristal {
            var cristalBasico = Cristal()
            var coloresBasicos = listOf(ColoresCristales.AZUL, ColoresCristales.VERDE, ColoresCristales.ROJO)
            cristalBasico.color = coloresBasicos.random()
            return cristalBasico
        }

        fun crearCristalPurpura(): Cristal {
            var cristalPurpura = Cristal(color = ColoresCristales.PURPURA)
            return cristalPurpura
        }

        fun crearCorona(): CoronaCristal {
            return CoronaCristal()
        }

        fun crearGuardianEstelar(): GuardianEstelar {
            return GuardianEstelar()
        }

        fun criaturaVoladora(): CriaturaVoladora {
            return CriaturaVoladora()
        }

        fun tronoEspecial(): TronoEspacial {
            return TronoEspacial()
        }

        fun crearUnAdversario(): Adversario {
            return Adversario()
        }
    }
}