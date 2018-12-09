package ie.gmit.sw.ds.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServiceSetup {
	
	public static void main(String[] args) throws Exception{

		DatabaseService cbs = new DatabaseServiceImpl();
		
		LocateRegistry.createRegistry(1099);
		
		Naming.rebind("databaseservice", cbs);
		
		System.out.println("Server Running..");
	}
}
