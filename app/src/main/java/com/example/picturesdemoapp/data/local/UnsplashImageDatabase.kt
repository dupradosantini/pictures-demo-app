package com.example.picturesdemoapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.picturesdemoapp.data.local.dao.UnsplashImageDao
import com.example.picturesdemoapp.data.local.dao.UnsplashRemoteKeysDao
import com.example.picturesdemoapp.model.UnsplashImage
import com.example.picturesdemoapp.model.UnsplashRemoteKeys

@Database(entities = [UnsplashImage::class, UnsplashRemoteKeys::class], version = 1)
abstract class UnsplashImageDatabase: RoomDatabase(){

    abstract fun UnsplashImageDao(): UnsplashImageDao

    abstract fun UnsplashRemoteKeysDao(): UnsplashRemoteKeysDao

}