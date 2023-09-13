// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.org.jetbrains.kotlin.android) apply false
    alias(libs.plugins.com.android.library) apply false
    kotlin("plugin.serialization") version "1.9.0"
}
true // Needed to make the Suppress annotation work for the plugins block