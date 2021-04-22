import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;

public class TemperatureClientRMIAyerKeroh {

		public static void main(String[] args) {
			
			
			try {
				
				// Get registry
				Registry rmiRegistry = LocateRegistry.getRegistry();
				
				TemperatureSensor remoteSensorAyerKeroh = (TemperatureSensor) rmiRegistry.lookup("SensorAyerKeroh");
				
				// Invoke method from the remote object
				int currentTempAyerKeroh = remoteSensorAyerKeroh.getTemperature();
				HashMap<String, Integer> currentDailyTempAyerKeroh = remoteSensorAyerKeroh.getTemperatureDays();
				float  currentAvgTempAyerKeroh = remoteSensorAyerKeroh.getAverageTemperature();
				
				System.out.println("Current temperature in Ayer Keroh is " + currentTempAyerKeroh + " Celcius");
				System.out.println("Temperature in Ayer Keroh daily " + currentDailyTempAyerKeroh + " Celcius");
				System.out.println("Average temperature in Ayer Keroh weekly " + currentAvgTempAyerKeroh + " Celcius");
			} catch (RemoteException | NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}

