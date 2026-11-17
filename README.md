# Vizbl Android Demo

This repository contains a demo application that integrates the Vizbl Android SDK.

The app demonstrates how to launch AR and load Vizbl objects using a `tinuuid`.

## What this demo shows

- basic SDK integration into an Android app
- presenting AR using the Vizbl Android SDK
- loading an object from Vizbl
- interacting with the object in AR

All AR logic, placement, and interaction are handled by the SDK.

## How to run

1. Clone the repository:

```bash
git clone https://github.com/VIZBL/vizbl-android-demo.git
```

2. Open the project in Android Studio

3. The demo ships with a few public Vizbl models, so it works as is. To show your own products, replace the Object IDs in the screens under `app/src/main/java/com/us/vizbl/ar/sdk/demo/ui/screens/` with IDs from your Vizbl library

4. Run the app on a physical device with ARCore support (the emulator does not run AR)

The SDK comes from Maven Central as `com.vizbl:ar-sdk:0.2`; no tokens or extra repositories are needed. Requires Android Studio with JDK 17 and a device on Android 8.1 (API 27) or newer.

## Notes

- AR is not supported on all Android devices
- a physical AR-compatible device is required
- the SDK automatically handles placement, UI, and interaction

## SDK

Vizbl Android SDK repository:  
https://github.com/VIZBL/vizbl-android-sdk

## Documentation

https://developer.vizbl.com/docs/android
