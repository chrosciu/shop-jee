package pl.training.orders;

import java.util.List;
import javax.ejb.Remote;

@Remote
public interface OrderRepository {
    Order save(Order order);
    Order findById(Long id);
    List<Order> findAll();
}