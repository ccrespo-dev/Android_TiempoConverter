package com.ccl.tiempodam.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ccl.tiempodam.ViewModel.ClimaDetailViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityDetailScreen(
    viewModel : ClimaDetailViewModel = viewModel(),
    onBackClick: () -> Unit
){
    val cityName by viewModel.cityName.collectAsState()
    val cityTemperature by viewModel.cityTemperature.collectAsState()
    // Controlar el Scroll de la ventana para la MediumTopAppBar, memoriza el movimiento para saber donde está
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    Scaffold(
        modifier = Modifier.fillMaxSize()
                            .nestedScroll(scrollBehavior.nestedScrollConnection), // asi conectamos el scrollBehavior con nuestra ventana
        topBar = {
            MediumTopAppBar( // Al hacer scroll se mueve hacia arriba
                title = {
                    Text(text = "Clima en $cityName")
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBackClick
                    ) {
                        Icon(imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = "")
                    }
                },
                // Referenciar al TopAppBar el scroll
                scrollBehavior = scrollBehavior
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding)
        ) {
            items(50){
                Text(text = "La temperatura es de $cityTemperature ºC")
            }

        }
    }
}