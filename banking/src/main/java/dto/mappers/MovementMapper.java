package dto.mappers;

import DTOs.MovementDetails;
import dk.cphbusiness.banking.interfaces.Movement;

/**
 *
 * @author jeff
 */
public class MovementMapper implements Mapper<Movement, MovementDetails> {

    @Override
    public MovementDetails fromInternal(Movement object) {
        return new MovementDetails(object.getTime().toString(), object.getAmount(), null);
    }

    @Override
    public Movement toInternal(MovementDetails object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
