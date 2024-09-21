# # Maven

+ Build automation tool
+ Apache Software Foundation
+ Created at 2003
+ current version : 3.3.1

## Maven introduction

### What is Maven?

+ Maven is a build tool
+ Dependency management tool
+ Project management tool
+ Standarized approach to building Software
+ Command line tool
+ IDE integration

> https://maven.apache.org/background/philosophy-of-maven.html

### Maven landscape

#### Project object model(POM)

+ Describes, configures and customizes a Maven Project
+ Maven read the pom.xml file to build a Project
+ Defines the 'address' for the project artifact using a coordinate system
+ Specifies project information, plugins, goals, Dependencies and profiles

#### Repositories

+ Holds build artifacts and Dependencies of varying types 
+ Local repositories(local cache)
+ Remote repositories
+ Local repository takes precedence during dependency resolution

#### Plugins and goals

+ Plugin is a collection of goals
+ Example: compiler plugin
+ Gals perform the actions in Maven builds
+ All work is donw via plugins and goals
+ Called indenpently or as part of a lifecycle phase

#### Lifestyle and phases

+ lifecycle is a sequence of named phases
+ Phaes are executed sequentially
+ 3 lifecycles: clean, default, site
+ Execution a phase executes all previous phases

## Maven technical overview



## Dependencies

## Lifestyle, goals, plugins
## Archtypes
## .m2e Eclipse plugin

> https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html

## Pom Inheritance

### Super pom file

/opt/homebrew/Cellar/maven/3.9.9/libexec/lib/maven-model-builder-3.9.9.jar/org/apache/maven/model/pom-4.0.0.xml


```bash
mvn help:effective-pom

mvn -DProduction package

export PACKAGE_ENV=PROD

mvn package

```

### archetype 

```bash

mvn archetype:generate

```

### change to eclipse project

```bash
mvn eclipse:eclipse

```

## Dependencys

+ Learn the basics of dependency management
+ Discover transitive dependency management
+ Connect to alternative remote repositories
+ Understand dependency scope

> mvn dependency:copy-dependencies
> mvn help:effective-settings -DshowPasswords=true

## Build lifecycle

+ Learn the basics of the Mave Lifestyle
+ Identify important Maven phases
+ Invoke plugins explicity and via the lifecycle
+ Configure plugins to customize their behavior
+ Build a simple custom plugin


> mvn help:describe -Dcmd=clean
> mvn help:describe -Dcmd=deploy


### lifecycle phases

important phases

#### Compile

+ Compile the source code of the project



#### Test-compile

+ Compile the test source code into the test destination directory


#### Test

+ Run tests using a suitable unit testing framework. these tests should not require the code be packaged or deployed


```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <confguration>
                <testFailureIgnore>true</testFailureIgnore>
            </confguration>
        </plugin>
    </plugins>
</build>
```

#### Package

+ take the compiled code and package it in its distributable format, such as a JAR

#### Install

+ Install the package into the local repository, for use as as dependency in other projects locally

#### Deploy

+ Done in an integration or release environment. copies the final package to the remote repository for sharing with other developers and projects

### Goals and Plugins

> mvn compiler:compile

> mvn help:describe -Dplugin=compiler

get plugin goals

> mvn help:describe -Dplugin=compiler  -Ddetail


> mvn compiler:help -Ddetail=true -Dgoal=compile

> mvn help:describe -Dcmd=compiler:compile -Ddetail

> mvn help:describe -Dcmd=<pluginGoal> -Ddetail

```bash
mvn archetype:generate \
  -DgroupId=sample.plugin \
  -DartifactId=hello-maven-plugin \
  -DarchetypeGroupId=org.apache.maven.archetypes \
  -DarchetypeArtifactId=maven-archetype-plugin

```

>  https://maven.apache.org/guides/plugin/guide-java-plugin-development.html

> mvn install 
> mvn sample.plugin:hello-maven-plugin:touch

use plugin-prefix

> https://maven.apache.org/guides/introduction/introduction-to-plugin-prefix-mapping.html

> mvn fCustom:touch



