package com.raywenderlich.android.droidwiki.dagger

import com.raywenderlich.android.droidwiki.utils.Const
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class NetworkModule{
    companion object{
        private const val NAME_BASE_URL = "NAME_BASE_URL"

    }
    @Provides
    @Named(NAME_BASE_URL)
    fun provideBaseUrlString()= "${Const.PROTOCOL}://${Const.LANGUAGE}.${Const.BASE_URL}"

}