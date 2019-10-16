package view;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.impl.accountServerImpl;
import service.impl.accountServerImpl_Anno;

/**
 * 基于注解的形式
 */
public class Anno_view {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("spring_anno.xml");

        accountServerImpl_Anno as = (accountServerImpl_Anno)ac.getBean("anno_service");

        as.saveAccount();
    }
}
