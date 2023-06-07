package com.anncode.offersandcoupons.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.anncode.offersandcoupons.R
import com.anncode.offersandcoupons.databinding.ActivityMainBinding
import com.anncode.offersandcoupons.model.Coupon
import com.anncode.offersandcoupons.viewModel.CouponViewModel


class MainActivity : AppCompatActivity() {
    private lateinit var couponViewModel : CouponViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        // VIEW
        setupBinding(savedInstanceState)
    }

    fun setupBinding(savedInstanceState: Bundle?) {
        val activityMainBinding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        couponViewModel = ViewModelProviders.of(this)[CouponViewModel::class.java]
        activityMainBinding.model = couponViewModel
        setupListUpdate()
    }

    fun setupListUpdate() {
        // CallCoupons
        couponViewModel.callCoupons()
        // getCoupons - Lista de cupones
        couponViewModel.getCoupons().observe(this, Observer { coupons : List<Coupon> ->
            Log.w("COUPON", coupons[0].title)
            couponViewModel.setCouponsInRecyclerAdapter(coupons)
        })
    }
}
