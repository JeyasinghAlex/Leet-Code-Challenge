package InterviewQuestions.InventoryClearanceSale;

/**
 * PayPal
 */
public class Product {

        private String productId;
        private int salesVelocity;
        private int stockLevel;

        // Constructor
        public Product(String productId, int salesVelocity, int stockLevel) {
            this.productId = productId;
            this.salesVelocity = salesVelocity;
            this.stockLevel = stockLevel;
        }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setSalesVelocity(int salesVelocity) {
        this.salesVelocity = salesVelocity;
    }

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }

    // Getters
        public String getProductId() {
            return productId;
        }

        public int getSalesVelocity() {
            return salesVelocity;
        }

        public int getStockLevel() {
            return stockLevel;
        }
}
