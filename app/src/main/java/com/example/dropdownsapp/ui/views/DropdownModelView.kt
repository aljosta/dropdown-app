package com.example.dropdownsapp.ui.views

import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.res.stringResource
import com.example.dropdownsapp.R

@Composable
fun DropdownModelView(
    modelList: List<String>,
    selectedModel: String,
    onOptionClick: (String) -> Unit,
) {
    var modelExpanded by rememberSaveable { mutableStateOf(false) }

    DropdownFieldView(
        label = stringResource(id = R.string.label_dropdown_model),
        optionList = modelList,
        expanded = modelExpanded,
        selectedOption = selectedModel,
        onExpandedChange = { modelExpanded = !modelExpanded },
        onDismissRequest = { modelExpanded = false },
        onOptionClick = { model ->
            modelExpanded = false
            onOptionClick(model)
        },
    )
}
