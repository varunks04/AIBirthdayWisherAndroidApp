#!/usr/bin/env sh
set -e

# Determine the directory of the script
DIR="$(cd "$(dirname "$0")" && pwd)"

# Define the Gradle wrapper version
GRADLE_VERSION=7.5

# Check if the Gradle wrapper is already present
if [ ! -f "$DIR/gradle/wrapper/gradle-wrapper.jar" ]; then
  echo "Gradle wrapper not found. Downloading..."
  mkdir -p "$DIR/gradle/wrapper"
  curl -L "https://services.gradle.org/distributions/gradle-$GRADLE_VERSION-bin.zip" -o "$DIR/gradle.zip"
  unzip -q "$DIR/gradle.zip" -d "$DIR/gradle"
  mv "$DIR/gradle/gradle-$GRADLE_VERSION/wrapper/gradle-wrapper.jar" "$DIR/gradle/wrapper/"
  mv "$DIR/gradle/gradle-$GRADLE_VERSION/wrapper/gradle-wrapper.properties" "$DIR/gradle/wrapper/"
  rm -rf "$DIR/gradle.zip" "$DIR/gradle/gradle-$GRADLE_VERSION"
fi

# Execute Gradle with the provided arguments
exec "$DIR/gradle/wrapper/gradle-wrapper.jar" "$@"