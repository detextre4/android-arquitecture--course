package com.anncode.offersandcoupons.model

import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData

class CouponObservable : BaseObservable() {
    private val couponRepository : CouponsRepository = CouponsRepositoryImpl()

    // Repositorio
    fun callCoupons() {
        couponRepository.getCoupons()
    }

    // ViewModel
    fun getCoupons() : MutableLiveData<List<Coupon>> {
        return couponRepository.getCoupons()
    }
}