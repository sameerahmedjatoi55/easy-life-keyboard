# Easy Life Keyboard - GitHub Actions APK Generation Guide

**Complete step-by-step guide to generate your APK using GitHub Actions (Cloud-based)**

⏱️ **Time Required**: 10-15 minutes
🎯 **Difficulty**: Easy
✅ **No Local Setup Needed**

---

## What is GitHub Actions?

GitHub Actions automatically builds your app in the cloud when you push code. No need to install Android SDK locally!

**Benefits**:
- ✅ Free (included with GitHub)
- ✅ Automated building
- ✅ No local setup required
- ✅ Fast (5-10 minutes)
- ✅ Download APK directly

---

## Prerequisites

You need:
1. GitHub account (free)
2. Git installed on your computer
3. The Easy Life Keyboard project files
4. Internet connection

---

## Step-by-Step Instructions

### Step 1: Create GitHub Repository

**1.1 Go to GitHub.com**
- Open https://github.com
- Sign in to your account
- If you don't have an account, click "Sign up" (free)

**1.2 Create New Repository**
- Click "+" icon (top right) → "New repository"
- Repository name: `easy-life-keyboard`
- Description: "Android keyboard with clipboard manager"
- Choose "Public" or "Private" (your choice)
- **Do NOT** initialize with README (we'll upload files)
- Click "Create repository"

**1.3 Copy Repository URL**
- After creation, you'll see a URL like:
  ```
  https://github.com/YOUR_USERNAME/easy-life-keyboard.git
  ```
- Copy this URL (you'll need it next)

---

### Step 2: Upload Project to GitHub

**2.1 Open Terminal/Command Prompt**

**On Windows**: 
- Press `Win + R`
- Type `cmd`
- Press Enter

**On Mac/Linux**:
- Open Terminal application

**2.2 Navigate to Project**

```bash
cd path/to/easy-life-keyboard-native
```

Replace `path/to/` with your actual path. Example:
```bash
cd ~/Downloads/easy-life-keyboard-native
```

**2.3 Initialize Git**

```bash
git init
git add .
git commit -m "Initial commit: Easy Life Keyboard v1.0"
```

**2.4 Add Remote Repository**

```bash
git remote add origin https://github.com/YOUR_USERNAME/easy-life-keyboard.git
```

Replace `YOUR_USERNAME` with your GitHub username.

**2.5 Push to GitHub**

```bash
git branch -M main
git push -u origin main
```

This uploads all files to GitHub. It may take a few minutes.

**✅ Check Success**: Go to https://github.com/YOUR_USERNAME/easy-life-keyboard and verify files are there.

---

### Step 3: Enable GitHub Actions

**3.1 Go to Repository Settings**
- On GitHub, go to your repository
- Click "Settings" tab (top right)

**3.2 Enable Actions**
- Click "Actions" in left sidebar
- Click "General"
- Under "Actions permissions", select:
  - ✅ "Allow all actions and reusable workflows"
- Click "Save"

**✅ Actions are now enabled!**

---

### Step 4: Trigger the Build

**4.1 Go to Actions Tab**
- On GitHub repository page
- Click "Actions" tab (top)

**4.2 Select Build Workflow**
- Click "Build APK" workflow (on left)

**4.3 Run Workflow**
- Click "Run workflow" button
- Select branch: "main"
- Click "Run workflow" button again

**⏳ Build is starting!** You'll see it in the list.

---

### Step 5: Monitor Build Progress

**5.1 Watch Build**
- The workflow will appear in the list
- Yellow dot = building
- Green checkmark = success
- Red X = failed

**5.2 View Logs (Optional)**
- Click the workflow run
- Click "build" job
- Expand steps to see detailed logs
- Useful for debugging if something fails

**⏱️ Build usually takes 5-10 minutes**

---

### Step 6: Download Your APK

**6.1 Wait for Build to Complete**
- Status changes from "In progress" to "Completed"
- Green checkmark appears

**6.2 Download APK**
- Click the completed workflow run
- Scroll down to "Artifacts" section
- You'll see:
  - `easy-life-keyboard-debug` (for testing)
  - `easy-life-keyboard-release` (for distribution)

**6.3 Choose Which APK**

| APK Type | Size | Use For |
|----------|------|---------|
| **Debug** | 15-20MB | Testing, development |
| **Release** | 8-12MB | Distribution, Play Store |

**For testing**: Download `easy-life-keyboard-debug`

**6.4 Download**
- Click the artifact name
- It downloads as a ZIP file
- Extract the ZIP
- Inside you'll find the APK file:
  - Debug: `app-debug.apk`
  - Release: `app-release-unsigned.apk`

**✅ You now have your APK!**

---

## Step 7: Install on Android Device

### Method 1: Via USB Cable (Recommended)

**7.1 Connect Device**
- Connect Android phone via USB cable
- Enable "File Transfer" mode on phone

**7.2 Transfer APK**
- On computer, open file manager
- Navigate to your APK file
- Copy it to phone storage

**7.3 Install**
- On phone, open file manager
- Navigate to the APK file
- Tap the APK
- Tap "Install"
- Grant permissions if prompted
- Tap "Open"

**✅ App is installed!**

### Method 2: Via Email

**7.1 Email APK to Yourself**
- Attach APK to email
- Send to your email

**7.2 Open on Phone**
- Open email on phone
- Download APK attachment
- Tap to install

### Method 3: Via Cloud Storage

**7.1 Upload to Cloud**
- Upload APK to Google Drive, Dropbox, OneDrive, etc.
- Share link

**7.2 Download on Phone**
- Open link on phone
- Download APK
- Tap to install

---

## Step 8: Set as Default Keyboard

**8.1 Open App**
- Find "Easy Life Keyboard" on home screen
- Tap to open

**8.2 Set as Default**
- Tap "Set as Default Keyboard" button
- Follow system prompts
- Confirm selection

**8.3 Start Using**
- Open any text field (Notes, Messages, etc.)
- Tap keyboard selector
- Choose "Easy Life Keyboard"
- Start typing!

---

## Troubleshooting

### Build Failed (Red X)

**Check Logs**:
1. Click the failed workflow
2. Click "build" job
3. Expand steps to see error
4. Common fixes:
   - Ensure all files are committed
   - Check for syntax errors
   - Verify AndroidManifest.xml is valid

**Retry Build**:
1. Go to Actions tab
2. Click "Build APK" workflow
3. Click "Run workflow"
4. Select "main" branch
5. Click "Run workflow"

### Can't Find Artifacts

**Check**:
- Build completed successfully (green checkmark)
- Scroll down on workflow page
- Look for "Artifacts" section
- If not there, build may have failed

### APK Won't Install

**Try**:
- Uninstall old version first
- Check device has enough storage
- Enable "Unknown Sources" in Settings
- Try different installation method

### App Crashes on Launch

**Check**:
- Device has Android 10 or higher
- Sufficient storage space
- Try clearing app cache
- Reinstall APK

---

## Build Variants Explained

### Debug APK (`app-debug.apk`)
- **Size**: 15-20MB
- **Use**: Testing, development
- **Features**: Debug symbols, logging
- **Installation**: Easier (no signing needed)
- **Distribution**: Not suitable for Play Store

### Release APK (`app-release-unsigned.apk`)
- **Size**: 8-12MB
- **Use**: Distribution, Play Store
- **Features**: Optimized, obfuscated
- **Installation**: Requires signing for Play Store
- **Distribution**: Suitable for Play Store

**For now, use Debug APK for testing.**

---

## Next Steps After Installation

### Test Features
- [ ] Type text with keyboard
- [ ] Test Shift key
- [ ] Test 123 button (numeric mode)
- [ ] Test emoji button
- [ ] Access Easy Life tab
- [ ] Upload photos/videos/documents
- [ ] Test search functionality
- [ ] Test settings

### Customize
- [ ] Adjust keyboard height
- [ ] Change key size
- [ ] Toggle predictive text
- [ ] Change theme (Light/Dark)
- [ ] Adjust clipboard limit

### Share
- [ ] Share with friends
- [ ] Get feedback
- [ ] Report bugs
- [ ] Suggest features

---

## Common Questions

### Q: Is GitHub Actions free?
**A**: Yes! Free with GitHub account. Includes 2,000 free build minutes per month.

### Q: How long does build take?
**A**: Usually 5-10 minutes. Depends on GitHub server load.

### Q: Can I build multiple times?
**A**: Yes! You can trigger builds as many times as you want.

### Q: What if build fails?
**A**: Check the logs for errors. Most common issues are file problems. Retry after fixing.

### Q: Can I modify the code?
**A**: Yes! Edit files, commit changes, push to GitHub, and trigger new build.

### Q: Is the APK safe?
**A**: Yes! Built from your own source code on GitHub's servers.

### Q: Can I share the APK?
**A**: Yes! Share with friends, family, or testers. They can install directly.

### Q: Can I publish to Play Store?
**A**: Yes! After signing the APK. See DEPLOYMENT.md for details.

---

## What Happens During Build?

**GitHub Actions automatically**:
1. ✅ Downloads your code
2. ✅ Sets up Android SDK
3. ✅ Installs dependencies
4. ✅ Compiles Kotlin code
5. ✅ Builds APK
6. ✅ Uploads artifacts
7. ✅ Makes available for download

**All in the cloud - no local setup needed!**

---

## Tips for Success

1. **Keep Project Updated**
   - Make changes locally
   - Commit: `git commit -m "Your message"`
   - Push: `git push origin main`
   - Trigger new build

2. **Monitor Builds**
   - Check Actions tab regularly
   - Review build logs
   - Fix any issues quickly

3. **Test Thoroughly**
   - Install on multiple devices if possible
   - Test all features
   - Report bugs

4. **Organize Artifacts**
   - Download and keep APKs
   - Label by version
   - Keep for reference

---

## Support

**Need Help?**
- Check troubleshooting section above
- Review build logs for errors
- Check GitHub Issues
- Create new issue if needed

**Documentation**:
- See QUICKSTART.md for usage
- See FEATURES.md for feature details
- See README.md for overview

---

## Summary

✅ **You now know how to**:
1. Create GitHub repository
2. Upload project to GitHub
3. Enable GitHub Actions
4. Trigger APK build
5. Download APK
6. Install on Android device
7. Set as default keyboard
8. Use the app

**Total time**: 10-15 minutes from start to installed app!

---

## Ready to Build?

**Follow these steps**:
1. ✅ Create GitHub account (if needed)
2. ✅ Create repository
3. ✅ Upload project
4. ✅ Enable Actions
5. ✅ Trigger build
6. ✅ Download APK
7. ✅ Install on device
8. ✅ Enjoy!

**Your APK will be ready in 10-15 minutes!** 🚀

---

**Questions? Check the troubleshooting section or review the steps above.**

**Happy building! 🎹📋**
