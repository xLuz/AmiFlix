# 🚀 GitHub Setup Guide - Get Your AmiFlix APK

## 📋 **Step-by-Step Instructions**

### **Step 1: Create GitHub Account** (if you don't have one)
1. Go to https://github.com
2. Click "Sign up"
3. Follow the registration process

### **Step 2: Create New Repository**
1. **Go to GitHub** and sign in
2. **Click the "+" icon** in top right → "New repository"
3. **Repository name**: `AmiFlix` (or any name you like)
4. **Description**: `French Anime Android TV App`
5. **Set to Public** (so GitHub Actions work for free)
6. **Don't** initialize with README (we already have files)
7. **Click "Create repository"**

### **Step 3: Upload Your AmiFlix Code**

**Option A: GitHub Web Interface (Easiest)**
1. **In your new repo**, click "uploading an existing file"
2. **Drag and drop** your entire `AmiFlix` folder
3. **Commit message**: `Initial AmiFlix Android TV app`
4. **Click "Commit changes"**

**Option B: Command Line**
```bash
cd /Users/oussamasaih/Desktop/AmiFlix
git init
git add .
git commit -m "Initial AmiFlix Android TV app"
git branch -M main
git remote add origin https://github.com/YOUR_USERNAME/AmiFlix.git
git push -u origin main
```

### **Step 4: Build Your APK** 🔨

1. **Go to your repo** on GitHub
2. **Click "Actions" tab** at the top
3. **You'll see**: "🎌 Build AmiFlix APK" workflow
4. **Click the workflow name**
5. **Click "Run workflow"** button (top right)
6. **Click the green "Run workflow"** button
7. **Wait 5-10 minutes** for build to complete ⏰

### **Step 5: Download Your APK** 📥

1. **After build completes**, click on the completed workflow run
2. **Scroll down to "Artifacts"** section
3. **Click "🎌-AmiFlix-Android-TV-APK"** to download
4. **Extract the downloaded zip** → you'll have `app-debug.apk`

---

## 🎯 **Alternative: Create a Release** (Bonus)

For a more professional download experience:

1. **In your repo**, click "Releases" (right sidebar)
2. **Click "Create a new release"**
3. **Tag version**: `v1.0.0`
4. **Release title**: `AmiFlix v1.0.0 - French Anime TV App`
5. **Click "Publish release"**
6. This will **automatically build and attach the APK** to the release!

---

## 📺 **Installing on Android TV**

Once you have `app-debug.apk`:

### **Method 1: USB Drive** 
```
1. Copy APK to USB drive
2. Connect USB to Android TV  
3. Open file manager app
4. Navigate to USB → install APK
5. Enable "Unknown Sources" if prompted
```

### **Method 2: ADB** (Advanced)
```bash
# Enable Developer Options on Android TV first
adb install app-debug.apk
```

### **Method 3: Cloud Transfer**
```
1. Upload APK to Google Drive/Dropbox
2. Download on Android TV
3. Install using file manager
```

---

## 🎉 **Expected Results**

✅ **Professional GitHub repo** with your code  
✅ **Automatic APK building** in the cloud  
✅ **Easy download** from GitHub  
✅ **Ready-to-install** Android TV app  
✅ **Beautiful French anime app** for your little brother!  

---

## 🆘 **Troubleshooting**

**Build failed?**
- Check the "Actions" tab for error logs
- Make sure all files uploaded correctly

**Can't download APK?**
- Artifacts expire after 30 days
- Re-run the workflow to get fresh APK

**Installation issues?**
- Enable "Unknown Sources" in Android TV settings
- Try different file manager apps
- Restart Android TV after installation

---

## 🔗 **Quick Links**

- **Create GitHub Account**: https://github.com/join
- **GitHub Actions Docs**: https://docs.github.com/en/actions
- **Android TV Settings**: Settings → Device Preferences → About → Build (tap 7 times for Developer Options)

**Ready to get your AmiFlix APK? Follow Step 1! 🚀** 