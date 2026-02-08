package com.example.nebula.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Nebula",
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = "A neutral, plugin-driven media platform. Add your own repositories to load extensions.",
            style = MaterialTheme.typography.bodyMedium
        )

        InfoCard(
            title = "Extensions",
            body = "Extensions are optional plugins that provide media data through a shared API. Nebula ships empty by default."
        )
        InfoCard(
            title = "Repositories",
            body = "Repos are user-added lists of extensions. You control which sources are available and can remove them any time."
        )
    }
}

@Composable
private fun InfoCard(title: String, body: String) {
    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        modifier = Modifier.fillMaxWidth(),
        content = {
            Column(
                modifier = Modifier.padding(PaddingValues(16.dp)),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(text = title, style = MaterialTheme.typography.titleMedium)
                Text(text = body, style = MaterialTheme.typography.bodyMedium)
            }
        }
    )
}
