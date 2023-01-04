package cn.senseless.androidkv

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class AndroidKVDelegate<T>(
    private val specifiedKey: String?,
    private val defaultValue: T?
) : ReadWriteProperty<Any, T> {

    override fun getValue(thisRef: Any, property: KProperty<*>): T {
        val key = getKey(thisRef, property)
        return when (property.returnType.classifier) {
            Float::class -> {
                if (defaultValue == null) {
                    AndroidKV.requireSource().getFloat(key) as T
                } else {
                    AndroidKV.requireSource().getFloat(key, defaultValue as Float) as T
                }
            }
            Int::class -> {
                if (defaultValue == null) {
                    AndroidKV.requireSource().getInt(key) as T
                } else {
                    AndroidKV.requireSource().getInt(key, defaultValue as Int) as T
                }
            }
            Boolean::class -> {
                if (defaultValue == null) {
                    AndroidKV.requireSource().getBoolean(key) as T
                } else {
                    AndroidKV.requireSource().getBoolean(key, defaultValue as Boolean) as T
                }
            }
            String::class -> {
                if (defaultValue == null) {
                    AndroidKV.requireSource().getString(key) as T
                } else {
                    AndroidKV.requireSource().getString(key, defaultValue as String) as T
                }
            }
            Any::class -> {
                AndroidKV.requireSource().getObject<T>(key, property.returnType.javaClass as Class<T>) as T
            }
            else -> {
                throw IllegalArgumentException("不支持的序列化类型")
            }
        }
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: T) {
        val key = getKey(thisRef, property)
        when (property.returnType.classifier) {
            Float::class -> {
                AndroidKV.requireSource().putFloat(key, value as Float)
            }
            Int::class -> {
                AndroidKV.requireSource().putInt(key, value as Int)
            }
            String::class -> {
                AndroidKV.requireSource().putString(key, value as String)
            }
            Boolean::class -> {
                AndroidKV.requireSource().putBoolean(key, value as Boolean)
            }
            Any::class -> {
                AndroidKV.requireSource().putObject(key, value as Any)
            }
        }
    }

    private fun getKey(thisRef: Any, property: KProperty<*>): String {
        return specifiedKey ?: "${thisRef.javaClass.name}.${property.name}"
    }
}