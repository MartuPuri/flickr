package com.masacre.flickr

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class FlickerApplication: DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()

        appComponent.inject(this)

        return appComponent
    }
}