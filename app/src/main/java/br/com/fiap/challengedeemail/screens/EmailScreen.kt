package br.com.fiap.challengedeemail.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.challengedeemail.R
import br.com.fiap.challengedeemail.agenda.theme.Blue900


@Composable
fun EmailScreen(navController: NavController) {

    var pesquisa by remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(
            brush = Brush.sweepGradient(
                listOf(
                    Color.Black,
                    Blue900,
                    Color.Black
                )
            ))) {
        Row(horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth()) {

            Button(
                onClick = {
                          navController.navigate("menu")

                },
                modifier = Modifier.size(70.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Blue900,
                    contentColor = Color.White
                )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_send_24),
                    contentDescription = "botão mais"
                )

            }

            OutlinedTextField(
                value = pesquisa,
                onValueChange = {letra ->
                    pesquisa = letra
                },
                label = {
                    Text(text = "Pesquisar e-mail", color = Color.White)
                },
                placeholder = {
                    Text(text = "Pesquisar e-mail", color = Color.White)
                },
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_search_24),
                        contentDescription = "botão de busca"
                    )
                },
                textStyle = TextStyle(fontSize = 20.sp, color = Color.White),
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White,
                    cursorColor = Color.White,
                )
            )
        }

        Column(
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier
                .size(width = 370.dp, height = 120.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.White)) {
                Column(modifier = Modifier.padding(10.dp)) {
                    Text(
                        text = "erikdavi123@gmail.com",
                        fontSize = 18.sp,
                        modifier = Modifier
                            .padding(bottom = 20.dp)
                    )
                    Text(text = "Estou mandando este email para dar o exemplo de como deve ficar a tela do app.")
                }
            }

            Box(modifier = Modifier
                .size(width = 370.dp, height = 120.dp)
                .padding(top = 10.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.White)) {
                Column(modifier = Modifier.padding(10.dp)) {
                    Text(
                        text = "arthirche44@gmail.com",
                        fontSize = 18.sp,
                        modifier = Modifier
                            .padding(bottom = 20.dp)
                    )
                    Text(text = "Estou mandando este email para dar o exemplo de como deve ficar a tela do app.")
                }
            }

            Box(modifier = Modifier
                .size(width = 370.dp, height = 120.dp)
                .padding(top = 10.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.White)) {
                Column(modifier = Modifier.padding(10.dp)) {
                    Text(
                        text = "nathan77@gmail.com",
                        fontSize = 18.sp,
                        modifier = Modifier
                            .padding(bottom = 20.dp)
                    )
                    Text(text = "Estou mandando este email para dar o exemplo de como deve ficar a tela do app.")
                }
            }

            Box(modifier = Modifier
                .size(width = 370.dp, height = 120.dp)
                .padding(top = 10.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.White)) {
                Column(modifier = Modifier.padding(10.dp)) {
                    Text(
                        text = "daniel1998@gmail.com",
                        fontSize = 18.sp,
                        modifier = Modifier
                            .padding(bottom = 20.dp)
                    )
                    Text(text = "Estou mandando este email para dar o exemplo de como deve ficar a tela do app.")
                }
            }
        }

    }

}

