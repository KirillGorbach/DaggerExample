package com.hogriders.daggerexample.di.module

import android.app.Activity
import android.content.Context
import com.hogriders.daggerexample.di.qualifier.ActivityContext
import com.hogriders.daggerexample.di.scope.DaggerApplicationScope
import dagger.Module
import dagger.Provides

@Module
class ActivityModule (private val context: Activity) {
    @ActivityContext
    @DaggerApplicationScope
    @Provides
    fun context(): Context = context
}