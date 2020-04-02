package dao;

import DTOs.identifiers.MovementIdentifier;
import DataLayer.DBConnector;
import dk.cphbusiness.banking.interfaces.Movement;
import implementations.MovementImpl;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
//

/**
 *
 * @author Alexander W. Hørsted-Andersen <awha86@gmail.com>
 */
public class MovementDAO implements IDAO {

    @Override
    public Object create(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object read(Serializable key) {
        MovementImpl m = null;
        try {
            PreparedStatement stmt;
            ResultSet rs;

            String sql = "SELECT * \n"
                    + "FROM movement\n"
                    + "WHERE idmovement = ?";

            stmt = DBConnector.getConnection().prepareStatement(sql);
            stmt.setString(1, (String) key);

            rs = stmt.executeQuery();
            while (rs.next()) {
                LocalDateTime timestamp = rs.getTimestamp("timestamp").toLocalDateTime();
                long amount = rs.getLong("amount");
                m = new MovementImpl(amount, timestamp);

            }

        } catch (SQLException ex) {
            System.out.println("error: " + ex.getMessage());
        }

        return m;

    }

    @Override
    public void update(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public MovementImpl addMovement(long amount, String sourceAccId, String destinationAccId, String type) {
        MovementImpl m = null;
        Integer id = null;
        try {
            PreparedStatement stmt;
            ResultSet rs;

            String sql = "INSERT INTO movement (amount, source_account, destination_account, type)\n"
                    + " VALUES (?, ?, ?, ?)";

            stmt = DBConnector.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, (int) amount);
            stmt.setString(2, sourceAccId);
            stmt.setString(3, destinationAccId);
            stmt.setString(4, type);

            int res = stmt.executeUpdate();

            if (res == 1) {
                rs = stmt.getGeneratedKeys();
                rs.next();
                id = rs.getInt(1);
                DBConnector.getConnection().commit();
            }

        } catch (SQLException ex) {
            System.out.println("error: " + ex.getMessage());
        }
        m = (MovementImpl) this.read(id.toString());
        return m;
    }

    public List<Movement> getAllWithdrawalsForAccount(Serializable key) {

        List<Movement> withdrawals = new ArrayList<>();

        try {
            PreparedStatement stmt;
            ResultSet rs;

            String sql = "SELECT * \n"
                    + "FROM movement\n"
                    + "WHERE type = ? AND source_account = ?";

            stmt = DBConnector.getConnection().prepareStatement(sql);
            stmt.setString(1, "withdrawal");
            stmt.setString(2, (String) key);

            rs = stmt.executeQuery();
            while (rs.next()) {
                LocalDateTime timestamp = rs.getTimestamp("timestamp").toLocalDateTime();
                long amount = rs.getLong("amount");
                withdrawals.add(new MovementImpl(amount, timestamp));

            }

        } catch (SQLException ex) {
            System.out.println("error: " + ex.getMessage());
        }

        return withdrawals;

    }

    public List<Movement> getAllDepositsForAccount(Serializable key) {

        List<Movement> deposits = new ArrayList<>();
        try {
            PreparedStatement stmt;
            ResultSet rs;

            String sql = "SELECT * \n"
                    + "FROM movement\n"
                    + "WHERE type = ? AND destination_account = ?";

            stmt = DBConnector.getConnection().prepareStatement(sql);

            stmt.setString(1, "deposit");
            stmt.setString(2, (String) key);
            rs = stmt.executeQuery();
            while (rs.next()) {
                LocalDateTime timestamp = rs.getTimestamp("timestamp").toLocalDateTime();
                long amount = rs.getLong("amount");
                deposits.add(new MovementImpl(amount, timestamp));
            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return deposits;

    }
}
