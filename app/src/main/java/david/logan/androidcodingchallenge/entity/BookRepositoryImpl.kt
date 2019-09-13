package david.logan.androidcodingchallenge.entity

import david.logan.androidcodingchallenge.proxy.BookService
import david.logan.androidcodingchallenge.proxy.BaseResponseCallback
import david.logan.androidcodingchallenge.proxy.GetBooksRequestImpl

class BookRepositoryImpl : BookRepository {

    companion object {
        @Volatile
        private var INSTANCE: BookRepository? = null
        fun getInstance() =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: BookRepositoryImpl().also {
                    INSTANCE = it
                }
            }
    }

    override fun getBooks(callback: BaseResponseCallback<List<Book>>) {
        BookService.getInstance().getBooks(GetBooksRequestImpl(object: BaseResponseCallback<List<Book>> {
            override fun onDataReceived(data: List<Book>?) {
                callback.onDataReceived(data)
            }
            override fun onDataFailure(error: String?) {
                callback.onDataFailure(error)
            }
        }))
    }
}