package net.pixnet.newsapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import net.pixnet.newsapp.Model.Item
import net.pixnet.newsapp.Model.NewRespondModel
import net.pixnet.newsapp.repo.NewsRepository

class MainViewModel(application: Application, private val repo: NewsRepository) :
    AndroidViewModel(application) {

    private val compositeDisposable = CompositeDisposable()

    private val newsLiveData = MutableLiveData<List<Item>>()

    fun getNewsDate() {
        val weatherDisposable =
            repo.fetchRemoteNews().news()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally { println("新聞資料") }
                .subscribe({ model: NewRespondModel ->
                   val newList =  model.getVector.items.filter {
                       it.type == "news" || it.type == "divider"
                   }
                    println("newList $newList")
                    newsLiveData.value = newList
                }) { e: Throwable? ->
                    println("新聞資料取得失敗 $e")
                }
        compositeDisposable.add(weatherDisposable)
    }

    fun getNewsLiveData(): MutableLiveData<List<Item>> {
        return newsLiveData
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}