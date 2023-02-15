package com.wangjin.library

import android.app.Activity
import androidx.fragment.app.FragmentActivity

class PermissionX {
    companion object {
        private const val TAG = "InvisibleFragment"
    }

    fun request(activity: FragmentActivity,vararg permissions : String,callback : PermissionCallback){
        val fragmentManager = activity.supportFragmentManager
        val existedFragment = fragmentManager.findFragmentByTag(TAG)
        

    }
}