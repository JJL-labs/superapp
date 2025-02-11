import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.gif.GifDecoder
import coil3.request.ImageRequest
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.jetbrains.kmpapp.R

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen(
    onClick: () -> Unit
) {
    val pagerState = rememberPagerState()

    Column() {
        HorizontalPager(
            state = pagerState,
            count = 3,
            modifier = Modifier.weight(1f)
        ) { page ->

            when (page) {
                0 -> OnBoardingPage(
                    icon = R.drawable.tela1,
                    text = "Olá, Bem vindo(a)",
                    pagerState = pagerState
                )

                1 -> OnBoardingPage(
                    icon = R.drawable.tela2,
                    text = "Antes de começarmos, vamos configurar as coisas",
                    pagerState = pagerState
                )

                2 -> SelectHospitalPage(onClick)
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingPage(
    icon: Int,
    text: String,
    pagerState: PagerState
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 50.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AsyncImage(
            model = ImageRequest
                .Builder(LocalContext.current)
                .data(icon)
                .decoderFactory(GifDecoder.Factory())
                .build(),
            contentDescription = "Creature Image",
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .padding(top = 250.dp)
                .align(Alignment.CenterHorizontally)
        )

        PagerIndicator(pagerState = pagerState)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectHospitalPage(onClick: () -> Unit) {
    val hospitalOptions = listOf("Hospital XPTO", "Hospital ABC", "Hospital XYZ")
    val ambienteOptions = listOf("Produção", "Desenvolvimento", "Teste")
    var selectedHospital by remember { mutableStateOf(hospitalOptions[0]) }
    var selectedAmbiente by remember { mutableStateOf(ambienteOptions[0]) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            textAlign = TextAlign.Center,
            text = "Selecione hospital e ambiente antes de continuar.",
            style = MaterialTheme.typography.bodyLarge.copy(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 200.dp)
        )


        Spacer(Modifier.height(170.dp))


        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Selecione o hospital",
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    color = Color.DarkGray
                )
                Spacer(modifier = Modifier.height(8.dp))
                ExposedDropdownMenuBox(
                    expanded = false,
                    onExpandedChange = {},
                    modifier = Modifier.fillMaxWidth()
                ) {
                    OutlinedTextField(
                        value = selectedHospital,
                        onValueChange = {},
                        readOnly = true,
                        trailingIcon = {
                            Icon(imageVector = Icons.Default.Close, contentDescription = "Clear")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(53.dp),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = MaterialTheme.colorScheme.background,
                            unfocusedContainerColor = MaterialTheme.colorScheme.background,
                            focusedIndicatorColor = Color.LightGray,
                            unfocusedIndicatorColor = Color.LightGray
                        ),
                        shape = MaterialTheme.shapes.medium
                    )
                }
            }
            Spacer(modifier = Modifier.height(15.dp))

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Selecione o ambiente",
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    color = Color.DarkGray
                )
                Spacer(modifier = Modifier.height(8.dp))
                ExposedDropdownMenuBox(
                    expanded = false,
                    onExpandedChange = {},
                    modifier = Modifier.fillMaxWidth()
                ) {
                    OutlinedTextField(
                        value = selectedAmbiente,
                        onValueChange = {},
                        readOnly = true,
                        trailingIcon = {
                            Icon(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = "Dropdown"
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(53.dp),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = MaterialTheme.colorScheme.background,
                            unfocusedContainerColor = MaterialTheme.colorScheme.background,
                            focusedIndicatorColor = Color.LightGray,
                            unfocusedIndicatorColor = Color.LightGray
                        ),
                        shape = MaterialTheme.shapes.medium
                    )
                }
            }
        }

        Spacer(Modifier.height(140.dp))


        Button(
            onClick = onClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp)
                .height(45.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF4979FB)
            ),
            shape = RoundedCornerShape(20),
        ) {
            Text(
                text = "Salvar",
                color = Color.White,
            )
        }

    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun PagerIndicator(pagerState: PagerState) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(3) { index ->
            val color =
                if (pagerState.currentPage == index) MaterialTheme.colorScheme.primary else Color.Gray
            Icon(
                imageVector = Icons.Default.Circle,
                contentDescription = "Page Indicator",
                modifier = Modifier
                    .padding(4.dp)
                    .size(10.dp),
                tint = color
            )
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Preview(showBackground = true)
@Composable
fun PreviewOnboarding() {
    MaterialTheme(
        colorScheme = if (isSystemInDarkTheme()) darkColorScheme() else lightColorScheme()
    ) {
        val pagerState = rememberPagerState()

        Surface {
            OnBoardingPage(
                icon = R.drawable.tela1,
                text = "Olá, Bem vindo(a)",
                pagerState = pagerState
            )
        }
    }
}


