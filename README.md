# kata-pencil-durability-java

This kata represents writing to a paper with a pencil, its eraser and their given durabilities.  

Examples and scenarios are [here](https://github.com/PillarTechnology/kata-pencil-durability).

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

What things you need to run the program and how to install them:


[Java 8 JDK](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

[Apache Maven](https://maven.apache.org/install.html)

[Git](https://git-scm.com/downloads)


### Installing

First ensure you follow the `Prerequisites` section above.

Then, open a command prompt to where you desire this kata to create its directory and paste the following within:

```
git clone https://github.com/Ryguy1979/kata-pencil-durability-java.git
```

Now, still on the command line, navigate to the directory just created by the above clone operation and type the following:

```
mvn test
```

Providing everything has been installed and cloned correctly, you should see output similar to this:

[Build output example](https://github.com/Ryguy1979/kata-pencil-durability-java/blob/master/readme-example.PNG)

## Running the tests

The above `mvn test` command ran the automated tests for this project.

A couple examples of what these test:


<pre><i>As a pencil manufacturer
I want writing to cause a pencil point to go dull
so that I can sell more pencils</i>

Given any character is an uppercase character
When the pencil writes this character
Then its durability is degraded by 2</pre>


<pre><i>As a writer
I want to be able to sharpen my pencil
so that I can continue to write with it after it goes dull</i>

Given the writer sharpens the pencil
When the pencil has a length of greater than 0
Then the pencil's durability is reset to a high value of a sharpened point</pre>

## Built With

* [IntelliJ](https://www.jetbrains.com/idea/) - The IDE used
* [Maven](https://maven.apache.org/) - Dependency and Build Management
* [JUnit5](https://junit.org/junit5/) - Testing Framework

## Authors

* **Rylan Van Wyk**

