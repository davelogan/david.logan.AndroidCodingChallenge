package david.logan.androidcodingchallenge.entity

import david.logan.androidcodingchallenge.proxy.BaseResponseCallback

interface BookRepository {

    fun getBooks(callback: BaseResponseCallback<List<Book>>)

}