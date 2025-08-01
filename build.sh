#!/usr/bin/env bash

echo "Kompilerar Java-koden..."
mkdir -p build/classes
javac -d build/classes $(find src/main/java -name "*.java")

if [[ $? -ne 0 ]]; then
  echo "Kompilering misslyckades!"
  exit 1
fi

echo "Kör programmet..."
java -cp build/classes Main
