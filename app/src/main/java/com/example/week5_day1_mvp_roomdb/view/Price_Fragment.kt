package com.example.week5_day1_mvp_roomdb.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week5_day1_mvp_roomdb.R
import com.example.week5_day1_mvp_roomdb.adapter.PriceAdapter
import com.example.week5_day1_mvp_roomdb.database.GuestDatabase
import com.example.week5_day1_mvp_roomdb.database.GuestEntity
import kotlinx.android.synthetic.main.price_fragment.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

class Price_Fragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.price_fragment, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        EventBus.getDefault().register(this)

    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe
    fun receiveNews(guestDatabase: GuestDatabase){
        val adapter = PriceAdapter(guestDatabase.guestDAO().retrieveAllGuests(), activity)
        prices_listView.adapter = adapter
        prices_listView.layoutManager = LinearLayoutManager(activity)
    }

    override fun onResume() {
        super.onResume()
        val adapter = PriceAdapter(MainActivity.guestDB.guestDAO().retrieveAllGuests(), activity)
        prices_listView.adapter = adapter
        prices_listView.layoutManager = LinearLayoutManager(activity)
    }
}