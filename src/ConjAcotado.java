import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Vector;


public class ConjAcotado {

	private LinkedList<Integer> elems = new LinkedList<Integer>(); //inserciones y borrado rápido
	
	//List<Integer> synchronizedList = Collections.synchronizedList(new LinkedList<Integer>()) ;
	
	private Vector<ListIterator<Integer>> idx; //acceso rapido, costoso borrado en el medio o al final
	
	private int begin = 28;
	
	private int end = -1;
	
	LinkedList<Integer>listaAuxiliar = new LinkedList<Integer>();
	
	
	                   
	
	public ConjAcotado(int cota){
		
		//cota + 1 no tiene next()
		int size = cota + 1;
		
		idx = new Vector<ListIterator<Integer>>(size);
		for (int i = 0; i < size; i++) {
			idx.insertElementAt(listaAuxiliar.listIterator(), i);
		}
		
	}
	
	public boolean pertenece(int elem){
		return idx.elementAt(elem).hasNext();
	}
	
	public int size(){
		return elems.size();
	}
	
	public void agregar(int elem){
		System.out.println();
		elems.addLast(elem);	
		int index = elems.size()- 1; // se guarda en la ultima posicion 
	    ListIterator<Integer> iter = elems.listIterator(index);
		// guardo en iterador la posicion de enum en la lista
		idx.insertElementAt(iter, elem);
		setBeginYEnd(elem);
	}
	
	public boolean isEmpty(){
		return elems.isEmpty();
	}
	
	private void setBeginYEnd(int elem){ 
		//[n3n] begin == 0, agrego el dos , 3 > 2
		
		if(isEmpty()){
			begin= elem;
			end = elem;
			}
		if(begin > elem){
			System.out.println("Entreeeeeee");
			begin = elem;
		}
		
		if(end < elem){
			end = elem;
		}
		
		
	}
	
	public void eliminar(int elem){
		
	    ListIterator<Integer> iter = idx.elementAt(elem);
		iter.next();
		iter.remove();
		
	}
	
	public IteratorConj iterator(){
		return new IteratorConj(this);
	}
	
	
	public LinkedList<Integer>getAll(){
		return this.elems;
	}
	
	
	static class IteratorConj implements Iterator<Integer>{
		
		
		private ConjAcotado conj;
		private int actual;
		
		public IteratorConj(ConjAcotado conj) {
			this.conj = conj;
			this.actual = conj.begin;
		}
		
		
		private ListIterator<Integer> getActualIterator(){
			return conj.idx.elementAt(actual);
		}


		@Override
		public boolean hasNext() {
			return actual < conj.end;
		}


		@Override
		public Integer next() {
			System.out.println("actual " +actual);
			ListIterator<Integer> iter = conj.idx.elementAt(actual);
			
			int n = iter.next();
			actual++;
			return n;
		}


		@Override
		public void remove() {
			ListIterator<Integer> iter = getActualIterator();
			iter.remove();
		}

		
	
	}
	
	public static void main(String[] args) {

		/*
				Vector<ListIterator<Integer>> v=new Vector();
				LinkedList<Integer> l = new LinkedList<Integer>();
				l.addLast(3);
				l.addLast(5);
				l.addLast(8);
				
				//[3,5,8] 
				ListIterator iter = l.listIterator(0); //apunta al 3
				ListIterator iter2 = l.listIterator(1); //apunta al 5
				ListIterator iter3 = l.listIterator(2); //apunta al 8
		        v.add(iter);
		        v.add(iter2);
		        v.add(iter3);
		        
		        
		        //quiero borrar el ocho ¿cómo sé cuál es el puntero al 8 sin recorrer todo el array?
		        
		        ListIterator i2 = v.elementAt(1);
		        i2.add(8); //[3,8,5,8]
		        
		        i2.set(0);
		        
		        i2.next();
		        i2.remove(); //[3,8,8]
		   
		        v.remove(2); //remove last
		        
		      
		        ListIterator i = v.elementAt(1);
		        i.next();
		        i.remove();
		        v.remove(1); // remove last
		       
		        System.out.println(v.size());
		        
		        
		        System.out.println(l);*/
				
				
				ConjAcotado ca = new ConjAcotado(6);
				ca.agregar(2);
				//ca.agregar(3);// v[n,n,2,3,n,n,n]
				//System.out.println(ca.pertenece(4)); //esto debería dar false;
				if(ca.pertenece(2)){
					ca.eliminar(2);
				}
				
				ca.agregar(8);
				
				System.out.println("lista" +ca.getAll());
				
				IteratorConj iter = ca.iterator();
				
				while(iter.hasNext()){
					System.out.println(iter.next());
				}
				
				//ca.agregar(5); //  v[n,n,3,2,5]
				//ca.agregar(2); //  v[n,2,3,n,5]
				//ca.agregar(4); // v[n,2,3,4,5]
				
				
				
			}
	
}
