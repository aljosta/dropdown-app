package com.example.dropdownsapp.ui.views

import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.res.stringResource
import com.example.dropdownsapp.R

@Composable
fun DropdownBrandView(
    brandList: List<String>,
    selectedBrand: String,
    onOptionClick: (String) -> Unit,
) {
    var expanded by rememberSaveable { mutableStateOf(false) }

    DropdownFieldView(
        label = stringResource(id = R.string.label_dropdown_brand),
        optionList = brandList,
        expanded = expanded,
        selectedOption = selectedBrand,
        onExpandedChange = { expanded = !expanded },
        onDismissRequest = { expanded = false },
        onOptionClick = { brand ->
            expanded = false
            onOptionClick(brand)
        },
    )
}
