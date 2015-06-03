import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class ConjAcotado {

	private List<Integer> elems = new LinkedList<Integer>(); //inserciones y borrado rápido
	
	private int[] idx; //acceso rapido, costoso borrado en el medio o al final
	                   //tiene num en tres
	
	
	
	public IteratorConj iterator(){
		IteratorConj iter = new IteratorConj();
		iter.setConj(this);
		return iter;
	}
	
	

	
	public int[] getIdx() {
		return idx;
	}




	public void setIdx(int[] idx) {
		this.idx = idx;
	}




	public List<Integer> getElems() {
		return elems;
	}

	public void setElems(List<Integer> elems) {
		this.elems = elems;
	}

	
	
	public ConjAcotado(int cota){
		idx = new int[cota];
	}
	
	public boolean pertenece(int elem){
		return idx[elem] != 0;
	}
	
	public void agregar(int elem){
		idx[elem] = elem;
		elems.add(elem);
		
	}
	
	public void eliminar(int elem){
		idx[elem] = 0;
		elems.remove(elem);
	}
	
	public static void main(String[] args) {

		ConjAcotado con = new ConjAcotado(6);
		con.agregar(5);
		/*
		Iterator<Integer> iter = con.iterator();
		while(iter.hasNext()){
			int n = iter.next();
			System.out.println(n);
		}
		
		*/
		
		if(con.pertenece(5)){
			con.eliminar(5);
		}
		
		
	}
	
		
	
	
	
}
