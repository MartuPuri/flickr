package com.masacre.flickr.activities

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun contributePhotoListActivity(): PhotoListActivity?
}