package com.naemo.sixcard.di.module

import android.app.Application
import android.content.Context
import com.naemo.sixcard.api.network.Client
import com.naemo.sixcard.utils.AppUtils
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    @Singleton
    @Provides
    fun provideClient(): Client {
        return Client()
    }

    @Singleton
    @Provides
    fun providesAppUtils(): AppUtils {
        return AppUtils()
    }

}