package com.anncode.offersandcoupons.model

import androidx.lifecycle.MutableLiveData

interface CouponsRepository {
    fun callCouponsApi()
    fun getCoupons() : MutableLiveData<List<Coupon>>
}