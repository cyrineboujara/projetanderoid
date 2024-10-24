package com.example.myprojet1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myprojet1.data.Product
import com.example.myprojet1.ui.theme.MyProjet1Theme

class MainActivity5 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyProjet1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProductListScreen(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ProductListScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

    // Liste des produits de maquillage
    val products = listOf(
        Product(name = "Sheglam Lipstick", price = 15.99, description = "A long-lasting, vibrant red lipstick.", imageUrl = R.drawable.sheg),
        Product(name = "Sheglam Foundation", price = 29.99, description = "A smooth, full-coverage foundation.", imageUrl = R.drawable.fond),
        Product(name = "Sheglam Eyeshadow", price = 19.99, description = "A palette with various vibrant colors.", imageUrl = R.drawable.rose)
    )

    // Organiser la page avec une LazyColumn pour la liste, et le bouton "Logout" en bas
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Utiliser LazyColumn pour rendre la liste des produits défilable
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f) // Permet à la liste d'occuper tout l'espace disponible
                .padding(16.dp) // Ajout de padding à la LazyColumn pour éviter que les éléments touchent les bords
        ) {
            items(products) { product ->
                ProductCard(product)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }

        // Bouton de déconnexion en bas de la page
        Button(
            onClick = {
                // Déconnexion
                with(sharedPreferences.edit()) {
                    putBoolean("isLoggedIn", false)
                    apply()
                }

                // Retourner à l'écran de connexion
                val intent = Intent(context, MainActivity::class.java)
                context.startActivity(intent)
                (context as ComponentActivity).finish() // Fermer MainActivity5
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF69B4) // Couleur rose pour le bouton de déconnexion
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp) // S'assurer que le bouton prend toute la largeur
        ) {
            Text(text = "Logout", color = Color.White)
        }
    }
}

@Composable
fun ProductCard(product: Product, modifier: Modifier = Modifier) {
    val context = LocalContext.current // Obtenez le contexte actuel

    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFC0CB) // Couleur rose pour la carte
        ),
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                // Démarrer MainActivity6 avec les détails du produit
                val intent = Intent(context, MainActivity6::class.java).apply {
                    putExtra("productName", product.name)
                    putExtra("productPrice", product.price)
                    putExtra("productDescription", product.description)
                    putExtra("productImageUrl", product.imageUrl)
                }
                context.startActivity(intent) // Démarrer l'activité
            }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = product.imageUrl),
                contentDescription = "Product Image",
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = product.name, style = MaterialTheme.typography.headlineMedium)
            Text(text = "$${product.price}", style = MaterialTheme.typography.bodyLarge)
            Text(text = product.description, style = MaterialTheme.typography.bodyMedium, textAlign = TextAlign.Center)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyProjet1Theme {
        ProductListScreen()
    }
}
