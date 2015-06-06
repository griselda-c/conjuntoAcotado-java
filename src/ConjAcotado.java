import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Vector;


public class ConjAcotado {

	private LinkedList<Integer> elems = new LinkedList<Integer>(); //inserciones y borrado rápido
	
	private Vector<ListIterator<Integer>> idx; //acceso rapido, costoso borrado en el medio o al final
	                   
/*
 * sacar el for del constructor
 * se rompe en el agregar. No puedo agregar en una posicion.
 * 
 */
	
	public Vector<ListIterator<Integer>> getIdx() {
		return idx;
	}


	public void setIdx(Vector<ListIterator<Integer>> idx) {
		this.idx = idx;
	}

	
	
	public ConjAcotado(int cota){
		
		//cota + 1 no tiene next()
		int size = cota + 1;
		idx = new Vector<ListIterator<Integer>>(size);
		for (int i = 0; i < size; i++) {
			idx.insertElementAt(elems.listIterator(), i);
		}
		
	}
	
	public boolean pertenece(int elem){
		//¿Cómo se en que indice esta el elem?
		return idx.elementAt(elem).hasNext();
	}
	

	
	public void agregar(int elem){
		elems.addLast(elem);	
		int index = elems.size()- 1; // se guarda en la ultima posicion 
		ListIterator<Integer> iter = elems.listIterator(index);
		// guardo en iterador la posicion de enum en la lista
		idx.insertElementAt(iter, elem);
	}
	
	public void eliminar(int elem){
		// como se en que indice esta el elemento
	    ListIterator<Integer> iter = idx.elementAt(elem);
		iter.next();
		iter.remove();
	}
	
	public LinkedList<Integer>getAll(){
		return this.elems;
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
		ca.agregar(3);// v[n,n,3,n,n]
		System.out.println(ca.pertenece(3)); //esto debería dar false;
		System.out.println("lista" +ca.getAll());
		
		//ca.agregar(5); //  v[n,n,3,2,5]
		//ca.agregar(2); //  v[n,2,3,n,5]
		//ca.agregar(4); // v[n,2,3,4,5]
		
		
		
	}
	
		
	
	
	
}
