package com.example.dropdownsapp.ui.views

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DropdownFieldView(
    label: String,
    optionList: List<String>,
    expanded: Boolean,
    selectedOption: String,
    onExpandedChange: (Boolean) -> Unit,
    onDismissRequest: () -> Unit,
    onOptionClick: (String) -> Unit,
) {
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = onExpandedChange,
        modifier = Modifier.fillMaxWidth(),
    ) {
        TextField(
            value = selectedOption,
            onValueChange = {},
            readOnly = true,
            label = { Text(text = label) },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded,
                )
            },
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = onDismissRequest,
        ) {
            optionList.forEach { brand ->
                DropdownMenuItem(
                    onClick = { onOptionClick(brand) },
                ) { Text(text = brand) }
            }
        }
    }
}
