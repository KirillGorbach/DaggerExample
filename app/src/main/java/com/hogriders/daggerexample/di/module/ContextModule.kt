package com.hogriders.daggerexample.di.module

import android.content.Context
import com.hogriders.daggerexample.di.qualifier.ApplicationContext
import com.hogriders.daggerexample.di.scope.DaggerApplicationScope
import dagger.Module
import dagger.Provides

@Module
class ContextModule (private val context: Context) {

    @ApplicationContext
    @DaggerApplicationScope
    @Provides
    fun context(): Context = context.applicationContext
}