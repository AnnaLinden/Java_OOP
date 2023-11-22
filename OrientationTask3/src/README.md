# Task 4

(W) Familiarize yourself with a few distributions that could be used in the simulator for experimentation. These distributions could be used in the following situations. Find answers online. You can also study other distributions. For example, Google "real life example of normal distribution".

## Answer

While researching online, I found a few distributions that could be useful in our simulator:

Normal Distribution: Often called the Gaussian distribution, it's used to represent real-valued random variables whose distributions are not known. It's applicable in a variety of fields like natural and social sciences. A real-life example is human heights. In a population, heights tend to cluster around a central average value with a decrease in frequency as you move away from the mean.

Binomial Distribution: Used when there are exactly two mutually exclusive outcomes of a trial, like success or failure. A real-life example is flipping a coin a certain number of times and counting the number of heads (or tails).

Exponential Distribution: This is used for modeling the time between events in a process where events occur continuously and independently at a constant average rate. A typical example is the amount of time until the next bus arrives at a bus stop.

Poisson Distribution: It's used for modeling the number of times an event occurs in a fixed interval of time or space. An example is the number of phone calls received by a call center per hour.

These distributions can simulate different scenarios in our project, depending on what aspect of real-life we want to replicate or study. The choice of distribution depends on the nature of the data and the specific requirements of the simulation.

# Task 3

(W) Why can't a Singleton object be created from outside the Singleton class using the new operation?

## Answer

A Singleton object cannot be created from outside the Singleton class using the new operator because the constructor of a Singleton class is made private. This private constructor prevents other classes from directly creating a new instance of the Singleton class. In a Singleton design pattern, only one instance of the class is allowed to exist, and this instance is accessed through a static method within the Singleton class. This method typically checks if an instance already exists; if not, it creates one using the private constructor and returns it. This approach ensures that no other class can bypass the mechanism and create another instance, thereby maintaining the Singleton property of having only one instance throughout the application.

# task 1

(W) Suppose you are compiling statistics on the age structure of students in our group. You should then draw 1000 age values and these should be distributed in the same way as the age distribution of the students in the group. How do you do it? Explain the algorithm in enough details to be able to program it directly. Take an idea/model from the example on section Your own distribution.

## Answer

### Student Age Distribution Simulation

To simulate the age structure of our group, we will follow a specific algorithm to draw 1000 age values. These values will reflect the approxinate (I don't have exact) age distribution of the students in our group. The steps we'll take are outlined below:

Step 1: Collect Age Data
First, we need to gather data on the age distribution of students in our group. This involves determining the percentage of students for each age within the group.

Step 2: Create an Age Distribution Representation
With the data collected, we create a representation of the age distribution. This will include each age and its corresponding percentage in the group. For example, if 20% of our students are 20 years old, we note this down.

Step 3: Convert to Cumulative Distribution
We then convert these percentages into a cumulative distribution. This helps in mapping random numbers to specific ages.

Step 4: Generate Random Numbers
Next, we generate 1000 random numbers between 1 and 100. These numbers will be used to simulate the age distribution.

Step 5: Map Random Numbers to Ages
For each random number, we determine the corresponding age based on our cumulative distribution. This mapping will ensure that the simulated ages reflect the actual distribution of our group.

Step 6: Repeat and Tally
We repeat this process for all 1000 random numbers, keeping a tally for each age.

Step 7: Result
At the end of this process, we will have a simulated age distribution of 1000 values, closely resembling the actual age structure of our group.

This approach allows us to accurately reflect the age distribution in our simulations, ensuring that our statistical analysis is as close to reality as possible.

Markdown format does not support complex tables natively, but you can use simple ASCII-style tables or list formats to represent data if needed.
