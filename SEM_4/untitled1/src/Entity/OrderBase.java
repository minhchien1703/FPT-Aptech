package Entity;

public class OrderBase {
    private int userId;
    private double total;

    public OrderBase () {}

    public OrderBase (int userId, double total) {
        userId = userId;
        total = total;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
