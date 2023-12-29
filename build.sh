#!/usr/bin/bash
mkdir build
jar cvfe App.jar App -C bin .
mv App.jar build/