package com.naemo.sixcard.api.repo

import android.app.Application
import android.content.Context
import com.naemo.sixcard.api.models.BinList
import com.naemo.sixcard.api.network.Client
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class Repository(application: Application) : CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    private val context: Context? = null
    var client = Client()
    @Inject set



}

