package david.logan.androidcodingchallenge.view

import android.widget.ProgressBar

interface BaseView {

    fun getProgressBar(): ProgressBar?
    fun showProgress(isShow: Boolean)
    fun showErrorMessage(message: String?)
}