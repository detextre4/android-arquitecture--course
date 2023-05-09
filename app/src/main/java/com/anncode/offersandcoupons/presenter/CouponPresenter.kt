package com.anncode.offersandcoupons.presenter

import com.anncode.offersandcoupons.model.Coupon

interface CouponPresenter {
    // VIEW
    fun showCoupons(coupons : List<Coupon>?)

    // INTERACT
    fun getCoupons()
}