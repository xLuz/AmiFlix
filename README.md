# AmiFlix - Android TV App

🎌 **AmiFlix** is a sleek Android TV application designed for watching French-dubbed anime content. Perfect for families who want to enjoy anime in French!

## 🌟 Features

- **📺 Android TV Optimized**: Built specifically for Android TV with D-pad navigation
- **🇫🇷 French Content**: Sources anime from popular French anime streaming websites
- **🎨 Sleek UI**: Modern, dark theme with TV-optimized interface
- **👨‍👩‍👧‍👦 Family-Friendly**: Includes parental controls and content filtering
- **📱 Remote Control Navigation**: Full D-pad and remote control support
- **🔍 Search & Discovery**: Find your favorite anime easily
- **❤️ Favorites System**: Save and organize your favorite anime
- **📈 Watch Progress**: Track your viewing progress across episodes
- **🎬 Multiple Sources**: Aggregates content from multiple French anime platforms

## 🚀 Installation

### Prerequisites
- Android TV device (Android 5.0+ / API 21+)
- Internet connection

### Building from Source

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/amiflix.git
   cd amiflix
   ```

2. **Open in Android Studio**
   - Launch Android Studio
   - Click "Open an existing Android Studio project"
   - Select the `amiflix` directory

3. **Build the APK**
   ```bash
   ./gradlew assembleDebug
   ```

4. **Install on Android TV**
   - Enable "Developer options" and "USB debugging" on your Android TV
   - Connect your TV via ADB or transfer the APK file
   - Install the APK: `adb install app/build/outputs/apk/debug/app-debug.apk`

## 📱 Usage

### Navigation
- Use your TV remote's D-pad to navigate through the interface
- **Home**: Browse featured anime, trending content, and recommendations
- **Search**: Find specific anime titles
- **Favorites**: Access your saved anime
- **History**: View your watch history
- **Settings**: Configure app preferences and parental controls

### Features

#### 🏠 Home Screen
- **Featured Anime**: Curated selection of popular anime
- **Trending**: Currently popular anime
- **New Episodes**: Recently released episodes
- **Continue Watching**: Resume where you left off
- **Recommendations**: Personalized suggestions

#### 🔍 Search
- Search across multiple French anime sources
- Filter by genre, year, and rating
- Real-time search results

#### 👶 Parental Controls
- Content filtering by age rating
- PIN protection for restricted content
- Safe mode for younger viewers

## 🏗️ Architecture

### Tech Stack
- **Language**: Kotlin
- **UI Framework**: Jetpack Compose for TV
- **Architecture**: MVVM with Repository pattern
- **Dependency Injection**: Hilt
- **Navigation**: Navigation Component
- **Video Player**: ExoPlayer
- **Web Scraping**: Jsoup
- **Networking**: Retrofit + OkHttp
- **Image Loading**: Coil

### Project Structure
```
app/
├── src/main/java/com/amiflix/androidtv/
│   ├── data/
│   │   ├── models/          # Data models
│   │   ├── repository/      # Data repository
│   │   └── scraper/         # Web scraping logic
│   ├── di/                  # Dependency injection
│   ├── ui/
│   │   ├── components/      # Reusable UI components
│   │   ├── navigation/      # Navigation setup
│   │   ├── screens/         # Screen composables
│   │   └── theme/           # App theming
│   └── MainActivity.kt      # Main entry point
└── src/main/res/
    ├── values/              # Resources (strings, colors, themes)
    └── xml/                 # Configuration files
```

## 🎨 Design

### Color Scheme
- **Primary**: `#6C5CE7` (Purple)
- **Secondary**: `#A29BFE` (Light Purple)
- **Background**: `#0B0B0B` (Dark)
- **Surface**: `#1A1A1A` (Dark Gray)
- **Accent**: Various colorful accents for visual appeal

### Typography
- TV-optimized font sizes
- High contrast for better readability
- Consistent spacing and hierarchy

## 🔧 Configuration

### Supported Sources
The app currently supports these French anime streaming sources:
- Anime-Sama
- Mavanimes
- Anime-Ultime
- JetAnime

### Customization
- Modify `StreamingSource` enum to add/remove sources
- Update scraping logic in `FrenchAnimeScraper`
- Customize UI themes in `ui/theme/`

## 🛠️ Development

### Adding New Features
1. Create feature branch: `git checkout -b feature/new-feature`
2. Implement feature following MVVM pattern
3. Add appropriate tests
4. Update documentation
5. Submit pull request

### Code Style
- Follow Kotlin coding conventions
- Use meaningful variable and function names
- Comment complex logic
- Follow single responsibility principle

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📋 TODO

- [ ] Implement video player with ExoPlayer
- [ ] Add search functionality
- [ ] Implement favorites system
- [ ] Add parental controls
- [ ] Optimize performance for TV devices
- [ ] Add more French anime sources
- [ ] Implement offline viewing
- [ ] Add subtitle support
- [ ] Create detailed anime information screens

## ⚖️ Legal Notice

This app is for educational purposes only. It aggregates publicly available content from various sources. Users are responsible for ensuring they comply with local laws and regulations regarding content consumption.

## 📞 Support

For support, please create an issue in the GitHub repository or contact the development team.

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

**Made with ❤️ for the French anime community** 