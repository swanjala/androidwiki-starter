
package com.raywenderlich.android.droidwiki.ui.search

import com.raywenderlich.android.droidwiki.model.SearchResult
import com.raywenderlich.android.droidwiki.network.Wiki
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject

class EntryPresenterImpl @Inject constructor(private val wiki:Wiki) : EntryPresenter {

  private lateinit var entryView: EntryView

  override fun setView(entryView: EntryView) {
    this.entryView = entryView
  }

  override fun getEntry(query: String) {
    entryView.displayLoading()
    wiki.search(query).enqueue(object : Callback {
      override fun onResponse(call: Call, response: Response) {
        entryView.dismissLoading()

        if (response?.isSuccessful == true) {
          SearchResult(response).list?.let {
            entryView.displayEntries(it)
          }
        } else {
          entryView.displayError(response?.message)
        }
      }

      override fun onFailure(call: Call, t: IOException) {
        entryView.displayError(t?.message)
        t?.printStackTrace()
      }
    })

  }
}