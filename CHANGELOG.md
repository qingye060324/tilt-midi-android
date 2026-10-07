# Changelog

## 1.0 — 2026-10-07

- Correct AppleMIDI invitation fields and session-name termination; validate the response token at the correct offset.
- Complete invitations on both control and data ports before reporting a connection.
- Handle clock synchronization and remote disconnects.
- Move DNS, socket operations, MIDI transmission and session shutdown to a background thread.
- Keep session state isolated during disconnect and reconnect, and stop the previous transport when switching between BLE and Wi-Fi.
- Document Windows rtpMIDI and Cubase CC reception.

Validation: the patched Java transport delivered CC messages through the real Windows rtpMIDI service to the Windows MIDI input, including periodic synchronization and reconnection. Android sources compiled and the APK signature verified. The user subsequently confirmed successful testing on their phone with this computer.
