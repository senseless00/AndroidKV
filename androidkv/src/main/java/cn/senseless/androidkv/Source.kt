package cn.senseless.androidkv

interface Source {
    fun <T> getObject(key: String, clazz: Class<T>): T?

    fun putObject(key: String, `object`: Any?)

    fun getString(key: String): String?

    fun getString(key: String, defaultValue: String): String

    fun putString(key: String, value: String?)

    fun getBoolean(key: String): Boolean

    fun getBoolean(key: String, defaultValue: Boolean): Boolean

    fun putBoolean(key: String, value: Boolean)

    fun getInt(key: String): Int

    fun getInt(key: String, defaultValue: Int): Int

    fun putInt(key: String, value: Int)

    fun getLong(key: String): Long

    fun getLong(key: String, defaultValue: Long): Long

    fun putLong(key: String, value: Long)

    fun getFloat(key: String): Float

    fun getFloat(key: String, defaultValue: Float): Float

    fun putFloat(key: String, value: Float)

    fun remove(key: String)

    operator fun contains(key: String): Boolean
}