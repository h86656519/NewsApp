package net.pixnet.newsapp

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import net.pixnet.newsapp.Model.NewRespondModel
import net.pixnet.newsapp.repo.NewsRepository
import org.junit.Test

import org.junit.Assert.*
import java.sql.Timestamp
import java.time.Instant
import java.time.ZoneId

import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun filterTest() {
        val numbers = listOf(1, 2, 3, 4, 5, 6, 7)
        val firstOdd = numbers.find { it % 2 != 0 }
        val lastEven = numbers.findLast { it % 2 == 0 }

        println("firstOdd $firstOdd")
        println("lastEven $lastEven")
    }

    @Test
    fun converTimstamp() {
//        val stamp = Timestamp(1639449799)
//        val date = Date(stamp.time)
//        println(date)

        val dt = Instant.ofEpochSecond(1639449799)
            .atZone(ZoneId.systemDefault())
            .toLocalDateTime()

        println("dt $dt")
    }

    @Test
    fun getNewsDate() {
        val weatherDisposable =
            NewsRepository().fetchRemoteNews().news()
                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
                .doFinally { println("新聞資料") }
                .subscribe({ model: NewRespondModel ->
                    println("資料回來了 ${model.getVector.items[1].items[1].appearance.mainTitle}")
//                    val newModel: NewRespondModel = model.getVector.items.first { it.type == "news" }

                }) { e: Throwable? ->
                    println("新聞資料取得失敗 $e")
                }

    }
}