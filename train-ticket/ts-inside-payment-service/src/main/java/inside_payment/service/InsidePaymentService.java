package inside_payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsidePaymentService {

    @Autowired
    private FeatureFlagService featureFlagService;

    public boolean drawback(String userId, String money, String orderId) {
        
        System.out.println("[TrainTicket][InsidePayment] Processing drawback for order: " + orderId);
        System.out.println("[TrainTicket][InsidePayment] User: " + userId + ", Amount: " + money);
        
        if (featureFlagService.isEnabled("fault-1-async-message-order")) {
            System.out.println("[TrainTicket][InsidePayment][F1 MONITORING] F1 fault is active during payment drawback");
            System.out.println("[TrainTicket][InsidePayment][F1 MONITORING] This operation may be delayed by cancel service");
        }
        
        try {
            Thread.sleep(500);
            
            System.out.println("[TrainTicket][InsidePayment] Drawback completed successfully");
            System.out.println("[TrainTicket][InsidePayment] Refund processed for order: " + orderId);
            
            return true;
            
        } catch (Exception e) {
            System.err.println("[TrainTicket][InsidePayment] Drawback failed: " + e.getMessage());
            return false;
        }
    }
}
