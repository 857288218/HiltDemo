package com.example.hiltdemo

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

class MyViewModel @ViewModelInject constructor(app: Application, val repository: Repository) : AndroidViewModel(app) {


}