package org.example

import kotlin.toString

enum class NombreAnimales {
    MAX,
    LUNA,
    ROCKY,
    BELLA,
    TOBY,
    COCO,
    SIMBA,
    LOLA,
    LUCKY,
    NALA,
    BRUNO,
    DAISY,
    REX,
    MILO,
    MOLLY,
    CHARLIE,
    KIRA,
    THOR,
    NINA,
    BUDDY,
    LUCY,
    ZEUS,
    COOKIE,
    JACK,
    PRINCESA,
    DUKE,
    CANELA,
    SHADOW,
    NUBE,
    PACO,
    CHISPA,
    MAYA,
    LOKI,
    KIWI,
    PELUSA,
    TRUENO,
    PANDA,
    CHIQUI,
    KAISER;


        companion object{
            fun devuelveNombre():String{
                return values().random().toString()
            }
        }
}

