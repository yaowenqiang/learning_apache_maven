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
+ Defines the 'address' for the project antifact using a coordinate system
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
