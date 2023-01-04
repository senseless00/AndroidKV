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

    fun requireSource(): Source {
        return this.source
            ?: throw IllegalArgumentException("未初始化AndroidKV，请在Application的onCreate函数调用未初始化AndroidKV.init()")
    }
}

fun <T> androidKV(key: String? = null, default: T? = null): ReadWriteProperty<Any, T> = AndroidKVDelegate(key, default)