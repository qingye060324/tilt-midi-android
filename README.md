# Tilt MIDI Android

Android motion-to-MIDI controller inspired by expressive tilt controllers. Configure pitch/roll/manual mappings on the phone and send MIDI CC values over BLE MIDI or Wi-Fi RTP-MIDI (AppleMIDI/RFC 6295).

## Current features
- Up to 32 mappings: axis, CC, channel, range, angle, smoothing, inversion and manual slider.
- BLE MIDI peripheral mode.
- RTP-MIDI client mode: enter the computer's LAN IP and AppleMIDI control port (usually 5004; data is port+1).
- Persistent JSON configuration and zero calibration.

## Windows
Install Tobias Erichsen's free rtpMIDI, create/enable a session, and note the session computer IP and port. In Tilt MIDI choose `连接 RTP-MIDI（Wi-Fi）`, enter the Windows IP and the rtpMIDI session control port. Then enable the resulting MIDI input in Cubase.

## macOS
In Audio MIDI Setup → Window → Show MIDI Studio → Network, create/connect a Network Session. Enter the Mac IP and its session control port in Tilt MIDI. Enable the Network Session input in Cubase.

## Notes
The app keeps the screen on and stops transport when backgrounded. RTP-MIDI implementation is a compact client aimed at one local peer; use a trusted LAN and allow UDP control/data ports through the computer firewall.

## Build
Open with Android Studio/JDK 17+ or run `./gradlew assembleDebug`.
