package david.logan.androidcodingchallenge.proxy

import android.util.Log
import david.logan.androidcodingchallenge.entity.Book
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BookService {

    companion object {
        private const val TAG = "BookService"

        @Volatile
        private var INSTANCE: BookService? = null
        fun getInstance() =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: BookService().also {
                    INSTANCE = it
                }
            }
    }

    fun getBooks(req: GetBooksRequest)  {
        BookServiceApi.create().getBooks().enqueue(object : Callback<List<Book>> {
            override fun onResponse(call: Call<List<Book>>, response: Response<List<Book>>) {
                if (response.isSuccessful) {
                    req.getResponseCallback().onDataReceived(response.body()!!)
                } else {
                    Log.e(TAG, String.format("Get Books request with: %s", response.message()))
                }
            }

            override fun onFailure(call: Call<List<Book>>, t: Throwable) {
                Log.e(TAG, String.format("Get Books request failed with: %s", t.toString()))
                req.getResponseCallback().onDataFailure(t.localizedMessage)
            }
        })
    }
}