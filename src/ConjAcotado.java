import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Vector;


public class ConjAcotado {

	private LinkedList<Integer> elems = new LinkedList<Integer>(); //inserciones y borrado rápido
	
	private Vector<ListIterator<Integer>> idx; //acceso rapido, costoso borrado en el medio o al final
	
	
	public ConjAcotado(int cota){
	
		idx = new Vector<ListIterator<Integer>>(cota);
		for (int i = 0; i < cota; i++) {
			//idx.insertElementAt(elems.listIterator(), i);
			  idx.add(elems.listIterator());
		}
		
	}
	
	public boolean pertenece(int elem){
		return idx.elementAt(elem).hasNext();
	}
	
	public int size(){
		return elems.size();
	}
	
	public void agregar(int elem){
		elems.addFirst(elem);	
		// ListIterator<Integer> iter = elems.listIterator(elems.size()-1);//apunta la ultimo elemento agregado
		idx.insertElementAt(elems.listIterator(), elem);
	}
	
	public boolean isEmpty(){
		return elems.isEmpty();
	}
	
		
	
	public void eliminar(int elem){
	   // ListIterator<Integer> iter = idx.elementAt(elem);
		//iter.next();
		//iter.remove();
		elems.remove(idx.elementAt(elem).next());
		idx.setElementAt(elems.listIterator(elems.size()), elem);
		
	}
	
	public IteratorConj iterator(){
		return new IteratorConj(elems.listIterator());
	}
	
	
	
	static class IteratorConj implements Iterator<Integer>{
		
		
		private ListIterator<Integer> conj;
		
		public IteratorConj(ListIterator<Integer> conj) {
			this.conj = conj;
		}
		
		

		@Override
		public boolean hasNext() {
			return conj.hasNext();
		}


		@Override
		public Integer next() {
			return conj.next();
		}


		@Override
		public void remove() {
			conj.next();
		}

		
	
	}
	
	public static void main(String[] args) {

				
				ConjAcotado ca = new ConjAcotado(6);
				ca.agregar(2);
				ca.agregar(3);// v[n,n,2,3,n,n,n]
				System.out.println(ca.pertenece(4)); //esto debería dar false;
				/*
				if(ca.pertenece(2)){
					ca.eliminar(2);
				}
				*/
				//ca.agregar(8);
				
				/*
				IteratorConj iter = ca.iterator();
				
				while(iter.hasNext()){
					System.out.println(iter.next());
				}
				
				*/
				
			}
	
}
