# ProGuard rules for Easy Life Keyboard

# Keep all classes in the app package
-keep class com.easylife.keyboard.** { *; }

# Keep Room database classes
-keep class androidx.room.** { *; }
-keepclassmembers class * {
    @androidx.room.* <fields>;
}

# Keep Kotlin metadata
-keepclassmembers class ** {
    *** Companion;
}
-keep class kotlin.Metadata { *; }

# Keep Android framework classes
-keep class android.** { *; }
-keep interface android.** { *; }

# Keep AndroidX classes
-keep class androidx.** { *; }
-keep interface androidx.** { *; }

# Remove logging
-assumenosideeffects class android.util.Log {
    public static *** d(...);
    public static *** v(...);
    public static *** i(...);
}

# Optimization settings
-optimizationpasses 5
-dontusemixedcaseclassnames
-verbose

# Rename source file attribute
-renamesourcefileattribute SourceFile
