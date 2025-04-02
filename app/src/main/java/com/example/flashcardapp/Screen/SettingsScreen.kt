package com.example.flashcardapp.Screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun RadioButtonScreen(
    onBackAndSaveButtonClick: () -> Unit
    ) {
    var selectedOption by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Та харуулахыг хүссэн хэсгээ сонгоно уу:", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))

        val options = listOf("Гадаад үгийг ил харуулах", "Монгол үгийг ил харуулах", "Хоёуланг нь ил харуулах")
        options.forEach { text ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 4.dp)
            ) {
                RadioButton(
                    selected = selectedOption == text,
                    onClick = { selectedOption = text }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { onBackAndSaveButtonClick()},
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFab47bc))
            ) {
                Text("БУЦАХ", color = Color.White)
            }

            Button(
                onClick = { onBackAndSaveButtonClick() },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFab47bc))
            ) {
                Text("ХАДГАЛАХ", color = Color.White)
            }
        }
    }
}

