# Easy Life Keyboard - Android Custom Keyboard with Clipboard Manager

A fully functional Android keyboard app with an integrated clipboard manager for text, images, videos, and documents. Features a modern UI, offline-first functionality, and seamless integration with Android system keyboard settings.

## Features

### 🎹 Keyboard Engine
- **QWERTY Layout** - Standard keyboard with all keys
- **Numeric/Symbol Toggle** - Quick access to numbers and symbols (123 button)
- **Emoji Support** - Dedicated emoji picker
- **Shift & Caps Lock** - Full text case control
- **Predictive Text** - Optional text suggestions (configurable)
- **Haptic Feedback** - Vibration on key press (optional)
- **Sound Feedback** - Audio feedback on typing (optional)

### 📋 Easy Life Clipboard Manager
- **Multi-format Support** - Text, images, videos, documents
- **Grid View Display** - Thumbnail previews for media
- **Pin/Save Items** - Mark important items for quick access
- **Search & Filter** - Find items by type or content
- **Folder Organization** - Organize items into custom folders
- **Tag System** - Categorize items with tags
- **History Limit** - 50 items by default (configurable: 25-100)
- **Offline Access** - All items stored locally

### 📤 Upload Manager
- **Photo Upload** - Pick from gallery or camera
- **Video Upload** - Select videos from device
- **Document Upload** - Support for PDF, DOCX, XLSX
- **File Preview** - Preview before saving
- **Folder/Tag Assignment** - Organize on upload
- **Batch Operations** - Manage multiple items

### ⚙️ Settings & Configuration
- **Set as Default Keyboard** - Make it your system keyboard
- **Keyboard Height** - Small, Medium, Large options
- **Key Size** - Adjust for comfort
- **Predictive Text** - Enable/disable suggestions
- **Emoji Suggestions** - Toggle emoji recommendations
- **Vibration Control** - Haptic feedback toggle
- **Sound Control** - Audio feedback toggle
- **Theme Support** - Light, Dark, Auto (system)
- **Clipboard Limit** - Customize history size
- **Auto-clear History** - Optional auto-cleanup

### 🔒 Privacy & Security
- **Local Storage Only** - All data stored on device
- **No Cloud Sync** - GDPR compliant
- **Offline-First** - Works without internet
- **Persistent Storage** - Data survives device reboot

## System Requirements

- **Android Version** - 10 (API 30) and above
- **RAM** - Minimum 512MB
- **Storage** - ~50MB for app + clipboard items
- **Permissions** - Read/Write external storage, Camera (optional)

## Installation

### Option 1: Build Locally (Recommended for Development)

#### Prerequisites
- Android Studio 2023.1 or later
- JDK 11 or higher
- Android SDK 34
- Gradle 8.1.0

#### Steps
1. Clone or download the project
2. Open in Android Studio
3. Sync Gradle files
4. Build → Build Bundle(s) / APK(s) → Build APK(s)
5. Find APK in `app/build/outputs/apk/debug/`

### Option 2: Use GitHub Actions (Automated Cloud Build)

1. **Fork or Upload to GitHub**
   ```bash
   git init
   git add .
   git commit -m "Initial commit"
   git remote add origin https://github.com/YOUR_USERNAME/easy-life-keyboard.git
   git push -u origin main
   ```

2. **Enable GitHub Actions**
   - Go to repository Settings → Actions → General
   - Ensure "Allow all actions and reusable workflows" is selected

3. **Trigger Build**
   - Push code to main branch or manually trigger workflow
   - Go to Actions tab → Build APK → Run workflow
   - Download APK from artifacts

4. **Get the APK**
   - Navigate to Actions → Latest workflow run
   - Download `easy-life-keyboard-debug` or `easy-life-keyboard-release`

### Option 3: Use Third-Party Build Services

Services like **Codemagic**, **AppCenter**, or **Bitrise** can also build your APK:

1. Connect your GitHub repository
2. Configure build settings (usually auto-detected)
3. Trigger build
4. Download APK from dashboard

## Project Structure

```
easy-life-keyboard/
├── app/
│   ├── src/main/
│   │   ├── java/com/easylife/keyboard/
│   │   │   ├── ime/
│   │   │   │   └── EasyLifeKeyboardService.kt      # Main keyboard engine
│   │   │   ├── ui/
│   │   │   │   ├── MainActivity.kt                 # App launcher
│   │   │   │   ├── UploadManagerActivity.kt        # Upload interface
│   │   │   │   ├── SettingsActivity.kt             # Settings screen
│   │   │   │   └── KeyboardViewManager.kt          # Keyboard UI
│   │   │   └── data/
│   │   │       ├── AppDatabase.kt                  # Room database
│   │   │       ├── ClipboardDao.kt                 # Database queries
│   │   │       ├── ClipboardItem.kt                # Data model
│   │   │       └── ClipboardRepository.kt          # Data layer
│   │   ├── res/
│   │   │   ├── layout/                             # XML layouts
│   │   │   ├── values/                             # Strings, colors, styles
│   │   │   ├── xml/                                # Keyboard layouts
│   │   │   └── mipmap/                             # App icons
│   │   └── AndroidManifest.xml
│   ├── build.gradle
│   └── proguard-rules.pro
├── build.gradle
├── settings.gradle
├── gradle.properties
├── .github/workflows/build-apk.yml                 # GitHub Actions workflow
└── README.md
```

## Build Variants

### Debug APK
- Unoptimized, includes debug symbols
- Suitable for testing and development
- Larger file size (~15-20MB)
- Can be installed alongside release version

### Release APK
- Optimized with ProGuard obfuscation
- Smaller file size (~8-12MB)
- Ready for production/distribution
- Requires signing for Play Store

## Configuration

### Keyboard Settings
Edit `app/src/main/res/values/strings.xml` to customize:
- App name and labels
- Default settings
- Help text

### Database Settings
Edit `app/src/main/java/com/easylife/keyboard/data/AppDatabase.kt`:
- Database name
- Version number
- Schema updates

### Keyboard Layouts
Edit XML files in `app/src/main/res/xml/`:
- `qwerty.xml` - QWERTY layout
- `numeric.xml` - Number/symbol layout

## Dependencies

- **AndroidX** - Modern Android framework
- **Room Database** - Local data persistence
- **Material Design** - UI components
- **Kotlin Coroutines** - Async operations
- **Lifecycle** - Component lifecycle management

## Building APK with Gradle

### Debug Build
```bash
./gradlew assembleDebug
# Output: app/build/outputs/apk/debug/app-debug.apk
```

### Release Build
```bash
./gradlew assembleRelease
# Output: app/build/outputs/apk/release/app-release-unsigned.apk
```

### Full Build
```bash
./gradlew build
```

### Clean Build
```bash
./gradlew clean build
```

## Installation on Device

### Via ADB (Android Debug Bridge)
```bash
adb install app/build/outputs/apk/debug/app-debug.apk
```

### Via File Manager
1. Copy APK to device storage
2. Open file manager
3. Tap APK file
4. Follow installation prompts

### Via Play Store (After Publishing)
- Upload signed APK to Google Play Console
- Users can install directly from Play Store

## Setting as Default Keyboard

1. Open Easy Life Keyboard app
2. Tap "Set as Default Keyboard"
3. Go to Android Settings → Languages & Input → Keyboard
4. Select "Easy Life Keyboard"
5. Confirm selection

## Usage Tips

### Clipboard Manager
- **Access**: Tap "Easy Life" tab in keyboard
- **Pin Items**: Tap pin icon to save frequently used items
- **Search**: Use search bar to find items
- **Filter**: Use filter buttons (Text, Images, Videos, Docs)

### Upload Manager
- **Access**: Open Easy Life Keyboard app → Upload Manager
- **Organize**: Assign folders and tags during upload
- **Preview**: Check file before saving

### Settings
- **Access**: Open Easy Life Keyboard app → Settings
- **Customize**: Adjust keyboard height, key size, feedback
- **Theme**: Switch between light/dark modes

## Troubleshooting

### Keyboard Not Appearing
- Ensure app is installed
- Go to Settings → Languages & Input → Keyboard
- Select Easy Life Keyboard
- Restart device if needed

### Clipboard Items Not Showing
- Check storage permissions
- Ensure items were uploaded successfully
- Restart keyboard by switching to another keyboard and back

### Performance Issues
- Clear clipboard history (Settings → Clear History)
- Reduce clipboard limit (Settings → Clipboard Limit)
- Restart device

### Build Failures
- Ensure JDK 11 is installed
- Run `./gradlew clean` before rebuilding
- Check Android SDK is up to date
- Verify all dependencies are downloaded

## Permissions

The app requires the following permissions:

| Permission | Purpose |
|-----------|---------|
| `READ_EXTERNAL_STORAGE` | Access photos, videos, documents |
| `WRITE_EXTERNAL_STORAGE` | Save clipboard items |
| `CAMERA` | Take photos for upload |
| `VIBRATE` | Haptic feedback on key press |
| `INTERNET` | Future cloud sync (optional) |

## Performance Optimization

- **Database**: Indexed queries for fast search
- **Memory**: Lazy-load clipboard items
- **Battery**: Minimize background processes
- **Storage**: Automatic old item cleanup
- **UI**: Efficient grid rendering with pagination

## Privacy Policy

Easy Life Keyboard respects user privacy:
- ✅ All data stored locally on device
- ✅ No cloud synchronization
- ✅ No tracking or analytics
- ✅ No ads or third-party services
- ✅ GDPR compliant

## Future Enhancements

- Cloud sync with encryption
- Custom keyboard themes
- Text expansion/shortcuts
- Multi-language support
- Gesture typing
- Voice input
- Clipboard sharing between devices

## Contributing

Contributions are welcome! Please:
1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Submit a pull request

## License

This project is provided as-is for personal and educational use.

## Support

For issues or questions:
1. Check the Troubleshooting section
2. Review the code comments
3. Check GitHub Issues
4. Contact via email

## Version History

### v1.0.0 (Current)
- Initial release
- QWERTY keyboard with basic features
- Clipboard manager with pin/search
- Upload manager for media
- Settings and customization
- Light/Dark theme support
- Offline-first functionality

---

**Easy Life Keyboard** - Your clipboard, always within reach! 🎹📋
