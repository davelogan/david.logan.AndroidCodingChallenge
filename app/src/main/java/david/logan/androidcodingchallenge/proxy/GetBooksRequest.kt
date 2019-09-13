package david.logan.androidcodingchallenge.proxy

import david.logan.androidcodingchallenge.entity.Book


interface GetBooksRequest: BaseRequest<List<Book>> {

    override fun getResponseCallback(): BaseResponseCallback<List<Book>>

}