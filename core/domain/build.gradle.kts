plugins {
    alias(libs.plugins.convetion.library)
}

android.namespace = "com.core.domain"

dependencies {
    commonMainImplementation(libs.coroutines.core)
    commonMainImplementation(libs.koin.core)
    commonMainImplementation(libs.supabase.gotrue)
}
