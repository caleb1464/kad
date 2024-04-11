package com.example.levo

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class DestinationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Destination()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Destination() {
    Column (modifier = Modifier
        .fillMaxSize()
    )
    {
        val mContext = LocalContext.current
        var search by remember {mutableStateOf("")}
        //Start of TopAppBar
        TopAppBar(
            title = { Text(text = "Destination", color = Color.White) },
            colors = TopAppBarDefaults.mediumTopAppBarColors(Color.Red),
            navigationIcon = {
                IconButton(onClick = {mContext.startActivity(Intent(mContext,MainActivity::class.java))})
                {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "ArrowBack",
                        tint = Color.White
                    )
                }
            },
            actions = {
                IconButton(
                    onClick = {
                        val shareIntent = Intent(Intent.ACTION_SEND)
                        shareIntent.type = "text/plain"
                        shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this is a cool content")
                        mContext.startActivity(Intent.createChooser(shareIntent, "Share"))
                    }
                )
                {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = "Share",
                        tint = Color.White
                    )
                }

                Spacer(modifier = Modifier.width(10.dp))

                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Settings",
                    tint = Color.White
                )
            },
            )//End of TopAppBar

        //Start of Box
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
            contentAlignment = Alignment.BottomCenter)
        {
             Image(painter = painterResource(id = R.drawable.mal),
                 contentDescription ="Mal",
                 modifier = Modifier
                     .fillMaxSize(),
                 contentScale = ContentScale.Crop
             )

            Text(text = "Let's plan your next vacation",
                fontSize = 30.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
            )
            //End of Box
        }

        Spacer(modifier = Modifier.height(10.dp))

        //Start of searchbar
        OutlinedTextField(
            value = search,
            onValueChange = {search = it},
            placeholder = { Text(text = "What's your destination ?") },
            leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "Search") },
            modifier = Modifier.padding(start = 10.dp, end = 10.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        //End of searchbar

        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "Recently viewed",
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            textDecoration = TextDecoration.Underline,
            fontSize = 25.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        //Row
        Row (modifier = Modifier.horizontalScroll(rememberScrollState()))
        {
            //Card
            Card(modifier = Modifier
                .width(200.dp)
                .height(200.dp)
            )
            {
                Column {
                    Box (modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp),
                        contentAlignment = Alignment.Center
                    )
                    {
                        Image(painter = painterResource(id = R.drawable.singapore), contentDescription = "singapore",
                            modifier = Modifier
                                .fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }
                    Text(text = "Singapore",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp
                    )
                }
            }
            //End of Card

            Spacer(modifier = Modifier.width(8.dp))

            //Card
            Card(modifier = Modifier
                .width(200.dp)
                .height(200.dp)
            )
            {
                Column {
                    Box (modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp),
                        contentAlignment = Alignment.Center
                    )
                    {
                        Image(painter = painterResource(id = R.drawable.peru),
                            contentDescription = "peru",
                            modifier = Modifier
                                .fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }
                    Text(text = "Peru",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp
                    )
                }
            }
            //End of Card

            Spacer(modifier = Modifier.width(8.dp))

            //Card
            Card(modifier = Modifier
                .width(200.dp)
                .height(200.dp)
            )
            {
                Column {
                    Box (modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp),
                        contentAlignment = Alignment.Center
                    )
                    {
                        Image(painter = painterResource(id = R.drawable.newyork),
                            contentDescription = "newyork",
                            modifier = Modifier
                                .fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }
                    Text(text = "New York",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp
                    )
                }
            }
            //End of Card

            Spacer(modifier = Modifier.width(8.dp))

            //Card
            Card(modifier = Modifier
                .width(200.dp)
                .height(200.dp)
            )
            {
                Column {
                    Box (modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp),
                        contentAlignment = Alignment.Center
                    )
                    {
                        Image(painter = painterResource(id = R.drawable.moscow),
                            contentDescription = "moscow",
                            modifier = Modifier
                                .fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }
                    Text(text = "Moscow",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp
                    )
                }
            }
            //End of Card

            Spacer(modifier = Modifier.width(8.dp))

            //Card
            Card(modifier = Modifier
                .width(200.dp)
                .height(200.dp)
            )
            {
                Column {
                    Box (modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp),
                        contentAlignment = Alignment.Center
                    )
                    {
                        Image(painter = painterResource(id = R.drawable.dubai),
                            contentDescription = "dubai",
                            modifier = Modifier
                                .fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }
                    Text(text = "Dubai",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp
                    )
                }
            }
            //End of Card

            Spacer(modifier = Modifier.width(8.dp))
        }
        //End of Row

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedButton(onClick = { mContext.startActivity(Intent(mContext,ExploreActivity::class.java)) },
            colors = ButtonDefaults.buttonColors(Color.Blue),
            modifier = Modifier.align(Alignment.CenterHorizontally))
        {
            Text(text = "Explore")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DestinationPreview(){
    Destination()
}