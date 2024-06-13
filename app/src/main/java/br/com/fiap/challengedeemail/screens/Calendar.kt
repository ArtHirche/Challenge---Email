package br.com.fiap.challengedeemail.screens

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.challengedeemail.components.AnimatedBorderCard
import br.com.fiap.challengedeemail.ui.theme.Blue200
import br.com.fiap.challengedeemail.ui.theme.Blue500
import br.com.fiap.challengedeemail.ui.theme.Blue900
import java.text.SimpleDateFormat
import java.util.*

data class Anotacao(
    var nota: String,
    var dataHora: Calendar,
    var emails: List<String>
)

var dataHoraTextView: Calendar = Calendar.getInstance()
var dataHoraSelecionada: Calendar = Calendar.getInstance()
var listaAnotacoes: MutableList<Anotacao> = mutableListOf()


fun atualizarDataEHora(dataHoraSelecionadaState: MutableState<Calendar>): String {
    val selectedDate = dataHoraSelecionada
    dataHoraSelecionadaState.value = selectedDate
    val formattedDate = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault()).format(dataHoraSelecionadaState.value.time)
    return formattedDate
}

fun selecioneDataEHora(context: Context, dataHoraSelecionadaState: MutableState<Calendar>) {
    val currentDate = Calendar.getInstance()
    val value = dataHoraSelecionadaState.value

    val datePickerDialog = DatePickerDialog(
        context,
        { _, year, month, dayOfMonth ->
            value.set(year, month, dayOfMonth)
            val timePickerDialog = TimePickerDialog(
                context,
                { _, hourOfDay, minute ->
                    value.set(Calendar.HOUR_OF_DAY, hourOfDay)
                    value.set(Calendar.MINUTE, minute)
                    // Atualiza o estado para forçar a recomposição
                    atualizarDataEHora(dataHoraSelecionadaState)
                },
                currentDate.get(Calendar.HOUR_OF_DAY),
                currentDate.get(Calendar.MINUTE),
                true
            )
            timePickerDialog.show()
        },
        currentDate.get(Calendar.YEAR),
        currentDate.get(Calendar.MONTH),
        currentDate.get(Calendar.DAY_OF_MONTH)
    )
    datePickerDialog.show()
}

fun salvarNota(
    context: Context,
    nota: String,
    dataHoraSelecionada: Calendar,
    listaAnotacoes: MutableList<Anotacao>,
    emails: List<String>
) {
    if (nota.isNotEmpty() && emails.isNotEmpty()) {
        val novaAnotacao = Anotacao(nota, dataHoraSelecionada.clone() as Calendar, emails)
        listaAnotacoes.add(novaAnotacao)
        Toast.makeText(
            context,
            "Anotação salva: ${novaAnotacao.nota}\nData e Hora: ${novaAnotacao.dataHora.time}\nE-mails: ${novaAnotacao.emails.joinToString(", ")}",
            Toast.LENGTH_LONG
        ).show()
    } else {
        Toast.makeText(context, "Por favor, insira uma anotação e pelo menos um e-mail.", Toast.LENGTH_SHORT).show()
    }
}

@Composable
fun AnotacaoItem(anotacao: Anotacao) {
    val formattedDate = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault()).format(anotacao.dataHora.time)
    Text(
        text = "Nota: ${anotacao.nota}\nData e Hora: $formattedDate\nE-mails: ${anotacao.emails.joinToString(", ")}"
    )
}

@Composable
fun AnotacoesList(listaAnotacoes: List<Anotacao>) {
    LazyColumn {
        items(listaAnotacoes.sortedByDescending { it.dataHora }) { anotacao ->
            AnotacaoItem(anotacao)
        }
    }
}

@Composable
fun PreviewAnotacoesList() {
    val listaAnotacoes = listOf(
        Anotacao("Primeira nota", Calendar.getInstance().apply { set(2024, Calendar.MAY, 15, 10, 30) }, listOf("email1@example.com")),
        Anotacao("Segunda nota", Calendar.getInstance().apply { set(2024, Calendar.APRIL, 20, 14, 0) }, listOf("email2@example.com"))
    )
    AnotacoesList(listaAnotacoes = listaAnotacoes)
}

@Composable
fun AnotacoesScreen(context: Context) {
    // Estado para armazenar a nota da anotação
    val notaState = remember { mutableStateOf(TextFieldValue()) }
    // Estado para armazenar os e-mails
    val emailsState = remember { mutableStateOf(TextFieldValue()) }
    // Estado para armazenar a data e hora selecionadas
    val dataHoraSelecionadaState = remember { mutableStateOf(Calendar.getInstance()) }
    // Lista de anotações
    val listaAnotacoes = remember { mutableStateOf(mutableListOf<Anotacao>()) }

    // LaunchedEffect para atualizar a data e hora sempre que dataHoraSelecionadaState mudar
    LaunchedEffect(dataHoraSelecionadaState.value) {
        dataHoraSelecionadaState.value = dataHoraSelecionadaState.value.clone() as Calendar
    }

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
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = { /*TODO*/ }) {
                Text(
                    text = "X",
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
            }
            Spacer(modifier = Modifier.padding(7.dp))
            Text(
                text = "Inbox Overview",
                fontSize = 28.sp,
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
        }
        Spacer(modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 3.dp))

        AnimatedBorderCard(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 10.dp),
            shape = RoundedCornerShape(8.dp),
            gradient = Brush.sweepGradient(listOf(Blue500, Blue200))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // Campo de texto para editar a nota da anotação
                OutlinedTextField(
                    value = notaState.value,
                    onValueChange = { notaState.value = it },
                    label = { Text("Digite sua anotação", color = Color.Black) },
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .fillMaxWidth(),
                    textStyle = TextStyle(color = Color.Black),
                    colors = TextFieldDefaults.colors(Color.White)
                )

                // Campo de texto para adicionar e-mails
                OutlinedTextField(
                    value = emailsState.value,
                    onValueChange = { emailsState.value = it },
                    label = { Text("Digite os e-mails separados por vírgula", color = Color.Black) },
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .fillMaxWidth(),
                    textStyle = TextStyle(color = Color.Black),
                    colors = TextFieldDefaults.colors(Color.White)

                )

                // Texto para exibir a data e hora selecionadas

                Text(
                    text = "Data e Hora: ${atualizarDataEHora(dataHoraSelecionadaState)}",
                    color = Color.White,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                // Botão para selecionar data e hora
                Button(
                    onClick = {
                        selecioneDataEHora(context, dataHoraSelecionadaState)
                    },
                    modifier = Modifier.padding(bottom = 8.dp)
                ) {
                    Text(text = "Selecionar Data e Hora")
                }

                // Botão para salvar a anotação
                Button(
                    onClick = {
                        val emailsList = emailsState.value.text.split(",").map { it.trim() }.filter { it.isNotEmpty() }
                        salvarNota(
                            context = context,
                            nota = notaState.value.text,
                            dataHoraSelecionada = dataHoraSelecionadaState.value,
                            listaAnotacoes = listaAnotacoes.value,
                            emails = emailsList
                        )
                        // Limpar os campos de texto após salvar
                        notaState.value = TextFieldValue()
                        emailsState.value = TextFieldValue()
                    }
                ) {
                    Text(text = "Salvar Anotação")
                }


            }
        }
    }
}
