package com.binar.mvp_staf.presenter

import com.binar.mvp_staf.model.GetAllStafResponseItem

interface StafView {
    fun onSuccess(pesan : String, staf : List<GetAllStafResponseItem>)
    fun onError(pesan : String)
}