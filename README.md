# Kiosk Display Application for Raspberry Pi

A Yocto-based embedded Linux application designed to run on a display in kiosk mode. The project includes a custom OpenEmbedded layer for building tailored Raspberry Pi images, with separate debug and production configurations. It also provides Wi-Fi connectivity through WPA Supplicant and systemd-networkd, along with additional package recipes. The production image uses a read-only root filesystem, while the debug image includes development and remote-access tools.

**Technologies**: Yocto Project, OpenEmbedded, BitBake, Linux, Raspberry Pi, systemd, wayland
