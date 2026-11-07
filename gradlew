#!/usr/bin/env sh
set -eu
VERSION=9.6.1
BASE="${GRADLE_USER_HOME:-$HOME/.gradle}/wrapper/dists/gradle-$VERSION-bin/texturecustomizer"
DIST="$BASE/gradle-$VERSION"
if [ ! -x "$DIST/bin/gradle" ]; then
  mkdir -p "$BASE"
  ARCHIVE="$BASE/gradle-$VERSION-bin.zip"
  if command -v curl >/dev/null 2>&1; then curl -fL "https://services.gradle.org/distributions/gradle-$VERSION-bin.zip" -o "$ARCHIVE"
  elif command -v wget >/dev/null 2>&1; then wget "https://services.gradle.org/distributions/gradle-$VERSION-bin.zip" -O "$ARCHIVE"
  else echo 'curl or wget is required to download Gradle.' >&2; exit 1; fi
  unzip -q -o "$ARCHIVE" -d "$BASE"
fi
exec "$DIST/bin/gradle" "$@"
