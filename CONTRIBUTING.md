# Contributing to Easy Life Keyboard

Thank you for your interest in contributing to Easy Life Keyboard! This document provides guidelines and instructions for contributing.

## Code of Conduct

- Be respectful and inclusive
- Provide constructive feedback
- Focus on the code, not the person
- Help others learn and grow

## Ways to Contribute

### 1. Report Bugs
- Check if bug already exists in Issues
- Provide clear description and steps to reproduce
- Include device info (Android version, device model)
- Attach screenshots or logs if possible

### 2. Suggest Features
- Check if feature already requested
- Describe the feature clearly
- Explain use case and benefits
- Provide mockups or examples if helpful

### 3. Improve Documentation
- Fix typos or unclear explanations
- Add examples and clarifications
- Improve formatting and readability
- Translate to other languages

### 4. Submit Code
- Fix bugs
- Implement features
- Improve performance
- Refactor code
- Add tests

## Getting Started

### Prerequisites
- Android Studio 2023.1+
- JDK 11+
- Git
- GitHub account

### Setup Development Environment

1. **Fork Repository**
   - Click "Fork" on GitHub
   - Clone your fork locally

2. **Clone Repository**
   ```bash
   git clone https://github.com/YOUR_USERNAME/easy-life-keyboard.git
   cd easy-life-keyboard
   ```

3. **Create Feature Branch**
   ```bash
   git checkout -b feature/your-feature-name
   ```

4. **Open in Android Studio**
   - Launch Android Studio
   - Click "Open" → Select project folder
   - Wait for Gradle sync

5. **Make Changes**
   - Edit code
   - Test thoroughly
   - Follow code style guidelines

6. **Commit Changes**
   ```bash
   git add .
   git commit -m "Add feature: your feature description"
   ```

7. **Push to Fork**
   ```bash
   git push origin feature/your-feature-name
   ```

8. **Create Pull Request**
   - Go to GitHub
   - Click "Compare & pull request"
   - Describe your changes
   - Submit PR

## Code Style Guidelines

### Kotlin Style
- Follow [Kotlin Coding Conventions](https://kotlinlang.org/docs/coding-conventions.html)
- Use meaningful variable names
- Add comments for complex logic
- Keep functions focused and small

### Naming Conventions
```kotlin
// Classes - PascalCase
class KeyboardService { }
class ClipboardItem { }

// Functions - camelCase
fun getClipboardItems() { }
fun updateItem() { }

// Constants - UPPER_SNAKE_CASE
const val MAX_ITEMS = 50
const val DEFAULT_HEIGHT = "medium"

// Variables - camelCase
var currentKeyboard: Keyboard? = null
val repository = ClipboardRepository(context)
```

### File Organization
```
com/easylife/keyboard/
├── ime/                    # Keyboard engine
│   └── EasyLifeKeyboardService.kt
├── ui/                     # UI activities and components
│   ├── MainActivity.kt
│   ├── SettingsActivity.kt
│   ├── UploadManagerActivity.kt
│   └── KeyboardViewManager.kt
├── data/                   # Data layer
│   ├── AppDatabase.kt
│   ├── ClipboardDao.kt
│   ├── ClipboardItem.kt
│   └── ClipboardRepository.kt
└── utils/                  # Utility functions (if added)
    └── Extensions.kt
```

### Documentation
- Add comments for public functions
- Explain complex algorithms
- Document edge cases
- Use KDoc for classes and functions

```kotlin
/**
 * Adds a clipboard item to the database.
 * 
 * Automatically removes oldest item if limit is reached.
 *
 * @param item The clipboard item to add
 * @return The ID of the inserted item
 */
suspend fun addItem(item: ClipboardItem): Long {
    // Implementation
}
```

## Testing

### Unit Tests
```kotlin
class ClipboardRepositoryTest {
    @Test
    fun testAddItem() {
        // Test implementation
    }
}
```

### Integration Tests
- Test keyboard functionality
- Test clipboard operations
- Test settings persistence
- Test multi-app compatibility

### Manual Testing
- Test on multiple Android versions (10, 11, 12, 13, 14)
- Test on different device sizes
- Test with different settings
- Test edge cases

## Commit Messages

Use clear, descriptive commit messages:

```
Format: [Type] Brief description

Types:
- feat: New feature
- fix: Bug fix
- docs: Documentation
- style: Code style
- refactor: Code refactoring
- perf: Performance improvement
- test: Adding tests
- chore: Build, dependencies, etc.

Examples:
- feat: Add clipboard search functionality
- fix: Fix keyboard height not persisting
- docs: Update README with new features
- refactor: Simplify clipboard repository
- perf: Optimize database queries
```

## Pull Request Process

1. **Before Submitting**
   - Test thoroughly
   - Run linter: `./gradlew lint`
   - Check for code style issues
   - Update documentation if needed
   - Add tests for new features

2. **PR Description**
   - Describe what changed and why
   - Reference related issues
   - Include before/after screenshots if UI change
   - List any breaking changes

3. **PR Template**
   ```markdown
   ## Description
   Brief description of changes
   
   ## Type of Change
   - [ ] Bug fix
   - [ ] New feature
   - [ ] Breaking change
   - [ ] Documentation update
   
   ## Testing
   - [ ] Tested on Android 10
   - [ ] Tested on Android 14
   - [ ] All features working
   
   ## Checklist
   - [ ] Code follows style guidelines
   - [ ] Documentation updated
   - [ ] No new warnings
   - [ ] Tests added/updated
   
   ## Screenshots (if applicable)
   [Add screenshots here]
   ```

4. **Review Process**
   - Maintainers will review code
   - May request changes
   - Once approved, PR will be merged
   - Your contribution is now part of the project!

## Development Workflow

### Feature Development
1. Create feature branch from `main`
2. Implement feature
3. Add tests
4. Update documentation
5. Submit PR for review
6. Address feedback
7. Merge to `main`

### Bug Fixes
1. Create bugfix branch from `main`
2. Reproduce bug
3. Fix issue
4. Add regression test
5. Submit PR
6. Merge to `main`

### Documentation Updates
1. Create docs branch
2. Update documentation
3. Submit PR
4. Merge to `main`

## Building and Testing

### Build Debug APK
```bash
./gradlew assembleDebug
```

### Build Release APK
```bash
./gradlew assembleRelease
```

### Run Tests
```bash
./gradlew test
```

### Run Linter
```bash
./gradlew lint
```

### Clean Build
```bash
./gradlew clean build
```

## Project Structure

```
easy-life-keyboard/
├── app/
│   ├── src/main/
│   │   ├── java/com/easylife/keyboard/    # Kotlin source code
│   │   ├── res/                            # Resources (layouts, strings, etc.)
│   │   └── AndroidManifest.xml
│   ├── build.gradle                        # App build configuration
│   └── proguard-rules.pro                  # Code obfuscation rules
├── .github/workflows/                      # GitHub Actions
├── build.gradle                            # Root build configuration
├── settings.gradle                         # Gradle settings
├── README.md                               # Project overview
├── BUILDING.md                             # Build instructions
├── DEPLOYMENT.md                           # Deployment guide
├── QUICKSTART.md                           # Quick start guide
├── CHANGELOG.md                            # Version history
└── CONTRIBUTING.md                         # This file
```

## Key Files to Know

| File | Purpose |
|------|---------|
| `app/build.gradle` | App dependencies and build config |
| `app/src/main/AndroidManifest.xml` | App permissions and components |
| `app/src/main/java/com/easylife/keyboard/ime/EasyLifeKeyboardService.kt` | Main keyboard engine |
| `app/src/main/java/com/easylife/keyboard/data/AppDatabase.kt` | Database setup |
| `app/src/main/res/xml/qwerty.xml` | Keyboard layout definition |

## Common Tasks

### Add New Feature
1. Create feature branch
2. Add code in appropriate package
3. Update UI if needed
4. Add database schema if needed
5. Update settings if configurable
6. Add tests
7. Update documentation
8. Submit PR

### Fix Bug
1. Create bugfix branch
2. Locate issue in code
3. Implement fix
4. Add test to prevent regression
5. Test thoroughly
6. Submit PR

### Update Documentation
1. Create docs branch
2. Edit relevant markdown file
3. Check formatting
4. Submit PR

## Getting Help

- **Questions**: Create GitHub Discussion
- **Issues**: Check existing issues first
- **Documentation**: Read README.md and guides
- **Code Examples**: Look at existing code

## Maintainers

- Primary maintainer: [Your Name]
- Reviewers: [Team members]
- Contact: [Email or GitHub]

## Recognition

Contributors will be recognized in:
- README.md contributors section
- CHANGELOG.md release notes
- GitHub contributors page

## License

By contributing, you agree that your contributions will be licensed under the same license as the project.

---

## Quick Reference

### Useful Commands
```bash
# Clone repository
git clone https://github.com/YOUR_USERNAME/easy-life-keyboard.git

# Create feature branch
git checkout -b feature/feature-name

# Build debug APK
./gradlew assembleDebug

# Run tests
./gradlew test

# Push changes
git push origin feature/feature-name

# Create pull request
# (via GitHub web interface)
```

### Important Files
- `README.md` - Project overview
- `BUILDING.md` - Build instructions
- `app/build.gradle` - Dependencies
- `app/src/main/AndroidManifest.xml` - Permissions

### Key Packages
- `ime/` - Keyboard engine
- `ui/` - User interface
- `data/` - Data persistence
- `utils/` - Utilities (if added)

---

Thank you for contributing to Easy Life Keyboard! Your efforts help make this project better for everyone. 🙏

**Happy coding! 🚀**
