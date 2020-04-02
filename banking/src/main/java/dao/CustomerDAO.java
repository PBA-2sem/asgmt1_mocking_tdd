package dao;

import DTOs.CustomerDetails;
import DataLayer.DBConnector;
import dk.cphbusiness.banking.interfaces.Bank;
import implementations.AccountImpl;
import implementations.BankImpl;
import implementations.CustomerImpl;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        List<AccountImpl> accounts = new ArrayList<>();
        try {
            PreparedStatement stmt;
            ResultSet rs;

            String sql = "SELECT number, balance, c.cpr as customerCpr, c.name as customerName, b.name as bankName, b.cvr as bankCvr \n"
                    + "FROM account a \n"
                    + "LEFT JOIN customer as c ON c.cpr = a.cpr \n"
                    + "RIGHT JOIN bank as b ON c.cvr = b.cvr \n"
                    + "WHERE a.cpr = ?";

            stmt = DBConnector.getConnection().prepareStatement(sql);
            stmt.setString(1, id);

            rs = stmt.executeQuery();
            while (rs.next()) {
                String number = rs.getString("number");
                long balance = (long) rs.getInt("balance");
                String cvr = rs.getString("bankCvr");
                String bankName = rs.getString("bankName");
                String customerName = rs.getString("customerName");
                String cpr = "" + rs.getInt("customerCpr");

                Bank b = new BankImpl(cvr, bankName);
                accounts.add(new AccountImpl(b, new CustomerImpl(cpr, customerName, b), number, balance));

            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
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
