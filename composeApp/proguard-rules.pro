# Uncomment this to preserve the line number information for
# debugging stack traces.
# -keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
-renamesourcefileattribute SourceFile

#Move all clases to single folder
-repackageclasses

#Optimization N iterations. You can chance count iterations
-optimizationpasses 3

#Remove all ours Log.x() files
-assumenosideeffects class android.util.Log {
    public static boolean isLoggable(java.lang.String, int);
    public static *** v(...);
    public static *** i(...);
    public static *** w(...);
    public static *** d(...);
    public static *** e(...);
}

-dontusemixedcaseclassnames
-verbose

-keep,allowobfuscation,allowshrinking class kotlin.coroutines.Continuation
-keep class java.lang.invoke.** { *; }

-dontwarn org.slf4j.impl.StaticLoggerBinder
