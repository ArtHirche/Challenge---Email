package br.com.fiap.challengedeemail.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.challengedeemail.R
import br.com.fiap.challengedeemail.components.AnimatedBorderCard
import br.com.fiap.challengedeemail.agenda.theme.Blue200
import br.com.fiap.challengedeemail.agenda.theme.Blue500
import br.com.fiap.challengedeemail.agenda.theme.Blue900

@Composable
fun HomeScreen(){



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
    Row (modifier = Modifier.shadow(elevation = 50.dp,
        shape = RectangleShape,
        clip = false,
        spotColor = Color.Black,
        ambientColor = Color.Black),
        ){
        Card (modifier = Modifier
            .height(170.dp)
            .padding(10.dp)
            .fillMaxWidth()
            .shadow(
                elevation = 50.dp,
                shape = RectangleShape,
                clip = false,
                spotColor = Color.Black,
                ambientColor = Color.Black
            ),
            elevation = CardDefaults.cardElevation(50.dp)){
            Column (verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(25.dp)
                    .padding(top = 5.dp)){
                Text(text = "Top emails", fontSize = 15.sp, fontWeight = FontWeight.Bold)
            }
            Column (verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()){
                EmailCard()
            }

        }

    }
}
@Composable
fun KPIs () {
    Row(modifier = Modifier.padding(10.dp)) {
        Card (modifier = Modifier
            .height(170.dp)
            .width(175.dp)
            .shadow(
                elevation = 50.dp,
                shape = RectangleShape,
                clip = false,
                spotColor = Color.Black,
                ambientColor = Color.Black
            )
            ){

                Column (verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(25.dp)
                            .padding(top = 5.dp)){
                    Text(text = "Emails received", fontSize = 15.sp, fontWeight = FontWeight.Bold)
                }
                Column (verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()){
                    Text(text = "16", fontSize = 60.sp)
                }
        }
        Spacer(modifier = Modifier.padding(8.dp))
        Card (modifier = Modifier
            .height(170.dp)
            .width(175.dp)
            .shadow(
                elevation = 50.dp,
                shape = RectangleShape,
                clip = false,
                spotColor = Color.Black,
                ambientColor = Color.Black
            )){
            Column (verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(25.dp)
                    .padding(top = 5.dp)){
                Text(text = "Next meeting", fontSize = 15.sp, fontWeight = FontWeight.Bold)
            }
            Column (verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()){
                MeetCard()
            }

        }
    }
}
@Composable
fun FavoriteNews(){
    Row (){
        Card (modifier = Modifier
            .height(170.dp)
            .padding(10.dp)
            .fillMaxWidth()
            .shadow(
                elevation = 50.dp,
                shape = RectangleShape,
                clip = false,
                spotColor = Color.Black,
                ambientColor = Color.Black
            )){
            Column (verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(25.dp)
                    .padding(top = 5.dp)){
                Text(text = "Best news according to your top searches", fontSize = 15.sp, fontWeight = FontWeight.Bold)
            }
            Column (verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()){
                NewsCardRow()
            }
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
            fontSize = 6.sp
        )
        Text(
            text = email.subject,
            fontWeight = FontWeight.Medium,
            fontSize = 8.sp
        )
        Text(
            text = email.preview,
            fontSize = 5.sp,
            maxLines = 1
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                text = email.time,
                fontSize = 6.sp
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
            title = "New technology revolutionizes the market",
            description = "Discover how the new AI is transforming industries.",
            time = "10:00",
            imageUrl = "https://www.fiap.com.br/e-images/2024/mba/reminder-live/header.png",
            url = R.drawable.tec
        ),
        NewsData(
            title = "Advancements in renewable energy",
            description = "How new methods are enhancing energy efficiency.",
            time = "12:30",
            imageUrl = "https://www.fiap.com.br/e-images/2024/mba/reminder-live/header.png",
            url = R.drawable.tec1
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
            .width(160.dp), colors = CardDefaults.cardColors(Blue500)) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id= news.url),
                contentDescription = null,
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = news.title,
                fontWeight = FontWeight.Bold,
                fontSize = 9.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = news.description,
                fontSize = 8.sp,
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
                    fontSize = 8.sp
                )
            }
        }
    }
}

data class NewsData(
    val title: String,
    val description: String,
    val time: String,
    val imageUrl: String,
    val url: Int
)
@Composable
fun MeetCard() {
    val newsList = listOf(
        MeetData(
            title = "Sprint Planning",
            description = "Discover how the new AI is transforming industries.",
            time = "9:00",
            organizador = "Organizador: Nathan Oliveira Pinho",
            local = "FIAP - Polo São Paulo"
        ),

    )

    Row(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        newsList.forEach { meet ->
            Meeting(meet = meet)
        }
    }
}

@Composable
fun Meeting(meet: MeetData) {

    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .padding(8.dp)
            .height(150.dp)
            .width(160.dp),colors = CardDefaults.cardColors(Blue500)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = meet.title,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "\uD83D\uDD52 ${meet.time}",
                fontSize = 11.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "\uD83D\uDCCD ${meet.local}",
                fontSize = 11.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = meet.organizador,
                fontSize = 8.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

        }
    }
}

data class MeetData(
    val title: String,
    val description: String,
    val time: String,
    val organizador: String,
    var local: String
)