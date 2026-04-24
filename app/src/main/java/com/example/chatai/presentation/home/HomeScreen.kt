@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.chatai.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.chatai.presentation.chat.ChatState
import com.example.chatai.presentation.chat.MessagesScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    //val viewModel: HomeViewModel = hiltViewModel()
    //val state by viewModel.state.collectAsState(remember { HomeScreenState.Idle })

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = { Text("Home") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        },
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(MaterialTheme.colorScheme.background)
        ) {
            Home(paddingValues, navController)
            //when (chatState) {
            //    is ChatState.Empty -> MessagesScreen(viewModel, emptyList(), paddingValues)
            //    is ChatState.Success -> {
            //        val successState = chatState as ChatState.Success
            //        MessagesScreen(viewModel, successState.messages, paddingValues)
            //    }
            //    is ChatState.Error -> {}
            // }
        }

    }

}

@Composable
fun Home(paddingValues: PaddingValues, navController: NavController) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
    ) {
        Button(onClick = {
            navController.navigate("chat")
        }) {
            Text("Go to Chat")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            navController.navigate("settings")
        }) {
            Text("Go to Settings")
        }
    }
}