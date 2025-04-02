import android.content.Context
import android.content.pm.ModuleInfo
import android.view.RoundedCorner
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.flashcardapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StartScreen(
    context: Context,
    onFixAndUpdateButtonClick: () -> Unit
) {
    var menuExpanded by remember { mutableStateOf(false) }
    Scaffold(
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier
                        .padding(top = 25.dp)
                ){
                    OneTextInput("Bataa", false)
                }
                Row (
                    modifier = Modifier
                        .padding(top = 25.dp)
                ){
                    OneTextInput("Ganaa", true)
                }
                Row (modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxHeight(0.5f))
                {
                    Button(
                        onClick = {onFixAndUpdateButtonClick()},
                        colors = ButtonDefaults.buttonColors(Color(0xFFab47bc))
                        ){
                        Text(
                            text = "Нэмэх"
                        )
                    }
                    Button(
                        onClick = {onFixAndUpdateButtonClick()},
                        colors = ButtonDefaults.buttonColors(Color(0xFFab47bc))
                        ){
                        Text(
                            text = "Шинэчлэх"
                        )
                    }
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(Color(0xFFab47bc))
                        ){
                        Text(
                            text = "устгах"
                        )
                    }
                }
                Row (
                    modifier = Modifier
                        .fillMaxHeight(),
                    horizontalArrangement = Arrangement.Center
                )

                {
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(Color(0xFFab47bc))
                        ){
                        Text(
                            text = "Дараа"
                        )
                    }
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(Color(0xFFab47bc))
                        ){
                        Text(
                            text = "Өмнөх"
                        )
                    }
                }
            }
        }
    )
}

@Composable
fun OneTextInput(string: String, boolean: Boolean) {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text(if (boolean) "MN" else "EN") },
        placeholder = { Text("Оруулна уу") },
        shape = RoundedCornerShape(12.dp),
    )
}
