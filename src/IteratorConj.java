import java.util.Iterator;
import java.util.ListIterator;


public class IteratorConj implements Iterator<Integer>{
	
	
	private ConjAcotado conj;
	private int actual;
	
	public IteratorConj(ConjAcotado conj) {
		this.conj = conj;
	}
	
	
	private ListIterator<Integer> getActualIterator(){
		return conj.getIdx().elementAt(actual);
	}


	@Override
	public boolean hasNext() {
		ListIterator<Integer> iter = getActualIterator();
		return iter.hasNext();
	}


	@Override
	public Integer next() {
		ListIterator<Integer> iter = getActualIterator();
		Integer res = iter.next();
		actual++;
		return res;
	}


	@Override
	public void remove() {
		ListIterator<Integer> iter = getActualIterator();
		iter.remove();
	}


	

	
	
	

	
}
