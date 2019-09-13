package david.logan.androidcodingchallenge.presenter

import david.logan.androidcodingchallenge.contract.MainContract
import david.logan.androidcodingchallenge.entity.Book
import david.logan.androidcodingchallenge.interactor.MainInteractor

class MainPresenter (private var view: MainContract.View) : MainContract.Presenter, MainContract.InteractorOutput {

    private var interactor: MainContract.Interactor =
        MainInteractor(this)

    override fun onViewResumed() {
        view.showProgress(true)
        interactor.loadBooks()
    }

    override fun onBookSelected(book: Book?) {
        //TODO show a detailed view for this book
    }

    override fun onViewPaused() {
        // no opp
    }

    override fun onViewStopped() {
        // no opp
    }

    override fun onViewStarted() {
        // no opp
    }

    override fun loadBooksSuccessful(books: List<Book>) {
        view.showProgress(false)
        view.displayBooks(books)
    }

    override fun loadBooksFailed(errorMsg: String?) {
        view.showProgress(false)
        view.showErrorMessage(errorMsg)
    }
}