package order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private FeatureFlagService featureFlagService;

    public boolean cancelOrder(String orderId, String loginToken) {
        
        System.out.println("[TrainTicket][Order] Processing order cancellation: " + orderId);
        
        if (featureFlagService.isEnabled("fault-1-async-message-order")) {
            System.out.println("[TrainTicket][Order][F1 MONITORING] F1 fault is active during order cancellation");
            System.out.println("[TrainTicket][Order][F1 MONITORING] Monitoring async message sequence");
        }
        
        try {
            updateOrderStatus(orderId, "CANCELLING");
            
            Thread.sleep(1000);
            
            updateOrderStatus(orderId, "CANCELLED");
            
            System.out.println("[TrainTicket][Order] Order cancellation completed: " + orderId);
            return true;
            
        } catch (Exception e) {
            System.err.println("[TrainTicket][Order] Order cancellation failed: " + e.getMessage());
            return false;
        }
    }
    
    public void updateOrderStatus(String orderId, String status) {
        
        long timestamp = System.currentTimeMillis();
        
        if (featureFlagService.isEnabled("fault-1-async-message-order")) {
            System.out.println("[TrainTicket][Order][F1 ANALYSIS] Order status change: " + orderId + " -> " + status + " at " + timestamp);
            System.out.println("[TrainTicket][Order][F1 ANALYSIS] This timing is critical for F1 fault detection");
        }
        
        System.out.println("[TrainTicket][Order] Updated order " + orderId + " status to: " + status);
    }
}
