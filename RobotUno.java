package equiporodrigo;
import robocode.*;
import java.awt.Color;

/**
 * Clase RobotUno: RobotUno hereda de TeamRobot
 * Esta clase define los "sentidos"(metodos) de el robot
 * que hemos creado.  
 * @author Jose Rodrigo Fuentes Ramirez
 * @version	1.0 
 * @see ListaDeRivales
 * @see InformacionRival
 * @see RobotData 	
 */

public class RobotUno extends TeamRobot{
	
	/** Inicializa nuestro arbol para guardar informacion de todos los robot enemigos.*/
	ListaDeRivales Enemigos = new ListaDeRivales();
	
	/** Almacena el Nombre y la Energia del Robot Escaneado.*/
	RobotData Rbc;
	
	/** Almacena un objeto RobotData, la distancia, los grados y los radianes del robot escaneado*/
	InformacionRival Robots;
	
	/** Atributo definido para guardar la informacion del objetivo*/
	InformacionRival objetivo;
	
	/** Atributo creado para actualizar la informacion del objetivo*/
	InformacionRival Actobjetivo;
	
	/** Guarda la la direccion en grados del robot a atacar */
	double posicionatacar;
	
	/** Guarda la energia del robot escaneado en ese momento*/
	double EnergiaActual;
	
	/** Guarda la energia del robot anteriormente escaneado*/
	double EnergiaAnterior = 100;
	
	/** Guarda la energia del robot mas debil*/
	double EMenorTodos = 200;
	
	/** Guarda el nombre del robot escaneado*/
	String Atacado;
	
	/** Guarda el numero de enemigos*/
	int enemigos = 0;
	
	/** Guarda el numero de robots en el campo de batalla*/
	int vivos;
	
	
	/**
	 * Metodo que se invoca cuando se inicializa la batalla
	 */
	public void run() {
	 // Pintamos nuestro tanque llamado Robotuno
		setBodyColor(Color.black);
		setGunColor(Color.gray);
		setRadarColor(Color.red);
		setBulletColor(Color.red);
		setAdjustRadarForRobotTurn(true);
	 // Bucle infinito, giramos siempre el radar	
		while(true) {
			turnRadarRight(360);
			turnRadarRight(360);
		}
	}
	
	/**
	 * Metodo que se invoca cuando escanea algun robot.
	 * @param el robot escaneado
	 */	
	public void onScannedRobot(ScannedRobotEvent e) {
	 // Guardamos el numero de enemigos 
		vivos = getOthers();
	 // Aumentamos el dato de la energia cuando un robot enemigo muere
		if(enemigos > vivos){
			EMenorTodos = 150;
		}
	 // Guardamos el numero de robots enemigos vivos.
		enemigos = vivos;
	 // Guardamos el nombre y la energia del robot escaneado.
		Rbc = new RobotData(e.getName(),e.getEnergy());
	 // Guardamos Un objeto Robot la posicion del tanque rival en grados y radianes, y finalmete la distancia.
		Robots = new InformacionRival(Rbc, e.getBearing(), e.getBearingRadians(), e.getDistance());
	 // Los insertamos en el arbol llamado enemigos.	
		Enemigos.insertar(e.getName(), Robots);
	 // Buscamos al robot escaneado para guardar su informacion en un atributo. 	
		InformacionRival Debil = Enemigos.buscar(e.getName());
	 // Muestra en la consola los robots guardados (No hce falta, lo puse para comprobar si el arbol funcionaba)	
	    Enemigos.mostrarPreOrden();
	 // Si el robot escaneado es uno de mi equipo no le ataca y si no lo es busca al mas debil
		if(e.getName().equals("equiporodrigo.RobotUno 1 (1)") || e.getName().equals("equiporodrigo.RobotUno 1 (2)") ||
			e.getName().equals("equiporodrigo.RobotUno 1 (3)") || e.getName().equals("equiporodrigo.RobotUno 1 (4)")){
			EnergiaActual = 200;
			Atacado = e.getName();
			System.out.println(Atacado + "ESSSSS de nuestro equipo");// muestra la salida en la consola
		}else{
			EnergiaActual = Debil.GetInfo().GetEnergia();// Guarda la energia del robot escaneado en ese momento
			Atacado = e.getName();
			System.out.println(Atacado + " NOOOOO es de nuestro equipo");// muestra la salida en la consola
		}
	 // En esta instruccion cambia de objetivo si dectecta a uno mas debil y si no le sigue atacando, actualiza los datos del robot objetivo cada vez que el radar pasa por el objetivo.
		if(EnergiaActual <= EMenorTodos){
			objetivo = Debil;
			posicionatacar = objetivo.GetGrados();
			turnRight(Debil.GetGrados());
			fire(3);		
		}else{
			Actobjetivo = Enemigos.buscar(objetivo.GetInfo().GetNombre());
			posicionatacar = Actobjetivo.GetGrados();
			if(posicionatacar != objetivo.GetGrados()){
				turnRight(Actobjetivo.GetGrados());
				fire(1);
			}else{
				fire(3);
			}
		}
	 	EnergiaAnterior = EnergiaActual;
	 // Guarda la energia menor de todos	
		if(EnergiaAnterior < EMenorTodos){
			EMenorTodos = EnergiaAnterior;
		}		
	}
	
	/**
	 * Metodo que se invoca cuando recibibos una bala de otro robot
	 * @param el robot escaneado
	 */
	public void onHitByBullet(HitByBulletEvent e) {
	 //	Gira hasta encontrar al robot que nos disparo y dispara. 
		turnRight(e.getBearing()); 
		fire(3);		
	}
	
	/**
	 * Metodo que se invoca cuando chocamos con un robot
	 * @param el robot escaneado
	 */
	public void onHitRobot (HitRobotEvent e) {
	 // Si esta adelante nuestro ir hacia atras .
		if (e.getBearing() > -90 && e.getBearing() < 90) {
			fire(3);
			back(100);
		} //Si esta detras, movernos hacia adelante.
		else {
			ahead(100);
		}
	}
	
	/**
	 * Metodo que se invoca cuando chocamos con una pared
	 * @param el robot escaneado
	 */
	public void onHitWall (HitWallEvent e){
		if (e.getBearing() > -90 && e.getBearing() < 90) {
			back(100);
		} //Si esta detras, movernos hacia adelante.
		else {
			ahead(100);
		}
	}	
}
