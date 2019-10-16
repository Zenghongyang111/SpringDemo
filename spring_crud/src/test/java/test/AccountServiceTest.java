package test;

import config.SpringConfiguration;
import domain.Account;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.AccountService;
import service.impl.AccountServiceImpl;

import java.lang.annotation.Target;
import java.util.List;

/**
 * 使用Junit单元测试配置
 * spring整合junit的配置
 *      1.导入spring整合junit的jar(坐标)
 *      2.使用Junit提供的一个注解把原有的main方法替换了，替换成spring提供的
 *          @RunnerWith
 *      3.告知spring的运行器，spring和ioc创建是基于xml还是注解的，并且说明位置
 *          @ContextConfiguration
 *               locations:指定xml的文件位置，加上classpath关键字，表示在类的路径下
 *                classes：指定注解类的位置
 *       当我们使用spring 5.x版本的时候，要求junit 必须是4.12及以上
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

    @Autowired
    private AccountServiceImpl asn;

    @Test
    public void  testFindAll(){
        //获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring_anno.xml");
        //得到对象
        AccountService as = (AccountServiceImpl)ac.getBean("accountService");
        List<Account> accounts = as.findAllAccount();
        for(Account a:accounts){
            System.out.println(a);
        }
    }
    @Test
    public void  testFindOne(){
        //使用注解配置获取容器 AnnotationConfigApplicationContext
//        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //得到对象
//        AccountService as = (AccountServiceImpl)ac.getBean("accountService");
        Account account = asn.findAccountById(1);
        System.out.println(account);

    }
    @Test
    public void  testSave(){
        //获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        //得到对象
        AccountService as = (AccountServiceImpl)ac.getBean("accountService");
        Account account = new Account();
        account.setMoney(123f);
        account.setName("哈哈");
        as.saveAccount(account);
    }
    @Test
    public void  testUpdate(){
        //获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        //得到对象
        AccountService as = (AccountServiceImpl)ac.getBean("accountService");
    }

    @Test
    public void  testDelete(){
        //获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        //得到对象
        AccountService as = (AccountServiceImpl)ac.getBean("accountService");
    }
}
