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
		int d1 = temp.get("Monday");
		int d2 = temp.get("Tuesday");
		int d3 = temp.get("Wednesday");
		int d4 = temp.get("Thursday");
		int d5 = temp.get("Friday");
		int d6 = temp.get("Saturday");
		int d7 = temp.get("Sunday");
		
		float average = (d1+d2+d3+d4+d5+d6+d7)/7;
		return average;
	}
	
	
}
