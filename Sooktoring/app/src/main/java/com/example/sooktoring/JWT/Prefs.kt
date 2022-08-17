package com.example.sooktoring.JWT

import android.content.Context
import android.content.Context.MODE_PRIVATE

class Prefs(context: Context) {
    private val prefNm = "mPref"
    private val prefs = context.getSharedPreferences(prefNm, MODE_PRIVATE)

    var token:String?
        get() = prefs.getString("token",null)
        set(value){
            prefs.edit().putString("token",value).apply()
        }

    var refreshtoken:String?
        get() = prefs.getString("refreshtoken",null)
        set(value){
            prefs.edit().putString("refreshtoken",value).apply()
        }

    var createdDate:String?
        get() = prefs.getString("createdDate",null)
        set(value){
            prefs.edit().putString("createdDate",value).apply()
        }

    var lastModifiedDate:Boolean?
        get() = prefs.getBoolean("lastModifiedDate", false)
        set(value){
            if (value != null) {
                prefs.edit().putBoolean("lastModifiedDate", value).apply()
            }
        }

    var id:String?
        get() = prefs.getString("id",null)
        set(value){
            prefs.edit().putString("id",value).apply()
        }

    var email:String?
        get() = prefs.getString("email",null)
        set(value){
            prefs.edit().putString("email",value).apply()
        }

    var userName:String?
        get() = prefs.getString("userName",null)
        set(value){
            prefs.edit().putString("userName",value).apply()
        }

    var imageUrl:String?
        get() = prefs.getString("imageUrl",null)
        set(value){
            prefs.edit().putString("imageUrl",value).apply()
        }

    var role:String?
        get() = prefs.getString("role",null)
        set(value){
            prefs.edit().putString("role",value).apply()
        }
}