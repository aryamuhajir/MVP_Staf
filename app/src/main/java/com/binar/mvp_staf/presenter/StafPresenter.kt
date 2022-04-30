package com.binar.mvp_staf.presenter

import com.binar.mvp_staf.model.GetAllStafResponseItem
import com.binar.mvp_staf.network.APIClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StafPresenter(var viewStaf : StafView) {
    fun getDataNews(){
        APIClient.instance.getAllStaf()
            .enqueue(object : Callback<List<GetAllStafResponseItem>> {
                override fun onResponse(
                    call: Call<List<GetAllStafResponseItem>>,
                    response: Response<List<GetAllStafResponseItem>>
                ) {
                    if (response.isSuccessful){
                        viewStaf.onSuccess("SUKSES", response.body()!!)
                    }else{
                        viewStaf.onError(response.message())
                    }
                }

                override fun onFailure(call: Call<List<GetAllStafResponseItem>>, t: Throwable) {
                    viewStaf.onError(t.message!!)
                }

            })
    }
}