package com.anncode.offersandcoupons.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.anncode.offersandcoupons.R
import com.anncode.offersandcoupons.model.Coupon

import com.anncode.offersandcoupons.presenter.CouponPresenter
import com.anncode.offersandcoupons.presenter.CouponPresenterImpl

class MainActivity : AppCompatActivity(), CouponView {

    private lateinit var couponPresenter : CouponPresenter
    private lateinit var rvCoupons : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        couponPresenter = CouponPresenterImpl(this)

        // VIEW
        rvCoupons = findViewById(R.id.rvCoupons) // UI
        rvCoupons.layoutManager = LinearLayoutManager(this)
        // VIEW

        getCoupons()
    }

    override fun showCoupons(coupons: List<Coupon>?) {
        rvCoupons.adapter = RecyclerCouponsAdapter(coupons, R.layout.card_coupon)
    }

    override fun getCoupons() {
        couponPresenter.getCoupons()
    }

}
