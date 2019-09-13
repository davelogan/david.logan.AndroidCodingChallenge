package david.logan.androidcodingchallenge.proxy

interface BaseResponseCallback<T> {
    fun onDataReceived(data: T?)

    fun onDataFailure(error: String?)
}