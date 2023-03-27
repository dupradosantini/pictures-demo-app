package com.example.picturesdemoapp.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.picturesdemoapp.data.local.UnsplashImageDatabase
import com.example.picturesdemoapp.data.paging.UnsplashRemoteMediator
import com.example.picturesdemoapp.data.remote.UnsplashApi
import com.example.picturesdemoapp.model.UnsplashImage
import com.example.picturesdemoapp.util.Constants.ITEMS_PER_PAGE
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val unsplashApi: UnsplashApi,
    private val unsplashImageDatabase: UnsplashImageDatabase
) {
    @OptIn(ExperimentalPagingApi::class)
    fun getAllImages(): Flow<PagingData<UnsplashImage>> {
        val pagingSourceFactory = { unsplashImageDatabase.unsplashImageDao().getAllImages() }
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            remoteMediator = UnsplashRemoteMediator(
                unsplashApi = unsplashApi,
                unsplashImageDatabase = unsplashImageDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }
}