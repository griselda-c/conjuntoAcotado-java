import java.util.Iterator;


public class IteratorConj implements Iterator<Integer>{
	
	
	private ConjAcotado conj;
	private int actual = 0;

	public ConjAcotado getConj() {
		return conj;
	}

	public void setConj(ConjAcotado conj) {
		this.conj = conj;
	}

	@Override
	public boolean hasNext() {
		int size = conj.getIdx().length - 1;
		return (actual < size);
	}

	@Override
	public Integer next() {
		actual++;
		return conj.getIdx()[actual];
	}
	
	

	@Override
	public void remove() {
		conj.getElems().remove(actual);
		conj.getIdx()[actual]= 0;
	}

}
