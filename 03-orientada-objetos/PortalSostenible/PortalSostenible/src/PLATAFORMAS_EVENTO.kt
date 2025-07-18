enum class PLATAFORMAS_EVENTO {
    ZOOM,
    GOOGLE_MEET,
    MICROSOFT_TEAMS,
    SKYPE,
    DISCORD;

    companion object {
        fun obtenerAleatorio(): String {
            return values().random().name
        }
    }
}
