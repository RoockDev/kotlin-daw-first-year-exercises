enum class DIRECCIONES_EVENTO(val direccion: String) {
    MADRID_GRANVIA("Gran Vía, 45, Madrid"),
    BARCELONA_DIAGONAL("Av. Diagonal, 150, Barcelona"),
    VALENCIA_CENTRO("Plaza del Ayuntamiento, Valencia"),
    SEVILLA_TORRE("Torre Sevilla, Sevilla"),
    BILBAO_GUGGENHEIM("Museo Guggenheim, Bilbao");

    companion object {
        fun obtenerAleatorio(): String {
            return values().random().name
        }
    }
}
