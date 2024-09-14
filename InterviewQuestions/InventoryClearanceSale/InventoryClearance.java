package InterviewQuestions.InventoryClearanceSale;

import java.util.ArrayList;
import java.util.List;

/**
 * PayPal
 */
public class InventoryClearance {

    public List<String> identifyClearanceItems(List<Product> products) {
        List<String> eligibleProducts = new ArrayList<>();

        for (Product product : products) {
            // A product is eligible for clearance if stockLevel >= 10 * salesVelocity
            if (product.getStockLevel() >= 10 * product.getSalesVelocity()) {
                eligibleProducts.add(product.getProductId());
            }
        }
        return eligibleProducts;
    }
}
