package models

class SumaryCard(
    val titulo: String,
    val monto: Double,
)

val listaSumaryCard = listOf(
    SumaryCard("Actividad", 0.0),
    SumaryCard("Ventas", 1500.99),
    SumaryCard("Ganancias", 1500.99)
)
