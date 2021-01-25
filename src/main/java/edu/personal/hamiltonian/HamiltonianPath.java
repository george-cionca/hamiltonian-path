package edu.personal.hamiltonian;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Solution to find whether an undirected graph has a Hamiltonian path or not.
 *
 * The time complexity of this algorithm is quadratic (i.e. O(n^2)), thus providing a solution in
 * polynomial time.
 *
 * @author george.cionca
 */
public class HamiltonianPath {

	public static void main(String[] args) {
		int[][] adjacencyMatrix = {
				{0, 1, 1, 0, 0, 0},
				{1, 0, 1, 0, 0, 0},
				{1, 1, 0, 1, 0, 0},
				{0, 0, 1, 0, 1, 1},
				{0, 0, 0, 1, 0, 1},
				{0, 0, 0, 1, 1, 0},
		};

		HamiltonianPath hamiltonianPath = new HamiltonianPath();

		List<Integer> path = hamiltonianPath.findHamiltonianPath(adjacencyMatrix);
		hamiltonianPath.displaySolution(path);
	}

	/**
	 * Retrieve the Hamiltonian path for the adjacency matrix provided as argument.
	 *
	 * @param adjacencyMatrix The adjacency matrix for the undirected graph
	 * @return The ordered list of node indexes representing the Hamiltonian path
	 */
	public List<Integer> findHamiltonianPath(int[][] adjacencyMatrix) {
		int numberOfNodes = adjacencyMatrix.length;
		NodeMap nodeMap = buildNodeMap(adjacencyMatrix);

		int visitedNodes = 1;
		int currentNodeIndex = nodeMap.startingNodeIndex;
		nodeMap.map.get(currentNodeIndex).visited = true;

		List<Integer> path = new ArrayList<>(numberOfNodes);
		path.add(currentNodeIndex);

		while (visitedNodes < numberOfNodes) {
			Optional<Node> nextNode = findNextNodeToVisit(currentNodeIndex, adjacencyMatrix, nodeMap.map);
			if (!nextNode.isPresent()) {
				break;
			}

			currentNodeIndex = nextNode.get().nodeIndex;
			nextNode.get().visited = true;
			path.add(currentNodeIndex);
			visitedNodes++;
		}

		if (visitedNodes < numberOfNodes) {
			return Collections.emptyList();
		}

		return path;
	}

	/**
	 * Build a map containing the nodes from the graph. Each key in the map referred through the node
	 * index will have only one value associated, represented through a {@link Node} instance.
	 * Therefore, the access operation for a certain node from the map will be constant (i.e. O(1)).
	 *
	 * As the map is being built, the node with the minimum number of edges incident to it will be
	 * retained and will be used as the starting node.
	 *
	 * @param adjacencyMatrix The adjacency matrix for the undirected graph
	 * @return An instance of {@link NodeMap}
	 */
	private NodeMap buildNodeMap(int[][] adjacencyMatrix) {
		Map<Integer, Node> map = new HashMap<>(adjacencyMatrix.length);
		int minimumEdges = Integer.MAX_VALUE;
		int startingNodeIndex = 0;

		for (int i = 0; i < adjacencyMatrix.length; i++) {
			Node node = new Node();
			node.nodeIndex = i;

			for (int j = 0; j < adjacencyMatrix.length; j++) {
				node.numberOfEdges += adjacencyMatrix[i][j];
			}
			map.put(i, node);

			if (node.numberOfEdges < minimumEdges) {
				minimumEdges = node.numberOfEdges;
				startingNodeIndex = i;
			}
		}

		NodeMap nodeMap = new NodeMap();
		nodeMap.map = map;
		nodeMap.startingNodeIndex = startingNodeIndex;

		return nodeMap;
	}

	/**
	 * Retrieve the next node to visit by checking the unvisited adjacent nodes of the current node,
	 * and selecting the adjacent node which has the minimum number of edges incident to it.
	 *
	 * @param currentNodeIndex The index of the current node in the path
	 * @param adjacencyMatrix The adjacency matrix for the undirected graph
	 * @param nodeMap An instance of {@link NodeMap}
	 * @return The {@link Node} instance wrapped within an Optional
	 */
	private Optional<Node> findNextNodeToVisit(int currentNodeIndex, int[][] adjacencyMatrix,
			Map<Integer, Node> nodeMap) {

		int minimumEdges = Integer.MAX_VALUE;
		Optional<Node> nextNode = Optional.empty();

		for (int j = 0; j < adjacencyMatrix.length; j++) {
			Node verifiedNode = nodeMap.get(j);

			if (adjacencyMatrix[currentNodeIndex][j] == 1 &&
					!verifiedNode.visited &&
					verifiedNode.numberOfEdges < minimumEdges) {

				minimumEdges = verifiedNode.numberOfEdges;
				nextNode = Optional.of(verifiedNode);
			}
		}

		return nextNode;
	}

	/**
	 * Display the list of nodes from the Hamiltonian path. An empty list indicates that no
	 * Hamiltonian paths were found.
	 *
	 * @param path The ordered list of node indexes representing the Hamiltonian path
	 */
	private void displaySolution(List<Integer> path) {
		if (path.isEmpty()) {
			System.out.println("No Hamiltonian paths were found for the current graph.");
		} else {
			System.out.println("The following Hamiltonian path was found: " + path);
		}
	}

	/**
	 * Structure to store the index of the node, the number of edges incident to the node, and a flag
	 * to indicate whether the node has been visited.
	 */
	private static class Node {

		private int nodeIndex;
		private int numberOfEdges;
		private boolean visited;

	}

	/**
	 * Structure to store the map which contains the nodes from the graph, where the key is
	 * represented by the node index and the value by a {@link Node} instance.
	 *
	 * The index of the starting node will also be stored in this structure.
	 */
	private static class NodeMap {

		private Map<Integer, Node> map;
		private int startingNodeIndex;

	}

}
