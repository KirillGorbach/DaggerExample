package com.hogriders.daggerexample.di.module

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