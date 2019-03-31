import java.util.ArrayList;
import java.util.List;

public class GrafoComListaDeAdjacencias implements Grafo {

	private List<Vertice> vertices = new ArrayList<>();
	private List<VerticeInterno> verticesInternos = new ArrayList<>();
	private List<Aresta> arestas = new ArrayList();

	public GrafoComListaDeAdjacencias(String... nomesVertices) {
		for (String nomeVertice : nomesVertices) {
			this.addVertice(nomeVertice);
		}
	}
	
	@Override
	public Vertice addVertice(String nome) {
		Vertice vertice = new Vertice();
		vertice.setNome(nome);
		vertices.add(vertice);
		
		VerticeInterno verticeInterno = new VerticeInterno();
		verticeInterno.setVertice(vertice);
		verticesInternos.add(verticeInterno);
		
		return vertice;
	}
	
	public Vertice getVertice(String nome) {
		for (Vertice vertice: vertices) {
			if (vertice.getNome().equals(nome)) {
				return vertice;
			}
		}
		
		return null;
	}
	
	private VerticeInterno getVerticeInterno(Vertice v) {
		for (VerticeInterno verticeInterno : verticesInternos) {
			if (verticeInterno.getVertice().equals(v)) {
				return verticeInterno;
			}
		}
		
		throw new RuntimeException("Vertice interno não encontrado");
	}

	@Override
	public void addAresta(Vertice v1, Vertice v2) {
		this.arestas.add(new Aresta(v1, v2));
	}

	@Override
	public List<Vertice> getVertices() {
		return vertices;
	}

	@Override
	public boolean segue(Vertice v1, Vertice v2) {
		for(Aresta aresta: this.arestas) {
			if (aresta.getOrigem().equals(v1) && aresta.getDestino().equals(v2))
				return true;
		}
		return false;
	}

}

class VerticeInterno {

	private Vertice vertice;
	private List<Aresta> arestas = new ArrayList<>();

	public Vertice getVertice() {
		return vertice;
	}

	public void setVertice(Vertice vertice) {
		this.vertice = vertice;
	}

	public List<Aresta> getArestas() {
		return arestas;
	}

}
