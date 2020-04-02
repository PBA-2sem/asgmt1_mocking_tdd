package dao;

import DataLayer.DBConnector;
import dk.cphbusiness.banking.interfaces.Account;
import dk.cphbusiness.banking.interfaces.Bank;
import implementations.AccountImpl;
import implementations.BankImpl;
import implementations.CustomerImpl;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 *
 * @author Alexander W. Hørsted-Andersen <awha86@gmail.com>
 */
public class AccountDAO implements IDAO {

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

//    @Override
//    public List readAll() {
//
//        List<AccountDetails> accountList = new ArrayList<>();
//        String sql = "SELECT * FROM bankingTest.accountTest";
//
//        try {
//            stmt = dbconnector.getConnection().createStatement();
//            rs = stmt.executeQuery(sql);
//            while (rs.next()) {
//                String number = rs.getString("number");
//                int balance = rs.getInt("balance");
//                int cpr = rs.getInt("cpr");
//                accountList.add(new AccountDetails(null, cpr + "", number, balance, null, null, null));  //TODO this cant be how to do it..
//            }
//        } catch (SQLException ex) {
//            System.out.println("error: " + ex.getMessage());
//        }
//
//        for (AccountDetails accountDetails : accountList) {
//            System.out.println(accountDetails.getNumber()); //
//        }
//
//        return accountList;
//    }
    @Override
    public Object read(Serializable key) {
        Account acc = null;

        try {
            PreparedStatement stmt;
            ResultSet rs;

            String sql = "SELECT number, balance, c.cpr as customerCpr, c.name as customerName, b.name as bankName, b.cvr as bankCvr \n"
                    + "FROM account a \n"
                    + "LEFT JOIN customer as c ON c.cpr = a.cpr \n"
                    + "RIGHT JOIN bank as b ON c.cvr = b.cvr \n"
                    + "WHERE number = ?";
            stmt = DBConnector.getConnection().prepareStatement(sql);
            stmt.setString(1, key.toString());

            rs = stmt.executeQuery();
            while (rs.next()) {
                String number = rs.getString("number");
                long balance = (long) rs.getInt("balance");
                String cvr = rs.getString("bankCvr");
                String bankName = rs.getString("bankName");
                String customerName = rs.getString("customerName");
                String cpr = "" + rs.getInt("customerCpr");

                Bank b = new BankImpl(cvr, bankName);
                acc = new AccountImpl(b, new CustomerImpl(cpr, customerName, b), number, balance);
            }

        } catch (SQLException ex) {
            System.out.println("error: " + ex.getMessage());
        }

        return acc;
    }

    public void updateBalanceForAccount(Serializable id, long balance) {
        try {
            PreparedStatement stmt;

            String sql = "UPDATE account\n"
                    + "SET balance = ?\n"
                    + "WHERE number = ?;";

            stmt = DBConnector.getConnection().prepareStatement(sql);
            stmt.setInt(1, (int) balance);
            stmt.setString(2, id.toString());

            stmt.executeUpdate();
            stmt.close();
            DBConnector.getConnection().commit();

        } catch (SQLException ex) {
            System.out.println("error: " + ex.getMessage());
        }

    }
}
