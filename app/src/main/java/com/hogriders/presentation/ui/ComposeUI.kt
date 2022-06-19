package com.hogriders.presentation.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hogriders.domain.model.User
import com.hogriders.presentation.vm.MainActivityViewModel

@Composable
fun  MainScreen(viewModel: MainActivityViewModel){
    val users = viewModel.c_users
     LazyColumn {
        items(users) { user ->
            UserView(user)
            Spacer(modifier = Modifier.height(2.dp))
        }
     }
}

@Composable
fun UserView(user: User) {
    Row {
        Text(text = user.id.toString())
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = user.name)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = user.age.toString())
    }
}