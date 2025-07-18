enum class Adversarios_Nombres {

    JOKER,
    LEX_LUTHOR,
    THANOS,
    DARTH_VADER,
    GREEN_GOBLIN,
    VENOM,
    ULTRON,
    RED_SKULL,
    DOCTOR_OCTOPUS,
    LOKI,
    MAGNETO,
    KINGPIN,
    DOOMSDAY,
    RAAS_AL_GHUL,
    SCARECROW,
    BANE,
    BLACK_ADAM,
    DARKSEID,
    HADES,
    MEGATRON,
    SHREDDER,
    SKELETOR,
    FREEZER,
    CELL,
    MAJIN_BUU,
    BLACK_MANTA,
    REVERSE_FLASH,
    SOLOMON_GRUNDY,
    APOCALYPSE,
    KRONOS;

    companion object {
        fun obtenerAleatorio(): String {
            return values().random().name
        }
    }

}