#!/usr/bin/bash
jpackage --input jar/ --main-jar App.jar --main-class App --type app-image --dest dist/ --name App --icon src/icon.png --java-options -Xmx1g
mv ./dist/App ./dist/linux
mv ./dist/linux/bin ./dist/linux/game