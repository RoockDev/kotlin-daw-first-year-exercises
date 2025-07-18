package org.example

import java.time.LocalDate

enum class FechasDeNacimiento(of: LocalDate) {
    ECHA_1(LocalDate.of(2020, 1, 15)),
    FECHA_2(LocalDate.of(2020, 3, 22)),
    FECHA_3(LocalDate.of(2020, 5, 7)),
    FECHA_4(LocalDate.of(2020, 7, 30)),
    FECHA_5(LocalDate.of(2020, 9, 12)),
    FECHA_6(LocalDate.of(2020, 11, 5)),
    FECHA_7(LocalDate.of(2021, 2, 14)),
    FECHA_8(LocalDate.of(2021, 4, 3)),
    FECHA_9(LocalDate.of(2021, 6, 19)),
    FECHA_10(LocalDate.of(2021, 8, 8)),
    FECHA_11(LocalDate.of(2021, 10, 25)),
    FECHA_12(LocalDate.of(2021, 12, 1)),
    FECHA_13(LocalDate.of(2022, 1, 9)),
    FECHA_14(LocalDate.of(2022, 3, 17)),
    FECHA_15(LocalDate.of(2022, 5, 30)),
    FECHA_16(LocalDate.of(2022, 7, 11)),
    FECHA_17(LocalDate.of(2022, 9, 28)),
    FECHA_18(LocalDate.of(2022, 11, 15)),
    FECHA_19(LocalDate.of(2023, 2, 2)),
    FECHA_20(LocalDate.of(2023, 4, 24)),
    FECHA_21(LocalDate.of(2023, 6, 7)),
    FECHA_22(LocalDate.of(2023, 8, 13)),
    FECHA_23(LocalDate.of(2023, 10, 5)),
    FECHA_24(LocalDate.of(2023, 12, 20)),
    FECHA_25(LocalDate.of(2024, 1, 30)),
    FECHA_26(LocalDate.of(2024, 3, 8)),
    FECHA_27(LocalDate.of(2024, 5, 17)),
    FECHA_28(LocalDate.of(2019, 7, 4)),
    FECHA_29(LocalDate.of(2019, 9, 22)),
    FECHA_30(LocalDate.of(2019, 11, 10));

    companion object {
        fun fechaAleatoria(): LocalDate {
            return values().random().toString().let { LocalDate.parse(it) }
        }
    }

}