package Negocio

enum class Utensilio {
    HACHA,
    CUCHILLO,
    PISTOLA,
    FUEGO;

    override fun toString(): String {
        return when(this){
            HACHA -> "Hacha"
            CUCHILLO -> "Cuchillo"
            PISTOLA -> "Pisto"
            FUEGO -> "Fuego"
        }
    }
}