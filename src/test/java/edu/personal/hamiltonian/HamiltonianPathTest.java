package edu.personal.hamiltonian;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Set of tests for verifying the correctness of the algorithm for a wider range of classes of
 * undirected graphs.
 *
 * @author george.cionca
 */
public class HamiltonianPathTest {

	private static HamiltonianPath hamiltonianPath;

	@BeforeAll
	public static void setUp() {
		hamiltonianPath = new HamiltonianPath();
	}

	@DisplayName("A Hamiltonian path should be found within the Barbell graph provided as example.")
	@Test
	public void testFindHamiltonianPathBarbellGraph() {
		int[][] adjacencyMatrix = {
				{0, 1, 1, 0, 0, 0},
				{1, 0, 1, 0, 0, 0},
				{1, 1, 0, 1, 0, 0},
				{0, 0, 1, 0, 1, 1},
				{0, 0, 0, 1, 0, 1},
				{0, 0, 0, 1, 1, 0},
		};

		List<Integer> path = hamiltonianPath.findHamiltonianPath(adjacencyMatrix);

		assertEquals(Arrays.asList(0, 1, 2, 3, 4, 5), path);
	}

	@DisplayName("A Hamiltonian path should be found within the Cocktail Party graph provided as "
			+ "example.")
	@Test
	public void testFindHamiltonianPathCocktailPartyGraph() {
		int[][] adjacencyMatrix = {
				{0, 1, 0, 1},
				{1, 0, 1, 0},
				{0, 1, 0, 1},
				{1, 0, 1, 0}
		};

		List<Integer> path = hamiltonianPath.findHamiltonianPath(adjacencyMatrix);

		assertEquals(Arrays.asList(0, 1, 2, 3), path);
	}

	@DisplayName("A Hamiltonian path should be found within the Complete graph provided as example.")
	@Test
	public void testFindHamiltonianPathCompleteGraph() {
		int[][] adjacencyMatrix = {
				{0, 1, 1, 1},
				{1, 0, 1, 1},
				{1, 1, 0, 1},
				{1, 1, 1, 0}
		};

		List<Integer> path = hamiltonianPath.findHamiltonianPath(adjacencyMatrix);

		assertEquals(Arrays.asList(0, 1, 2, 3), path);
	}

	@DisplayName("No Hamiltonian paths should be found within the Bipartite graph provided as "
			+ "example.")
	@Test
	public void testFindHamiltonianPathBipartiteGraph() {
		int[][] adjacencyMatrix = {
				{0, 0, 0, 0, 1, 1, 0, 0, 1},
				{0, 0, 0, 0, 0, 0, 1, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 1, 0},
				{0, 0, 0, 0, 0, 0, 0, 1, 0},
				{1, 0, 0, 0, 0, 0, 0, 0, 0},
				{1, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 1, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 1, 1, 0, 0, 0, 0, 0},
				{1, 0, 0, 0, 0, 0, 0, 0, 0}
		};

		List<Integer> path = hamiltonianPath.findHamiltonianPath(adjacencyMatrix);

		assertEquals(Collections.emptyList(), path);
	}

	@DisplayName("A Hamiltonian path should be found within the Complete Bipartite graph provided as "
			+ "example.")
	@Test
	public void testFindHamiltonianPathCompleteBipartiteGraph() {
		int[][] adjacencyMatrix = {
				{0, 0, 0, 1, 1},
				{0, 0, 0, 1, 1},
				{0, 0, 0, 1, 1},
				{1, 1, 1, 0, 0},
				{1, 1, 1, 0, 0}
		};

		List<Integer> path = hamiltonianPath.findHamiltonianPath(adjacencyMatrix);

		assertEquals(Arrays.asList(0, 3, 1, 4, 2), path);
	}

	@DisplayName("A Hamiltonian path should be found within the Cycle graph provided as example.")
	@Test
	public void testFindHamiltonianPathCycleGraph() {
		int[][] adjacencyMatrix = {
				{0, 1, 0, 1},
				{1, 0, 1, 0},
				{0, 1, 0, 1},
				{1, 0, 1, 0}
		};

		List<Integer> path = hamiltonianPath.findHamiltonianPath(adjacencyMatrix);

		assertEquals(Arrays.asList(0, 1, 2, 3), path);
	}

	@DisplayName("A Hamiltonian path should be found within the Gear graph provided as example.")
	@Test
	public void testFindHamiltonianPathGearGraph() {
		int[][] adjacencyMatrix = {
				{0, 1, 0, 0, 0, 1, 1},
				{1, 0, 1, 0, 0, 0, 1},
				{0, 1, 0, 1, 0, 0, 1},
				{0, 0, 1, 0, 1, 0, 1},
				{0, 0, 0, 1, 0, 1, 1},
				{1, 0, 0, 0, 1, 0, 1},
				{1, 1, 1, 1, 1, 1, 0}
		};

		List<Integer> path = hamiltonianPath.findHamiltonianPath(adjacencyMatrix);

		assertEquals(Arrays.asList(0, 1, 2, 3, 4, 5, 6), path);
	}

	@DisplayName("A Hamiltonian path should be found within the Ladder graph provided as example.")
	@Test
	public void testFindHamiltonianPathLadderGraph() {
		int[][] adjacencyMatrix = {
				{0, 1, 0, 1, 0, 0},
				{1, 0, 1, 0, 1, 0},
				{0, 1, 0, 0, 0, 1},
				{1, 0, 0, 0, 1, 0},
				{0, 1, 0, 1, 0, 1},
				{0, 0, 1, 0, 1, 0}
		};

		List<Integer> path = hamiltonianPath.findHamiltonianPath(adjacencyMatrix);

		assertEquals(Arrays.asList(0, 3, 4, 5, 2, 1), path);
	}

	@DisplayName("A Hamiltonian path should be found within the Mobius Ladder graph provided as "
			+ "example.")
	@Test
	public void testFindHamiltonianPathMobiusLadderGraph() {
		int[][] adjacencyMatrix = {
				{0, 1, 0, 0, 1, 0, 0, 1},
				{1, 0, 1, 0, 0, 1, 0, 0},
				{0, 1, 0, 1, 0, 0, 1, 0},
				{0, 0, 1, 0, 1, 0, 0, 1},
				{1, 0, 0, 1, 0, 1, 0, 0},
				{0, 1, 0, 0, 1, 0, 1, 0},
				{0, 0, 1, 0, 0, 1, 0, 1},
				{1, 0, 0, 1, 0, 0, 1, 0}
		};

		List<Integer> path = hamiltonianPath.findHamiltonianPath(adjacencyMatrix);

		assertEquals(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7), path);
	}

	@DisplayName("A Hamiltonian path should be found within the Path graph provided as example.")
	@Test
	public void testFindHamiltonianPathPathGraph() {
		int[][] adjacencyMatrix = {
				{0, 1, 0, 0},
				{1, 0, 1, 0},
				{0, 1, 0, 1},
				{0, 0, 1, 0}
		};

		List<Integer> path = hamiltonianPath.findHamiltonianPath(adjacencyMatrix);

		assertEquals(Arrays.asList(0, 1, 2, 3), path);
	}

	@DisplayName("A Hamiltonian path should be found within the Prism graph provided as example.")
	@Test
	public void testFindHamiltonianPathPrismGraph() {
		int[][] adjacencyMatrix = {
				{0, 1, 0, 1, 1, 0, 0, 0},
				{1, 0, 1, 0, 0, 1, 0, 0},
				{0, 1, 0, 1, 0, 0, 1, 0},
				{1, 0, 1, 0, 0, 0, 0, 1},
				{1, 0, 0, 0, 0, 1, 0, 1},
				{0, 1, 0, 0, 1, 0, 1, 0},
				{0, 0, 1, 0, 0, 1, 0, 1},
				{0, 0, 0, 1, 1, 0, 1, 0}
		};

		List<Integer> path = hamiltonianPath.findHamiltonianPath(adjacencyMatrix);

		assertEquals(Arrays.asList(0, 1, 2, 3, 7, 4, 5, 6), path);
	}

	@DisplayName("A Hamiltonian path should be found within the Sun graph provided as example.")
	@Test
	public void testFindHamiltonianPathSunGraph() {
		int[][] adjacencyMatrix = {
				{0, 1, 0, 0, 0, 1},
				{1, 0, 1, 1, 0, 1},
				{0, 1, 0, 1, 0, 0},
				{0, 1, 1, 0, 1, 1},
				{0, 0, 0, 1, 0, 1},
				{1, 1, 0, 1, 1, 0}
		};

		List<Integer> path = hamiltonianPath.findHamiltonianPath(adjacencyMatrix);

		assertEquals(Arrays.asList(0, 1, 2, 3, 4, 5), path);
	}

	@DisplayName("A Hamiltonian path should be found within the Wheel graph provided as example.")
	@Test
	public void testFindHamiltonianPathWheelGraph() {
		int[][] adjacencyMatrix = {
				{0, 1, 1, 1},
				{1, 0, 1, 1},
				{1, 1, 0, 1},
				{1, 1, 1, 0}
		};

		List<Integer> path = hamiltonianPath.findHamiltonianPath(adjacencyMatrix);

		assertEquals(Arrays.asList(0, 1, 2, 3), path);
	}

	@DisplayName("A Hamiltonian path should be found within the Antiprism graph provided as example.")
	@Test
	public void testFindHamiltonianPathAntiprismGraph() {
		int[][] adjacencyMatrix = {
				{0, 1, 1, 0, 1, 1},
				{1, 0, 1, 1, 0, 1},
				{1, 1, 0, 1, 1, 0},
				{0, 1, 1, 0, 1, 1},
				{1, 0, 1, 1, 0, 1},
				{1, 1, 0, 1, 1, 0}
		};

		List<Integer> path = hamiltonianPath.findHamiltonianPath(adjacencyMatrix);

		assertEquals(Arrays.asList(0, 1, 2, 3, 4, 5), path);
	}

	@DisplayName("A Hamiltonian path should be found within the Crown graph provided as example.")
	@Test
	public void testFindHamiltonianPathCrownGraph() {
		int[][] adjacencyMatrix = {
				{0, 0, 0, 1, 0, 1},
				{0, 0, 1, 0, 1, 0},
				{0, 1, 0, 0, 0, 1},
				{1, 0, 0, 0, 1, 0},
				{0, 1, 0, 1, 0, 0},
				{1, 0, 1, 0, 0, 0}
		};

		List<Integer> path = hamiltonianPath.findHamiltonianPath(adjacencyMatrix);

		assertEquals(Arrays.asList(0, 3, 4, 1, 2, 5), path);
	}

	@DisplayName("No Hamiltonian paths should be found within the graph provided as example.")
	@Test
	public void testFindHamiltonianPathSampleGraph() {
		int[][] adjacencyMatrix = {
				{0, 1, 0, 0},
				{1, 0, 1, 1},
				{0, 1, 0, 0},
				{0, 1, 0, 0}
		};

		List<Integer> path = hamiltonianPath.findHamiltonianPath(adjacencyMatrix);

		assertEquals(Collections.emptyList(), path);
	}

	@DisplayName("No Hamiltonian paths should be found within the disconnected graph provided as "
			+ "example.")
	@Test
	public void testFindHamiltonianPathDisconnectedGraph() {
		int[][] adjacencyMatrix = {
				{0, 0, 0, 0},
				{0, 0, 1, 0},
				{0, 1, 0, 1},
				{0, 0, 1, 0},
		};

		List<Integer> path = hamiltonianPath.findHamiltonianPath(adjacencyMatrix);

		assertEquals(Collections.emptyList(), path);
	}

}
