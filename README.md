# Hamiltonian Path - Polynomial-time Algorithm

## Introduction

The current algorithm represents a possible solution to find, in polynomial time, whether an 
undirected graph has a Hamiltonian path or not.

This implementation aims to provide a solution in quadratic time (i.e. O(n<sup>2</sup>)).

As part of graph theory, a Hamiltonian path can be defined as follows:

> In the mathematical field of graph theory, a Hamiltonian path (or traceable path) is a path in an 
> undirected or directed graph that visits each vertex exactly once. A Hamiltonian cycle (or 
> Hamiltonian circuit) is a Hamiltonian path that is a cycle. Determining whether such paths and 
> cycles exist in graphs is the Hamiltonian path problem, which is NP-complete.  
> -- <cite>[Wikipedia][1]</cite>

[1]: https://en.wikipedia.org/wiki/Hamiltonian_path

## Implementation

The main concept used as part of this implementation is based on an observation that I noticed while 
trying to find (i.e. on paper) a Hamiltonian path for several undirected graphs.

The steps could be defined as follows:

1. Read the adjacency matrix of the graph.

2. While the adjacency matrix is being read, a map (i.e. dictionary-based structure) will be created 
with all the nodes. Also, the starting node of the path will be selected while the adjacency matrix 
is being read. These operations can be described as follows:

    2.1. The map will store all the nodes from the graph, as a key - value structure.
    
    Each entry in the map will be represented as: (key: node index, value: node class)
    
    The node class will contain the following details about the node: node index, number of incident 
    edges to it, and a flag to indicate if the current node has already been visited or not.
    
    By taking into consideration that each entry in the map will contain just the value 
    corresponding to that node, it can be stated that any read access from the map for a given node 
    index will be constant (i.e. O(1)).
    
    2.2. As part of reading the adjacency matrix and building the map at step 2.1., the starting 
    node will also be retained. The starting node of the path will be represented by the node which 
    has the minimum number of edges incident to it.

    If multiple nodes exist in the graph with this property, then the node with the lowest index 
    number will be selected. In this context, we can assume that each node will have an index 
    associated to it, starting from zero: 0, 1, 2, etc.
    
3. The starting node identified at step 2.2. will be marked as visited.
4. The next operations will be followed for the remaining nodes. The loop will end either when 
the number of visited nodes is equal to the number of nodes from the graph, or when there hasn't 
been found an unvisited adjacent node for the current node.

    Therefore, the next steps will be followed as part of this loop:
    
    4.1. The first operation will be to find the next node to visit.
    
      The next node to be visited will have to respect the following constraints:
    
      - To have an edge to the current node
      - To not have been visited so far
      - To have the minimum number of edges incident to it, when compared to the other adjacent nodes 
    to the current node.
   
   4.2. If a next node hasn't been found, then the algorithm will end and indicate that no 
   Hamiltonian paths were found.
   
   4.3. If a next node has been found, then this will represent the current node. It will be marked 
   as visited, and the number of visited nodes will be incremented.
   
5. If the number of visited nodes is equal to the number of nodes from the graph, then a Hamiltonian 
path has been found. Either way, a message will be displayed based on the outcome of the algorithm.

The algorithm is available within the current repository, at the following location: 

```
src/main/java/edu/personal/hamiltonian/HamiltonianPath.java
```

## Testing

Several tests have been added to verify the algorithm.

JUnit 5 has been used as a test framework for writing the tests.

The tests are available within the current repository, at the following location:

```
src/test/java/edu/personal/hamiltonian/HamiltonianPathTest.java
```

The following classes of undirected graphs have been tested up to this point:

- Barbell graph
- Cocktail Party graph
- Complete graph
- Bipartite graph
- Complete Bipartite graph
- Cycle graph
- Gear graph
- Ladder graph
- Mobius Ladder graph
- Path graph
- Prism graph
- Sun graph
- Wheel graph
- Antiprism graph
- Crown graph
- Disconnected graph
- An additional graph (i.e. from my mind)

## Running the algorithm / tests

### Prerequisites

- Java 8 installed

Running the algorithm or the tests can be done:

- Directly from an IDE like Eclipse
- From the command-line, with the current directory being set as the top-level directory of the 
project:
    
    - Running the algorithm: ```gradlew.bat run```
    
    - Running the tests: ```gradlew.bat test```
      
      For Unix-like operating systems, ```gradlew.bat``` should be replaced with: ```./gradlew```

In order to test the algorithm for a different undirected graph, the adjacency matrix can be updated 
in the ```main``` method from:

```
src/main/java/edu/personal/hamiltonian/HamiltonianPath.java
```

Alternatively, more tests can added within:

```
src/test/java/edu/personal/hamiltonian/HamiltonianPathTest.java
```