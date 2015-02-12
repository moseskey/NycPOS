# About NycPOS
This is a full rewrite of OpenBravo POS/uniCenta oPOS using modern development
tools, methods, and libraries. Additionally, once complete, it will carry a
full new UI written using modern Java development methods, and more consistent
themeing. An attempt is being made to salvage as much of the original code as
possible, in order to provide an upgrade path for those currently on outdated
versions of OpenBravo/uniCenta.

Please be advised that while this project is currently in a state of flux, it
is currently able to compile "out of the box", it is nowhere near ready for
production use. We expect it will take 4-6 weeks of development time to get the
code into a modern, stable state before it will be usable by non-developers.

## Compiling and Running

Currently, (although much is broken), NycPOS will compile and run via the
following:

    git clone https://github.com/KNQ/NycPOS.git
    cd NycPOS
    ./gradlew build run

In order to compile, you will need to manually install some maven artifacts for
some projects that the current code base depends on. These are
[beanshell2](https://code.google.com/p/beanshell2/), and
[javapos](http://www.javapos.com/). Please see
`misc/manual-install-maven-artifacts.sh` in the source tree for an example of
how to manually register a maven artifact after you have downloaded the
respective jars. Please check `build.gradle` for the correct maven group and
artifact ids, as these are likely to rapidly change.

Additionally, you will need to extract images from the uniCenta 3.81 source
tree and copy them into the `src/main/resources/images` and
`src/main/resources/templates/default` directories.

## Look to the Future

In the following days/weeks to come, we will fix the SQL, various scripts,
strip out the awt/swing interface for JavaFX 8, and otherwise modernize the
code base. Much work has already been done to this effect, however there is
still a long, uphill battle in front of us, due to the poor state of the
existing code base.
