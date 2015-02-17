# About NycPOS [![Build Status](https://travis-ci.org/KNQ/NycPOS.svg)](https://travis-ci.org/KNQ/NycPOS)
This is a full, top-down rewrite of [OpenBravo POS](http://www.openbravo.com/)/[uniCenta oPOS](http://www.unicenta.com/)
using modern development tools, methods, and libraries. Additionally, once
complete, it will carry a new UI written using modern Java UI (likely JavaFX
8), and more consistent themeing. An attempt is being made to salvage as much
of the original code as possible, in order to provide an upgrade path for those
currently on outdated versions of OpenBravo/uniCenta.

Additionally, while we are doing a full rewrite of the UI, we are aiming to
keep the same general look, feel, and button layout/positioning, in order
eliminate (as much as possible) employee re-training, and to hopefully
otherwise limit interruptions for existing retail businesses, should they
choose to switch to NycPOS.

NOTE: This project is currently in a state of flux -- but currently, it can
compile "out of the box." Please be advised, however, that the current state of
the code is nowhere near ready for production use. We expect it will take a
further 4-6 weeks of development time to get the code into a modern, stable
state before it will be usable by non-developers. We are hoping for an Alpha
release by March 1st, 2015.

## Compiling and Running

Currently (although much is still broken), NycPOS will compile and run via the
following:

    git clone https://github.com/KNQ/NycPOS.git
    cd NycPOS
    ./gradlew build run

In order to compile, you will need to manually install some maven artifacts for
some projects that the code base depends on, but that are not available in any
maven repositories. These are
[beanshell2](https://code.google.com/p/beanshell2/), and
[javapos](http://www.javapos.com/). Please see
`misc/install-maven-artifacts.sh` in the source tree for an example of how to
manually register a maven artifact after you have downloaded the respective
jars. Please check `build.gradle` for the correct maven group and artifact ids,
as these are likely to change faster than the documentation will.

Additionally, you will need to extract images from the uniCenta 3.81 source
tree and copy them into the `src/main/resources/images` and
`src/main/resources/templates/default` directories.

### Database setup

The project is currently in a state of flux with regards to the database
(design/schema/imports/etc). However, you can currently import the base schema
with [Liquibase](http://www.liquibase.org/) via the following commands:

    cd NycPOS
    rm -rf .db && ./gradlew lqbUpdate

You can then run the embedded H2 database via the following:

    cd NycPOS
    ./gradlew runH2DbServer

We plan in the future to support all databases that support modern SQL and that
Liquibase also supports. We are also planning to support imports from uniCenta
3.70/3.81 into NycPOS directly out of the box. For older versions of uniCenta,
one will need to first upgrade their uniCenta installation, and then migrate to
NycPOS.

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

### TODO

In line with the above, we are currently working on the following (in no
specific or promised delivery order):

* Fix broken AWT/Swing screens
* Change all binary (image) assets to better / standardized open icon set
* Fix and write unit tests for peripherals
* Fix dependency issues
* Unit tests, travis deployment
* Convert AWT/Swing UI to JavaFX 8
* Modernize database schema/structure/scripts
  * Standardize database schema (reflection?)
  * Swap out hard coded SQL for ORM style generated code (jOOQ)
  * Separate sample data from scripts into template resource files
* Fix database upgrades/migrations (liquibase)
* Fix broken scripts in template resources
  * Add multiple templates for various types of businesses
    (restaurant/grocery/etc)
* Revamp system to support multiple displays, printers, cash drawers and other
  peripherals in easier to use, simplified UI
* Create standalone distributions and installers for Linux, OS X, Windows
* Expand payment gateway support and consolidate/simplify configuration screens
  * Add support for NFC and other "modern" payment peripherals
* Swap Apache Derby for H2/SQLite for simple installations
* Add option to operate as client/server and eliminate direct database access
  in client (for security/sanity purposes)
  * Isolate business logic from client logic
  * Define API
* Strip beanshell2 dependency and replace with generic scripting engine support
  (Groovy, JRuby, etc)
* Replace velocity templates/dependency with updated templates in Groovy
  Templates or other modern Java based template engine (preference for lowest
  external dependency count) 
* *And much, much, more ... please see `TODO` file for immediate worklog*
