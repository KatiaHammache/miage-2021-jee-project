package fr.pantheonsorbonne.ufr27.miage.camel;

import fr.pantheonsorbonne.ufr27.miage.service.OrderService;
import org.apache.camel.CamelContext;
import org.apache.camel.Handler;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import java.util.List;

@ApplicationScoped
public class OrderGateway {

    @Inject
    CamelContext context;

    @Inject
    ConnectionFactory connectionFactory;

    @Inject
    OrderService orderService;


    @Handler
    public Integer createOrder(Integer message){
        return  orderService.createOrder(message);
    }

    @Handler
    public Integer addProductOrder(List<Integer> messageBody){
        return orderService.addProductOrder(messageBody.get(1),messageBody.get(0));
    }
    @Handler
    public Float getTotalPrice(Integer message){
        return orderService.getTotalPrice(message);
    }

    @Handler
    public void deleteOrder(Integer orderId){
        orderService.deleteOrder(orderId);
    }

    @Handler
    public Integer deleteProductOrder(List<Integer> messageBody) {
        return orderService.deleteProductOrder(messageBody.get(1),messageBody.get(0));
    }


}
