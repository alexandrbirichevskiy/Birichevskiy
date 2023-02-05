package ru.alexandrbirichevskiy.mykinopoiskfintech.domain.network

import androidx.paging.PagingSource
import androidx.paging.PagingState
import retrofit2.HttpException
import ru.alexandrbirichevskiy.mykinopoiskfintech.domain.responses.FilmResponse

class PopularMoviesPagingSource(
    private val api: PopularMoviesApi
) : PagingSource<Int, FilmResponse>() {

    override fun getRefreshKey(state: PagingState<Int, FilmResponse>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
        return page.prevKey?.plus(1) ?: page.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, FilmResponse> {
        val page: Int = params.key ?: 1
        val response = api.getPopularMovies(page = page)

        return if (response.isSuccessful) {
            val movies = response.body()?.films ?: listOf()
            val nextKey =
                if (movies.size < 20 || page == response.body()?.pagesCount) null else page + 1
            val prevKey = if (page == 1) null else page - 1

            LoadResult.Page(movies, prevKey, nextKey)
        } else {
            LoadResult.Error(HttpException(response))
        }
    }
}