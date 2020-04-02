package dao;

import DTOs.AccountDetails;
import DataLayer.DBConnector;
import implementations.AccountImpl;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexander W. Hørsted-Andersen <awha86@gmail.com>
 */
public class AccountDAO implements dao.IDAO {

    private Statement stmt;
    private ResultSet rs;
    private DBConnector dbconnector;

    public AccountDAO(DBConnector dbconnector) {
        this.dbconnector = dbconnector;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
