# Tilt MIDI Android

Android motion-to-MIDI controller inspired by expressive tilt controllers. Configure pitch/roll/manual mappings on the phone and send MIDI CC values over BLE MIDI or Wi-Fi RTP-MIDI (AppleMIDI/RFC 6295).

## Version 1.0
Download the Android APK from [GitHub Releases](https://github.com/qingye060324/tilt-midi-android/releases/latest). Android 8.0 or newer is required. Version 1.0 fixes the AppleMIDI packet format, completes control and data invitations, handles clock synchronization, and sends network MIDI on a background thread. Wi-Fi reception with Windows rtpMIDI and Cubase has been confirmed by the user.

## Current features
- Up to 32 mappings: axis, CC, channel, range, angle, smoothing, inversion and manual slider.
- BLE MIDI peripheral mode.
- RTP-MIDI client mode: enter the computer's LAN IP and AppleMIDI control port (usually 5004; data is port+1).
- Persistent JSON configuration and zero calibration.

## Windows
Install Tobias Erichsen's free rtpMIDI, create/enable a session, and note the session computer IP and port. In Tilt MIDI choose `连接 RTP-MIDI（Wi-Fi）`, enter the Windows IP and the rtpMIDI session control port. Then enable the resulting MIDI input in Cubase.

The phone and computer must be on a LAN that allows communication between clients. Allow the session's two UDP ports through the computer firewall: the control port (usually 5004) and the data port (control port + 1). Set the session's `Who may connect to me` policy to allow the phone. This app initiates the connection by IP; it does not browse Bonjour services.

In Cubase, open Studio Setup → MIDI Port Setup, make the rtpMIDI session input visible, and select it as the track input. WinRT MIDI may append `[1]` to the port name. To test, use a manual mapping on channel 1 / CC1, record a MIDI part, and inspect the Modulation controller lane. For parameter control, use the instrument's MIDI Learn or Cubase MIDI Remote / Quick Controls. The app sends CC messages, not notes.

## macOS
In Audio MIDI Setup → Window → Show MIDI Studio → Network, create/connect a Network Session. Enter the Mac IP and its session control port in Tilt MIDI. Enable the Network Session input in Cubase.

## Notes
The app keeps the screen on and stops transport when backgrounded. RTP-MIDI implementation is a compact client aimed at one local peer; use a trusted LAN and allow UDP control/data ports through the computer firewall.

## Build
Open with Android Studio/JDK 17+ or run `./gradlew assembleDebug`.
