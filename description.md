# Description of the contents of this project

Complete me!
## How to test & run the project

### Prerequisites
Based on this guide from [gradle](https://gradle.org/install/#prerequisites)

First check your Java JDK version and be sure you have version 8 or higher:
```bash
java -version
java version "1.8.0_121"
```
And then install gradle in your machine with a package manager.

For MacOS (Assuming you've installed Homebrew):
```bash
brew install gradle
```
__For other operating systems please update this guide.__

You can check your new installed gradle version:
```bash
gradle -v

------------------------------------------------------------
Gradle 7.5.1
------------------------------------------------------------

Build time:   2022-08-05 21:17:56 UTC
Revision:     d1daa0cbf1a0103000b71484e1dbfe096e095918

Kotlin:       1.6.21
Groovy:       3.0.10
Ant:          Apache Ant(TM) version 1.10.11 compiled on July 10 2021
JVM:          1.8.0_333 (Oracle Corporation 25.333-b02)
OS:           Mac OS X 11.7 x86_64
```

Now go to the folder where you have cloned the repository and then run the following command to see all the available gradle tasks for the project:
```bash
cd lab1-git-race/
gradle tasks
```
You can run any task with the command bellow:
```bash
gradle taskname
```

### How to test the project
Go to the folder where you have cloned the repository and then run the following command to test it:
```bash
cd lab1-git-race/
gradle test
```
You should see something like this after finishing the tests:
```bash
BUILD SUCCESSFUL in 8s
4 actionable tasks: 2 executed, 2 up-to-date
```
Wich will automatically detect and execute all the unit tests in the test source set.

You can also run the following command wich will perform all verification tasks, including unit tests:
```bash
cd lab1-git-race/
gradle check
```
It will show you something like this:
```bash
BUILD SUCCESSFUL in 1s
4 actionable tasks: 4 up-to-date
```

### How to build and run the project
Go to your project folder and run the following command:
```bash
cd lab1-git-race/
gradle bootRun
```
Then you can open your browser and check the following [page](http://localhost:8080/) wich will show you the website running.

To stop the webserver just press <kbd>Ctrl</kbd> + <kbd>c</kbd>