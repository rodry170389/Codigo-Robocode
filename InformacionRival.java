package equiporodrigo;

/**
 * Clase InformacionRival: Guarda un objeto del a clase RobotData, 
 * la posicion del robot en grados, la posicion del robot en radianes
 * y la distancia del robot escaneado.  
 * @author Jose Rodrigo Fuentes Ramirez
 * @version	1.0  
 * @see RobotData  	
 */
public class InformacionRival
{
	
	/** Atributo que guarda la energia y el nombre.*/
	private RobotData Info;
	
	/** Atributo que guarda la posicion del robot escaneado en grados.*/
	private double grados;
	
	/** Atributo que guarda la posicion del robot escaneado en grados.*/
	private double radianes;
	
	/** Atributo que guarda la distancia del robot escaneado.*/
	private double distancia;
	
	/**
     * Constructor de objetos InformacionRival dado un objeto RobotData, su posicion en grados,
     * su posicion en radianes y su distancia.
     */
	public InformacionRival(RobotData Info, double grados, double radianes, double distancia){
		this.Info = Info;
		this.grados = grados;
		this.radianes = radianes;
		this.distancia = distancia;
	}

	/**
     * Devuelve un objeto RobotData
     * @return Info
     */
	public RobotData GetInfo(){
		return Info;
	}
    
	/**
     * Asigna un objeto RobotData
     * @param Info
     */
	public void SetInfo(RobotData Info){
		this.Info = Info;
	}
	
	/**
     * Devuelve la posicion del robot escaneado en grados
     * @return grados
     */
	public double GetGrados(){
		return grados;
	}
	
	/**
     * Asigna la posicion del robot escaneado en grados
     * @param grados
     */
	public void SetGrados(double grados){
		this.grados = grados;
	}

    /**
     * Devuelve la posicion del robot escaneado en radianes
     * @return radianes
     */
	public double GetRadianes(){
		return radianes;
	}
	
	/**
     * Asigna la posicion del robot escaneado en radianes
     * @param radianes
     */
	public void SetRadianes(double radianes){
		this.radianes = radianes;
	}
   
	/**
     * Devuelve la distancia del robot escaneado
     * @return distancia
     */
	public double GetDistancia(){
		return distancia;
	}
	
	/**
     * Asigna la distancia del robot escaneado
     * @param distancia
     */
	public void SetDistancia(double distancia){
		this.distancia = distancia;
	}
}
