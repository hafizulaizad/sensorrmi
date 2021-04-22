import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * This class represent the server-side application using RMI
 * 
 * @author emalianakasmuri
 *
 */
public class TemperatureServerRMIApp {

	public static void main(String[] args) {
		
		
		try {
			
			// Create interface object
			TemperatureSensor sensorJasin = new TemperatureSensorManager();
			TemperatureSensor ayerKeroh = new TemperatureSensorManager();
			
			// Get registry
			Registry rmiRegistry = LocateRegistry.getRegistry();
			
			// Register interface object as remote object
			
			rmiRegistry.rebind("SensorJasin", sensorJasin);
			
			System.out.println("SensorJasin is successfully registered");
			
			rmiRegistry.rebind("SensorAyerKeroh", ayerKeroh);
			
			System.out.println("SensorAyerKeroh is successfully registered");
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
