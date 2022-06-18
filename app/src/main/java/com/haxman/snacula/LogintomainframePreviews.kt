package com.haxman.snacula

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.haxman.snacula.ui.theme.SnaculaTheme



@Preview(showBackground = true)
@Composable
fun TitlePreview() {
    SnaculaTheme {
        NewTitle()
    }
}

@Preview(showBackground = true)
@Composable
fun TextFieldPreview() {
    SnaculaTheme {
        //InputField(TextFieldValue(""))
    }
}