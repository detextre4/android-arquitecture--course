package com.anncode.offersandcoupons.viewModel

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anncode.offersandcoupons.R
import com.anncode.offersandcoupons.model.Coupon
import com.anncode.offersandcoupons.model.CouponObservable
import com.anncode.offersandcoupons.view.RecyclerCouponsAdapter

class CouponViewModel : ViewModel() {
    private val couponObservable : CouponObservable = CouponObservable()
    private lateinit var recyclerCouponsAdapter : RecyclerCouponsAdapter

    fun callCoupons() {
        couponObservable.callCoupons()
    }

    fun getCoupons() : MutableLiveData<List<Coupon>> {
        return couponObservable.getCoupons()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setCouponsInRecyclerAdapter(coupons: List<Coupon>) {
        recyclerCouponsAdapter.setCouponsList(coupons)
        recyclerCouponsAdapter.notifyDataSetChanged()
    }

    fun getRecyclerCouponsAdapter() : RecyclerCouponsAdapter {
        recyclerCouponsAdapter = RecyclerCouponsAdapter(this, R.layout.card_coupon)
        return recyclerCouponsAdapter
    }

    fun getCouponAt(position : Int) : Coupon? {
        val coupons : List<Coupon>? = couponObservable.getCoupons().value
        return coupons?.get(position)
    }
}