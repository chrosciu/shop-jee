package pl.training.orders;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Singleton;

@Singleton
public class HashMapOrderRepository implements OrderRepository {
    private Map<Long, Order> orders = new HashMap<>();
    private long index = 0;

    @Override
    public Order save(Order order) {
        order.setId(++index);
        orders.put(index, order);
        return order;
    }

    @Override
    public Order findById(Long id) {
        return orders.get(id);
    }

    @Override
    public List<Order> findAll() {
        return List.copyOf(orders.values());
    }
}
