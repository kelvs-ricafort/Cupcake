package com.kelvsricafort101.wordpress.cupcake

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import kotlinx.coroutines.launch

@Composable
fun CupcakeNavigationDrawer(
    currentScreen: CupcakeScreen,
    drawerState: DrawerState,
    onNavigate: (CupcakeScreen) -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,

) {
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = modifier
                    .width(dimensionResource(R.dimen.drawer_size))
                    .fillMaxHeight()
            ) {
                Spacer(modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_large)))
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier
                        .padding(
                            horizontal = dimensionResource(R.dimen.horizontal_padding),
                            vertical = dimensionResource(R.dimen.vertical_padding)
                        )
                )
                NavigationDrawerItem(
                    label = { Text(text = stringResource(R.string.home)) },
                    selected = currentScreen == CupcakeScreen.Start,
                    icon = {
                        Icon(
                           imageVector = Icons.Default.Home,
                            contentDescription = stringResource(R.string.home)
                        )
                    },
                    onClick = {
                        scope.launch {
                            drawerState.close()
                        }
                        onNavigate(CupcakeScreen.Start)
                    },
                    modifier = Modifier.padding(
                        horizontal = dimensionResource(R.dimen.horizontal_arrangement)
                    )
                )
                NavigationDrawerItem(
                    label = { Text(text = stringResource(R.string.about_app)) },
                    selected = currentScreen == CupcakeScreen.About,
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = stringResource(R.string.about_app)
                        )
                    },
                    onClick = {
                        scope.launch {
                            drawerState.close()
                        }
                        onNavigate(CupcakeScreen.About)
                    },
                    modifier = Modifier.padding(
                        horizontal = dimensionResource(R.dimen.horizontal_arrangement)
                    )
                )
            }
        }
    ) {
        content()
    }
}