package com.example.myprojet1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myprojet1.ui.theme.MyProjet1Theme
import androidx.compose.ui.platform.LocalContext

class MainActivity4 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyProjet1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SendRecoveryEmailScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun SendRecoveryEmailScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current // Obtenir le contexte ici

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Recovery Email Sent!",
            style = MaterialTheme.typography.headlineMedium,
            color = Color(0xFF6200EE) // Couleur violette
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "An email has been sent to your provided address with instructions to reset your password.",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(horizontal = 16.dp),
            textAlign = androidx.compose.ui.text.style.TextAlign.Center // Centre le texte
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Bouton pour retourner à la page de connexion
        Button(
            onClick = {
                // Action pour retourner à la page de connexion
                val intent = Intent(context, MainActivity::class.java) // Créer un Intent pour MainActivity
                context.startActivity(intent) // Démarrer MainActivity
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EE)) // Couleur violette
        ) {
            Text(text = "Back to Login", color = Color.White) // Texte blanc sur le bouton violet
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SendRecoveryEmailScreenPreview() {
    MyProjet1Theme {
        SendRecoveryEmailScreen()
    }
}
