enum class NOMBRES_RANDOM {

    JUAN, MARIA, PEDRO, LUCIA, CARLOS, ANA, MIGUEL, ELENA, DANIEL, SOFIA,
    ALBERTO, PAULA, SERGIO, MARTA, JAVIER, LAURA, RAUL, CLAUDIA, ANDRES, CARMEN;

    companion object {
        fun obtenerAleatorio(): String {
            return values().random().name
        }
    }


}