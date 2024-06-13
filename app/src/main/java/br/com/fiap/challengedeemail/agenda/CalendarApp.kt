package com.pandaways.mycalendar.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle




data class Anotacao(
    var anotacao: String,
    var dataHora: LocalDate,
    var emails: List<String>
)

data class CalendarUiModel1(
    val today: LocalDate,
    val startDate: CalendarUiModel1.Date,
    val endDate: CalendarUiModel1.Date,
    val selectedDate: CalendarUiModel1.Date,
    val visibleDates: List<CalendarUiModel1.Date>
) {
    data class Date(
        val date: LocalDate,
        val day: String,
        val isSelected: Boolean,
        val isToday: Boolean
    )
}

class CalendarDataSource1 {
    val today: LocalDate = LocalDate.now()

    fun getData(startDate: LocalDate = today, lastSelectedDate: LocalDate = today): CalendarUiModel1 {
        val visibleDates = (0..30).map {
            val date = startDate.plusDays(it.toLong())
            CalendarUiModel1.Date(
                date = date,
                day = date.dayOfWeek.name.take(3),
                isSelected = date == lastSelectedDate,
                isToday = date == today
            )
        }

        return CalendarUiModel1(
            today = today,
            startDate = visibleDates.first(),
            endDate = visibleDates.last(),
            selectedDate = visibleDates.firstOrNull { it.isSelected } ?: visibleDates.first(),
            visibleDates = visibleDates
        )
    }
}

@Composable
fun CalendarApp(
    anotacoes: List<Anotacao>,
    modifier: Modifier = Modifier,
) {
    val dataSource = CalendarDataSource1()
    var data by remember { mutableStateOf(dataSource.getData(lastSelectedDate = dataSource.today)) }
    var selectedAnotacoes by remember { mutableStateOf(emptyList<Anotacao>()) }

    Column(modifier = modifier.fillMaxSize()) {
        Header(
            data = data,
            onPrevClickListener = { startDate ->
                val finalStartDate = startDate.minusDays(1)
                data = dataSource.getData(startDate = finalStartDate, lastSelectedDate = data.selectedDate.date)
                selectedAnotacoes = anotacoes.filter { it.dataHora.isEqual(data.selectedDate.date) }
            },
            onNextClickListener = { endDate ->
                val finalStartDate = endDate.plusDays(2)
                data = dataSource.getData(startDate = finalStartDate, lastSelectedDate = data.selectedDate.date)
                selectedAnotacoes = anotacoes.filter { it.dataHora.isEqual(data.selectedDate.date) }
            }
        )
        Content(data = data) { date ->
            data = data.copy(
                selectedDate = date,
                visibleDates = data.visibleDates.map {
                    it.copy(
                        isSelected = it.date.isEqual(date.date)
                    )
                }
            )
            selectedAnotacoes = anotacoes.filter { it.dataHora.isEqual(date.date) }
        }

        // Display selected anotacoes
        AnotacoesList(selectedAnotacoes)
    }
}

@Composable
fun Header(
    data: CalendarUiModel1,
    onPrevClickListener: (LocalDate) -> Unit,
    onNextClickListener: (LocalDate) -> Unit,
) {
    Row {
        Text(
            text = if (data.selectedDate.isToday) {
                "Today"
            } else {
                data.selectedDate.date.format(
                    DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                )
            },
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        )
        IconButton(onClick = {
            onPrevClickListener(data.startDate.date)
        }) {
            Text(text = "<")
        }
        IconButton(onClick = {
            onNextClickListener(data.endDate.date)
        }) {
            Text(text = ">")
        }
    }
}

@Composable
fun Content(
    data: CalendarUiModel1,
    onDateClickListener: (CalendarUiModel1.Date) -> Unit,
) {
    LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 48.dp)) {
        items(data.visibleDates.size) { index ->
            ContentItem(
                date = data.visibleDates[index],
                onDateClickListener
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentItem(
    date: CalendarUiModel1.Date,
    onClickListener: (CalendarUiModel1.Date) -> Unit,
) {
    Card(
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 4.dp)
            .clickable {
                onClickListener(date)
            }
        ,
        colors = CardDefaults.cardColors(
            containerColor = if (date.isSelected) {
                Color.White
            } else {
                Color.White
            }
        ),
    ) {
        Column(
            modifier = Modifier
                .width(40.dp)
                .height(48.dp)
                .padding(4.dp)
        ) {
            Text(
                text = date.day,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = date.date.dayOfMonth.toString(),
                modifier = Modifier.align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}

@Composable
fun AnotacoesList(anotacoes: List<Anotacao>) {
    Column(modifier = Modifier.padding(16.dp)) {
        anotacoes.forEach { anotacao ->
            Text(
                text = "Nota: ${anotacao.anotacao}\nData: ${anotacao.dataHora}\n" +
                        "Email: ${anotacao.emails}", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .padding(8.dp)
            )
        }
    }
}

