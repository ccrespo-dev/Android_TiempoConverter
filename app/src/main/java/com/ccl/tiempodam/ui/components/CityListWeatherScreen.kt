package com.ccl.tiempodam.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ccl.tiempodam.ViewModel.CityLIstWeatherViewModel
import com.ccl.tiempodam.model.WeatherCity

@Composable
fun CityListWeatherScreen(
    //Si ya existe lo recupera sino lo crea
    viewModel: CityLIstWeatherViewModel = viewModel(),
    onCardClick: (WeatherCity) -> Unit
){
    val listaCiudades by viewModel.cityList.collectAsState()


    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(items = listaCiudades){ ciudad ->
                Card(
                    modifier = Modifier.fillMaxSize(),
                    onClick = { onCardClick(ciudad) }

                ){
                    Text(text = ciudad.cityName)
                }
            }
        }
    }
}