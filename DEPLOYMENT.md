# Easy Life Keyboard - Deployment & Distribution Guide

Complete guide for deploying and distributing the Easy Life Keyboard app.

## Table of Contents
1. [Quick Start](#quick-start)
2. [GitHub Setup](#github-setup)
3. [Automated APK Generation](#automated-apk-generation)
4. [Testing the APK](#testing-the-apk)
5. [Distribution Options](#distribution-options)
6. [Play Store Publishing](#play-store-publishing)
7. [Troubleshooting](#troubleshooting)

---

## Quick Start

**Get your APK in 5 minutes:**

1. **Upload to GitHub**
   ```bash
   git clone <this-repo>
   cd easy-life-keyboard-native
   git init
   git add .
   git commit -m "Initial Easy Life Keyboard"
   git remote add origin https://github.com/YOUR_USERNAME/easy-life-keyboard.git
   git push -u origin main
   ```

2. **Enable Actions**
   - Go to GitHub repository
   - Settings → Actions → General
   - Select "Allow all actions"

3. **Trigger Build**
   - Go to Actions tab
   - Click "Build APK"
   - Click "Run workflow"
   - Wait 5-10 minutes

4. **Download APK**
   - Click completed workflow
   - Download artifact: `easy-life-keyboard-debug.zip`
   - Extract to get `app-debug.apk`

5. **Install on Device**
   - Transfer APK to Android device
   - Tap to install
   - Grant permissions
   - Done!

---

## GitHub Setup

### Create Repository

1. **On GitHub.com**
   - Click "+" → "New repository"
   - Name: `easy-life-keyboard`
   - Description: "Android keyboard with clipboard manager"
   - Select "Public" or "Private"
   - Click "Create repository"

2. **Clone to Local Machine**
   ```bash
   git clone https://github.com/YOUR_USERNAME/easy-life-keyboard.git
   cd easy-life-keyboard
   ```

3. **Add Project Files**
   ```bash
   # Copy all files from easy-life-keyboard-native to this directory
   cp -r ../easy-life-keyboard-native/* .
   ```

4. **Push to GitHub**
   ```bash
   git add .
   git commit -m "Initial commit: Easy Life Keyboard v1.0"
   git push origin main
   ```

### Configure Repository Settings

1. **Branch Protection**
   - Settings → Branches
   - Add rule for `main` branch
   - Require status checks before merging

2. **Actions Permissions**
   - Settings → Actions → General
   - Allow all actions and reusable workflows
   - Save

3. **Secrets (Optional for signing)**
   - Settings → Secrets and variables → Actions
   - Add `KEYSTORE_PASSWORD` if using signed builds
   - Add `KEY_PASSWORD` if using signed builds

---

## Automated APK Generation

### GitHub Actions Workflow

The project includes `.github/workflows/build-apk.yml` which:
- Runs on every push to `main` branch
- Builds debug and release APKs
- Uploads artifacts automatically
- Can be manually triggered

### Trigger Build Manually

1. Go to Actions tab
2. Click "Build APK" workflow
3. Click "Run workflow" dropdown
4. Select branch (main)
5. Click "Run workflow"
6. Monitor progress in workflow logs

### View Build Logs

1. Click the workflow run
2. Click "build" job
3. Expand steps to see detailed logs
4. Useful for debugging build failures

### Download Artifacts

1. Click completed workflow run
2. Scroll to "Artifacts" section
3. Download desired APK:
   - `easy-life-keyboard-debug` - For testing
   - `easy-life-keyboard-release` - For distribution

---

## Testing the APK

### Prerequisites
- Android device (Android 10+)
- USB cable
- USB Debugging enabled on device

### Enable USB Debugging
1. Open Settings on Android device
2. Go to About Phone
3. Tap Build Number 7 times
4. Go back to Settings
5. Developer Options → USB Debugging → Enable

### Install APK

**Method 1: Via ADB**
```bash
adb devices  # List connected devices
adb install app-debug.apk
```

**Method 2: File Transfer**
1. Copy APK to device via USB
2. Open file manager on device
3. Tap APK file
4. Tap "Install"
5. Grant permissions
6. Tap "Open"

**Method 3: Email/Cloud**
1. Email APK to yourself
2. Open email on device
3. Download APK
4. Tap to install

### Test Features

**Keyboard Functionality**
- [ ] Open any text field (Notes, Messages, etc.)
- [ ] Tap keyboard selector
- [ ] Select "Easy Life Keyboard"
- [ ] Type text - verify all keys work
- [ ] Test Shift key (caps lock)
- [ ] Test Backspace
- [ ] Test 123 button (numeric mode)
- [ ] Test emoji button
- [ ] Test Space bar

**Clipboard Manager**
- [ ] Tap "Easy Life" tab in keyboard
- [ ] Verify clipboard items appear
- [ ] Test search functionality
- [ ] Test filter buttons (Text, Images, Videos, Docs)
- [ ] Test pin/unpin items
- [ ] Test long-press menu (delete, copy, share)

**Upload Manager**
- [ ] Open Easy Life Keyboard app
- [ ] Tap "Upload Manager"
- [ ] Test photo upload
- [ ] Test video upload
- [ ] Test document upload
- [ ] Test folder assignment
- [ ] Test tag assignment
- [ ] Verify items appear in clipboard

**Settings**
- [ ] Open Easy Life Keyboard app
- [ ] Tap "Settings"
- [ ] Test keyboard height adjustment
- [ ] Test key size adjustment
- [ ] Test predictive text toggle
- [ ] Test emoji suggestions toggle
- [ ] Test vibration toggle
- [ ] Test sound toggle
- [ ] Test theme switching (Light/Dark)
- [ ] Test clipboard limit adjustment

### Report Issues

If you find bugs:
1. Note the exact steps to reproduce
2. Take screenshots
3. Check device logs: `adb logcat`
4. Create GitHub Issue with details

---

## Distribution Options

### Option 1: GitHub Releases

**Easiest for beta testers**

1. Create Release
   ```bash
   git tag v1.0.0
   git push origin v1.0.0
   ```

2. Go to GitHub → Releases
3. Click "Create a release"
4. Select tag `v1.0.0`
5. Add title and description
6. Upload APK file
7. Click "Publish release"

8. Share release link with testers

### Option 2: Direct Download

1. Upload APK to file hosting:
   - Google Drive
   - Dropbox
   - OneDrive
   - GitHub Releases

2. Share download link

3. Users download and install manually

### Option 3: Google Play Store

See [Play Store Publishing](#play-store-publishing) section below

### Option 4: F-Droid (Open Source)

For open-source versions:
1. Submit to F-Droid
2. Goes through review process
3. Available on F-Droid app store

### Option 5: APK Distribution Sites

- APKMirror
- APKPure
- Uptodown
- SlideME

**Note**: Ensure you follow each site's terms of service

---

## Play Store Publishing

### Prerequisites
- Google Play Developer account ($25 one-time fee)
- Signed APK or AAB (Android App Bundle)
- App icon, screenshots, description

### Step 1: Create Developer Account

1. Go to [play.google.com/console](https://play.google.com/console)
2. Click "Create account"
3. Accept terms and pay $25 fee
4. Complete profile information

### Step 2: Create App

1. Click "Create app"
2. Enter app name: "Easy Life Keyboard"
3. Select "Apps"
4. Select "Free"
5. Click "Create app"

### Step 3: Fill App Details

1. **App Access**
   - Select "Full app"

2. **Content Rating**
   - Fill questionnaire
   - Get content rating

3. **Target Audience**
   - Select "Not primarily for children"

4. **Content**
   - Add screenshots (min 2, max 8)
   - Add app icon (512x512px)
   - Add feature graphic (1024x500px)
   - Add short description (80 chars)
   - Add full description (4000 chars)

### Step 4: Build & Sign APK

```bash
# Create keystore (one-time)
keytool -genkey -v -keystore easy-life-keyboard.keystore \
  -keyalg RSA -keysize 2048 -validity 10000 \
  -alias easy-life-keyboard

# Build signed APK
./gradlew assembleRelease \
  -Pandroid.injected.signing.store.file=easy-life-keyboard.keystore \
  -Pandroid.injected.signing.store.password=YOUR_PASSWORD \
  -Pandroid.injected.signing.key.alias=easy-life-keyboard \
  -Pandroid.injected.signing.key.password=YOUR_PASSWORD
```

### Step 5: Upload APK

1. Go to Release → Production
2. Click "Create new release"
3. Upload signed APK
4. Add release notes
5. Review all details

### Step 6: Submit for Review

1. Go to Content rating
2. Fill questionnaire
3. Go to Pricing & distribution
4. Verify all settings
5. Click "Review" → "Submit"

### Step 7: Monitor Review

1. Check email for review status
2. Usually takes 1-3 hours
3. Once approved, app goes live

### Step 8: Manage App

- Monitor downloads and ratings
- Respond to user reviews
- Push updates
- Monitor crashes and ANRs

---

## Continuous Updates

### Release New Version

1. Update version in `app/build.gradle`:
   ```gradle
   versionCode 2
   versionName "1.1.0"
   ```

2. Commit and push:
   ```bash
   git add .
   git commit -m "v1.1.0: Bug fixes and improvements"
   git push origin main
   ```

3. GitHub Actions builds automatically

4. Download new APK from artifacts

5. For Play Store:
   - Upload new APK to Play Console
   - Add release notes
   - Submit for review

---

## Troubleshooting

### Build Fails on GitHub Actions

**Check logs:**
1. Go to Actions tab
2. Click failed workflow
3. Click "build" job
4. Expand failed step
5. Read error message

**Common fixes:**
- Ensure all files are committed
- Check for syntax errors in Kotlin
- Verify AndroidManifest.xml is valid
- Check build.gradle dependencies

### APK Installation Fails

```bash
# Clear app data
adb shell pm clear com.easylife.keyboard

# Uninstall completely
adb uninstall com.easylife.keyboard

# Reinstall
adb install app-debug.apk
```

### Keyboard Not Appearing

1. Ensure app is installed
2. Go to Settings → Languages & Input
3. Check "Easy Life Keyboard" is listed
4. Tap to select it
5. Restart device if needed

### Play Store Rejection

Common reasons:
- Crashes on startup
- Missing privacy policy
- Misleading description
- Violates content policy

**Solution:**
- Fix issues
- Test thoroughly
- Resubmit with detailed notes

---

## Monitoring & Analytics

### GitHub Analytics
- Track downloads from releases
- Monitor issue reports
- Watch for feature requests

### Play Store Analytics
- Monitor daily active users
- Track crash reports
- Review user ratings
- Analyze user feedback

### Performance Monitoring
- Monitor app crashes
- Track ANR (Application Not Responding)
- Monitor memory usage
- Track battery impact

---

## Backup & Version Control

### Backup Strategy
```bash
# Create backup branch
git branch backup-v1.0
git push origin backup-v1.0

# Tag releases
git tag -a v1.0.0 -m "Version 1.0.0 release"
git push origin v1.0.0
```

### Version History
- Keep all releases on GitHub
- Tag each release
- Document changes in CHANGELOG.md
- Maintain release notes

---

## Security Considerations

### Keystore Security
- **Never commit keystore to GitHub**
- Store securely offline
- Use strong password
- Backup securely

### Signing Key
- Keep private key safe
- Don't share with anyone
- Use same key for all updates
- Losing key means can't update app

### Code Security
- Review dependencies
- Keep libraries updated
- Scan for vulnerabilities
- Use ProGuard obfuscation

---

## Next Steps

1. ✅ Build APK using GitHub Actions
2. ✅ Test on Android device
3. ✅ Gather user feedback
4. ✅ Fix bugs and add features
5. ✅ Publish to Play Store
6. ✅ Monitor user reviews
7. ✅ Push regular updates

---

## Support & Resources

- [Android Developers](https://developer.android.com/)
- [Google Play Console Help](https://support.google.com/googleplay/android-developer)
- [GitHub Actions Documentation](https://docs.github.com/en/actions)
- [Gradle Documentation](https://gradle.org/)

---

**Ready to deploy? Start with GitHub Actions!** 🚀
