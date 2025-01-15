package com.example.pmdm_persistencia.Screens.login

import android.widget.CompoundButton.OnCheckedChangeListener
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RememberMe(checked:Boolean,onCheckedChange:(Boolean) -> Unit){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { onCheckedChange(!checked) }
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = { onCheckedChange(it) },
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Black,  // Color para el estado marcado
                uncheckedColor = Color.Black,  // Color para el estado desmarcado
                checkmarkColor = Color.White   // Color de la marca (✔)
            )
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Remember Me", style = MaterialTheme.typography.bodyLarge, color = Color.Black)
    }
}