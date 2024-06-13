package br.com.fiap.challengedeemail.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.challengedeemail.R
import br.com.fiap.challengedeemail.agenda.theme.Blue200
import br.com.fiap.challengedeemail.agenda.theme.Blue500
import br.com.fiap.challengedeemail.agenda.theme.Blue900

@Composable
fun OptionsEmailScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.sweepGradient(
                    listOf(
                        Color.Black,
                        Blue900,
                        Color.Black
                    )
                )   )  )
    {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Opções",
                fontSize = 36.sp,
                style = TextStyle(
                    brush = Brush.horizontalGradient(
                        listOf(
                            Color.White,
                            Blue500,
                            Blue200
                        )
                    )
                )
            )
        }

        Spacer(modifier = Modifier.padding(10.dp))

        Button(
            onClick = {
                navController.navigate("home")

            },
            modifier = Modifier
                .fillMaxWidth()
            ,
            colors = ButtonDefaults.buttonColors(
                containerColor = Blue900,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(0.dp),
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_inbox_24),
                    contentDescription = "caixa inbox",
                    modifier = Modifier.size(35.dp)
                )
                Text(
                    text = "Principal",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 20.dp)
                )
            }
        }

        Spacer(modifier = Modifier.padding(5.dp))

        Button(
            onClick = {
                navController.navigate("calendar")

            },
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Blue900,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(0.dp),
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_warning_amber_24),
                    contentDescription = "Spam",
                    modifier = Modifier.size(35.dp)
                )
                Text(
                    text = "Calendario",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 20.dp)
                )
            }
        }

        Spacer(modifier = Modifier.padding(5.dp))

        Button(
            onClick = {
    navController.navigate("agenda")
            },
            modifier = Modifier
                .fillMaxWidth()
            ,
            colors = ButtonDefaults.buttonColors(
                containerColor = Blue900,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(0.dp),
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_star_outline_24),
                    contentDescription = "Com Estrela",
                    modifier = Modifier.size(35.dp)
                )
                Text(
                    text = "Agenda",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 20.dp)
                )
            }
        }

        Spacer(modifier = Modifier.padding(5.dp))

        Button(
            onClick = {
                navController.navigate("emaillist")

            },
            modifier = Modifier
                .fillMaxWidth()
            ,
            colors = ButtonDefaults.buttonColors(
                containerColor = Blue900,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(0.dp),
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_send_24),
                    contentDescription = "Recebidos",
                    modifier = Modifier.size(35.dp)
                )
                Text(
                    text = "Enviados",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 20.dp)
                )
            }
        }

        Spacer(modifier = Modifier.padding(5.dp))

        Button(
            onClick = {

            },
            modifier = Modifier
                .fillMaxWidth()
            ,
            colors = ButtonDefaults.buttonColors(
                containerColor = Blue900,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(0.dp),
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_delete_24),
                    contentDescription = "Lixeira",
                    modifier = Modifier.size(35.dp)
                )
                Text(
                    text = "Lixeira",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 20.dp)
                )
            }
        }

        Spacer(modifier = Modifier.padding(5.dp))

        Button(
            onClick = {

            },
            modifier = Modifier
                .fillMaxWidth()
            ,
            colors = ButtonDefaults.buttonColors(
                containerColor = Blue900,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(0.dp),
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                    contentDescription = "voltar",
                    modifier = Modifier.size(35.dp)
                )
                Text(
                    text = "Voltar",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 20.dp)
                )
            }
        }

    }


}


