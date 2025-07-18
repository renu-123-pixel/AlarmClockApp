# ⏰ Alarm Clock App

A simple yet functional Alarm Clock Android application built using Java and XML. The app allows users to set alarms, manage multiple alarm times, and get timely notifications.

## 📱 Features

- Set one-time or recurring alarms
- Delete or update existing alarms
- Simple and clean user interface
- Runs in the background using `AlarmManager`
- Works across Android versions with notification support

## 🛠️ Built With

- **Language:** Java
- **UI:** XML (ConstraintLayout, TimePicker, RecyclerView)
- **Frameworks/Components:**
  - `AlarmManager` for scheduling alarms
  - `BroadcastReceiver` for triggering alarms
  - `PendingIntent` to run alarm logic
  - `NotificationManager` to alert users

## 📷 Screenshots

| Home Screen | Set Alarm | Snooze dismiss Alarm |
|-------------|------------|---------------------|
| <img src="Activity_1.jpeg" width="200" /> | <img src="Activity_2.jpeg" width="200"/> | <img src="Activity_3.jpeg" width="200"/> |

## 🚀 Getting Started

### Prerequisites

- Android Studio (Flamingo or newer recommended)
- Minimum SDK: 21 (Lollipop)
- Gradle 7.0+

### Installation

1. Clone the repository:

```bash
git clone https://github.com/renu-123-pixel/AlarmClockApp.git
Open the project in Android Studio.

Sync Gradle and build the project.

Run on an emulator or Android device.

📁 Project Structure

AlarmClockApp/
├── app/
│   ├── java/com/example/alarmclock/
│   │   ├── AlarmReceiver.java
│   │   ├── AlarmScheduler.java
│   │   └── MainActivity.java
│   └── res/
│       ├── layout/
│       └── values/
├── AndroidManifest.xml
└── build.gradle

📌 To-Do / Improvements
 Add sound/vibration options

 Save alarms using Room or SharedPreferences

🙋‍♀️ Author
Renu – GitHub Profile

🤝 Contributing
Pull requests are welcome! For major changes, please open an issue first to discuss what you'd like to change.

📄 License
This project is licensed under the MIT License. See the LICENSE file for details.
