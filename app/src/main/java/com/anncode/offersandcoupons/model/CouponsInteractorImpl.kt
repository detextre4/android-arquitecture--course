package com.anncode.offersandcoupons.model

import com.anncode.offersandcoupons.presenter.CouponPresenter

class CouponsInteractorImpl(var couponPresenter : CouponPresenter) : CouponsInteractor {

    private var couponRepository : CouponsRepository = CouponsRepositoryImpl(couponPresenter)

    override fun getCouponsApi() {
        TODO("Not yet implemented")
    }
}