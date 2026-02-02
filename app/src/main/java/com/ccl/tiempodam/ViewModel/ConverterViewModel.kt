package com.ccl.tiempodam.ViewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ConverterViewModel : ViewModel() {
    // El input del usuario
    // Variable privada dentro del ViewModel que se puede modificar
    private val _celsiusInput = MutableStateFlow("")
    // Version pública e INMUTABLE que la UI escucha
    val celsiusInput = _celsiusInput.asStateFlow()

    // Guardamos el resultado del calculo
    private val _fahremheitResult = MutableStateFlow(0.0)
    val fahremheitResult = _fahremheitResult.asStateFlow()

    fun onCelsiusChange(newInput: String){
        _celsiusInput.value = newInput
        converter(newInput)
    }

    private fun converter(input : String){
        val celsius  = input.toDoubleOrNull()
        if (celsius != null)
        {
            _fahremheitResult.value = (celsius * 1.8) + 32
        }else{
            _fahremheitResult.value = 0.0
        }
    }

}