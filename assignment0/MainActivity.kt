package com.example.assignment0

import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment0.ui.theme.Assignment0Theme
import androidx.compose.ui.text.style.TextAlign
import kotlin.random.Random



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment0Theme {
                Scaffold { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        NamaAku()
                        DecisionScreen()
                    }
                }
            }
        }
    }
}


@Composable
fun NamaAku(){
    Text("ID: 1861521 CCID: jsantoso",
        fontSize = 24.sp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 18.dp, vertical = 14.dp))
}

@Composable
fun DecisionScreen() {
    var answer by remember { mutableStateOf("")}
    var count by remember { mutableStateOf(0)}
    val yesChance = 0.50
    val maybeChance = 0.25
    val noChance = 0.10
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        Text(
            text = "Click Count: $count",
            textAlign = TextAlign.Center,
            fontSize = 24.sp)
        Row(modifier = Modifier.padding(10.dp)) {
            Text(
                text = "Should we go?",
                textAlign = TextAlign.Center,
                fontSize = 30.sp,
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 18.dp, vertical = 14.dp)
            )

        }
        Row(modifier = Modifier){
        Button(
            onClick = {
                answer = if (Random.nextDouble() < yesChance)
                    "yes yay!"
            else "no boo :("
               count++ }
        ){
            Text("Yes")
        }
            Spacer(modifier = Modifier.width(8.dp))

        Button(
            onClick = {
                answer = if (Random.nextDouble() < maybeChance) "Yes"
                else "No chance"
                count++}
        ){
            Text("Maybe")
        }
            Spacer(modifier = Modifier.width(8.dp))

        Button(
            onClick = {
                answer = if (Random.nextDouble() < noChance ) "Of Course"
                else "Yikes no"
                count++}
        ){
            Text("No")
        }
        }
        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = answer,
            fontSize = 24.sp,
            modifier = Modifier.padding(top = 24.dp)
        )
     }
}
