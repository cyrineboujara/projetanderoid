package com.example.myprojet1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myprojet1.ui.theme.MyProjet1Theme

class MainActivity5 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Activer le mode plein écran
        setContent {
            MyProjet1Theme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    // Contenu principal de l'application
                    GreetingScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun GreetingScreen(modifier: Modifier = Modifier) {
    // Écran de bienvenue avec un message
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp), // Ajout de padding
        verticalArrangement = Arrangement.Center, // Centrer verticalement
        horizontalAlignment = Alignment.CenterHorizontally // Centrer horizontalement
    ) {
        // Message de bienvenue pour l'écran de connexion
        Greeting(name = "User") // Appel de la fonction Greeting avec "User"
        Spacer(modifier = Modifier.height(16.dp)) // Espacement entre le message et d'autres éléments éventuels
        Image(
            painter = painterResource(id = R.drawable.welcom), // Image login.png dans res/drawable
            contentDescription = "Login Image",
            modifier = Modifier
                .size(250.dp) // Taille de l'image
                .padding(bottom = 30.dp) // Espacement entre l'image et le texte Login
        )
        Text(
            text = "Please Login", // Indication pour l'utilisateur
            style = MaterialTheme.typography.bodyLarge, // Utiliser un style de texte approprié
            textAlign = TextAlign.Center // Centrer le texte
        )
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Welcome, $name!",
        modifier = modifier,
        style = MaterialTheme.typography.headlineMedium, // Utiliser un style de texte
        textAlign = TextAlign.Center // Centrer le texte
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyProjet1Theme {
        GreetingScreen() // Afficher l'aperçu de l'écran de bienvenue
    }
}
