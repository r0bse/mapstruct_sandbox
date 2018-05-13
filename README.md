# mapstruct_sandbox
Sandbox for playing around with Mapstruct, H2 and Liquibase in a SpringBoot Project

## MapStruct Overview

MapStruct is a code generator that greatly simplifies the implementation of mappings between Java bean types based on a convention over configuration approach.\
http://mapstruct.org/

## Project Setup

Uses:
* gradle
* H2
* Liquibase
* Spring Boot
* Map Struct

### Run Instructions

`./gradlew bootRun`

### REST URLs 

* http://localhost/persons \
//TODOs
* http://localhost/superheros
* http://localhost/secretidenties

### IntelliJ Configuration

To be able to use Code Completion and run the Application from IntelliJ you have to do 2 things:
1. enable build/run delegation to gradle (Settings -> Build/Run/Deployment -> Gradle -> Runner) 
2. Install mapstruct-plugin from Idea Repository