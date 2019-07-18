# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Volumes/HardDrive/android-sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

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
-keepattributes *Annotation*
-dontwarn javax.xml.bind.DatatypeConverter

# Joda rules
-keep class org.joda.** { *; }
-dontwarn org.joda.time.tz.ZoneInfoCompiler

# Jsonwebtoken rules
-keepattributes InnerClasses

-keep class org.bouncycastle.** { *; }
-keepnames class org.bouncycastle.** { *; }
-dontwarn org.bouncycastle.**

-keep class io.jsonwebtoken.** { *; }
-keepnames class io.jsonwebtoken.* { *; }
-keepnames interface io.jsonwebtoken.* { *; }

-dontwarn io.jsonwebtoken.impl.Base64Codec

# Proguard configuration for Jackson
-keepattributes *Annotation*,EnclosingMethod
-keepattributes Signature
-keep class com.fasterxml.jackson.databind.ObjectMapper {
    public <methods>;
    protected <methods>;
}
-keep class com.fasterxml.jackson.databind.ObjectWriter {
    public ** writeValueAsString(**);
}
-keepclassmembers public class * {
     @com.fasterxml.jackson.annotation.JsonCreator *;
}
-keepnames class com.fasterxml.jackson.** { *; }
-keepnames interface com.fasterxml.jackson.** { *; }
-keepnames class com.fasterxml.jackson.databind.** { *; }
-dontwarn com.fasterxml.jackson.databind.**
-dontwarn org.w3c.dom.bootstrap.DOMImplementationRegistry
-keep class com.saltedge.authenticator.api.model.request.CreateProviderTokenRequestData

# Fabric rules
-keepattributes SourceFile,LineNumberTable
-keep public class * extends java.lang.Exception
-keep class com.crashlytics.** { *; }
-dontwarn com.crashlytics.**

# Retrofit
-keep class retrofit2.** { *; }
-keep class com.squareup.okhttp3.* { *;}
-keepnames class okhttp3.internal.publicsuffix.PublicSuffixDatabase
-dontwarn retrofit2.**
-dontwarn okio.**
-dontwarn okhttp3.**
-dontwarn com.squareup.okhttp3.**
-dontwarn org.conscrypt.**

# Retain generic providerName information for use by reflection by converters and adapters.
-keepattributes Signature
-dontwarn javax.annotation.**
-dontwarn javax.annotation.Nullable
-dontwarn javax.annotation.ParametersAreNonnullByDefault
# Retain declared checked exceptions for use by a Proxy instance.
-keepattributes Exceptions
-dontwarn javax.annotation.**