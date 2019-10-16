package service;

import domain.Account;

import java.util.List;

/**
 * 账户的业务类
 */
public interface AccountService {
    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 查询一个
     * @return
     */
    Account findAccountById(Integer id);

    /**
     * 保存
     */
    void saveAccount(Account account);

    /**
     * 更新
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除
     * @param accountId
     */
    void deleteAccount(Integer accountId);
    /**
     * 转账
     * @param sourceName  转出账户名称
     * @param targetName  转入账户名称
     * @param money       转战金额
     */
    public void transfer(String sourceName,String targetName,Float money);
}
