package david.logan.androidcodingchallenge.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import david.logan.androidcodingchallenge.R
import david.logan.androidcodingchallenge.contract.MainContract
import david.logan.androidcodingchallenge.entity.Book
import david.logan.androidcodingchallenge.presenter.MainPresenter
import david.logan.androidcodingchallenge.view.adapters.BookListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), MainContract.View, BookListAdapter.BookListListener {

    private lateinit var pBar: ProgressBar

    private val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pBar = activity_main_pb

        activity_main_book_list.adapter = BookListAdapter(this, null)

        activity_main_book_list.addItemDecoration(
            DividerItemDecoration(activity_main_book_list.context,
                LinearLayoutManager.VERTICAL)
        )
    }

    override fun onStart() {
        super.onStart()
        presenter.onViewStarted()
    }

    override fun onStop() {
        super.onStop()
        presenter.onViewStopped()
    }

    override fun onPause() {
        super.onPause()
        presenter.onViewPaused()
    }

    override fun onResume() {
        super.onResume()
        presenter.onViewResumed()
    }

    override fun displayBooks(books: List<Book>) {
        (activity_main_book_list.adapter as BookListAdapter).updateData(books)
    }

    override fun getProgressBar(): ProgressBar? {
        return pBar
    }

    override fun bookItemSelected(book: Book?) {
        presenter.onBookSelected(book)
    }
}
