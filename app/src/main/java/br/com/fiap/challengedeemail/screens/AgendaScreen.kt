package br.com.fiap.challengedeemail.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.challengedeemail.R
import br.com.fiap.challengedeemail.agenda.theme.Blue200
import br.com.fiap.challengedeemail.agenda.theme.Blue500
import br.com.fiap.challengedeemail.agenda.theme.Blue900
import br.com.fiap.challengedeemail.components.AnimatedBorderCard
import com.pandaways.mycalendar.ui.Anotacao
import com.pandaways.mycalendar.ui.CalendarApp
import java.time.LocalDate

@Composable
fun Agenda(){
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
                )
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = stringResource(id = R.string.app_name),
            fontSize = 36.sp,
            fontFamily = FontFamily.Monospace,
            color = Color.White,
            fontWeight = FontWeight.Bold,
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

        Spacer(modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 30.dp))

        AnimatedBorderCard(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 5.dp),
            shape = RoundedCornerShape(8.dp),
            gradient = Brush.sweepGradient(listOf(Blue500, Blue200))
        ) {

            Column(
                modifier = Modifier.padding(all = 5.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val today = LocalDate.now()
                val anotacoes1= listOf(
                    Anotacao("Nota 1", today.plusDays(1), listOf("email1@example.com")),
                    Anotacao("Nota 2", today.plusDays(2), listOf("email2@example.com")),
                    Anotacao("Nota 3", today.plusDays(3), listOf("email3@example.com")),
                    Anotacao("Nota 4", today.plusDays(4), listOf("email4@example.com")),
                    Anotacao("Nota 5", today.plusDays(5), listOf("email5@example.com"))
                )
                CalendarApp(
                    modifier = Modifier.padding(5.dp),
                    anotacoes = anotacoes1
                )
            }
        }
    }
}