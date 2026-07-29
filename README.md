<div align="center">

  <img src="app/src/main/res/drawable/voy_logo.xml" alt="Voy Logo" width="120" height="120" />

  # 🚗 VOY - Smart Carpooling & Eco-Mobility Platform

  <p align="center">
    <strong>Connect. Shared Rides. Reduce Emissions.</strong>
  </p>

  <p align="center">
    <a href="https://kotlinlang.org"><img src="https://img.shields.io/badge/Language-Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white" alt="Kotlin" /></a>
    <a href="https://developer.android.com"><img src="https://img.shields.io/badge/Platform-Android-3DDC84?style=for-the-badge&logo=android&logoColor=white" alt="Android" /></a>
    <a href="https://developer.android.com/about/versions/14"><img src="https://img.shields.io/badge/Target%20SDK-34%20%28Android%2014%29-00599C?style=for-the-badge&logo=android" alt="Target SDK 34" /></a>
    <a href="https://developer.android.com/about/versions/marshmallow"><img src="https://img.shields.io/badge/Min%20SDK-26%20%28Android%208.0%29-orange?style=for-the-badge" alt="Min SDK 26" /></a>
    <a href="https://developers.google.com/maps"><img src="https://img.shields.io/badge/Maps-Google%20Maps%20SDK-4285F4?style=for-the-badge&logo=googlemaps&logoColor=white" alt="Google Maps" /></a>
  </p>

  <p align="center">
    <a href="#-about-the-project">About</a> •
    <a href="#-key-features">Key Features</a> •
    <a href="#-figma-ui-design--screenshots">UI Designs & Screenshots</a> •
    <a href="#-tech-stack--architecture">Tech Stack</a> •
    <a href="#-repository-structure">Project Structure</a> •
    <a href="#-api-endpoint-reference">API Endpoints</a> •
    <a href="#-getting-started">Getting Started</a>
  </p>

</div>

---

## 📌 About The Project

**Voy** is an Android carpooling and smart mobility application built natively with **Kotlin**, **Android Jetpack**, **Google Maps & Places SDK**, and **Retrofit REST API**.

The application connects vehicle owners who have empty seats with passengers traveling along matching routes. By encouraging shared commuting, Voy helps users reduce daily travel costs, mitigate traffic congestion, and track their personal carbon footprint savings.

- **Package Name**: `com.kanishak.voy`
- **Architecture**: Single-Activity Architecture with MVVM & Jetpack Navigation Components
- **Primary Contributor**: [Kanishak Rajput](https://github.com/KanishakRajput13)

---

## ✨ Key Features

### 🚘 For Passengers
- **Search Available Rides**: Find matching rides by setting origin, destination, date, and seat count requirements (`getAvailableRides`).
- **Interactive Route Preview**: View real-time polyline routes, pickup/dropoff points, estimated duration, and distance on Google Maps (`computeRoutes`).
- **Driver Profile & Vehicle Inspection**: Review verified driver badges, vehicle models, total seats, and fare per seat.
- **One-Tap Join Requests**: Submit ride requests directly to drivers and track approval statuses in real time.

### 🚘 For Drivers
- **Offer a Ride**: Publish upcoming trips by selecting start and end points via Google Places Autocomplete or map selection (`offerRide`).
- **Rider Request Management**: Review incoming passenger requests, inspect rider profiles, and accept or decline requests (`driverManageRequest`).
- **Driver Verification**: Document upload workflow (Driver's License photo upload) to receive verified status (`VerifyUser`).
- **Ride Lifecycle Controls**: Manage trip progression states (Pending $\rightarrow$ Active $\rightarrow$ Completed $\rightarrow$ Cancelled).

### 🌱 Eco-Dashboard & Sustainability Metrics
- **Emissions Tracker**: Dynamic calculation of CO₂ saved (in kg) and fuel reduction per shared ride (`rides/emissions-savings/`).
- **Green Contribution Badges**: Earn eco-badges as travel emissions savings accumulate over time.

### 🛡️ Safety & Security Tools
- **Emergency Contact Dispatch**: Save emergency contacts (`emergency_contact_phone`) for quick access during trips.
- **Verification Badges**: Driver verification indicators ensure trust between co-passengers.
- **Safety Tools Menu**: Instant access to safety guidelines and emergency features.

### 🔐 Authentication & Security
- **JWT Session Persistence**: Token management using Jetpack DataStore (`DataStoreManager`).
- **Multi-Factor OTP Verification**: Email OTP and Phone OTP verification screens.
- **Account Recovery**: Secure password reset flow with OTP authorization.

---

## 🎨 Figma UI Design & Screenshots

The user interface of Voy was designed in Figma focusing on dark mode aesthetics, intuitive card views, and seamless map interactions.

🔗 **Figma Design Canvas**: [Car-Pooling App on Figma](https://www.figma.com/design/hxbx5Q9BApdUOyUolBvAMm/Car-Pooling-app?node-id=0-1&t=RBiag46gOykASeLX-1)

### 📸 Application Screenshots

> *Note: Export your Figma screens into `docs/screenshots/` to display your app designs directly below.*

<div align="center">
  <table>
    <tr>
      <td align="center" width="33%">
        <img src="docs/screenshots/home.png" alt="Home Dashboard" width="220" fallback="app/src/main/res/drawable/verify_profile.png"/><br/>
        <b>Home Dashboard</b>
      </td>
      <td align="center" width="33%">
        <img src="docs/screenshots/ride_search.png" alt="Ride Search & Map" width="220" fallback="app/src/main/res/drawable/riders_before.png"/><br/>
        <b>Map Route & Search</b>
      </td>
      <td align="center" width="33%">
        <img src="docs/screenshots/eco_dashboard.png" alt="Eco Dashboard" width="220"/><br/>
        <b>Eco Impact Tracker</b>
      </td>
    </tr>
    <tr>
      <td align="center" width="33%">
        <img src="docs/screenshots/driver_verification.png" alt="Driver Verification" width="220" fallback="app/src/main/res/drawable/license_demo.png"/><br/>
        <b>DL Verification</b>
      </td>
      <td align="center" width="33%">
        <img src="docs/screenshots/matching_rides.png" alt="Matching Rides" width="220"/><br/>
        <b>Matching Rides List</b>
      </td>
      <td align="center" width="33%">
        <img src="docs/screenshots/profile.png" alt="User Profile" width="220"/><br/>
        <b>Profile & Vehicle Details</b>
      </td>
    </tr>
  </table>
</div>

---

## 🛠️ Tech Stack & Libraries

| Category | Component / Library | Purpose |
| :--- | :--- | :--- |
| **Language** | Kotlin `1.9+` | Modern type-safe Android development |
| **UI Framework** | XML Layouts + ViewBinding | Efficient view access without `findViewById` |
| **Navigation** | Jetpack Navigation Component | Single-activity screen flows (`nav_graph.xml`, `home_nav_graph.xml`) |
| **Networking** | Retrofit 2 + Gson Converter | REST API calls and JSON deserialization |
| **HTTP Logging** | OkHttp 4 Logging Interceptor | Network request and response debugging |
| **Maps & Routing** | Google Maps SDK + Places SDK | Interactive map rendering, place autocomplete, polyline calculation |
| **Location Utils** | Google Maps Android Utils | Marker clustering, polyline decoding, map overlays |
| **Async Operations** | Kotlin Coroutines + Flow | Non-blocking asynchronous network and storage operations |
| **Data Storage** | Jetpack DataStore (Preferences) | Secure asynchronous key-value storage for JWT auth tokens |
| **Image Loading** | Glide `4.12.0` | Efficient image caching and profile image rendering |

---

## 📂 Repository Structure

```
voy/
├── app/
│   ├── build.gradle.kts                # Module-level Gradle configuration (Namespace: com.kanishak.voy)
│   └── src/
│       └── main/
│           ├── AndroidManifest.xml     # App permissions, activities, and metadata
│           ├── java/com/kanishak/voy/
│           │   ├── MainActivity.kt               # Entry point for Auth flow
│           │   ├── BaseFragment.kt               # Abstract base fragment
│           │   ├── SplashFragment.kt             # App launch splash screen
│           │   ├── ContinueWithEmail.kt          # Auth selection container
│           │   ├── KeyboardUtils.kt              # Keyboard visibility helpers
│           │   ├── adapter/                      # RecyclerView Adapters
│           │   │   ├── MatchingRidesAdapter.kt   # Available rides list adapter
│           │   │   ├── MyRidesAdapter.kt         # User's offered/booked rides
│           │   │   ├── RideAdapter.kt            # Generic ride item adapter
│           │   │   ├── RideHistoryAdapter.kt     # Past rides history adapter
│           │   │   └── SuggestionsAdapter.kt     # Places autocomplete search suggestions
│           │   ├── api/                          # Networking & Data Layer
│           │   │   ├── ApiService.kt             # Retrofit API endpoints
│           │   │   ├── RetrofitInstance.kt       # Singleton Retrofit client
│           │   │   ├── DataStoreManager.kt       # Preferences DataStore for tokens
│           │   │   ├── dataclasses/              # Request/Response DTOs
│           │   │   └── datamodels/               # ViewModels (SharedViewModel, UserData)
│           │   ├── authentication/               # Auth Flow Fragments
│           │   │   ├── LoginFragment.kt          # User Login
│           │   │   ├── CreateAccount.kt          # User Registration
│           │   │   ├── OtpFragment.kt            # General OTP verification
│           │   │   ├── VerifyEmailFragment.kt    # Email OTP confirmation
│           │   │   ├── VerifyPhoneFragment.kt    # Phone OTP confirmation
│           │   │   ├── ForgotPasswordFragment.kt # Password recovery request
│           │   │   └── ResetPassword.kt          # Password reset confirmation
│           │   ├── geocoding_helper/             # Reverse Geocoding & Coordinates
│           │   │   ├── GeocodingHelper.kt        # Address to LatLng resolver
│           │   │   └── LocationCoordinates.kt    # Coordinate data structures
│           │   ├── home/                         # Core App Dashboard
│           │   │   ├── HomeActivity.kt           # Main application host activity
│           │   │   ├── HomeFragment.kt           # Home dashboard & quick actions
│           │   │   ├── MapActivity.kt           # Fullscreen map activity
│           │   │   ├── MapFragment.kt            # Interactive route selection map
│           │   │   ├── ChooseSpotFragment.kt     # Pickup/Dropoff search screen
│           │   │   ├── MatchingMyRidesFragment.kt# Matching passenger/driver rides
│           │   │   ├── MyRidesFragment.kt        # Current active rides
│           │   │   ├── EcoFragment.kt            # CO₂ emissions & green stats
│           │   │   ├── DriverVerificationFragment.kt # DL verification status
│           │   │   ├── UploadLicenseFragment.kt  # DL image capture & upload
│           │   │   ├── VehicleDetailsFragment.kt # Car model, seats & plate info
│           │   │   ├── SafetyToolsFragment.kt    # Emergency contacts & assistance
│           │   │   ├── ProfileFragment.kt        # User profile & avatar edit
│           │   │   ├── EditInfo.kt               # Edit personal info dialog
│           │   │   └── SettingsFragment.kt       # App settings & logout
│           │   └── mapRoute/                     # Map rendering utilities
│           │       └── MapUtils.kt               # Route polyline drawing helpers
│           └── res/                              # Layouts, Drawables, Navigation & Values
│               ├── layout/                       # XML Layout files
│               ├── navigation/                   # nav_graph.xml & home_nav_graph.xml
│               └── values/                       # colors.xml, strings.xml, themes.xml
├── build.gradle.kts                    # Root Gradle build script
└── settings.gradle.kts                 # Repository settings & plugin management
```

---

## 📡 API Endpoint Reference

The application communicates with a backend REST server via Retrofit (`ApiService.kt`):

### 🔑 Authentication (`auth/`)
| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `POST` | `auth/register/` | Register a new user account |
| `POST` | `auth/login/` | User login & JWT token generation |
| `POST` | `auth/forgot-password/` | Initiate password recovery |
| `POST` | `auth/verify-otp/` | Verify password reset OTP |
| `POST` | `auth/reset-password/` | Submit new account password |
| `POST` | `auth/verify-email/` | Verify user email address |
| `POST` | `auth/verify-phone/` | Verify user mobile number |
| `GET`  | `auth/user/` | Fetch authenticated user profile data |
| `PUT`  | `auth/user/` | Update profile photo, name, gender, or vehicle details |

### 🚗 Rides & Booking (`rides/`)
| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `POST` | `rides/passenger/search/` | Search available rides matching route criteria |
| `POST` | `rides/passenger/{requestId}/request/` | Request to join an available ride |
| `POST` | `rides/driver/create/` | Publish/offer a new ride |
| `GET`  | `rides/driver/requests/{driverId}/` | List incoming rider join requests |
| `POST` | `rides/driver/manage-request/{requestId}/` | Accept or reject a rider request |
| `POST` | `rides/driver/{requestId}/status/` | Update ride status (Started, In-Progress, Completed) |
| `GET`  | `rides/ride-history/` | Fetch completed & past ride history |
| `GET`  | `rides/emissions-savings/{rideId}/` | Fetch eco CO₂ emission savings for a ride |

### 🗺️ Google Maps Directions
| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `POST` | `directions/v2:computeRoutes` | Compute route polylines, distance, and duration |

---

## 🚀 Getting Started

Follow these steps to set up and run **Voy** locally on your Android Studio environment.

### Prerequisites
- **Android Studio**: Jellyfish (2023.3.1) or newer
- **JDK**: Version 17 or higher
- **Android SDK**: Target SDK 34, Min SDK 26
- **Google Maps API Key**: Enabled with *Maps SDK for Android*, *Places API*, and *Routes API*

### Setup Steps

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/KanishakRajput13/voy.git
   cd voy
   ```

2. **Configure Google Maps API Key**:
   Create a `secret.properties` file in the root directory of the project:
   ```properties
   API_KEY=YOUR_GOOGLE_MAPS_API_KEY_HERE
   ```

3. **Build the Application**:
   Open the project in Android Studio, let Gradle sync complete, and build:
   ```bash
   ./gradlew assembleDebug
   ```

4. **Run on Emulator or Physical Device**:
   - Ensure location services are enabled on the target device/emulator.
   - Run the `app` target from Android Studio.

---

## 🤝 Author & Acknowledgments

- **Maintainer & Primary Contributor**: [Kanishak Rajput](https://github.com/KanishakRajput13)
- **Figma UI Designer**: [Voy Figma Design](https://www.figma.com/design/hxbx5Q9BApdUOyUolBvAMm/Car-Pooling-app?node-id=0-1&t=RBiag46gOykASeLX-1)
