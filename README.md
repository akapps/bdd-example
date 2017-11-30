# A BDD use-case using Cucumber

I created this project as a support to a presentation of what BDD is.
It has been built as a step-by-step illustration of how to go BDD using Cucumber.

Following the branch `follow/steps` commit by commit, it is possible to build a (really) simple example
alongside me.


## Steps

#### 1. Feature definition

Let's just define what the system should do in a feature file : `account_management.feature`.  
In IntelliJ, with the Cucumber plugin active, you can run it directly by right-clicking the **Feature** keyword.

##### (1.1) We add some more scenarios / examples  

#### 2. `wrong-way/no-business` Implements the glue

Here I provide a "glue" (*ie implementation*) for the feature.  
But **the glue itself contain the business code** : this may seem a trivial mistake, but I saw it for real.
With more complicated business feature in a legacy app, recognize the feature from the test code (glue) is not always
so simple. Generally speaking, the glue code should be really minimalistic.  
Even with a B(T)DD approach, never forget that you ultimately want to ship production code :)