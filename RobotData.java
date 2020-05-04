package equiporodrigo;

/**
 * Clase RobotData: Guarda la energia y el Nombre del robot escaneado
 * para luego guardarlo en sus respectivos atributos.  
 * @author Jose Rodrigo Fuentes Ramirez
 * @version	1.0  
 */

public class RobotData
	{
	
	/** Atributo que guarda el Nombre del robot escaneado.*/
	private String Nombre;
	
	/** Atributo que guarda la energia del Robot escaneado.*/
	private double energia;
	
	/**
     * Constructor de objetos RobotData dado su nombre y su energia.
     */
    public RobotData(String Nombre, double energia){
		this.Nombre = Nombre;
		this.energia = energia;
		}		
	
	/**
     * Devuelve el Nombre del Robot
     * @return Nombre
     */
	public String GetNombre(){
		return Nombre;
	}

	/**
     * Asigna el Nombre correspondiente a cada robot
     * @param Nombre
     */
	public void SetNombre(String Nombre){
		this.Nombre = Nombre;
	}
	
	/**
     * Devuelve la energia del Robot
     * @return energia
     */
	public double GetEnergia(){
		return energia;
	}
	
	/**
     * Asigna la energia correspondiente a cada robot
     * @param energia  
     */
	public void SetEnergia(double energia){
		this.energia = energia;
	}
}