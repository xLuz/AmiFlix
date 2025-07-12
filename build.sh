#!/bin/bash

# AmiFlix Android TV App Build Script
# This script builds the APK and provides installation instructions

echo "🎌 AmiFlix Android TV App Builder 🎌"
echo "========================================"

# Check if Android SDK is available
if ! command -v ./gradlew &> /dev/null; then
    echo "❌ Gradle wrapper not found. Please run this script from the project root."
    exit 1
fi

# Clean previous builds
echo "🧹 Cleaning previous builds..."
./gradlew clean

# Build debug APK
echo "🔨 Building debug APK..."
./gradlew assembleDebug

# Check if build was successful
if [ $? -eq 0 ]; then
    echo "✅ Build successful!"
    echo ""
    echo "📦 APK Location:"
    echo "   app/build/outputs/apk/debug/app-debug.apk"
    echo ""
    echo "📱 Installation Instructions:"
    echo "   1. Enable 'Developer options' on your Android TV"
    echo "   2. Enable 'USB debugging' in Developer options"
    echo "   3. Connect your Android TV via ADB or transfer APK file"
    echo "   4. Install using: adb install app/build/outputs/apk/debug/app-debug.apk"
    echo ""
    echo "🎯 Alternative Installation:"
    echo "   1. Copy the APK file to a USB drive"
    echo "   2. Connect USB drive to your Android TV"
    echo "   3. Use a file manager app to install the APK"
    echo ""
    echo "🎉 Enjoy watching French anime on AmiFlix!"
else
    echo "❌ Build failed. Please check the error messages above."
    exit 1
fi 