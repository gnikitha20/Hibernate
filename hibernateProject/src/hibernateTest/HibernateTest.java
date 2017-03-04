package hibernateTest;


import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Address;
import model.UserDetails;
import model.Vehicle;

public class HibernateTest {
	public static void main(String[] args) {
		UserDetails ud = new UserDetails();
		ud.setUserName("AJAY");
		ud.setJoinedDate(new Date(02-18-2017));
		Address add1 = new Address();
		add1.setCity("Huntsville");
		add1.setState("AL");
		add1.setStreet("Brownston CT");
		add1.setZipcode("35763");
		Address add2 = new Address("KANSAS","MO","6625 W141 ST","64093");
		ud.getListOfAddresses().add(add1);
		ud.getListOfAddresses().add(add2);
 		ud.setDescription("Description of First Person goes here");
 		Vehicle vehicle = new Vehicle();
 		vehicle.setVehicleName("Car");
 		ud.setVehicle(vehicle);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(ud);
		session.save(vehicle);
		session.getTransaction().commit();
		session.close();
		
		/*SessionFactory sf = new Configuration().configure().buildSessionFactory();
		UserDetails ud = new UserDetails();
		ud = null;
		Session session = sf.openSession();
		session.beginTransaction();
		ud= session.get(UserDetails.class,1);
		System.out.println("USER NAME IS "+ ud.getUserName().toUpperCase()+ " HE LIVES IN "+ud.getListOfAddresses());
	*/}
}
