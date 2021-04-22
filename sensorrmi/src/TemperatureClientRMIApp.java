import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;


/**
 * This class represent the client-side of RMI application
 * 
 * @author emalianakasmuri
 *
 */
public class TemperatureClientRMIApp {

	public static void main(String[] args) {
		
		
		try {
			
			// Get registry
			Registry rmiRegistry = LocateRegistry.getRegistry();
			
			// Look-up for the remote object
			TemperatureSensor remoteSensorJasin = (TemperatureSensor) rmiRegistry.lookup("SensorJasin");
			
			// Invoke method from the remote object
			int currentTempJasin = remoteSensorJasin.getTemperature();
			
			System.out.println("Current temperature in Jasin is " + currentTempJasin + " Celcius");
		
			TemperatureSensor remoteSensorAyerKeroh = (TemperatureSensor) rmiRegistry.lookup("SensorAyerKeroh");
			
			// Invoke method from the remote object
			int currentTempAyerKeroh = remoteSensorAyerKeroh.getTemperature();
			HashMap<String, Integer> currentAvgTempAyerKeroh = remoteSensorAyerKeroh.getTemperatureDays();
			
			
			System.out.println("Current temperature in Ayer Keroh is " + currentTempAyerKeroh + " Celcius");
			System.out.println("Temperature in Ayer Keroh daily " + currentAvgTempAyerKeroh + " Celcius");
			
		} catch (RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
