# TextureCustomizer

Modulares Fabric-Client-Projekt für Minecraft Java 1.21.11. Ziel ist ein zentraler Arbeitsplatz, um einzelne Ressourcen aus verschiedenen Resource Packs auszuwählen und in eigenen Profilen zu kombinieren.

> **Entwicklungsstatus: frühes Grundgerüst (0.1.0).** Das Projekt enthält aktuell die Client-Registrierung, einen änderbaren Minecraft-Keybind (über Steuerung), ein erstes Menügerüst und eine kleine lokale Konfigurationsablage. Online-Bibliothek, echter Asset-Mixer, ZIP-Analyse, Profile und Vorschau sind noch nicht implementiert. Die Kacheln im Menü sind ausdrücklich Platzhalter und führen noch keine Texturänderung aus.

## Anforderungen

- Minecraft Java Edition **1.21.11**
- Fabric Loader **0.19.3**
- Fabric API **0.141.6+1.21.11**
- Java **21**

## Aktueller Funktionsumfang

- Client-only Fabric-Mod-Entrypoint
- Menü öffnen mit `Rechte Umschalttaste` (Keybind in Minecraft-Steuerung änderbar)
- Erstes dunkles Menülayout mit Kategorien
- Lokale Properties-Konfiguration unter `.minecraft/config/texturecustomizer.properties`
- Gradle-Projekt und GitHub-Actions-Buildworkflow

## Installation

Eine installierbare JAR wird erst nach einem erfolgreichen Build erzeugt. Lege die gebaute JAR aus `build/libs/` in den `mods`-Ordner deiner Fabric-Installation. Fabric Loader und Fabric API müssen installiert sein.

## Build (Windows)

Voraussetzung: Java 21 und Internetverbindung für den ersten Abhängigkeitsdownload.

```powershell
.\gradlew.bat build
```

Die JAR liegt anschließend in `build/libs/`.

## Build (Linux/macOS)

```bash
./gradlew build
```

## VS Code

1. Java 21 installieren.
2. Den entpackten Ordner `TextureCustomizer` in VS Code öffnen.
3. Bei Nachfrage das Java-Projekt importieren lassen.
4. Im integrierten Terminal `./gradlew build` (Windows: `./gradlew.bat build`) ausführen.

## Roadmap

1. Stabiles Grundgerüst und Menü
2. Kategorien, Suche, Favoriten und lokale Pack-Bibliothek
3. Sicherer ZIP-/Resource-Pack-Import und Asset-Analyse
4. Asset-Mixer mit Abhängigkeits- und Konfliktauflösung
5. Profile, Import/Export und Offline-Verwaltung
6. Online-Anbindung über erlaubte offizielle APIs
7. Vorschauen, Sounds und Partikeleffekte
8. Tests, Performance und Release

## Bekannte Einschränkungen

- Noch kein tatsächlicher Texturwechsel oder Resource-Pack-Mixer.
- Noch keine Online-API-Anbindung oder Downloadfunktion.
- Noch keine automatische Erkennung von Resource-Pack-Inhalten.
- Noch keine vollständige Profil-/Favoritenverwaltung.
- Der Gradle-Wrapper-Launcher lädt bei Bedarf Gradle 9.6.1. Der originale `gradle-wrapper.jar` ist nicht enthalten; siehe `docs/DEVELOPMENT.md`.

## Lizenz

MIT für den Quellcode dieses Projekts. Importierte Resource Packs behalten ihre jeweiligen Urheberrechte und Lizenzen.
