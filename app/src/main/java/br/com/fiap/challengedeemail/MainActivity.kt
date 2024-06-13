package br.com.fiap.challengedeemail

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.challengedeemail.screens.Agenda
import br.com.fiap.challengedeemail.screens.Calendar
import br.com.fiap.challengedeemail.screens.EmailScreen
import br.com.fiap.challengedeemail.screens.FormLogin
import br.com.fiap.challengedeemail.screens.HomeScreen
import br.com.fiap.challengedeemail.screens.OptionsEmailScreen
import com.pandaways.mycalendar.ui.Anotacao
import com.pandaways.mycalendar.ui.CalendarApp
import java.time.LocalDate

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController , startDestination = "login") {
                composable(route = "login"){ FormLogin(navController)}
                composable(route = "menu"){OptionsEmailScreen(navController)}
                composable(route = "home"){ HomeScreen(navController)}
                composable(route = "emaillist"){ EmailScreen(navController)}
                composable(route = "calendar"){
                    val context = LocalContext.current
                    Calendar(context = context, navController)}
                composable(route = "agenda"){ Agenda(navController)}

                }
            }
        }
    }


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

