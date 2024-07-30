import org.hibernate.Session;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entity.Fee;
import entity.Getaway;
import entity.TestGetaway;
import entity.TestFee;
import entity.TestVacation;
import entity.Vacation;

public class Main {

	public static void main(String[] args) {
		final var registry = new StandardServiceRegistryBuilder()
				.build();

		try (final var sf = new MetadataSources( registry )
				.addAnnotatedClasses( TestGetaway.class, TestFee.class, TestVacation.class )
				.buildMetadata()
				.buildSessionFactory()) {

			sf.inTransaction( Main::initDb );
			sf.inTransaction( Main::testFee );
			sf.inTransaction( Main::testGetaway );
//			TODO uncomment if uncommented in initDb
//			sf.inTransaction( Main::testVacation );
		}
		catch (Exception e) {
			StandardServiceRegistryBuilder.destroy( registry );
		}
	}

	private static void initDb(Session session) {
		session.persist( new TestFee( 1L, new Fee( true, false ) ) );
		session.persist( new TestGetaway( 1L, new Getaway( "B", "A" ) ) );
//TODO vacation can't even be instantiated due to argument mismatch
//  You can try manually inserting the data using SQL and then selecting vacation
//		session.persist( new TestVacation( 1L, new Vacation( true, 7 ) ) );
	}

	private static void testFee(Session session) {
		TestFee testFee = session.find( TestFee.class, 1L );
		System.out.println("Expected 'false': " + testFee.getFee().issuedA());
		System.out.println("Expected 'true': " + testFee.getFee().issuedB());
	}

	private static void testGetaway(Session session) {
		TestGetaway testGetaway = session.find( TestGetaway.class, 1L );
		System.out.println("Expected 'A': " + testGetaway.getGetaway().getawayA());
		System.out.println("Expected 'B': " + testGetaway.getGetaway().getawayB());
	}

	private static void testVacation(Session session) {
		try {
			TestVacation testVacation = session.find( TestVacation.class, 1L );
			System.out.println("Expected '7': " + testVacation.getVacation().amount());
			System.out.println("Expected 'true': " + testVacation.getVacation().issued());

		} catch (Exception e) {
			System.out.println("Shouldn't throw, but did");
			e.printStackTrace();
		}
	}
}
