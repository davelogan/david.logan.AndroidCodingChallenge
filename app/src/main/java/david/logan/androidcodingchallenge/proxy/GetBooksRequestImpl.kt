package david.logan.androidcodingchallenge.proxy

import david.logan.androidcodingchallenge.entity.Book

class GetBooksRequestImpl(private val callback: BaseResponseCallback<List<Book>>) :
    GetBooksRequest {

    override fun getResponseCallback(): BaseResponseCallback<List<Book>> {
        return callback
    }
}