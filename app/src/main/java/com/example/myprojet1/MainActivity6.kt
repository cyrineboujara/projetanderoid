package com.example.myprojet1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myprojet1.ui.theme.MyProjet1Theme

class MainActivity6 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyProjet1Theme {
                val intent = intent
                val productName = intent.getStringExtra("productName") ?: ""
                val productPrice = intent.getDoubleExtra("productPrice", 0.0)
                val productDescription = intent.getStringExtra("productDescription") ?: ""
                val productImageUrl = intent.getIntExtra("productImageUrl", R.drawable.default_image)

                // Afficher les détails du produit ici
                ProductDetailScreen(productName, productPrice, productDescription, productImageUrl)
            }
        }
    }
}

@Composable
fun ProductDetailScreen(name: String, price: Double, description: String, imageUrl: Int) {
    val context = LocalContext.current // Obtenez le contexte ici

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = imageUrl),
            contentDescription = "Product Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(200.dp).fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = name, style = MaterialTheme.typography.headlineMedium)
        Text(text = "$$price", style = MaterialTheme.typography.bodyLarge)
        Text(text = description, style = MaterialTheme.typography.bodyMedium)

        Spacer(modifier = Modifier.height(16.dp)) // Espacement avant le bouton
        Button(onClick = {
            // Retourner à MainActivity5
            val intent = Intent(context, MainActivity5::class.java) // Créer un Intent pour MainActivity5
            context.startActivity(intent) // Démarrer MainActivity5
            (context as ComponentActivity).finish() // Optionnel : terminer l'activité actuelle
        }) {
            Text(text = "Retour")
        }
    }
}
