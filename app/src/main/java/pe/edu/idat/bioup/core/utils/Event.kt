package pe.edu.idat.bioup.core.utils

class Event<out T> (private val content: T) {
    var hasBeenHandled = false
        private set

    fun getContentNotChange(): T?{
        return if (hasBeenHandled){
            null
        }else {
            hasBeenHandled = true
            content
        }
    }
}