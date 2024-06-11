package br.com.fiap.challengedeemail.screens

import android.graphics.Paint.Style
import android.icu.text.ListFormatter.Width
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.DividerDefaults.color
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.challengedeemail.R
import br.com.fiap.challengedeemail.components.AnimatedBorderCard
import br.com.fiap.challengedeemail.components.TextFieldCustom
import br.com.fiap.challengedeemail.ui.theme.Blue200
import br.com.fiap.challengedeemail.ui.theme.Blue500
import br.com.fiap.challengedeemail.ui.theme.Blue900

@Composable
fun HomeScreen(){


    var username by remember { mutableStateOf("")}
    var password by remember { mutableStateOf("")}
    var rememberMeCheck by remember { mutableStateOf(false)}

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
                text = stringResource(id = R.string.app_name),
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
            Column {
                PrincipalEmail()
                KPIs()
                FavoriteNews()
            }
        }


    }
}

@Composable
fun PrincipalEmail(){
    Row (){
        Card (modifier = Modifier
            .height(170.dp)
            .padding(10.dp)
            .fillMaxWidth()){
            EmailCard()
        }

    }
}
@Composable
fun KPIs () {
    Row(modifier = Modifier.padding(10.dp)) {
        Card (modifier = Modifier
            .height(170.dp)
            .width(175.dp)){



        }
        Spacer(modifier = Modifier.padding(8.dp))
        Card (modifier = Modifier
            .height(170.dp)
            .width(175.dp)){

        }
    }
}
@Composable
fun FavoriteNews(){
    Row (){
        Card (modifier = Modifier
            .height(170.dp)
            .padding(10.dp)
            .fillMaxWidth()){
            NewsCardRow()
        }

    }
}

@Composable
fun EmailCard() {
    val emails = listOf(
        EmailData(
            sender = "technews@daily.com",
            subject = "Tech Daily | Latest updates in AI",
            preview = "Hello, today's top news includes advancements in artificial intelligence...",
            time = "09:00"
        ),
        EmailData(
            sender = "info@kotlinlang.org",
            subject = "Kotlin Weekly | New Jetpack Compose features",
            preview = "Hi there, check out the new features in Jetpack Compose that were released...",
            time = "12:30"
        ),
        EmailData(
            sender = "news@techcrunch.com",
            subject = "TechCrunch | Startup funding news",
            preview = "Hello, today's top story is about the recent funding round of a tech startup...",
            time = "15:45"
        )
    )

    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(5.dp)
        ) {
            emails.forEach { email ->
                EmailItem(email = email)
                Spacer(modifier = Modifier.height(5.dp))
            }
        }
    }
}

@Composable
fun EmailItem(email: EmailData) {
    Column {
        Text(
            text = email.sender,
            fontWeight = FontWeight.Bold,
            fontSize = 7.sp
        )
        Text(
            text = email.subject,
            fontWeight = FontWeight.Medium,
            fontSize = 10.sp
        )
        Text(
            text = email.preview,
            fontSize = 6.sp,
            maxLines = 1
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                text = email.time,
                fontSize = 8.sp
            )
        }
    }
}

data class EmailData(
    val sender: String,
    val subject: String,
    val preview: String,
    val time: String
)
@Composable
fun NewsCardRow() {
    val newsList = listOf(
        NewsData(
            title = "Nova tecnologia revoluciona o mercado",
            description = "Descubra como a nova IA está transformando indústrias.",
            time = "10:00",
            imageUrl = "https://www.fiap.com.br/e-images/2024/mba/lembrete-live/header.png"
        ),
        NewsData(
            title = "Avanços em energia renovável",
            description = "Como os novos métodos estão melhorando a eficiência energética.",
            time = "12:30",
            imageUrl = "https://www.fiap.com.br/e-images/2024/mba/lembrete-live/header.png"
        ),
    )

    Row(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        newsList.forEach { news ->
            NewsItem(news = news)
        }
    }
}

@Composable
fun NewsItem(news: NewsData) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .padding(8.dp)
            .height(150.dp)
            .width(160.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = news.title,
                fontWeight = FontWeight.Bold,
                fontSize = 10.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = news.description,
                fontSize = 9.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = news.time,
                    fontSize = 15.sp
                )
            }
        }
    }
}

data class NewsData(
    val title: String,
    val description: String,
    val time: String,
    val imageUrl: String
)
