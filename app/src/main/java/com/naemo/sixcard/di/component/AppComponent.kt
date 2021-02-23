package com.naemo.sixcard.di.component

import android.app.Application
import com.naemo.SixCard
import com.naemo.sixcard.di.builder.ActivityBuilder
import com.naemo.sixcard.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidSupportInjectionModule::class), (AppModule::class), (ActivityBuilder::class)])
interface AppComponent {

    fun inject(sixCard: SixCard)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application) : Builder

        fun build(): AppComponent
    }

}