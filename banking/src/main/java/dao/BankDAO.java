package dao;

import DataLayer.DBConnector;
import implementations.BankImpl;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

        String sql = "SELECT * FROM bankingTest.bankTest where cvr = " + key;
        BankImpl bank = null;
        try {
            stmt = DBConnector.getConnection().createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                String cvr = rs.getString("cvr");
                String name = rs.getString("name");
                bank = new BankImpl(cvr, name);
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
