package com.emretekin.supportlibraryv28additions

import android.content.Context
import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.support.design.widget.NavigationView
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

/**
 * Created by emretekin on 13.11.2018.
 */
class BottomNavigationDrawerFragment : BottomSheetDialogFragment() {

    private lateinit var navigationView: NavigationView;

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_bottomsheet, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        createViews()
        setListeners()
    }

    private fun createViews() {
        navigationView = view!!.findViewById(R.id.navigation_view)
    }

    private fun setListeners() {
        navigationView.setNavigationItemSelectedListener { menuItem ->
            // Bottom Navigation Drawer menu item clicks
            when (menuItem.itemId) {
                R.id.nav1 -> context!!.toast("nav1 Clicked")
                R.id.nav2 -> context!!.toast("nav2 Clicked")
                R.id.nav3 -> context!!.toast("nav3 Clicked")
            }
            true

        }
    }

    // This is an extension method in Context for showing easy Toast
    private fun Context.toast(message: CharSequence) {
        val toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.BOTTOM, 0, 600)
        toast.show()
    }

}