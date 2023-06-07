package com.anncode.offersandcoupons.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@Suppress("UNREACHABLE_CODE")
class CouponsRepositoryImpl : CouponsRepository {
    private val coupons = MutableLiveData<List<Coupon>>()
    // Subject MutableLiveData
    // Observers List Coupon
    // Change List Coupon - MutableLiveData
    // Observe

    // All connexion logic
    override fun callCouponsApi() {
        // CONTROLLER
        val couponsList : MutableList<Coupon> = mutableListOf()
        val apiAdapter = ApiAdapter()
        val apiService = apiAdapter.getClientService()
        val call = apiService.getCoupons()

        call.enqueue(object : Callback<JsonObject> {
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Log.e("ERROR: ", t.message ?: "Unknown error occurred")
                t.stackTrace
            }

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                val offersJsonArray = response.body()?.getAsJsonArray("offers")
                offersJsonArray?.forEach { jsonElement: JsonElement ->
                    val jsonObject = jsonElement.asJsonObject
                    val coupon = Coupon(jsonObject)
                    couponsList.add(coupon)
                }
                // VIEW
                coupons.value = couponsList
            }
        })
        // CONTROLLER
    }

    override fun getCoupons() : MutableLiveData<List<Coupon>> {
        return coupons
    }
}