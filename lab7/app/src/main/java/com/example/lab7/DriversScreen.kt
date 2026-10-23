package com.example.lab7

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun DriversScreen(navController: NavController) {
    var driverNames by remember {
        mutableStateOf("")
    }

    var drivers = remember {
        mutableStateListOf<String>()
    }
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Button(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier.testTag("backButton") // for testing
        ) {
            Text("Back to home")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // title text
        Text(
            text = "FormulaZero Drivers",
            fontSize = 30.sp
        )

        // input
        TextField(
            value = driverNames,
            onValueChange = {
                driverNames = it // update driver
                },
                label = {
                    Text("Enter driver's name")
                },
                modifier = Modifier.testTag("driverInput") // for testing
            )

        // add driver
        Button(
            onClick = {
                if (driverNames.isNotBlank()) {
                    drivers.add(driverNames)
                    driverNames = ""
                }
            },
            modifier = Modifier.testTag("addDriverButton") // for testing
        ) {
            Text("Add")
        }

        // clear drivers
        Button(
            onClick = {
                drivers.clear()
            },
            modifier = Modifier.testTag("clearDriversButton")
        ) {
            Text("Clear All Drivers")
        }

        Text("Drivers List")

        // display drivers
        LazyColumn {
            items(drivers) { driver ->
                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = driver,
                    fontSize = 24.sp
                )
            }
        }

    }
}
