package com.hogriders.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class ContextModule(private val appContext: Context) {
    @Provides
    @Singleton
    fun providesContext(): Context = appContext
}