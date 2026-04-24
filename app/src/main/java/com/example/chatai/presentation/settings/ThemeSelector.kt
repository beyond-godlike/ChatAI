package com.example.chatai.presentation.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.chatai.presentation.ui.theme.ThemeMode
import com.example.chatai.presentation.ui.theme.ThemeState

@Composable
fun ThemeSelector() {

    Column {
        ThemeOption("System", ThemeMode.SYSTEM)
        ThemeOption("Light", ThemeMode.LIGHT)
        ThemeOption("Dark", ThemeMode.DARK)
    }
}
@Composable
fun ThemeOption(title: String, mode: ThemeMode) {

    val selected = ThemeState.mode == mode

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { ThemeState.mode = mode }
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        RadioButton(
            selected = selected,
            onClick = { ThemeState.mode = mode }
        )

        Text(text = title)
    }
}