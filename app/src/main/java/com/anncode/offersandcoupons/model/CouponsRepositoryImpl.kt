package com.anncode.offersandcoupons.model

import com.anncode.offersandcoupons.presenter.CouponPresenter

class CouponsRepositoryImpl(var couponPresenter : CouponPresenter) : CouponsRepository {

    // All connexion logic
    override fun getCouponsApi() {
        TODO("Not yet implemented")

//        couponPresenter.showCoupons()
    }
}