package fi.vincit.vallila.corba;

import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import fi.vincit.vallila.corba.generated.VallilaServicePOATie;

public class VallilaServer {

	public static void main(String[] args) throws Throwable {
		ORB orb = ORB.init(args, null);

		System.out.println("getting NameService...");

		Object corbaObj = orb.resolve_initial_references("NameService");

		NamingContext ns = NamingContextHelper.narrow(corbaObj);

		corbaObj = orb.resolve_initial_references("RootPOA");

		POA rootPOA = POAHelper.narrow(corbaObj);

		rootPOA.the_POAManager().activate();

		VallilaServiceImpl vallilaService = new VallilaServiceImpl();

		VallilaServicePOATie poaTie = new VallilaServicePOATie(vallilaService, rootPOA);

		System.out.println("rebinding Nameservice...");

		ns.rebind(new NameComponent[] { new NameComponent("VallilaService", "") }, poaTie._this(orb));

		orb.run();
	}
}
