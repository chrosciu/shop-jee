package pl.training.orders;

import java.util.Optional;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.mapstruct.factory.Mappers;
import pl.training.products.ProductRepository;

@Path("orders")
public class OrderRestService {
    @EJB
    private OrderRepository orderRepository;
    @EJB
    private ProductRepository productRepository;
    private OrderMapper orderMapper;

    @PostConstruct
    public void postConstruct() {
        orderMapper = Mappers.getMapper(OrderMapper.class);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public OrderOutputDto addOrder(OrderInputDto orderDto) {
        Order orderToAdd = orderMapper.fromInputDto(orderDto, productRepository);
        Order order = orderRepository.save(orderToAdd);
        return orderMapper.toOutputDto(order);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public OrderOutputDto getOrder(@QueryParam("id") Long id) {
        return Optional.ofNullable(orderRepository.findById(id))
            .map(orderMapper::toOutputDto)
            .orElseThrow(() -> new OrderNotFoundException(id));
    }
}
