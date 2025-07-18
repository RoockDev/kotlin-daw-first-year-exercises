enum class FECHAS_EVENTO(val fecha: String) {
    ENERO("10-01-2025"),
    FEBRERO("15-02-2025"),
    MARZO("20-03-2025"),
    ABRIL("25-04-2025"),
    MAYO("30-05-2025");

    companion object {
        fun obtenerAleatorio(): String {
            return values().random().name
        }
    }
}
