package com.example.mjfinanceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mjfinanceapp.ui.theme.MJFinanceAppTheme
import models.SumaryCard
import models.User

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
    val usuario = User(1, "Maria", 1500.99)
    val cards = listOf(
        SumaryCard("Ventas", 1500.99),
        SumaryCard("Ventas", 1500.99)
    )

    Column(
        modifier = Modifier
            .padding(paddingValues = innerPadding)
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 15.dp, vertical = 30.dp)
    ) {
        Bienvenida(user = usuario)
        Cards(sumaryCard = cards)
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


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    MJFinanceAppTheme {
        MyComplexLayout(innerPadding = PaddingValues(10.dp))
    }
}