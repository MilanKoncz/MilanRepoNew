
public class Main {
	
	static Graph network = new Graph();
	
	public static void main(String[] args) {
		/*
		 * Ransomware Algorithmus: -breitensuche
		 * 
		 */

		

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

		breitenSuche();
		System.out.println("-----------------------------------------------------------");
		gewichteteSuche();
		
		
	}
	
	public static void breitenSuche() {
		network.setAllVertexMarks(false);
		network.getVertex("PC2").setMark(true);
		
		List<Vertex> neighbours = new List<Vertex>();
		Queue<Vertex> queue = new Queue<Vertex>();
		Vertex activeVertex = network.getVertex("PC2");
		
		while(network.allVerticesMarked() != true) {
			
			neighbours = network.getNeighbours(activeVertex);
			neighbours.toFirst();
			while(neighbours.hasAccess()) {
				if(neighbours.getContent().isMarked()) {
					neighbours.next();
				}else {
					queue.enqueue(neighbours.getContent());
					neighbours.next();
				}
				
			}
			
			activeVertex = queue.front();
			queue.dequeue();
			activeVertex.setMark(true);		
		}
		
		List<Vertex> all = network.getVertices();
		all.toFirst();
		while(all.hasAccess()) {
			if(all.getContent().isMarked()) {
				System.out.println(all.getContent().getID());
				all.next();
			}else {
				System.out.println("Error");
			}
			
		}
	}
	
	public static void gewichteteSuche() {
		
	}

}
