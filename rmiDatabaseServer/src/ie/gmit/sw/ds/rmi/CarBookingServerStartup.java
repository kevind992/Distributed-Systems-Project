package ie.gmit.sw.ds.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class CarBookingServerStartup {
	
	public static void main(String[] args) throws Exception{

		CarBookingServer cbs = new CarBookingServerImpl();
		
		//System.setSecurityManager(new RMISecurityManager());
		
		LocateRegistry.createRegistry(1099);
		
		Naming.rebind("carbooking2", cbs);
		
		System.out.println("Server Running..");
	}
}
