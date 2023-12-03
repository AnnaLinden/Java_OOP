# Task 1: Performance Measures in a Java Project Simulator

## Health Center Scenario

This task involves applying the concepts of performance measures in the context of a Java project simulator, using a health center as an example.

### Performance Variables Explanation

1. **Arrived Clients Count (A)**: Number of patients arriving at the health center.
2. **Clients Serviced Count (C)**: Number of patients treated.
3. **Active Time in Service Point (B)**: Time spent by medical staff in treating patients.
4. **Total Simulation Time (T)**: Overall duration of the simulation.
5. **Service Point Utilization (U)**: Efficiency of staff, calculated as \( U = \frac{B}{T} \).
6. **Service Throughput (X)**: Treatment rate, \( X = \frac{C}{T} \).
7. **Average Service Time (S)**: Mean treatment time per patient, \( S = \frac{B}{C} \).
8. **Response Time for Individual Patient (R𝑖)**: Duration from a patient's arrival to treatment completion.
9. **Cumulative Waiting Time (W)**: Total wait time for all patients.
10. **Average Response Time (R)**: Mean time from arrival to treatment, \( R = \frac{W}{C} \).
11. **Average Queue Length (N)**: Mean number of patients in the queue, \( N = \frac{W}{T} \).

## Assignment Tasks

### Writing Task (W)

- Discuss each performance measure in the context of the health center. Describe the implications of each variable on efficiency, responsiveness, and patient experience.

### Programming Task (P)

- Implement the simulation in Java, capturing and calculating these metrics. The program should simulate patient arrivals, queue management, service, and compute the performance measures.

### Tips for the Assignment

- **Real-world Application**: Explain how each variable impacts the real-world functioning of a health center.
- **Use of Diagrams**: Incorporate diagrams for a visual representation of patient flow and variable calculation.
- **Examples**: Provide hypothetical scenarios to illustrate the calculation of derived variables.
