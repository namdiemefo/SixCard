package com.naemo.sixcard.views.main

import android.app.Application
import androidx.databinding.ObservableField
import com.naemo.sixcard.R
import com.naemo.sixcard.api.models.BinList
import com.naemo.sixcard.api.network.Client
import com.naemo.sixcard.api.repo.Repository
import com.naemo.sixcard.views.base.BaseViewModel
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class MainViewModel(application: Application) : BaseViewModel<MainNavigator>(application), CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Main

    var search = ObservableField("")
    var cardScheme = ObservableField("")
    var cardType = ObservableField("")
    var bank = ObservableField("")
    var country = ObservableField("")
    var cardLength = ObservableField("")
    var prepaid = ObservableField("")

    val repository = Repository(application)

    var client = Client()
        @Inject set


    fun getBin() {

        var cardNumber = search.get().toString()

        if (cardNumber.length < 6) {
            getNavigator()?.showSnackBarMsg("Enter at least 6 digits")
        } else if (cardNumber.length > 8) {
            getNavigator()?.showSnackBarMsg("Card must be at least 8 digits")
        } else {

            var binListCall: Call<BinList> = client.getApi().check(cardNumber.toInt())
            binListCall.enqueue(object : Callback<BinList> {
                override fun onFailure(call: Call<BinList>, t: Throwable) {
                    getNavigator()?.showSnackBarMsg(t.toString())
                }

                override fun onResponse(call: Call<BinList>, response: Response<BinList>) {

                    if (response.isSuccessful || response.code() == 200) {
                        val data = response.body()
                        data?.let { setCard(it) }
                    } else {
                        getNavigator()?.showSnackBarMsg("Something unexpected happened")
                    }
                }

            })

        }

    }

    private fun setCard(it: BinList) {

        cardScheme.set(it.scheme)
        cardType.set(it.type)
        bank.set(it.bank?.name)
        country.set(it.country?.name)
        cardLength.set(it.number?.length.toString())
    }


}

interface MainNavigator {

    fun searchForCardDetails()

    fun showSnackBarMsg(msg: String)


}

@Module
class MainModule {

    @Provides
    fun providesMainViewModel(application: Application): MainViewModel {
        return MainViewModel(application)
    }

    @Provides
    fun layoutId(): Int {
        return R.layout.activity_main
    }

}