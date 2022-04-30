package com.binar.mvp_staf.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.binar.mvp_staf.R
import com.binar.mvp_staf.adapter.RvAdapter
import com.binar.mvp_staf.model.GetAllStafResponseItem
import com.binar.mvp_staf.presenter.StafPresenter
import com.binar.mvp_staf.presenter.StafView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), StafView {
    private lateinit var presenterStaf : StafPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenterStaf = StafPresenter(this)
        presenterStaf.getDataNews()
    }

    override fun onSuccess(pesan: String, staf: List<GetAllStafResponseItem>) {
        rv_staf.layoutManager = LinearLayoutManager(this)
        rv_staf.adapter = RvAdapter(staf)
    }

    override fun onError(pesan: String) {
        Toast.makeText(this,pesan, Toast.LENGTH_LONG).show()
    }
}