package com.example.dropdownsapp.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DropdownView(
    modifier: Modifier = Modifier,
) {
    val dropdownValues = mapOf(
        "Toyota" to listOf("Camry", "Corolla", "Sequoia"),
        "Honda" to listOf("Civic", "Fit"),
        "BMW" to listOf("X1", "X2", "X3"),
    )

    var selectedBrand by rememberSaveable { mutableStateOf("") }

    var selectedModel by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxSize().padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        DropdownBrandView(
            brandList = dropdownValues.map { it.key },
            selectedBrand = selectedBrand,
        ) { brand ->
            selectedBrand = brand
            selectedModel = ""
        }

        DropdownModelView(
            modelList = dropdownValues[selectedBrand]?.toList() ?: emptyList(),
            selectedModel = selectedModel,
        ) { model ->
            selectedModel = model
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDropdown() {
    DropdownView()
}
