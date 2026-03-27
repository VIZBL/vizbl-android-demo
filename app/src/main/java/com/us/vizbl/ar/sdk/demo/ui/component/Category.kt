package com.us.vizbl.ar.sdk.demo.ui.component

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.us.vizbl.ar.sdk.demo.R
import com.us.vizbl.ar.sdk.demo.ui.component.button.VizblLinkButton
import com.us.vizbl.ar.sdk.demo.ui.theme.AppTheme

@Composable
fun VizblCategory(
    modifier: Modifier = Modifier,
    isShowBackground: Boolean = true,
    @StringRes category: Int,
    content: @Composable () -> Unit
) {
    Column {
        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = stringResource(category),
            fontWeight = FontWeight.Medium,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.secondary
        )
        Spacer(Modifier.height(8.dp))

        if (isShowBackground) {
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(24.dp))
                    .background(MaterialTheme.colorScheme.secondary)
            ) {
                content()
            }
        } else {
            content()
        }
    }
}

@Preview
@Composable
private fun CategoryPreview_Light() {
    AppTheme(darkTheme = false) {
        Column {
            for (i in (0..3)) {
                VizblCategory(category = R.string.main_getting_started_category) {
                    VizblLinkButton(
                        title = stringResource(R.string.main_shop_preview_title),
                        subtitle = stringResource(R.string.main_shop_preview_body)
                    ) {
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun CategoryPreview_Night() {
    AppTheme(darkTheme = true) {
        Column {
            for (i in (0..3)) {
                VizblCategory(category = R.string.main_getting_started_category) {
                    VizblLinkButton(
                        title = stringResource(R.string.main_shop_preview_title),
                        subtitle = stringResource(R.string.main_shop_preview_body)
                    ) {
                    }
                }
            }
        }
    }
}