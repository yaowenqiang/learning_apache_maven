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

## Core plugins


+ Learn how to use the most common Maven plugins
+ Understand the purpose of plugins
+ Reinforce plugin invocation and configuration

> https://maven.apache.org/plugins/


### clean

> mvn clean
> mvn clean:clean

### jar


> mvn package

> mvn jar:jar

> mvn jar:jar -Djar.finalName=test -Djar.forceCreation=true

> https://maven.apache.org/plugins/maven-jar-plugin/plugin-info.html

finalName is not working on the jar plugin anymore,
but can be specified in the build secion of pom file

```xml
<build>
    <finalName>WhatEverYouLike</finalName>
</build>

```

> mvn clean package

> brew install p7zip
> 7z -l xxx.jar


### javadoc


```bash


mvn javadoc:javadoc  -Dheader=MyJavaDoc -Dfooter=Copyleft
mvn javadoc:javadoc 
mvn javadoc:jar
mvn javadoc:aggregate
mvn javadoc:aggregate-jar
mvn javadoc:test-javadoc
mvn javadoc:test-jar
mvn javadoc:test-aggregate
mvn javadoc:test-aggregate-jar
```

> https://maven.apache.org/plugins/maven-javadoc-plugin/usage.html

### install

> mvn install

### deploy

> https://jfrog.com/

### surefile

> mvn test

> mvn install -Dmaven.test.skip=true

TODO

### eclipse

> mvn eclipse:eclipse

### war

> mvn war:war



## Create and structure maven projects

+ Understand the bennfits of archetypes
+ Create a custom archetype
+ Build a multi-module project

> mvn archetype:create-from-project

> bat target/generated-sources/archetype/src/main/resources/archetype-resources/pom.xml

> cd target/generated-sources/archetype
> mvn install

## Additional Features

+ Learn how to deploy a web application to a server
+ Discover how to encrypt credentials
+ use properties to make configuration dynamic
+ Uncover additional help and debugging

### install tomcat

```bash

wget https://dlcdn.apache.org/tomcat/tomcat-9/v9.0.95/bin/apache-tomcat-9.0.95.tar.gz

tar zxvf apache-tomcat-9.0.95.tar.gz

sudo mv apache-tomcat-9.0.95 /usr/local/
cd /usr/local/apache-tomcat-9.0.95/
./bin/startup.sh



```

> http://localhost:8080/

### Add user to tomcat

```bash
vim /usr/local/apache-tomcat-9.0.95/conf/tomcat-users.xml

add 

<role rolename="manager-gui"/>
<user username="tomcat" password="123456" roles="manager-gui"/>

<role rolename="manager-script"/>
<user username="admin" password="123456" roles="manager-gui"/>
# stop and start tomcat 

./bin/shutdown.sh
./bin/startup.sh

mvn tomcat7:deploy
mvn tomcat7:redeploy

```

#### encrypt password

```bash

mvn -emp password

touch ~/.m2/settings-security.xml

mvn tomcat7:undeploy

https://maven.apache.org/guides/mini/guide-encryption.html

```

### debugging

```bash

mvn -help
mvn compiler:help
mvn -q compile
mvn -x compile






```


## m2e plugin

TODO

## dependency plugin

> mvn dependency:tree

## add mvn auto completion

> brew install zsh-completions 

> chmod go-w '/opt/homebrew/share'

> chmod -R go-w '/opt/homebrew/share/zsh'


