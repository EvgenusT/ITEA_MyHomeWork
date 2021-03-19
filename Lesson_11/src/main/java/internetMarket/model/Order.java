package internetMarket.model;

import java.time.LocalDate;

public class Order {
    private int userId;
    private int productId;
    private int count;
    private String status;
    private LocalDate date;

    public Order(int userId, int productId, int count, String status, LocalDate date) {
        this.userId = userId;
        this.productId = productId;
        this.count = count;
        this.status = status;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "userId=" + userId +
                ", productId=" + productId +
                ", count=" + count +
                ", status='" + status + '\'' +
                ", date=" + date +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public int getProductId() {
        return productId;
    }

    public int getCount() {
        return count;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
