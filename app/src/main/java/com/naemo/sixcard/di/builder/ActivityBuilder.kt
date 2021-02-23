package com.naemo.sixcard.di.builder

import com.naemo.sixcard.views.main.MainActivity
import com.naemo.sixcard.views.main.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun contributeMainActivity(): MainActivity

}