package equiporodrigo;

/**
 * Clase ListaDeRivales: Crea el arbol que guarda toda
 * la informacion de los robots escaneados.
 * @author Jose Rodrigo Fuentes Ramirez
 * @version	1.0  
 * @see Nodo
 * @see InformacionRival
 * @see RobotData 	
 */
public class ListaDeRivales
{
	/** Inicializa el nodo raiz del arbol.*/
	private Nodo raiz;
	
	/**
     * Constructor del arbol.
     */
	public ListaDeRivales() {
		raiz = null;
	}
	
	/**
	 * Comprueba si el arbol esta vacio
	 * @return true si el arbol este vacio o false si no.
	 */
	public boolean isVacio(){
		if(raiz == null){
			 return true;
		 }else{
			 return false;
		 }	
	}
	
	/**
	 * Devuelve el objeto almacenado en el nodo cuya clave asociada coincide con la que se pasa como parametro.
	 * @param clave cadena de texto a buscar
	 * @return objeto almacenado con la clave buscada
	 */
	public InformacionRival buscar(Comparable clave){
		 if(isVacio()){
			 return null;
		 }
		 if(raiz.GetClave().equals(clave)){
			 return raiz.GetInfoTotal();
		 }else{
			 if(raiz.GetClave().compareTo(clave) == -1){
				 return raiz.GetHijoDer().buscar(clave);			
			 }else{
				 return raiz.GetHijoIzq().buscar(clave);
			 }
		 }
	 }

	/**
	 * Inserta un nuevo elemento en el arbol, con la clave y la informacion indicadas
	 * @param clave del nuevo elemento
	 * @param info nuevo objeto a almacenar
	 */
	public void insertar(Comparable clave, InformacionRival info){
		 if(isVacio()){
			 Nodo nodo = new Nodo(clave,info);					 
			 raiz = nodo;
		 }
		 else{
			 if(raiz.GetClave().equals(clave)){
				raiz.SetInfoTotal(info);
			 }else{
				 if(raiz.GetClave().compareTo(clave)==-1){
					 raiz.GetHijoDer().insertar(clave, info);
				 }else{
					 raiz.GetHijoIzq().insertar(clave, info); 					
				 }
			 }
		 }
	 }
	
	/**
	 * Presenta por salida estandar todas las entradas del arbol, siguiendo el recorrido pre-orden.
	 * Para cada nodo, se presenta:
	 *   1-  Informacion almacenada en el nodo
	 *   2-  Hijo izquierdo
	 *   3-  Hijo derecho
	 */
	public void mostrarPreOrden(){
		 if(!isVacio()){
			 System.out.println(this.raiz.GetInfoTotal().GetInfo().GetNombre());
			 this.raiz.GetHijoIzq().mostrarPreOrden();
			 this.raiz.GetHijoDer().mostrarPreOrden();
		 }
	 }
}
