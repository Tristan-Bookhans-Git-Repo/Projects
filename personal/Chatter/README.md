# Chatter

An Android messaging app built as a personal project, inspired by the Artisan FAM university work. Users register, discover other users, start private chats, and exchange messages with background push notifications.

## What it does

- Register with a name to create an account
- Browse other registered users
- Start a private chat with any user
- Send and receive messages in real time
- Receive push notifications when a new message arrives (background polling every 15 seconds)

## Tech stack

- **Android (Java)** — frontend, Material Design UI, ViewPager tabs
- **PHP + MySQL** — backend running on a LAMP server
- **OkHttp3** — HTTP networking
- **Android Foreground Service** — background message polling

## How to run

1. Open in Android Studio and run `gradle build`
2. Deploy the PHP backend files to a LAMP server
3. Update the server URL in the app if hosting elsewhere
4. Install the APK on an Android device

## Status

Personal project — complete (feature-complete for its original scope). Backend is tied to a university LAMP server; would need rehosting to run independently.
