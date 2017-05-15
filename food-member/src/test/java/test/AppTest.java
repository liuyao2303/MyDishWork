package test;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

    public AppTest(String name) {
        super(name);
    }

    private Configuration cfg = new Configuration();

    public void setUp() {
        System.out.println("initia... Hibernate");
        cfg.addAnnotatedClass(UserInfoDmo.class);
        cfg.addAnnotatedClass(UserLoginDmo.class);
        cfg.configure();
    }

    public void tearDown() {
    }

    public void insert() {
        SessionFactory sf = cfg.buildSessionFactory();
        Session ss = sf.openSession();
        Transaction tx = sf.getCurrentSession().beginTransaction();
        UserLoginDmo u = (UserLoginDmo) ss.load(UserLoginDmo.class,1);
        printBean(u);
        tx.commit();
    }

    public void hqlQuery() {
        SessionFactory sf = cfg.buildSessionFactory();
        Session ss = sf.openSession();
        Transaction tx = sf.getCurrentSession().beginTransaction();

        System.out.println("111111");
        tx.commit();
    }

    private void printBean(UserLoginDmo dmo) {
    }

    public static Test suite () {
        TestSuite suite = new TestSuite();
        suite.addTest(new AppTest("insert"));
        suite.addTest(new AppTest("hqlQuery"));
        return suite;
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }
}
