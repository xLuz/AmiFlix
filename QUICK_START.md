# 🚀 Quick Start Guide - Get Your AmiFlix APK

## 📱 **3 Ways to Get Your APK**

### **🎯 Method 1: Android Studio (Easiest)**
1. **Download Android Studio**: https://developer.android.com/studio
2. **Open Project**: File → Open → Select your `AmiFlix` folder
3. **Build APK**: Build → Build Bundle(s) / APK(s) → Build APK(s)
4. **Find APK**: `app/build/outputs/apk/debug/app-debug.apk`

### **🎯 Method 2: GitHub Actions (Automatic)**
1. **Upload to GitHub**: Create a new repository and push this code
2. **Enable Actions**: Go to Actions tab in your GitHub repo
3. **Run Build**: Click "Build AmiFlix APK" → "Run workflow"
4. **Download APK**: After build completes, download from Artifacts

### **🎯 Method 3: Command Line (Advanced)**
**Requirements**: Android SDK installed
```bash
# Install Android SDK first
# Then run:
./gradlew assembleDebug
```

## 📺 **Installing on Android TV**

### **Option A: ADB (Developer Mode)**
```bash
# Enable Developer Options on your Android TV
adb install app-debug.apk
```

### **Option B: USB Transfer**
1. Copy APK to USB drive
2. Connect USB to Android TV
3. Use file manager to install APK
4. Allow "Install from Unknown Sources"

### **Option C: Direct Transfer**
1. Send APK file to your Android TV (email, cloud storage, etc.)
2. Download and install using a file manager

## 🎌 **What You'll Get**

✅ **Complete Android TV App** - AmiFlix  
✅ **French Anime Content** - Ready to stream  
✅ **TV Remote Navigation** - D-pad optimized  
✅ **Beautiful Interface** - Dark theme, modern design  
✅ **Multiple Sources** - French anime websites  
✅ **Family-Friendly** - Safe for your little brother  

## 🆘 **Need Help?**

**Can't build?** → Use Android Studio (Method 1)  
**No Android Studio?** → Use GitHub Actions (Method 2)  
**Need Android TV help?** → Check TV settings for "Unknown Sources"  

## 📂 **Current Project Status**

✅ **Complete codebase** - Ready to build  
✅ **All dependencies** - Configured  
✅ **TV optimization** - D-pad navigation  
✅ **French content** - Anime sources  
⏳ **APK building** - Choose method above  

**Your AmiFlix app is ready - just pick your preferred build method! 🎉** 