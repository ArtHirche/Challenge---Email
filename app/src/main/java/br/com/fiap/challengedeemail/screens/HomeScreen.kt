package br.com.fiap.challengedeemail.screens

import android.graphics.Paint.Style
import android.icu.text.ListFormatter.Width
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
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
            modifier = Modifier.fillMaxWidth().padding(10.dp),
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



        }
    }
}