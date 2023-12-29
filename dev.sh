#!/usr/bin/bash
javac -d bin src/*.java
cp src/*.png bin/
java -cp bin App