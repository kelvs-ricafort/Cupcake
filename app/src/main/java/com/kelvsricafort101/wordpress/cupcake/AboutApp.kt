package com.kelvsricafort101.wordpress.cupcake

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import com.kelvsricafort101.wordpress.cupcake.ui.theme.CupcakeTheme

@Composable
fun AboutScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(dimensionResource(R.dimen.padding_large)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium))
    ) {
        // App Icon
        Box(
            modifier = Modifier
                .size(dimensionResource(R.dimen.app_icon_size))
                .clip(RoundedCornerShape(dimensionResource(R.dimen.round_small)))
        ) {
            Image(
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = stringResource(R.string.about_app),
                modifier = Modifier.fillMaxSize()
            )
            Image(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = stringResource(R.string.about_app),
                modifier = Modifier.fillMaxSize()
            )
        }
        // App Name
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.headlineSmall
        )

        // App Description
        Text(
            text = stringResource(R.string.about_app_description),
            style = MaterialTheme.typography.bodyLarge
        )
        HorizontalDivider(modifier = Modifier.padding(vertical = dimensionResource(R.dimen.vertical_padding)))

        // App Info
        AboutSection(
            title = stringResource(R.string.app_info)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
            ) {
                val version = BuildConfig.VERSION_NAME
                val build = BuildConfig.VERSION_CODE

                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            SpanStyle(
                                fontWeight = FontWeight.Bold
                            )
                        ) {
                            append(stringResource(R.string.version, "").substringBefore(":").trim())
                            append(": ")
                        }
                        append(version)
                    },
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            SpanStyle(
                                fontWeight = FontWeight.Bold
                            )
                        ) {
                            append(stringResource(R.string.build, 0).substringBefore(":").trim())
                            append(": ")
                        }
                        append(build.toString())
                    },
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        // Developer Info
        AboutSection(
            title = stringResource(R.string.developer_info)
        ) {
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        SpanStyle(
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append(stringResource(R.string.developer, "").substringBefore(":").trim())
                        append(": ")
                    }
                    append(stringResource(R.string.developer_name))
                },
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.fillMaxWidth()
            )
        }

        // Features Section
        AboutSection(
            title = stringResource(R.string.app_features),
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.vertical_arrangement))
            ) {
                FeatureItem(
                    icon = Icons.Default.ShoppingCart,
                    text = stringResource(R.string.feature_order_cupcakes)
                )
                FeatureItem(
                    icon = Icons.Default.Language,
                    text = stringResource(R.string.feature_multiple_language_support)
                )
                FeatureItem(
                    icon = Icons.Default.DarkMode,
                    text = stringResource(R.string.feature_dark_mode_support)
                )
            }
        }
    }
}

@Composable
private fun AboutSection(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleMedium
        )

        content()
    }
}

@Composable
private fun FeatureItem(
    icon: ImageVector,
    text: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.horizontal_arrangement))
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null
        )
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AboutScreenPreview() {
    CupcakeTheme(darkTheme = false) {
        Surface {
            AboutScreen(
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AboutScreenDarkPreview() {
    CupcakeTheme(darkTheme = true) {
        Surface {
            AboutScreen(
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
