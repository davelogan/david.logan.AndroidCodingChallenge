package david.logan.androidcodingchallenge.proxy

interface BaseRequest<T> {
    fun getResponseCallback(): BaseResponseCallback<T>
}