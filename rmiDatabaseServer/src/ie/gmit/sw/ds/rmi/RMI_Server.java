package ie.gmit.sw.ds.rmi;

import java.rmi.*;
import java.util.*;
import ie.gmit.sw.ds.models.Accounts;


public interface RMI_Server extends Remote{

	public ArrayList<Accounts> getFileNames() throws RemoteException;
	
}
