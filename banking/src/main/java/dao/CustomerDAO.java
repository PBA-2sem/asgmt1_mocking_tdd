package dao;

import DTOs.CustomerDetails;
import DataLayer.DBConnector;
import implementations.AccountImpl;
import implementations.BankImpl;
import implementations.CustomerImpl;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexander W. Hørsted-Andersen <awha86@gmail.com>
 */
public class CustomerDAO implements dao.IDAO {

    private Statement stmt;
    private ResultSet rs;
    
    
    public List<AccountImpl> getAccountsDB(String id){
        String sql = "Select * from account where cpr = " + id;
        
        List<AccountImpl> accounts = new ArrayList<>();
        
        BankImpl bank = new BankImpl("", "");
        CustomerImpl customer = new CustomerImpl("", "", bank);
        AccountImpl acc = new AccountImpl(bank, customer, "");
        String number = "";
        
        
        try {
             stmt = DBConnector.getConnection().createStatement();
            rs = stmt.executeQuery(sql);
             while (rs.next()) {
                number = rs.getString("number");
                acc = new AccountImpl(bank, customer, number);
                accounts.add(acc);
            }
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! " +accounts.size());
                
             
        } catch (Exception e) {
        }
        return accounts;
    
    }

    public CustomerImpl getCustomerDB(String id) {

        String sql = "SELECT * from customer WHERE cpr =" + id;

        CustomerImpl customer = null;
        String name = "";
        String cpr = "";
        BankImpl bank = new BankImpl("", "");

        try {
            stmt = DBConnector.getConnection().createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {

                cpr = rs.getInt("cpr") + "";
                name = rs.getNString("name");
                customer = new CustomerImpl(cpr, name, bank);
            }

        } catch (Exception e) {
        }
        return customer;

    }

    @Override
    public Object read(Serializable key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public Object create(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
