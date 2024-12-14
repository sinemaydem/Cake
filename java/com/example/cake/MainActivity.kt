package com.example.cake

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.cake.ui.theme.AnaRenk
import com.example.cake.ui.theme.AnaRenk2
import com.example.cake.ui.theme.AnaRenkDark
import com.example.cake.ui.theme.AnaRenkDark2
import com.example.cake.ui.theme.YaziRenk1
import com.example.cake.ui.theme.YaziRenk2
import com.example.cake.ui.theme.CakeTheme
import com.example.cake.ui.theme.pasifico

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CakeTheme {
                Anasayfa()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Anasayfa(darkTheme: Boolean = isSystemInDarkTheme()) {
    val configuration = LocalConfiguration.current
    val ekranYuksekligi = configuration.screenHeightDp.dp
    val ekranGenisligi = configuration.screenWidthDp.dp

    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    stringResource(id = R.string.app_name),
                    fontFamily = pasifico,
                    fontSize = 30.sp
                )
            },
            actions = {
                IconButton(onClick = { /* Profil sayfasına git */ }) {
                    Icon(Icons.Default.AccountCircle, contentDescription = "Profile Icon", tint = YaziRenk2)
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = if (darkTheme) AnaRenkDark else AnaRenk,
                titleContentColor = YaziRenk2
            )
        )
    }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.tatliBaslik),
                color = if (darkTheme) AnaRenkDark else AnaRenk,
                fontWeight = FontWeight.Bold,
                fontSize = 36.sp
            )

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.chocolate_cake),
                    contentDescription = "Chocolate Cake Image",
                    modifier = Modifier.size(200.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(id = R.string.fiyatYazi),
                        color = if (darkTheme) AnaRenkDark else AnaRenk,
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp
                    )
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                painter = painterResource(id = R.drawable.star),
                                contentDescription = "Rating Star",
                                tint = Color.Yellow
                            )
                            Text(
                                text = "4.2",
                                color = if (darkTheme) YaziRenk2 else Color.Gray,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                painter = painterResource(id = R.drawable.clock),
                                contentDescription = "Clock Icon",
                                tint = if (darkTheme) YaziRenk2 else Color.Gray
                            )
                            Text(
                                text = stringResource(id = R.string.teslimatSure),
                                color = if (darkTheme) YaziRenk2 else Color.Gray,
                                fontSize = 16.sp
                            )
                        }
                    }
                }
            }

            Text(
                text = stringResource(id = R.string.tatliAciklama),
                color = if (darkTheme) YaziRenk2 else YaziRenk1,
                fontSize = 22.sp,
                textAlign = TextAlign.Center
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                // İçerikler başlığı
                Text(
                    text = stringResource(id = R.string.icerikYazi),
                    color = if (darkTheme) AnaRenkDark else AnaRenk,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                )

                // Başlık ile içerik çipleri arasında boşluk
                Spacer(modifier = Modifier.size(16.dp))

                // İçerik çipleri
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    MyChip(icerik = stringResource(id = R.string.cikolataYazi))
                    MyChip(icerik = stringResource(id = R.string.findikYazi))
                    MyChip(icerik = stringResource(id = R.string.ahududuYazi))
                    MyChip(icerik = stringResource(id = R.string.cilekYazi))
                }
            }


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { /* Direkt satın al işlemi */ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (darkTheme) AnaRenkDark2 else AnaRenk2,
                        contentColor = YaziRenk2
                    ),
                    modifier = Modifier.size(
                        width = ekranGenisligi / 2.2f,
                        height = ekranYuksekligi / 12
                    )
                ) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text(
                            text = stringResource(id = R.string.direktSatinAl),
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }


                Spacer(modifier = Modifier.width(8.dp)) // Butonlar arasında boşluk eklemek için Spacer

                Button(
                    onClick = { /* Sepete ekle işlemi */ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (darkTheme) AnaRenkDark else AnaRenk,
                        contentColor = YaziRenk2
                    ),
                    modifier = Modifier.size(
                        width = ekranGenisligi / 2.2f,
                        height = ekranYuksekligi / 12
                    )
                ) {
                    Text(text = stringResource(id = R.string.buttonYazi), fontSize = 20.sp)
                }
            }

        }
        }
    }


@Preview(showBackground = true, locale = "tr")//dil değişikliği
@Composable
fun GreetingPreview() {
    CakeTheme  {
        Anasayfa()
    }
}

@Composable
fun MyChip(icerik: String, width: Dp = 100.dp, height: Dp = 40.dp) {
    Button(
        onClick = { },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSystemInDarkTheme()) AnaRenkDark2 else AnaRenk2,
            contentColor = YaziRenk2,
        ),
        modifier = Modifier.size(width, height)
    ) {
        Text(text = icerik,
            fontSize = 10.sp,
            textAlign = TextAlign.Center)
    }
}