## androidkv module

用Kotlin代理的方式实现安卓键值对持久化存储

```kotlin
object Cache {
    var token by androidKV<String>("token")
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AndroidKV.init(applicationContext)
        val textView = findViewById<TextView>(R.id.text)
        Cache.token = "abc"
        textView.text = Cache.token
    }
}
```
Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:
```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Step 2. Add the dependency
[![](https://jitpack.io/v/senseless00/AndroidKV.svg)](https://jitpack.io/#senseless00/AndroidKV)
```groovy
dependencies {
        implementation 'com.github.senseless00:AndroidKV:Tag'
}
```