package com.wangjin.library

import android.content.pm.PackageManager
import androidx.fragment.app.Fragment

//typealias关键字可以用于给任意类型指定一个别名
typealias PermissionCallback = (Boolean,List<String>) -> Unit
class InvisibleFragment : Fragment() {
    //callback 变量作为运行时权限申请结果的回调,函数类型变量
    //private var callBack : ((Boolean,List<String>) -> Unit)? = null
    private var callBack : PermissionCallback? = null

    fun requestNow(cb : PermissionCallback,vararg permissions : String){
        callBack = cb
        requestPermissions(permissions,1)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if(requestCode == 1){
            //记录所有被用户拒绝的权限
            val deniedList = ArrayList<String>()
            for((index,result) in grantResults.withIndex()){
                if(result != PackageManager.PERMISSION_GRANTED){
                    deniedList.add(permissions[index])
                }
            }
            val callGradient = deniedList.isEmpty()
            callBack?.let {
                it(callGradient,deniedList)
            }
        }
    }
}