import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;



/**
 * This class manage the value of temperature from the sensor.
 * 
 * @author emalianakasmuri
 *
 */
public class TemperatureSensorManager extends UnicastRemoteObject implements TemperatureSensor {

	private static final long serialVersionUID = 1L;

	HashMap<String, Integer> temp = new HashMap<>();
	
	public TemperatureSensorManager() throws RemoteException {
		super();
	}

	@Override
	public int getTemperature() throws RemoteException {
		
		return 35;
	}

	
	public HashMap<String, Integer> getTemperatureDays() throws RemoteException {
		temp.put("Monday", 32);
		temp.put("Tuesday", 31);
		temp.put("Wednesday", 33);
		temp.put("Thursday", 35);
		temp.put("Friday", 36);
		temp.put("Saturday", 33);
		temp.put("Sunday", 33);
		
		
		return temp;
	}

	@Override
	public float getAverageTemperature() throws RemoteException {
		HashMap<String,Integer>data = getTemperatureDays();
		
		float total = 0;
		
		for(int temperature:data.values()) {
			total += temperature;
		}
		
		float average = (float)total / 7;
		return average;
	}
	
	
}
