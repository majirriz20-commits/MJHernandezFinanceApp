package com.example.mjfinanceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mjfinanceapp.ui.theme.MJFinanceAppTheme
import models.SumaryCard
import models.Transaction
import models.User
import models.listaSumaryCard
import models.listaTransacciones
import models.listaUsuario
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MJFinanceAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyComplexLayout(innerPadding)
                }
            }
        }
    }
}

@Composable
fun MyComplexLayout(innerPadding: PaddingValues) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .padding(paddingValues = innerPadding)
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 15.dp, vertical = 30.dp)
            .verticalScroll(scrollState)
    ) {
        //Bienvenida
        listaUsuario.forEach { user ->
            Bienvenida(user = user)
        }

        Spacer(modifier = Modifier.height(10.dp))

        //CARDS
        Cards(sumaryCard = listaSumaryCard)

        //TRANSACCION
        TransactionsHeader()
        listaTransacciones.forEach { transaction ->
            TransaccionesItem(
                transaction = transaction
            )
        }
    }
}

//Bienvenida
@Composable
fun Bienvenida(user: User) {
    //Row de bienvenida
    Row(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(56.dp)
                .clip(CircleShape)
                .background(Color(0xFFF1E5D8)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = null,
                modifier = Modifier
                    .size(36.dp)
            )
        }

        Column {
            Text(
                text = "Hola ${user.nombre}",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Bienvenido",
                fontSize = 16.sp,
                color = Color.Gray,
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Icon(
            imageVector = Icons.Default.Menu,
            contentDescription = null,
            modifier = Modifier
                .size(28.dp)
        )
    }
}

//Cards
@Composable
fun Cards(sumaryCard: List<SumaryCard>){
    //Cajas?
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp),
        horizontalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        //Caja verde
        Card(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(Color(0xFFE6F2ED))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Default.Face,
                    contentDescription = "Actividad",
                    modifier = Modifier
                        .size(36.dp)
                )
                Text(
                    text = "Actividad",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "de la semana",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
        }
        //Cajas verde y naranja?
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            //Tarejeta ventas
            Card(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(Color(0xFFF1E4D9))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = sumaryCard[1].titulo,
                        fontSize = 16.sp,
                        color = Color.Gray
                    )
                    Text(
                        text = "$${sumaryCard[1].monto}",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            //Tarjeta Ganancias
            Card(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(Color(0xFFE5E0F6))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = sumaryCard[2].titulo,
                        fontSize = 16.sp,
                        color = Color.Gray
                    )
                    Text(
                        text = "$${sumaryCard[2].monto}",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

//Transactions

//Transactions header
@Composable
fun TransactionsHeader(){
    //Encabezado
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Transactions",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "See all",
            fontSize = 16.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun TransaccionesItem(transaction: Transaction){
    //Items
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .padding(10.dp)
                .size(50.dp)
                .clip(CircleShape)
                .background(Color.Black),
            contentAlignment = Alignment.Center
        ){
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "Carritos de compras",
                tint = Color.White,
                modifier = Modifier
                    .size(24.dp)
            )
        }
        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            Text(
                text = transaction.establecimiento,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = transaction.categoria,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
        Column(
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = "$${transaction.monto}",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = transaction.hora,
                fontSize = 12.sp,
                color = Color.Gray
            )
        }
    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    MJFinanceAppTheme {
        MyComplexLayout(innerPadding = PaddingValues(10.dp))

    }
}