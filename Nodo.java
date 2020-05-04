package equiporodrigo;

/**
 * Clase Nodo: Crea un nodo nuevo en el arbol llamado
 * ListaDeRivales. En cada nodo guarda informacion de un robot  
 * @author Jose Rodrigo Fuentes Ramirez
 * @version	1.0 
 * @see ListaDeRivales
 * @see InformacionRival	
 */
public class Nodo
{
	/** Guarda la clave del nodo.*/
	private Comparable clave;
	
	/** Guarda Informacion del rival mediande un objeto InformacionRival.*/
	private InformacionRival infoTotal;
	
	/** Guarda el arbol de la izquierda.*/
	private ListaDeRivales hijoIzq;
	
	/** Guarda el arbol de la derecha.*/
	private ListaDeRivales hijoDer;
	
	/**
     * Constructor de Nodos dado su clave y la informacion del robot escaneado.
     */		
	public Nodo(Comparable clave, InformacionRival infoTotal) {
		this.clave = clave;
		this.infoTotal = infoTotal;
		hijoIzq = new ListaDeRivales();
		hijoDer = new ListaDeRivales();
	}
	
	/**
     * Devuelve un objeto RobotData
     * @return Info
     */		
	public Comparable GetClave(){
		return clave;
	}
	
	
	public void SetClave(Comparable clave){
		this.clave = clave;
	}
	
	/**
     * Devuelve un objeto InformacionRival en el cual contiene inforacion del robot
	 * como por ejemplo su energia, su nombre, etc.
     * @return infoTotal
     */
	public InformacionRival GetInfoTotal(){
		return infoTotal;
	}
	
			
	public void SetInfoTotal(InformacionRival infoTotal){
		this.infoTotal = infoTotal;
	}
	
	/**
     * Devuelve un objeto ListaDeRivales, concretamente el arbol de la izquierda
     * @return hijoIzq
     */		
	public ListaDeRivales GetHijoIzq(){
		return hijoIzq;
	}
	
	
	public void SetHijoIzq(ListaDeRivales hijoIzq){
		this.hijoIzq = hijoIzq;
	}
	
	/**
     * Devuelve un objeto ListaDeRivales, concretamente el arbol de la derecha
     * @return hijoDe
     */
	public ListaDeRivales GetHijoDer(){
		return hijoDer;
	}
	
	public void SetHijoDer(ListaDeRivales hijoDer){
		this.hijoDer = hijoDer;
	}
}
