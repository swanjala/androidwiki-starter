package com.raywenderlich.android.droidwiki.application

import android.app.Application
import com.raywenderlich.android.droidwiki.dagger.AppComponent
import com.raywenderlich.android.droidwiki.dagger.AppModule
import com.raywenderlich.android.droidwiki.dagger.DaggerAppComponent

class WikiApplication : Application() {

  lateinit var appComponent:AppComponent


  override fun onCreate() {
    super.onCreate()
   appComponent = initDagger(this)

    //wikiComponent = DaggerAppComponent.create()

  }

  private fun initDagger(application:WikiApplication): AppComponent =
          DaggerAppComponent.builder()
                  .appModule(AppModule(application))
                  .build()
}