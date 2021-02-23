package com.naemo.sixcard.views.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.naemo.sixcard.BR
import com.naemo.sixcard.R
import com.naemo.sixcard.api.models.BinList
import com.naemo.sixcard.databinding.ActivityMainBinding
import com.naemo.sixcard.utils.AppUtils
import com.naemo.sixcard.views.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), MainNavigator {

    var mainViewModel: MainViewModel? = null
        @Inject set

    var mLayoutId = R.layout.activity_main
        @Inject set

    var appUtils: AppUtils? = null
        @Inject set

    private var mBinder: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        doBinding()
        initViews()
    }

    private fun initViews() {

    }

    private fun doBinding() {
        mBinder = getViewDataBinding()
        mBinder?.viewModel = mainViewModel
        mBinder?.navigator = this
        mBinder?.viewModel?.setNavigator(this)
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getViewModel(): MainViewModel? {
        return mainViewModel
    }

    override fun getLayoutId(): Int {
        return mLayoutId
    }


    override fun searchForCardDetails() {
        getViewModel()?.getBin()
    }

    override fun showSnackBarMsg(msg: String) {
        appUtils?.showSnackBar(this, main_frame, msg)
    }

    override fun showDialog() {
        appUtils?.showDialog(this)
    }

    override fun cancelDialog() {
        appUtils?.cancelDialog()
    }
}
