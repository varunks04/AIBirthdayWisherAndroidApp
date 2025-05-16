# ProGuard rules for the AI Birthday Wisher app

# Keep the application class and its members
-keep class com.example.aibirthdaywisher.** { *; }

# Keep the data models
-keep class com.example.aibirthdaywisher.data.model.** { *; }

# Keep the DAO interfaces
-keep interface com.example.aibirthdaywisher.data.local.** { *; }

# Keep the repository classes
-keep class com.example.aibirthdaywisher.data.repository.** { *; }

# Keep the ViewModel classes
-keep class com.example.aibirthdaywisher.ui.**ViewModel { *; }

# Keep the Retrofit service interface
-keep interface com.example.aibirthdaywisher.network.** { *; }

# Keep the dependency injection modules
-keep class com.example.aibirthdaywisher.di.** { *; }

# Keep the utility classes
-keep class com.example.aibirthdaywisher.utils.** { *; }

# Keep the calendar fragment and its members
-keep class com.example.aibirthdaywisher.ui.calendar.CalendarFragment { *; }

# Keep the cards fragment and its members
-keep class com.example.aibirthdaywisher.ui.cards.** { *; }

# Keep the home fragment and its members
-keep class com.example.aibirthdaywisher.ui.home.HomeFragment { *; }

# Keep the settings fragment and its members
-keep class com.example.aibirthdaywisher.ui.settings.SettingsFragment { *; }

# Keep the splash activity
-keep class com.example.aibirthdaywisher.SplashActivity { *; }

# Keep the main activity
-keep class com.example.aibirthdaywisher.MainActivity { *; }

# Keep all annotations
-keepattributes *Annotation

# Keep the Parcelable interface
-keep class * implements android.os.Parcelable {
    public static final ** CREATOR;
}