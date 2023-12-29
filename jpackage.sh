#!/usr/bin/bash
if [[ $(uname) == "Linux" ]]; then
    jpackage --input jar/ --main-jar App.jar --main-class App --type app-image --dest dist/ --name App --icon icon.png --java-options -Xmx1g
    if [ -d "./dist/linux" ]; then
        rm -r ./dist/linux
    fi
    mv ./dist/App ./dist/linux
fi

if [[ $(uname) == "Darwin" ]]; then
    echo "MacOS"
fi

if [[ $(uname -a) == *"CYGWIN"* ]] || [[ $(uname -a) == *"MINGW"* ]] || [[ $(uname -a) == *"MSYS"* ]]; then
    mv ./icon.png ./icon.ico
    jpackage --input jar/ --main-jar App.jar --main-class App --type app-image --dest dist/ --name App --icon icon.ico --java-options -Xmx1g
    mv ./icon.ico ./icon.png
    if [ -d "./dist/windows" ]; then
        rm -r ./dist/windows
    fi
    mv ./dist/App ./dist/windows
fi


# press any key to continue
read -n 1 -s -r -p "Press any key to continue"