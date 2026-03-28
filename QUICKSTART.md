# Easy Life Keyboard - Quick Start Guide

Get your APK and install Easy Life Keyboard in minutes!

## 📥 Option 1: Download Pre-built APK (Fastest)

If you have a pre-built APK file:

1. **Transfer to Android Device**
   - Via USB cable
   - Via email
   - Via cloud storage (Google Drive, Dropbox, etc.)

2. **Install**
   - Open file manager on device
   - Tap the APK file
   - Tap "Install"
   - Grant permissions if prompted
   - Tap "Open"

3. **Set as Default Keyboard**
   - Open Easy Life Keyboard app
   - Tap "Set as Default Keyboard"
   - Go to Settings → Languages & Input → Keyboard
   - Select "Easy Life Keyboard"

4. **Start Using**
   - Open any text field (Notes, Messages, etc.)
   - Tap keyboard selector
   - Choose "Easy Life Keyboard"
   - Start typing!

---

## 🔨 Option 2: Build APK with GitHub Actions (Recommended)

**No local setup required!**

### Step 1: Upload Project to GitHub

```bash
# Clone this project
git clone https://github.com/YOUR_USERNAME/easy-life-keyboard.git
cd easy-life-keyboard

# Initialize git
git init
git add .
git commit -m "Easy Life Keyboard - Initial commit"

# Push to GitHub
git remote add origin https://github.com/YOUR_USERNAME/easy-life-keyboard.git
git branch -M main
git push -u origin main
```

### Step 2: Enable GitHub Actions

1. Go to your GitHub repository
2. Click "Settings" tab
3. Click "Actions" → "General"
4. Select "Allow all actions and reusable workflows"
5. Click "Save"

### Step 3: Trigger Build

1. Go to "Actions" tab
2. Click "Build APK" workflow
3. Click "Run workflow" button
4. Select "main" branch
5. Click "Run workflow"

### Step 4: Wait for Build

- Build usually takes 5-10 minutes
- You can watch progress in real-time
- Check the workflow logs for details

### Step 5: Download APK

1. Click the completed workflow run
2. Scroll down to "Artifacts" section
3. Download `easy-life-keyboard-debug.zip`
4. Extract the ZIP file
5. You'll get `app-debug.apk`

### Step 6: Install on Device

- Transfer APK to Android device
- Tap to install
- Grant permissions
- Open app and set as default keyboard

---

## 💻 Option 3: Build Locally with Android Studio

**Best for developers**

### Prerequisites
- Android Studio 2023.1+
- JDK 11+
- 4GB RAM
- 5GB disk space

### Steps

1. **Download Android Studio**
   - Visit [developer.android.com/studio](https://developer.android.com/studio)
   - Install for your OS

2. **Open Project**
   - Launch Android Studio
   - Click "Open" → Select project folder
   - Wait for Gradle sync

3. **Configure SDK**
   - File → Settings → Android SDK
   - Install Android 14 (API 34)
   - Install Build-Tools 34.0.0

4. **Build APK**
   - Click Build → Build Bundle(s) / APK(s) → Build APK(s)
   - Wait for build to complete
   - APK location: `app/build/outputs/apk/debug/app-debug.apk`

5. **Install**
   - Connect Android device via USB
   - Enable USB Debugging on device
   - Click Run → Run 'app'
   - Select device
   - Click OK

---

## 📱 First Time Setup

### 1. Install App
- Install APK (see options above)
- Grant requested permissions

### 2. Set as Default Keyboard
- Open Easy Life Keyboard app
- Tap "Set as Default Keyboard"
- Follow system prompts
- Confirm selection

### 3. Explore Features
- **Keyboard**: Type normally
- **Easy Life Tab**: Access clipboard items
- **Upload Manager**: Add photos, videos, documents
- **Settings**: Customize keyboard behavior

### 4. Upload First Items
- Open Easy Life Keyboard app
- Tap "Upload Manager"
- Tap "📷 Photo" / "🎥 Video" / "📄 Document"
- Select file from device
- Add folder/tags (optional)
- Tap "Upload"
- Items now appear in Easy Life tab

---

## 🎯 Common Tasks

### Type Text
1. Open any text field
2. Tap keyboard selector
3. Choose "Easy Life Keyboard"
4. Type normally
5. Use Shift for capitals
6. Use 123 for numbers/symbols

### Access Clipboard Items
1. Open text field
2. Tap "Easy Life" tab in keyboard
3. Scroll to find item
4. Tap to paste

### Pin Important Items
1. Open Easy Life tab
2. Find item you want to pin
3. Tap pin icon (becomes gold)
4. Item stays at top of list

### Search for Items
1. Open Easy Life tab
2. Tap search bar
3. Type search term
4. Results filter in real-time

### Filter by Type
1. Open Easy Life tab
2. Use filter buttons at top:
   - **All** - Show everything
   - **Text** - Text only
   - **Images** - Photos only
   - **Videos** - Videos only
   - **Docs** - Documents only

### Adjust Keyboard Settings
1. Open Easy Life Keyboard app
2. Tap "Settings"
3. Adjust:
   - Keyboard height
   - Key size
   - Vibration feedback
   - Sound feedback
   - Theme (Light/Dark)
   - Clipboard limit

### Clear Clipboard History
1. Open Easy Life Keyboard app
2. Tap "Settings"
3. Scroll to "Clipboard Settings"
4. Tap "Clear Clipboard History"
5. Confirm

---

## ⚙️ Settings Explained

| Setting | Options | Default | Purpose |
|---------|---------|---------|---------|
| Keyboard Height | Small, Medium, Large | Medium | Adjust keyboard size |
| Key Size | Small, Normal, Large | Normal | Adjust individual key size |
| Predictive Text | On/Off | On | Show text suggestions |
| Emoji Suggestions | On/Off | On | Show emoji recommendations |
| Vibration | On/Off | On | Haptic feedback on key press |
| Sound | On/Off | Off | Audio feedback on key press |
| Theme | Light, Dark, Auto | Auto | Choose color scheme |
| Clipboard Limit | 25, 50, 100 | 50 | Max items to store |

---

## 🆘 Troubleshooting

### Keyboard Not Appearing
- Ensure app is installed
- Go to Settings → Languages & Input → Keyboard
- Select Easy Life Keyboard
- Restart device

### Clipboard Items Not Showing
- Check storage permissions
- Restart keyboard (switch to another, then back)
- Clear app cache

### Installation Fails
- Uninstall old version first
- Ensure device has enough storage
- Try different installation method

### Build Fails on GitHub
- Check internet connection
- Verify all files are committed
- Check GitHub Actions logs for errors
- Try rebuilding

### Performance Issues
- Clear clipboard history
- Reduce clipboard limit
- Restart device
- Check device storage space

---

## 📚 Learn More

- **Full Documentation**: See `README.md`
- **Build Instructions**: See `BUILDING.md`
- **Deployment Guide**: See `DEPLOYMENT.md`
- **GitHub Actions**: See `.github/workflows/build-apk.yml`

---

## 🎉 You're Ready!

Your Easy Life Keyboard is now installed and ready to use. Enjoy faster typing and easy clipboard access!

**Tips for best experience:**
- ✅ Pin your most-used items
- ✅ Organize with folders and tags
- ✅ Customize keyboard height to your preference
- ✅ Enable vibration feedback for tactile response
- ✅ Use search to quickly find items

---

## 📞 Need Help?

1. Check the Troubleshooting section above
2. Read the full README.md
3. Check GitHub Issues
4. Review build logs for errors

---

**Happy typing! 🎹📋**
