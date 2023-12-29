#!/usr/bin/bash
jar cvfe jar/App.jar App -C bin .
jpackage --input jar/ --main-jar App.jar --main-class App --type app-image --dest dist/ --name App --icon src/icon.png --java-options -Xmx1g