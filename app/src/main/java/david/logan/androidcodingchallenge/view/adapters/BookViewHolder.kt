package david.logan.androidcodingchallenge.view.adapters

import androidx.recyclerview.widget.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import david.logan.androidcodingchallenge.R
import david.logan.androidcodingchallenge.entity.Book
import kotlinx.android.synthetic.main.book_list_item.view.*

class BookViewHolder (parent: ViewGroup) : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(
    R.layout.book_list_item, parent, false)) {

    fun bindTo(book: Book?) {

        val imageUrl = book?.imageURL
        imageUrl?.let {
            if (it.isNotEmpty()) {
                Glide.with(itemView)
                    .load(it)
                    .into(itemView.book_list_item_image)

            }
        }

        itemView.book_list_item_title.text = book?.title ?: ""

        val author = book?.author
        if (author != null) {
            itemView.book_list_item_author.text = String.format("Author: %s", author)
            itemView.book_list_item_author.visibility = View.VISIBLE
        } else {
            itemView.book_list_item_author.visibility = View.GONE
        }

    }
}