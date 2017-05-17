package aoptest;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

public class SpringAOPTest {

    @Test
    public void inteceptorTest(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-test.xml");
        PersonServer bean = (PersonServer)ctx.getBean("personServiceBean");
        bean.save(null);
    }
}