package com.example.flashcardapp.Screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.flashcardapp.data.WordPair
import com.example.flashcardapp.model.WordViewModel
import com.example.flashcardapp.model.WordViewModelFactory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FixAndUpdateScreen(
//    viewModel: WordViewModel = viewModel(),
    onInsertAndCancel: () -> Unit
) {
    var englishWord by remember { mutableStateOf("") }
    var mongolianWord by remember { mutableStateOf("") }

    Scaffold { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            InputTextField(value = englishWord, onValueChange = { englishWord = it }, label = "EN")
            Spacer(modifier = Modifier.height(8.dp))
            InputTextField(value = mongolianWord, onValueChange = { mongolianWord = it }, label = "MN")
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Button(
                    onClick = {
//                        if (englishWord.isNotBlank() && mongolianWord.isNotBlank()) {
//                            viewModel.insertWord(WordPair(mongolian = mongolianWord, english = englishWord))
//                            onInsertAndCancel() // Амжилттай нэмсний дараа буцах
//                        }
                        onInsertAndCancel()
                    },
                    colors = ButtonDefaults.buttonColors(Color(0xFFf07178))
                ) { Text(text = "Оруулах") }
                Button(
                    onClick = { onInsertAndCancel() },
                    colors = ButtonDefaults.buttonColors(Color(0xFFf07178))
                ) { Text(text = "Болих") }
            }
        }
    }
}

@Composable
fun InputTextField(value: String, onValueChange: (String) -> Unit, label: String) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(label) },
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.fillMaxWidth()
    )
}
