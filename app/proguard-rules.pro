# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

# Keep data models
-keep class com.amiflix.androidtv.data.models.** { *; }

# Keep Retrofit interfaces
-keep class com.amiflix.androidtv.data.api.** { *; }

# Keep R8 optimizations
-keepattributes *Annotation*

# Keep Jetpack Compose
-keep class androidx.compose.** { *; }
-keep class androidx.tv.** { *; }

# Keep ExoPlayer
-keep class com.google.android.exoplayer2.** { *; }
-keep class androidx.media3.** { *; }

# Keep Retrofit
-keep class retrofit2.** { *; }
-keep class okhttp3.** { *; }

# Keep Gson
-keep class com.google.gson.** { *; }
-keep class * implements com.google.gson.** { *; }

# Keep JSoup
-keep class org.jsoup.** { *; }

# Keep Kotlin coroutines
-keep class kotlinx.coroutines.** { *; }

# Keep Parcelable
-keep class * implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator *;
}

# Keep enum classes
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

# Keep annotation classes
-keep @androidx.annotation.Keep class * { *; }
-keep class * {
    @androidx.annotation.Keep <fields>;
}
-keep class * {
    @androidx.annotation.Keep <methods>;
}

# Keep R class
-keep class **.R$* {
    *;
}

# Keep BuildConfig
-keep class com.amiflix.androidtv.BuildConfig { *; }

# Optimize but keep stack traces
-keepattributes SourceFile,LineNumberTable
-renamesourcefileattribute SourceFile 