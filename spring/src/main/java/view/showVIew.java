package view;

import dao.impl.accountDaoImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import service.impl.accountServerImpl;
import service.impl.accountServerImpl2;
import service.impl.accountServerImpl3;

/**
 * 模拟一个表现层，调用业务层
 */
public class showVIew {
    /**
     * 获取spring的Ioc核心容器，并根据id获取对象
     * Application三个常用实现类
     *  1.ClassPathXmlApplicationContext  (常用）加载类路径下的配置文件，要求配置文件必须在类路径下，不在的话，无法加载
     *  2.FileSystemXmlApplicationContext   他可以加载磁盘任意路径下的配置文件（必须有访问权限）
     *
     *  3.AnnotationConfigApplicationContext    读取注解，创建容器
     *
     *核心容器的两个接口引发出的问题
     *  ApplicationContext：单例对象适用
     *      构建核心容器时，创建对象采取的思想策略是立即加载的方式，只要一读取完配置文件，马上就创建配置文件中配置的对象
     *  BeanFactory：多例对象适用
     *      构建核心容器时，创建对象采取的思想策略是延迟加载的方式，什么时候根据id获取对象，什么时候真正创建对象；
     */
    public static void main(String[] args) {
//        //1.获取核心容器对象
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
//      ApplicationContext ac = new FileSystemXmlApplicationContext("磁盘中xml的路径地址");
//        //2. 根据id获取Bean对象
//      accountServerImpl as = (accountServerImpl)ac.getBean("accountServer");
        accountServerImpl as = (accountServerImpl)ac.getBean("accountServer");
        accountServerImpl2 as2 = (accountServerImpl2)ac.getBean("accountServer2");
        accountServerImpl3 as3 = (accountServerImpl3)ac.getBean("accountServer3");
        as.saveAccount();
        as2.saveAccount();
        as3.saveAccount();
//        accountDaoImpl ad = ac.getBean("accountDao",accountDaoImpl.class);
//        System.out.println(as);
//        System.out.println(ad);
//        --------------------------------------
//        BeanFactory模式获取对象
//        Resource resource = new ClassPathResource("bean.xml");
//        BeanFactory bf = new XmlBeanFactory(resource);
//        accountServerImpl as = (accountServerImpl)bf.getBean("accountServer");
//        System.out.println(as);
    }



}
