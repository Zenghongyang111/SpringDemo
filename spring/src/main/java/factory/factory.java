package factory;

import service.accountServer;
import service.impl.accountServerImpl;

/**
 * 模拟一个工厂类，（该类可能是存在于jar包中的，我们无法通过修改源码的方式来提供默认的构造函数
 */
public class factory {
    public accountServer getAccountService() {
//       return new accountServerImpl();
        return null;
    }
}
