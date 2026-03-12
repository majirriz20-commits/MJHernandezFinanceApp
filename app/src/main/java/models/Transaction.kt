package models

class Transaction(
    val id: Int,
    val establecimiento: String,
    val categoria: String,
    val monto: Double,
    val hora: String,
)

val listaTransacciones = listOf(
    Transaction(1,"Supermarket", "Groceries", 45.99, "10:30 AM"),
    Transaction(2,"Gas Station", "Fuel", -30.5, "12:15 PM"),
    Transaction(3, "Coffee Shop", "Food & Drinks",5.75,"8:00 AM"),
    Transaction(4, "Electronics Store", "Electronics", 120.0, "3:45 PM"),
    Transaction(5, "Booksotore", "Books", 25.99, "2:00 PM"),
    Transaction(6, "Restaurant", "Dining", 60.0, "7:30 PM")
)

