package com.anncode.offersandcoupons.view

import com.anncode.offersandcoupons.model.Coupon

interface CouponView {
    // VIEW
    fun getCoupons()

    // PRESENTER
    fun showCoupons(coupons : List<Coupon>)
}