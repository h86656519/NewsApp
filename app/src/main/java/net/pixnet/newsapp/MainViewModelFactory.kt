package net.pixnet.newsapp

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import net.pixnet.newsapp.repo.NewsRepository

class MainViewModelFactory(private val application: Application,
                           private val repo: NewsRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(application,repo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}