## Homework 2 - Design Pattern Code Generator  Plugin for IntelliJ Idea

### Overview

This plugin allows the users to create java source files for a design pattern. It uses the Design Pattern Code Generator developed during Hw1. It provides a UI for developers on  [IntelliJ IDEA](https://www.jetbrains.com/idea/) to generate invoke the generators of the DePaCoG application. 

The plugin is built using [Plugin Devkit](https://www.jetbrains.org/intellij/sdk/docs/basics/getting_started/using_dev_kit.html).  It is a bundled IntelliJ IDEA plugin for developing plugins for the IntelliJ Platform using IntelliJ IDEA’s own build system

### Instructions

#### Prerequisites

- [Java 9](https://docs.oracle.com/javase/9/) or above
- [Gradle Build Tool](https://gradle.org/)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/)

#### Running the application

1. Clone or download this repository onto your system

2. Open the Command Line Interface and browse to the project directory  (Project : rahul_romilkeswani_hw2)

3. Run the project with the following commands

   ```
   gradle runIde
   ```

   This launches an instance of IDEA with the plugin activated. 

### Application Design

![](https://github.com/rahulromilkeswani/intellij-idea-plugin-to-create-design-patterns/blob/master/Screenshots/Capture.jpg)

#### Modules

1. **Action** : This package contains actions associated with each of the patterns. The action opens up the GUI window the receive the user inputs for the particular pattern and then delegates the creation tasks to the Creator. 
2. **InputDialog** : This package contains a JDialog class and a form for each design pattern. The class instantiates the form and sets the given input in the corresponding Action class on events. The forms define the layout for the input window. 
3. **Creator** : The creator invokes the methods from Hw1 using the Generator Facade. It's also responsible for setting the output directory to the workspace of the newly launched IDEA instance. 

#### External Libraries Used

1.  [SLF4J](http://www.slf4j.org/index.html) and [LogBack](http://logback.qos.ch/) : For logging

2.  [Lightbender Typesafe Config](https://github.com/lightbend/config) : For configuration library management

6. [jUnit](https://junit.org/junit4/) : Testing framework

4. DePaCog : Design Pattern Code Generator application (Hw1)

   

   Below is the gradle dependency diagram of the Plugin. 

   ![cap2](https://github.com/rahulromilkeswani/intellij-idea-plugin-to-create-design-patterns/blob/master/Screenshots/cap2.jpg)

### Output and Simulation

#### Working 

1. In the launched instance of Idea, go to Code  --> Create Design Patterns
2. Select the design pattern you want to create the source files for. 
3. The input dialog for the corresponding pattern opens.
4. Enter the inputs and click on the OK button. 
5. The source files get created in the current project.

#### Sample Run

**NOTE** :  

**Change the directory of the logs to some desired path in the logback.xml file under src/main/resources. The default path set it "C:" which  is a windows drive.**

**Run the project from the rahul_romilkeswani_hw2 folder using the 'gradle runIde' command.**

#### **The source files are generated in the [Workspace path +  'src/Output' ] directory of the project. So make sure to have a src directory in the project and a directory within the src named Output** 

#### **Input for methods are seperated by a space. Multiple methods are separated by a semicolon.                                      [eg: "methodName1 methodType1;methodName2 methodType2"]**

#### **Menu**

![Menu](https://github.com/rahulromilkeswani/intellij-idea-plugin-to-create-design-patterns/blob/master/Screenshots/Menu.png)

##### Getting Inputs for the pattern

![Menu](https://github.com/rahulromilkeswani/intellij-idea-plugin-to-create-design-patterns/blob/master/Screenshots/Strategy.png)


### Limitations

1. The application doesn't handle errors that might occur when keywords are given as inputs. For example, the class name itself being a keyword. 
2. Returns null at the end of the generated method. So giving VOID as the return type when prompted would throw errors in the file. 
3. If a file has been wrongly created, user would have to manually delete the files before the next run. 
4. The package for the generated files is set to 'Output'. The user would need to have a src/Output directory in the project. 
5. Duplicate class names aren't checked for. It results in overwriting. 
6. Path for logs isn't it the project directory by default. It can however be changed to any other location on the system in the logback.xml
7. Number of objects/classes that can be created for a type are limited to 2 for most patterns. 
