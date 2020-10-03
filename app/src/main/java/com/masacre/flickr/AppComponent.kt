package com.masacre.flickr

import com.masacre.flickr.activities.ActivityModule
import com.masacre.flickr.networking.NetworkingModule
import com.masacre.flickr.viewmodel.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, ActivityModule::class, NetworkingModule::class, ViewModelModule::class])
interface AppComponent : AndroidInjector<DaggerApplication>