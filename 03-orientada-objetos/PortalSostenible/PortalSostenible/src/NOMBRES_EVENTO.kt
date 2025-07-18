enum class NOMBRES_EVENTO {
    CONFERENCIA_TECH,
    WORKSHOP_IA,
    SEMINARIO_CIBERSEGURIDAD,
    CURSO_DESARROLLO_WEB,
    CHARLA_BIG_DATA;

    companion object {
        fun obtenerAleatorio(): String {
            return values().random().name
        }
    }


}