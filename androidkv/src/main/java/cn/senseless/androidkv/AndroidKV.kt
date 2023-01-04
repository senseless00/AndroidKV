package cn.senseless.androidkv

import android.content.Context
import kotlin.properties.ReadWriteProperty


object AndroidKV {
    private var source: Source? = null

    fun init(context: Context) {
        init(SharedPreferencesSources(context, "AndroidKV"))
    }

    fun init(source: Source) {
        this.source = source
    }

    fun requireSource(): Source = source!!
}

fun <T> androidKV(key: String? = null, default: T? = null): ReadWriteProperty<Any, T> = AndroidKVDelegate(key, default)