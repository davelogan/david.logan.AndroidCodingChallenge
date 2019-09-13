package david.logan.androidcodingchallenge.interactor

import david.logan.androidcodingchallenge.contract.MainContract
import david.logan.androidcodingchallenge.entity.Book
import david.logan.androidcodingchallenge.entity.BookRepositoryImpl
import david.logan.androidcodingchallenge.proxy.BaseResponseCallback

class MainInteractor(private val outputContract: MainContract.InteractorOutput) : MainContract.Interactor {

    override fun loadBooks() {
        BookRepositoryImpl.getInstance().getBooks(object: BaseResponseCallback<List<Book>> {
            override fun onDataReceived(data: List<Book>?) {
                if (data!=null) {
                    outputContract.loadBooksSuccessful(data)
                } else {
                    outputContract.loadBooksFailed("No data received")
                }
            }

            override fun onDataFailure(error: String?) {
                outputContract.loadBooksFailed(error)
            }
        })
    }
}