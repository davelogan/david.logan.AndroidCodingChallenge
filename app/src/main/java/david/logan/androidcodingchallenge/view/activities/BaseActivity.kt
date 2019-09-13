package david.logan.androidcodingchallenge.view.activities

import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import david.logan.androidcodingchallenge.view.BaseView

abstract class BaseActivity : AppCompatActivity(), BaseView {

    override fun showProgress(isShow: Boolean) {
        val pb = getProgressBar()
        pb?.let{ progressBar ->
            progressBar.visibility = if (isShow) View.VISIBLE else View.GONE
        }
    }

    override fun showErrorMessage(message: String?) {
        message.let { msg ->
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }
    }
}