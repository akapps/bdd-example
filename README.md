# A BDD use-case using Cucumber

I created this project as a support to a presentation of what BDD is.
It has been built as a step-by-step illustration of how to go BDD using Cucumber.

Following the branch `follow/steps` commit by commit, it is possible to build a (really) simple example
alongside me.


## Steps

#### 1. Feature definition

Let's just define what the system should do in a feature file : `account_management.feature`.  
In IntelliJ, with the Cucumber plugin active, you can run it directly by right-clicking the **Feature** keyword.

##### 1.1. We add some more scenarios / examples

#### 2. Implement business code and glue

I create business objects to resolve the feature. Those objects should remain pretty simple, in order to only fulfill
what is defined by the feature file.  
Of course, best practices in code design should be applied nevertheless.

#### 3. Add a Cucumber launcher

Until now, the feature could be run using IntelliJ but not by standard build tools (Maven, Gradle).  
In this step I define a Cucumber feature(s) launcher. Such a class will be the entry-point for (here) JUnit to run
the feature's examples as tests.