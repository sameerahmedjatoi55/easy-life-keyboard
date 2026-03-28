# Building Easy Life Keyboard APK

This guide provides step-by-step instructions for building the Easy Life Keyboard APK using various methods.

## Table of Contents
1. [Quick Start with GitHub Actions](#quick-start-with-github-actions)
2. [Local Build with Android Studio](#local-build-with-android-studio)
3. [Command Line Build with Gradle](#command-line-build-with-gradle)
4. [Cloud Build Services](#cloud-build-services)
5. [Troubleshooting](#troubleshooting)

---

## Quick Start with GitHub Actions

**Easiest method - No local setup required!**

### Prerequisites
- GitHub account
- Git installed on your computer

### Steps

1. **Upload Project to GitHub**
   ```bash
   git clone https://github.com/YOUR_USERNAME/easy-life-keyboard.git
   cd easy-life-keyboard
   git add .
   git commit -m "Initial commit"
   git push origin main
   ```

2. **Enable GitHub Actions**
   - Go to your repository on GitHub
   - Click "Settings" tab
   - Click "Actions" → "General"
   - Select "Allow all actions and reusable workflows"
   - Click "Save"

3. **Trigger the Build**
   - Go to "Actions" tab
   - Click "Build APK" workflow
   - Click "Run workflow" → "Run workflow"
   - Wait for build to complete (usually 5-10 minutes)

4. **Download APK**
   - Click the completed workflow run
   - Scroll down to "Artifacts"
   - Download `easy-life-keyboard-debug` or `easy-life-keyboard-release`
   - Extract the ZIP file to get the APK

### What You Get
- **Debug APK**: `app-debug.apk` (~15-20MB) - For testing
- **Release APK**: `app-release-unsigned.apk` (~8-12MB) - For distribution

---

## Local Build with Android Studio

**Best for development and customization**

### Prerequisites
- Android Studio 2023.1 or later
- JDK 11 or higher
- 4GB RAM minimum
- 5GB disk space

### Installation Steps

1. **Download Android Studio**
   - Visit [developer.android.com/studio](https://developer.android.com/studio)
   - Download and install for your OS

2. **Install JDK 11**
   - Download from [oracle.com](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
   - Or use Android Studio's built-in JDK

3. **Open Project**
   - Launch Android Studio
   - Click "Open" → Select project folder
   - Wait for Gradle sync to complete

4. **Configure SDK**
   - Go to File → Settings → Appearance & Behavior → System Settings → Android SDK
   - Click "SDK Platforms" tab
   - Install Android 14 (API 34)
   - Click "SDK Tools" tab
   - Install "Android SDK Build-Tools 34.0.0"

5. **Build APK**
   - Click Build → Build Bundle(s) / APK(s) → Build APK(s)
   - Wait for build to complete
   - See notification with APK location

6. **Find APK**
   - APK location: `app/build/outputs/apk/debug/app-debug.apk`
   - Or use "Locate" button in notification

### Install on Device
- Connect Android device via USB
- Enable USB Debugging on device
- Click Run → Run 'app'
- Select device
- Click OK

---

## Command Line Build with Gradle

**For CI/CD pipelines and automation**

### Prerequisites
- JDK 11 or higher
- Android SDK installed
- Gradle (included in project)

### Setup

1. **Set ANDROID_HOME**
   ```bash
   # Linux/Mac
   export ANDROID_HOME=$HOME/Android/Sdk
   export PATH=$PATH:$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools
   
   # Windows (PowerShell)
   $env:ANDROID_HOME = "$env:USERPROFILE\AppData\Local\Android\Sdk"
   $env:Path += ";$env:ANDROID_HOME\tools;$env:ANDROID_HOME\platform-tools"
   ```

2. **Verify Installation**
   ```bash
   java -version
   gradle --version
   ```

### Build Commands

**Debug Build**
```bash
./gradlew assembleDebug
# Output: app/build/outputs/apk/debug/app-debug.apk
```

**Release Build**
```bash
./gradlew assembleRelease
# Output: app/build/outputs/apk/release/app-release-unsigned.apk
```

**Full Build (All variants)**
```bash
./gradlew build
```

**Clean Build**
```bash
./gradlew clean build
```

**Build with Logging**
```bash
./gradlew assembleDebug --info
```

### Install via ADB
```bash
adb install app/build/outputs/apk/debug/app-debug.apk
```

### Uninstall
```bash
adb uninstall com.easylife.keyboard
```

---

## Cloud Build Services

### Option 1: Codemagic

1. Go to [codemagic.io](https://codemagic.io)
2. Sign up with GitHub account
3. Connect your repository
4. Click "Start new build"
5. Configure build settings (auto-detected)
6. Click "Start build"
7. Download APK from dashboard

### Option 2: AppCenter (Microsoft)

1. Go to [appcenter.ms](https://appcenter.ms)
2. Sign in with Microsoft account
3. Create new app
4. Connect GitHub repository
5. Configure build settings
6. Trigger build
7. Download from Build section

### Option 3: Bitrise

1. Go to [bitrise.io](https://bitrise.io)
2. Sign up with GitHub
3. Add new app
4. Select repository
5. Configure workflow
6. Start build
7. Download artifacts

---

## Signing Release APK

For Play Store distribution, you need to sign the APK.

### Create Keystore
```bash
keytool -genkey -v -keystore easy-life-keyboard.keystore \
  -keyalg RSA -keysize 2048 -validity 10000 \
  -alias easy-life-keyboard
```

### Build Signed APK
```bash
./gradlew assembleRelease \
  -Pandroid.injected.signing.store.file=easy-life-keyboard.keystore \
  -Pandroid.injected.signing.store.password=YOUR_PASSWORD \
  -Pandroid.injected.signing.key.alias=easy-life-keyboard \
  -Pandroid.injected.signing.key.password=YOUR_PASSWORD
```

### Or Configure in gradle.properties
```properties
KEYSTORE_FILE=easy-life-keyboard.keystore
KEYSTORE_PASSWORD=your_password
KEY_ALIAS=easy-life-keyboard
KEY_PASSWORD=your_password
```

Then build:
```bash
./gradlew assembleRelease
```

---

## Build Configuration

### Change App Name
Edit `app/src/main/res/values/strings.xml`:
```xml
<string name="app_name">Your Custom Name</string>
```

### Change Package Name
Edit `app/build.gradle`:
```gradle
applicationId "com.yourcompany.keyboard"
```

### Change Version
Edit `app/build.gradle`:
```gradle
versionCode 2
versionName "1.1.0"
```

### Change Min/Target SDK
Edit `build.gradle`:
```gradle
ext {
    minSdkVersion = 30
    targetSdkVersion = 34
    compileSdkVersion = 34
}
```

---

## Troubleshooting

### Build Fails with "SDK not found"
```bash
# Solution: Set ANDROID_HOME
export ANDROID_HOME=$HOME/Android/Sdk
```

### "Gradle sync failed"
```bash
# Solution: Clean and sync
./gradlew clean
./gradlew --refresh-dependencies
```

### "Unsupported Java version"
```bash
# Solution: Use JDK 11
java -version  # Should show 11.x.x
```

### APK Installation Fails
```bash
# Solution: Uninstall old version first
adb uninstall com.easylife.keyboard
adb install app/build/outputs/apk/debug/app-debug.apk
```

### Out of Memory During Build
```bash
# Solution: Increase heap size
export GRADLE_OPTS="-Xmx2048m"
./gradlew assembleDebug
```

### Gradle Daemon Issues
```bash
# Solution: Stop and restart daemon
./gradlew --stop
./gradlew assembleDebug
```

---

## Build Performance Tips

1. **Use Gradle Daemon**
   ```gradle
   org.gradle.daemon=true
   ```

2. **Enable Parallel Builds**
   ```gradle
   org.gradle.parallel=true
   ```

3. **Increase JVM Memory**
   ```bash
   export GRADLE_OPTS="-Xmx2048m -XX:MaxPermSize=512m"
   ```

4. **Use Build Cache**
   ```gradle
   org.gradle.caching=true
   ```

5. **Disable Unnecessary Features**
   - Disable Instant Run if not needed
   - Disable Lint checks for faster builds

---

## Next Steps

After building the APK:

1. **Test on Device**
   - Install APK on Android device
   - Test all features
   - Check for crashes

2. **Publish to Play Store**
   - Create Google Play Developer account
   - Upload signed APK
   - Fill in app details
   - Submit for review

3. **Share with Others**
   - Upload APK to file sharing service
   - Share link with testers
   - Collect feedback

---

## Additional Resources

- [Android Developers - Build](https://developer.android.com/studio/build)
- [Gradle Documentation](https://gradle.org/guides/)
- [Android Studio Guide](https://developer.android.com/studio/intro)
- [Play Console Help](https://support.google.com/googleplay/android-developer)

---

**Need help?** Check the main README.md or the Troubleshooting section above.
