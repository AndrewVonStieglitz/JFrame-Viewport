#!/usr/bin/bash
javac -d bin src/*.java
cp src/*.png bin/
jar cvfe jar/App.jar App -C bin .