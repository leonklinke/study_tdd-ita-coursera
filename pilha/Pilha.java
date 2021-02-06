package pilha;

public class Pilha {
	
	private Object[] elementos;
	private int quantidade = 0;
	public int tamanhoMaximo;
	
	public Pilha(int maximo) {
		elementos = new Object[maximo];
		tamanhoMaximo = maximo;
	}

	public boolean estaVazia() {
		return quantidade == 0;
	}
	public boolean estaCheia() {
		return quantidade == elementos.length;
	}

	public int tamanho() {
		return quantidade;
	}

	public void empilha(Object elemento) {
		if(estaCheia()) {
			throw new PilhaCheiaException("Não é possível empilhar");
		}
		elementos[quantidade] = elemento;
		quantidade++;
	}

	public Object topo() {
		return elementos[quantidade-1];
	}

	public Object desempilha() {
		if(estaVazia()) {
			throw new PilhaVaziaException("Não é possível desempilhar");
		}
		Object topo = topo();
		quantidade--;
		return topo;
	}

}
