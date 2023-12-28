#!/usr/bin/bash
if [[ $(uname) == "Linux" ]]; then
    jpackage --input jar/ --main-jar App.jar --main-class App --type app-image --dest dist/ --name App --icon src/icon.ico --java-options -Xmx1g
    mv ./dist/App ./dist/linux
    mv ./dist/linux/bin ./dist/linux/game
fi

if [[ $(uname) == "Darwin" ]]; then
    echo "MacOS"
fi

if [[ $(uname -a) == *"CYGWIN"* ]] || [[ $(uname -a) == *"MINGW"* ]] || [[ $(uname -a) == *"MSYS"* ]]; then
    jpackage --input jar/ --main-jar App.jar --main-class App --type app-image --dest dist/ --name App --icon src/icon.ico --java-options -Xmx1g
    mv ./dist/App ./dist/windows
fi


# press any key to continue
read -n 1 -s -r -p "Press any key to continue"