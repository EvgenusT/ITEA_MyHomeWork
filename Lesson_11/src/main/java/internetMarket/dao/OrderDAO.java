package internetMarket.dao;

import java.util.List;

public interface OrderDAO <Order>{

    List<Order> findByUserId(int userId);

    List<Order> findByUserIdAndStatus(int userId, String status);

    void createOrder(Order model);

    void updateOrder(Order model);
}
