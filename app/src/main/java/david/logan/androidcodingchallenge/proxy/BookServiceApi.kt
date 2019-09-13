package david.logan.androidcodingchallenge.proxy

import david.logan.androidcodingchallenge.entity.Book
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.Call

interface BookServiceApi {

    companion object Factory {
        fun create(): BookServiceApi {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://de-coding-test.s3.amazonaws.com")
                .build()

            return retrofit.create(BookServiceApi::class.java)
        }
    }

    @GET("/books.json")
    fun getBooks(): Call<List<Book>>

}