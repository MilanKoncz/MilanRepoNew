
public class Main {

	public static void main(String[] args) {
		/*
		 * Ransomware Algorithmus: -breitensuche
		 * 
		 */
		Graph network = new Graph();

		network.addVertex(new Vertex("PC1"));
		network.addVertex(new Vertex("PC2")); // start
		network.addVertex(new Vertex("PC3"));
		network.addVertex(new Vertex("Rathaus"));
		network.addVertex(new Vertex("Keller"));
		network.addVertex(new Vertex("Sporthalle"));
		network.addVertex(new Vertex("Serverraum Main"));
		network.addVertex(new Vertex("Serverraum 1+2"));
		network.addVertex(new Vertex("Ruheraum"));
		network.addVertex(new Vertex("Erdkunde Vorbereitung"));
		network.addVertex(new Vertex("SLZ"));

		network.addEdge(new Edge(network.getVertex("PC1"), network.getVertex("Serverraum Main"), 8));
		network.addEdge(new Edge(network.getVertex("Serverraum Main"), network.getVertex("Serverraum 1+2"), 6));
		network.addEdge(new Edge(network.getVertex("Serverraum Main"), network.getVertex("Ruheraum"), 2));
		network.addEdge(new Edge(network.getVertex("Serverraum Main"), network.getVertex("Keller"), 3));
		network.addEdge(new Edge(network.getVertex("Keller"), network.getVertex("Rathaus"), 13));
		network.addEdge(new Edge(network.getVertex("Keller"), network.getVertex("Sporthalle"), 6));
		network.addEdge(new Edge(network.getVertex("Erdkunde Vorbereitung"), network.getVertex("Ruheraum"), 7));
		network.addEdge(new Edge(network.getVertex("Erdkunde Vorbereitung"), network.getVertex("PC2"), 7));
		network.addEdge(new Edge(network.getVertex("Erdkunde Vorbereitung"), network.getVertex("PC3"), 14));
		network.addEdge(new Edge(network.getVertex("Erdkunde Vorbereitung"), network.getVertex("SLZ"), 8));

		System.out.println(
				"-----------------------------------------------------------breitenTraversal-----------------------------------------------------------");
		breitenTraversal(network, network.getVertex("PC2"));
		System.out.println(
				"-----------------------------------------------------------greedyAlgorithmTraversal-----------------------------------------------------------");
		greedyAlgorithmTraversal(network, network.getVertex("PC2"));
		System.out.println(
				"-----------------------------------------------------------breitenSuche-----------------------------------------------------------");
		List<Vertex> path = breitenSuche(network, network.getVertex("PC2"), network.getVertex("Ruheraum"));
		path.toFirst();
		while (path.hasAccess()) {
			if (path.getContent().isMarked()) {
				System.out.println(path.getContent().getID());
				path.next();
			} else {
				System.out.println("Error");
			}

		}
		// System.out.println("-----------------------------------------------------------");
		// other Methods
	}

	public static void breitenTraversal(Graph network, Vertex pStart) {
		network.setAllVertexMarks(false);
		pStart.setMark(true);

		List<Vertex> neighbours = new List<Vertex>();
		List<Vertex> path = new List<Vertex>();
		path.append(pStart);
		Queue<Vertex> queue = new Queue<Vertex>();
		Vertex activeVertex = pStart;

		while (network.allVerticesMarked() != true) {

			neighbours = network.getNeighbours(activeVertex);
			neighbours.toFirst();
			while (neighbours.hasAccess()) {
				if (neighbours.getContent().isMarked()) {
					neighbours.next();
				} else {
					queue.enqueue(neighbours.getContent());
					neighbours.next();
				}

			}

			activeVertex = queue.front();
			path.append(activeVertex);
			queue.dequeue();
			activeVertex.setMark(true);
		}

		path.toFirst();
		while (path.hasAccess()) {
			if (path.getContent().isMarked()) {
				System.out.println(path.getContent().getID());
				path.next();
			} else {
				System.out.println("Error");
			}

		}
	}

	public static void greedyAlgorithmTraversal(Graph network, Vertex pStart) {

		network.setAllVertexMarks(false);
		pStart.setMark(true);

		List<Vertex> neighbours = new List<Vertex>();
		List<Vertex> path = new List<Vertex>();
		path.append(pStart);
		Vertex activeVertex = pStart;
		double w1;
		double w2;
		double pathLenght = 0;

		while (network.allVerticesMarked() != true) {

			neighbours = network.getNeighbours(activeVertex);
			neighbours.toFirst();
			w1 = network.getEdge(activeVertex, neighbours.getContent()).getWeight();
			neighbours.next();
			while (neighbours.hasAccess()) {
				if (neighbours.getContent().isMarked()) {
					neighbours.next();
				} else {
					w2 = network.getEdge(activeVertex, neighbours.getContent()).getWeight();
					if (w1 < w2) {
						neighbours.next();
					} else {
						w1 = w2;
						pathLenght += w1;
						neighbours.next();
					}
				}

			}
			activeVertex = neighbours.getContent();
			activeVertex.setMark(true);
			path.append(activeVertex);
		}

		System.out.println("Pathlenght: " + pathLenght);

		path.toFirst();
		while (path.hasAccess()) {
			if (path.getContent().isMarked()) {
				System.out.println(path.getContent().getID());
				path.next();
			} else {
				System.out.println("Error");
			}

		}
	}

	public static List<Vertex> breitenSuche(Graph network, Vertex pStart, Vertex pZiel) {
		network.setAllVertexMarks(false);
		pStart.setMark(true);

		List<Vertex> neighbours = new List<Vertex>();
		List<Vertex> path = new List<Vertex>();
		path.append(pStart);
		Queue<Vertex> queue = new Queue<Vertex>();
		Vertex activeVertex = pStart;

		while (network.allVerticesMarked() != true) {

			neighbours = network.getNeighbours(activeVertex);
			neighbours.toFirst();
			while (neighbours.hasAccess()) {
				if (neighbours.getContent().isMarked()) {
					neighbours.next();
				} else {
					if (neighbours.getContent().equals(pZiel)) {
						path.append(neighbours.getContent());
						return path;
					} else {
						queue.enqueue(neighbours.getContent());
						neighbours.next();
					}

				}

			}

			activeVertex = queue.front();
			path.append(activeVertex);
			queue.dequeue();
			activeVertex.setMark(true);
		}

		path.toFirst();
		while (path.hasAccess()) {
			if (path.getContent().isMarked()) {
				System.out.println(path.getContent().getID());
				path.next();
			} else {
				System.out.println("Error");
			}

		}
		return path;
	}

	public static void tiefenTraversal(Graph network, Vertex vertex) {
		network.setAllVertexMarks(false);
		vertex.setMark(true);
		List<Vertex> neighbours = network.getNeighbours(vertex);
		neighbours.toFirst();
		while (neighbours.hasAccess()) {
			Vertex neighbour = neighbours.getContent();
			if (!neighbour.isMarked()) {
				tiefenTraversal(network, neighbour);
			}
			neighbours.next();
		}
	}

	
	}


