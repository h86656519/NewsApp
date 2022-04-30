package net.pixnet.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import net.pixnet.newsapp.R
import net.pixnet.newsapp.databinding.ActivityMainBinding
import net.pixnet.newsapp.repo.NewsRepository

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        viewModel = ViewModelProvider(
            this,
            MainViewModelFactory(application,NewsRepository())
        ).get(MainViewModel::class.java)

        initView()

        viewModel.getNewsDate()
    }

    private fun initView() {
        val linearLayoutManager = LinearLayoutManager(
            this,
            RecyclerView.VERTICAL, false
        )

        binding!!.rvNews.layoutManager = linearLayoutManager
        val adapter = NewsAdapter()
        binding!!.rvNews.adapter = adapter

        viewModel.getNewsLiveData().observe(this) {
            adapter.updateList(it)
        }
    }
}