package dao;

import DataLayer.DBConnector;
import implementations.AccountImpl;
import implementations.BankImpl;
import implementations.CustomerImpl;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Alexander W. Hørsted-Andersen <awha86@gmail.com>
 */
public class BankDAO implements dao.IDAO {

    private Statement stmt;
    private ResultSet rs;

    @Override
    public Object create(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object read(Serializable key) {

        String sql = "SELECT b.cvr, b.name as bankname, c.name as customername, number, balance, c.cpr\n"
                + "FROM bank as b\n"
                + "INNER JOIN customer as c\n"
                + "      ON c.cvr = b.cvr\n"
                + "INNER JOIN account as a\n"
                + "      ON a.cpr=c.cpr\n"
                + "      WHERE b.cvr = " + key;

        BankImpl bank = null;
        Map<String, CustomerImpl> customers = new HashMap<>();

        try {
            stmt = DBConnector.getConnection().createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                if (bank == null) {
                    String cvr = rs.getString("cvr");
                    String bankname = rs.getString("bankname");
                    bank = new BankImpl(cvr, bankname);
                }

                String number = rs.getString("number");
                long balance = rs.getLong("balance");

                String cpr = rs.getInt("cpr") + ""; //REEEEE
                String customername = rs.getString("customername");

                CustomerImpl customer;

                if (customers.get(cpr) == null) {

                    customer = new CustomerImpl(cpr, customername, bank);
                    bank.addCustomer(customer);
                    customers.put(cpr, customer);
                } else {
                    customer = customers.get(cpr);
                }

                bank.addAccount(
                        new AccountImpl(bank, customer, number, balance
                        ));

            }

            //
        } catch (SQLException ex) {
            System.out.println("error: " + ex.getMessage());
        }

        return bank;

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
