package net.pixnet.newsapp.http

import io.reactivex.rxjava3.core.Observable
import net.pixnet.newsapp.Model.NewRespondModel
import retrofit2.http.GET

interface NewsApi {

    @GET("/interview/interview_get_vector.json")
    fun news(): Observable<NewRespondModel>
}