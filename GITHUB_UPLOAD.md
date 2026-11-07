# GitHub-Upload – Schritt für Schritt (Windows)

1. `TextureCustomizer-1.21.11-Fabric.zip` herunterladen.
2. Im Windows-Explorer rechtsklicken und **Alle extrahieren** auswählen.
3. Den entpackten Ordner `TextureCustomizer` öffnen.
4. GitHub im Browser öffnen und anmelden.
5. Über **New repository** ein neues Repository namens `TextureCustomizer` erstellen.
6. Im Repository **Add file → Upload files** wählen.
7. Den Inhalt des Projektordners in den Uploadbereich ziehen. Wichtig: `.github`, `gradlew`, `gradlew.bat`, `gradle`, `src`, `build.gradle`, `gradle.properties` und `settings.gradle` müssen enthalten sein.
8. Unten **Commit changes** anklicken.
9. Den Reiter **Actions** öffnen und den Workflow `Build TextureCustomizer` kontrollieren.
10. Wenn der Build erfolgreich ist, den Workflow öffnen und unter **Artifacts** das erzeugte JAR-Artefakt herunterladen.

## Lokal in VS Code öffnen

1. VS Code starten.
2. **Datei → Ordner öffnen** auswählen.
3. Den entpackten Ordner `TextureCustomizer` wählen.
4. Java 21 und die Extension **Extension Pack for Java** installieren.
5. **Terminal → Neues Terminal** öffnen.
6. Ausführen: ` .\gradlew.bat build` (ohne führendes Leerzeichen im Terminal).

## Spätere Aktualisierungen

Wenn du die Dateien direkt auf GitHub bearbeitest, kannst du die aktualisierten Dateien über **Code → Download ZIP** erneut herunterladen und lokal entpacken. Wenn du Git verwendest, kannst du das Repository einmal klonen und später mit `git pull` aktualisieren.

```bash
git clone https://github.com/DEIN-NAME/TextureCustomizer.git
cd TextureCustomizer
git pull
git add .
git commit -m "Update TextureCustomizer"
git push
```

`DEIN-NAME` durch deinen GitHub-Benutzernamen ersetzen.
