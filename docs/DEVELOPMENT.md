# Entwicklung

## Toolchain

- Java 21
- Minecraft 1.21.11
- Fabric Loader 0.19.3
- Fabric API 0.141.6+1.21.11
- Fabric Loom Remap 1.17.13
- Gradle 9.6.1

## Wrapper-Hinweis

Die Umgebung, in der dieses Starterpaket erstellt wurde, hatte keinen Zugriff auf das Internet und keine vorhandene Gradle-Installation. Deshalb konnte das offizielle `gradle-wrapper.jar` nicht bezogen werden. `gradlew` und `gradlew.bat` sind transparente Bootstrap-Skripte, die Gradle 9.6.1 in das Benutzer-Gradle-Verzeichnis laden und starten. Sie benötigen beim ersten Start eine Internetverbindung. Das ist kein originaler Gradle Wrapper; bei Bedarf kann später `gradle wrapper --gradle-version 9.6.1` ausgeführt werden, sobald Gradle lokal verfügbar ist.

## Build

Windows PowerShell:

```powershell
.\gradlew.bat build
```

Linux/macOS:

```bash
./gradlew build
```
