package com.example.galerialvg

import android.widget.Toast
import androidx.compose.foundation.BorderStroke


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage


@Composable
fun GaleriaLVG(modifier: Modifier){
    Column (modifier = modifier.background(Color(0xFF393747))){
    Text(
        "Galería de Plantas", fontFamily = FontFamily.Cursive,
        fontSize = 40.sp, fontWeight = FontWeight.Bold, color = Color.White,
        modifier = Modifier.padding(0.dp,20.dp,0.dp,0.dp).fillMaxWidth(), textAlign = TextAlign.Center,

    )
    val context = LocalContext.current
    LazyVerticalGrid(modifier= modifier.fillMaxSize()
        .background(Color(0xFF393747)),
        columns = GridCells.Adaptive(180.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        items(getImagenes()){
            ItemImagenes(imagen = it) {
                Toast.makeText(context, it.titulo, Toast.LENGTH_SHORT).show()
            }

        }
    }
}
}

@Composable
fun ItemImagenes(imagen : Imagenes, onItemSelected : (Imagenes) -> Unit){

    Card(border = BorderStroke(2.dp, Color(0xFF2cb957)),
        modifier = Modifier.padding(8.dp)
            .clickable { onItemSelected(imagen)
                },
        ){
        Column (modifier = Modifier.background(Color(0xFF393747)).align(Alignment.CenterHorizontally)){

            AsyncImage(
                model = imagen.rutaImagen,
                contentDescription = null,
                modifier = Modifier.fillMaxWidth().width(200.dp).height(300.dp),
                contentScale = ContentScale.Crop
            )
            Text(imagen.titulo, fontFamily = FontFamily.Cursive,
                fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White,
                modifier = Modifier.padding(10.dp).fillMaxWidth(), textAlign = TextAlign.Center)
        }

    }

}

fun getImagenes () : List<Imagenes>{
    return listOf(
        Imagenes("https://i.pinimg.com/236x/29/4e/a0/294ea09587406f1469888040ac8b3830.jpg","Costilla de Adán"),
        Imagenes("https://i.pinimg.com/736x/50/d2/c9/50d2c90b76343d56930f41c57168699a.jpg","Palmera"),
        Imagenes("https://i.pinimg.com/236x/a0/7f/10/a07f100b06a7196b34083d7a928b5f88.jpg","Suculenta"),
        Imagenes("https://i.pinimg.com/236x/e8/a9/26/e8a9267ab262df8fc456a332d0e30eb4.jpg","Calathea"),
        Imagenes("https://i.pinimg.com/236x/49/ad/19/49ad19bb78af6dbe5adcc645c09773ad.jpg","Olivo"),
        Imagenes("https://i.pinimg.com/236x/78/2b/27/782b2764eea5a5ab36abb507a1e8dd11.jpg","Cempasúchil"),
        Imagenes("https://i.pinimg.com/236x/cb/4a/f0/cb4af0420e9f91f6b202720f8fc60b54.jpg","Hawaiana"),
        Imagenes("https://i.pinimg.com/236x/00/4b/31/004b319dd48341af2df55f9a518474c1.jpg","Fucsia"),
        Imagenes("https://i.pinimg.com/236x/64/cb/f8/64cbf8eeb120f1c4fad2d3de00fe3ee6.jpg","Flor de pájaro"),




        )
}