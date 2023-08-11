package com.example.in_demand_app.viewModel

import android.provider.ContactsContract.Data
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.in_demand_app.data.Note
import java.util.Date

class BucketViewModel : ViewModel() {
    public val notes = mutableStateListOf<Note>()

    public fun addRandomNote(){
        notes.add(Note("Note add ${notes.size}", description = Date().toLocaleString()))
    }
}