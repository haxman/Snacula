package com.haxman.snacula

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.haxman.snacula.ui.theme.SnaculaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SnaculaTheme {
                LogintomainframeScreen()
            }
        }
    }
}

@Composable
fun LogintomainframeScreen() {
    val mCounter = remember { mutableStateOf(0)}
    var changePlaces by remember { mutableStateOf(Color.White)}
    var text by remember { mutableStateOf("") }
    var x = 50000
    Surface(modifier = Modifier.fillMaxSize(), color = changePlaces) {
        Column(
            modifier = Modifier
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            NewTitle()
            Spacer(
                Modifier.height(20.dp)
            )
            InputField(inputText=text)
            Spacer(
                Modifier.height(20.dp)
            )
            SubmitButton() {
                changePlaces = Color.Red
              /*  while (x > 0) {
                    if (changePlaces == Color.Red){
                        changePlaces = Color.Black
                    } else{
                        changePlaces = Color.Red
                    }
                    x--
                }*/
                if(text == "elpres"){
                    println(text)
                }

            }
            Text(text = mCounter.value.toString(), fontSize = 50.sp)
            CreateButton(text = "Add 5") {
                mCounter.value += 5
                println(mCounter)
            }
        }
    }

}

@Composable
fun NewTitle(){
    Text(
        text = "Completely Inconspicuous Normal App for Great Guest",
        style = MaterialTheme.typography.h3,
        textAlign = TextAlign.Center
    )
}


@Composable
fun InputField(inputText: String) {
    var text by remember { mutableStateOf(TextFieldValue(inputText)) }
    OutlinedTextField(
        value = text,
        leadingIcon = { Icon(imageVector = Icons.Default.Face, contentDescription = null) },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        label = { Text(text = "Username") },
        placeholder = { Text(text = "Your Username") },
      //  visualTransformation = PasswordVisualTransformation(),
        singleLine = true,
        onValueChange = {
            text = it
        }
    )
}

@Composable
fun SubmitButton(onClick: () -> Unit) {
    Button(onClick = onClick, ) {
        Text(text = "Submit")
    }
}

@Composable
fun CreateButton(text:String, onClick: ()-> Unit){
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFF0F9D58))
    ){
        Text(text = text, color = Color.White)
    }
}