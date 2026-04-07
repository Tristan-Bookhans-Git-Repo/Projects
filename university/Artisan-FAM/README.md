# Artisan FAM

An Android marketplace app that connects customers with local artisans. Built as a university COMS project.

## What it does

Customers can browse artisans by specialty and rating, send hire requests, and exchange messages. Artisans can register their business, receive job requests, and respond to customers. Includes a PHP/MySQL backend and a compiled release APK.

## Tech stack

- **Android (Java)** — frontend, OkHttp3 for networking, Material Design UI
- **PHP + MySQL** — backend REST-style API
- **LAMP stack** — server environment
- **Gradle** — build system

## How to run

**Android app:**
1. Open in Android Studio
2. Run `gradle build` or build via the IDE
3. Deploy to an Android device or emulator

**Backend:**
- Deploy PHP files to a LAMP server
- Configure the MySQL database (`d2105569`)
- Update the server URL in the Android app if hosting elsewhere

A pre-built APK (`Artisan FAM.apk`) is included in the project folder.

## Status

Academic exercise — complete. Includes project report (DOCX), ERD diagrams, and walkthrough videos.
