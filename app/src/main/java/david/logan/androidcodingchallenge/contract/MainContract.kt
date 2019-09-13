package david.logan.androidcodingchallenge.contract

import david.logan.androidcodingchallenge.entity.Book
import david.logan.androidcodingchallenge.view.BaseView

interface MainContract {

    interface View: BaseView {
        fun displayBooks(books: List<Book>)
    }

    interface Presenter {
        fun onViewResumed()
        fun onViewPaused()
        fun onViewStopped()
        fun onViewStarted()
        fun onBookSelected(book: Book?)
    }

    interface Interactor {
        fun loadBooks()
    }

    interface InteractorOutput {
        fun loadBooksSuccessful(books: List<Book>)
        fun loadBooksFailed(errorMsg: String?)
    }
}