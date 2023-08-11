package com.example.lazylistcolumnui_with_viewmodle

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.in_demand_app.data.Note
import com.example.in_demand_app.viewModel.BucketViewModel
import com.example.lazylistcolumnui_with_viewmodle.ui.theme.LazyListColumnUI_With_ViewModleTheme

class MainActivity : ComponentActivity() {
    //new view model
    //init view modle
    private val bucketViewModle : BucketViewModel by viewModels()

    //new view model
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyListColumnUI_With_ViewModleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    //SignUp_Screen()
                    //SignIn_Screen()
                    Surface(
                        // on below line we are specifying modifier and color for our app
                        modifier = Modifier.fillMaxSize(),

                        )
                    {
                        //new view modle
                        HomeScreen(getString(R.string.app_name))
                        //new view modle

                        // mapUI(LocalContext.current)
                    }
                    // on below line we are calling method to display UI
                }
            }
        }
    }



    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    fun HomeScreen (name: String){
        Scaffold(
            floatingActionButton = {
                ExtendedFloatingActionButton(
                    text = { "Add Random note" },
                    icon = { Icon(Icons.Filled.Add, contentDescription = "Add Random note") },
                    onClick = {
                        bucketViewModle.addRandomNote()
                    })
            }
        ) {
            createLazyListColumnUI(bucketViewModle.notes)
        }
    }
    @Composable
    private fun createLazyListColumnUI(notes: List<Note>) {
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(10.dp), verticalArrangement = Arrangement.spacedBy(5.dp)
        ){
            //now update ui and add description field
            // now Add background color to item
         items(notes)
             {
                     item ->  Column (
                 modifier = Modifier.background(Color.Cyan)
             ){
                 Text(text = item.title)
                 Spacer(modifier = Modifier.height(10.dp))
                 Text(text = item.description)
             }
             }

        }
    }

    @Composable
    @Preview
    fun HomeScreenPreview () {
        HomeScreen("Bucket List")
    }
}
