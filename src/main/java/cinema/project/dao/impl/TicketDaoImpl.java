package cinema.project.dao.impl;

import cinema.project.dao.AbstractDao;
import cinema.project.dao.TicketDao;
import cinema.project.model.Ticket;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class TicketDaoImpl extends AbstractDao<Ticket> implements TicketDao {
    public TicketDaoImpl(SessionFactory factory) {
        super(factory, Ticket.class);
    }
}
