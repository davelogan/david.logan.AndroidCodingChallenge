package david.logan.androidcodingchallenge.view.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import david.logan.androidcodingchallenge.entity.Book

class BookListAdapter (private var listener: BookListListener, private var books: List<Book>?) :
    RecyclerView.Adapter<BookViewHolder>() {

    override fun getItemCount() = books?.size ?: 0

    override fun onBindViewHolder(holderListItem: BookViewHolder, position: Int) {
        holderListItem.bindTo(getItem(position))
        holderListItem.itemView.setOnClickListener { listener.bookItemSelected(getItem(position)) }
    }

    private fun getItem(position: Int): Book? {
        return books?.get(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder =
        BookViewHolder(parent)

    fun updateData(books: List<Book>) {
        this.books = books
        this.notifyDataSetChanged()
    }

    interface BookListListener {
        fun bookItemSelected(book: Book?)
    }
}