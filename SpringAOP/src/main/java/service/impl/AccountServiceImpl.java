package service.impl;

import dao.AccountDao;
import domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.AccountService;
import utils.TransactionManager;

import java.util.List;

/**
 * 账户的业务层实现类
 *
 * 事务控制应该在业务层
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    private TransactionManager tx;

    public void setTx(TransactionManager tx) {
        this.tx = tx;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }


    @Override
    public List<Account> findAllAccount() {
        try{
            //1.开启事务
            tx.beginTransaction();
            //2.执行操作
            List<Account> accounts = accountDao.findAllAccount();
            //3.提交事务
            tx.commit();
            //4.返回结果
            return accounts;
        }catch (Exception e){
            //5.回滚操作
            tx.rollback();
            throw  new RuntimeException();
        }finally {
            //6。释放连接
            tx.release();
        }
    }

    @Override
    public Account findAccountById(Integer id) {
        try{
            //1.开启事务
            tx.beginTransaction();
            //2.执行操作
            Account account = accountDao.findAccountById(id);
            //3.提交事务
            tx.commit();
            //4.返回结果
            return account;
        }catch (Exception e){
            //5.回滚操作
            tx.rollback();
            throw  new RuntimeException();
        }finally {
            //6。释放连接
            tx.release();
        }

    }

    @Override
    public void saveAccount(Account account) {
        try{
            //1.开启事务
            tx.beginTransaction();
            //2.执行操作
           accountDao.saveAccount(account);
            //3.提交事务
            tx.commit();
        }catch (Exception e){
            //5.回滚操作
            tx.rollback();
        }finally {
            //6。释放连接
            tx.release();
        }
    }

    @Override
    public void updateAccount(Account account) {
        try{
            //1.开启事务
            tx.beginTransaction();
            //2.执行操作
            accountDao.updateAccount(account);
            //3.提交事务
            tx.commit();

        }catch (Exception e){
            //5.回滚操作
            tx.rollback();
        }finally {
            //6。释放连接
            tx.release();
        }
    }

    @Override
    public void deleteAccount(Integer accountId) {
        try{
            //1.开启事务
            tx.beginTransaction();
            //2.执行操作
            accountDao.deleteAccount(accountId);
            //3.提交事务
            tx.commit();

        }catch (Exception e){
            //5.回滚操作
            tx.rollback();
        }finally {
            //6。释放连接
            tx.release();
        }
    }

    /**
     * 转账
     * @param sourceName  转出账户名称
     * @param targetName  转入账户名称
     * @param money       转战金额
     */
    public void transfer(String sourceName,String targetName,Float money){
        try{
            //1.开启事务
            tx.beginTransaction();
            //2.执行操作
             //2.1.根据名称查询转出账户
                Account source = accountDao.findAccountByName(sourceName);
                //2.2.根据名称查询转入账户
                Account target = accountDao.findAccountByName(targetName);
                //2.3.转出账户扣款，转入账户加钱
                source.setMoney(source.getMoney()-money);
                target.setMoney(target.getMoney()+money);
                //2.4.更新两个账户的信息
                accountDao.updateAccount(source);
//                int i=1/0;
                accountDao.updateAccount(target);
            //3.提交事务
            tx.commit();

        }catch (Exception e){
            //5.回滚操作
            tx.rollback();
            e.printStackTrace();
        }finally {
            //6。释放连接
            tx.release();
        }

    }
}

