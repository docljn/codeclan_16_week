# Setting up Android Studio for the First Time

Button clicks are in CAPS

### Android Studio install wizard:
- Open Android Studio from Dock / Spotlight Search
- I do not have a previous version of Studio - `OK`
- `NEXT`
- Wait for pop up saying `Android Studio is ready to update`
- Click `update`
- Select `Update and Restart`
- Once done select `Do not import settings`
- Click `NEXT` on the Welcome Screen
- Select Custom Install Type - `NEXT`
- Select White or Black theme - `NEXT`
- Tick Performance (Intel HAXM) and tick Android Virtual Device
- SDK location should be the default: "/Users/user/Library/Android/sdk" - `NEXT`
- Recommended HAXM RAM setting is fine - `NEXT`
- `FINISH`
- Wait..... or go do something else (SOLID homework perhaps?)
- It will fail to download "source-24", you can retry all you like, it never downloads, so just hit `CANCEL`
- `FINISH`
- It will run the setup wizard every time you launch Android Studio, you just have to click cancel and it will open the normal start screen where you can start a project or open existing projects.


### Welcome to Android Studio screen:
- Click: Configure > Project Defaults > Project Structure
- Android SDK location: Click the small button with 3 tiny dots on it, to the right of the top text box
- Navigate to and select the `user > Library > Android > sdk` folder. The path should read "/Users/user/Library/Android/sdk" - `OK`
- `APPLY` and/or `OK`
- `BACK`, `BACK`


### Set SDK path:
- Open the Android Studio menu in the toolbar at the top of the screen. Select Preferences. (or hit `cmd + ,`)
- Expand Appearance & Behaviour > System Settings > Android SDK
- [VERY IMPORTANT] DESELECT the top option, which is "API level 27", it should say it's partially installed, we want rid of it.
- Tick Android versions from API level 26 down to API level 23
- It should list the versions of android SDK that will be installed, and that 27 will be deleted.
- Click `Accept`
- Wait.....
- `FINISH`
- `OK`

## Installing emulator.

- Click on tools > Android > AVD manager
- Click `Create new virtual device`
- Select `Nexus 5X` then `NEXT`
- Download `API 27`.
- Click `FINISH`
- `NEXT`, `FINISH`


Whoop! You're all done.
