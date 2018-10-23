package tserr.redditclient

enum class ViewType {
    NEWS, LOADING
}


interface ViewItem {
    fun getViewType(): ViewType
}

data class NewsItem(
        val title: String,
        val author: String,
        val subReddit: String,
        val postDate: Long,
        val thumbnail: String,
        val numComments: Int,
        val rating: Int,
        val url: String,
        val link: String
): ViewItem {
    override fun getViewType() = ViewType.NEWS
}

object LoadingItem: ViewItem {
    override fun getViewType() = ViewType.LOADING

}

data class NewsModel(
    val newsList: List<NewsItem>? = null,
    val after: String = ""
)