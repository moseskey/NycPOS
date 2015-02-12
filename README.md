# About NycPOS
This is a full, top-down rewrite of OpenBravo POS/uniCenta oPOS using modern
development tools, methods, and libraries. Additionally, once complete, it will
carry a full new UI written using modern Java UI (likely JavaFX 8), and more
consistent themeing. An attempt is being made to salvage as much of the
original code as possible, in order to provide an upgrade path for those
currently on outdated versions of OpenBravo/uniCenta.

Please be advised that this project is currently in a state of flux, however it
is currently able to compile "out of the box." However, it is nowhere near
ready for production use. We expect it will take 4-6 weeks of development time
to get the code into a modern, stable state before it will be usable by
non-developers.

## Compiling and Running

Currently (although much is still broken), NycPOS will compile and run via the
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
artifact ids, as these are likely to change faster than the documentation will.

Additionally, you will need to extract images from the uniCenta 3.81 source
tree and copy them into the `src/main/resources/images` and
`src/main/resources/templates/default` directories.

## Look to the Future

In the following days/weeks to come, we will fix the SQL, various scripts,
strip out the awt/swing interface for JavaFX 8, and otherwise modernize the
code base. Much work has already been done to this effect, however there is
still a long, uphill battle in front of us, due to the poor state of the
existing code base.

### Stated Project Goals

NycPOS is an attempt to create a truly open, modern POS ready for use by
small-to-medium businesses ("small enterprises") with one or more retail
locations, notably restaurants, groceries, or other plain, small
brick-and-mortar businesses. It does not aim to be a "one-size-fits-all" retail
or ERP environment. Please look to other projects if that is your specific
use-case.

### Project TODO

In line with the above, we are currently working on the following (in no
specific or promised delivery order):

* Converting AWT/Swing UI to JavaFX 8
* Modernizing the database structure, scripts
* Fixing database upgrades 
* Fixing broken scripts/templates
* Adding multiple templates for various types of businesses
  (restaurant/grocery/etc)
* Revamping entire system to support multiple displays, printers, and other
  peripherals in a much easier to use, simplified UI
* Adding a full unit test suite
* Greatly expanding payment gateway support and consolidating configuration
  screens
* Adding support for NFC and other "modern" payment peripherals
