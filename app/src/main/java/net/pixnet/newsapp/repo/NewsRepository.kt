package net.pixnet.newsapp.repo

import net.pixnet.newsapp.http.ApiManager
import net.pixnet.newsapp.http.NewsApi

class NewsRepository {
    private val apiManager: ApiManager = ApiManager.getInstance()

    fun fetchRemoteNews(): NewsApi {
        return apiManager.getNewsApiRetrofit()
    }
}