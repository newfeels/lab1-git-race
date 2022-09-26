# Description of the contents of this project
<!-- TOC -->

* [Which are the technologies used in the code](#which-are-the-technologies-used-in-the-code)
* [Build the app](#build-the-app)
* [Deployment](#deployment)
    * [Docker Usage](#docker-usage)
    * [Docker Compose](#docker-compose)
    * [How to deploy in a Kubernetes cluster](#how-to-deploy-in-a-kubernetes-cluster)
        * [With Minikube](#with-minikube)
        * [Without Minikube](#without-minikube)
* [Gradle Configuration](#gradle-configuration)
    * [Plugins](#plugins)
    * [Repositories](#repositories)
    * [Dependencies](#dependencies)
    * [Kotlin](#kotlin)
* [How to test & run the project](#how-to-test--run-the-project)
    * [Prerequisites](#prerequisites)
    * [How to test the project](#how-to-test-the-project)
    * [How to build and run the project](#how-to-build-and-run-the-project)
* [IntegrationTest.kt description](#integrationtestkt-description)

<!-- /TOC -->

## Which are the technologies used in the code

The technologies that we found in the project are:

* Gradle 7.5.1
* Kotlin 1.7
* HTML 5
* Bootstrap
* Markdown

These technologies can be divided depending on its use:

* To document the project it's being used Markdown. Markdown is a language with plain text syntax for the generation of files that can be accessible for different platforms.
* On the server-side we can found Kotlin with the framework Spring, we use Kotlin here because of its features which can be useful on the develop the app.
* To desing the page has been choosen HTML with Bootstrap which is use to customize the page with Sass.
* Finally for build automation we have Gradle. Gradle is a feature which helps us with the compilation of the code, avoiding overwork.

## Build the app

For building and running the app you will have to use  `gradlew`:
For listing all options you have to execute : `./gradlew tasks`
The most important commands you have is `build` for building and `bootRun` for running the application.

For checking if it works you only have to go to <http://localhost:8080> and there will be an image of Universidad of Zaragoza

## Deployment

### Docker Usage

to build the docker image and run the container:

```sh
docker build . -t lab1-git-race -f .\src\main\docker\app.dockerfile

docker run -d -p 8080:8080 --name lab1-git-race-container lab1-git-race
```

To stop the container use:

```sh
docker stop <identifier:hash>
```

### Docker Compose

```sh
docker-compose up -d
```

### How to deploy in a Kubernetes cluster

First of all, ensure you've got a properly configured cluster on your computer.
If you don't have one, you can easily install a local Kubernetes cluster via
[Minikube](https://minikube.sigs.k8s.io/docs/start/).

#### With Minikube

First, start your local cluster if you haven't done so yet:

```bash
minikube start
```

Once you have a running minikube cluster, apply the `deployment.yml` manifest as follows
(ensure your current directory is at the root of the project):

```bash
minikube kubectl -- apply -f .\deployment.yaml
```

**Note:** Wait until the pods are on a `Running` state. You can check your cluster status with the following command:

```bash
minikube kubectl get all
```

Finally, expose the service to the browser with the following command:

```bash
minikube service lab1-git-race
```

This will open a tunnel and print a URL that allows you to open the app with your browser of choice.

#### Without Minikube

First check if you can use kubectl on your cluster:

```bash
kubectl --help
```

Once your cluster is up and running, apply the `deployment.yml` manifest as follows
(ensure your current directory is at the root of the project):

```bash
kubectl apply -f ./deployment.yml
```

**Note:** Wait until the pods are on a `Running` state. You can check your cluster status with the following command:

```bash
kubectl get all
```

After that, the service needs to be exposed via port forwarding, so you can open the app with your browser of choice:

```bash
kubectl port-forward svc/lab1-git-race [forwarded-port]:8080
```

For example, if you choose to forward port 3000, the output of the command should be as follows:

```bash
$ kubectl port-forward svc/lab1-git-race 3000:8080
> Forwarding from 127.0.0.1:3000 -> 8080
> Forwarding from [::1]:3000 -> 8080
...
```

If you want to clean the cluster, enter the following command:

```bash
kubectl delete -f deployment.yml
```

## Gradle Configuration

Gradle is a tool for automating building.  
The Gradle build file `build.gradle.kts` (which is located in the main directory) specifies Gradle's configuration for this project.

The build file consists of 4 main sections:

* Plugins
* Repositories
* Dependencies
* Kotlin
* Kotlin compiler options

### Plugins

Plugins are extensions that add features to Gradle.
In this project there are plugins added for [Kotlin](https://github.com/JetBrains/kotlin) and [SpringBoot](https://github.com/spring-projects/spring-boot).

### Repositories

In this section the repository for solving dependencies is declared.  
In our case, `mavenCentral()` specifies that the [Maven Central public repository](https://repo.maven.apache.org/maven2/) will be used to solve dependencies.

### Dependencies

This section contains the dependencies of the project which will be downloaded from Maven's repository specified above.  
The dependencies used in this project are:

* [SpringBoot](https://github.com/spring-projects/spring-boot)
* [Jackson](https://github.com/FasterXML/jackson)
* [Kotlin Reflection](https://kotlinlang.org/docs/reflection.html#jvm-dependency)
* Kotlin Standard Library JDK 8 extension
* [Bootstrap WebJar](https://github.com/webjars/bootstrap)

### Kotlin

Kotlin is configured to run on the JVM.
When the Kotlin targets the JVM platform, options of the compile task are specified in the `compileKotlin` variable.
In our case, we specify that the target version of the JVM is 11 with `jvmTarget` and we configure the compiler to generate error by adding the `-Xjsr305=strict` flag.

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

**For other operating systems please update this guide.**

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

To stop the webserver just press `Ctrl` + `c` on your terminal.

## IntegrationTest.kt description

File that containing the integration tests. The purpose of integration testing is to confirm that different components of the application interact with each other. Integration testing is considered complete, when actual results and expected results are same. In this case, we want to check that the modified client connects correctly to the server.


## HelloController tests description

There are two different tests generated for this controller in the project:

* HelloControllerUnitTests
* HelloControllerMVCTests

### HelloControllerUnitTests

File that contains tests whose purpose is to prove the correct internal performance. This tests may prove the behaviour of a function for all its possible input parameters (this possible inputs includes correct and wrong values). In this case, the test check that the function welcome returns the correct value and modifies the map correctly.

### HelloControllerMVCTests

File that contains tests whose purpose is to prove the correct performance when different components interact among themselves. In the case of this test, it generates a GET request and prove that this request finish wit correct status and returns the correct value.