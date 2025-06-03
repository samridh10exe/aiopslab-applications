package order.service;

import dev.openfeature.sdk.Client;
import dev.openfeature.sdk.OpenFeatureAPI;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class FeatureFlagService {
    
    private Client client;
    
    @PostConstruct
    public void initialize() {
        try {
            this.client = OpenFeatureAPI.getInstance().getClient();
            System.out.println("[TrainTicket][Order][FeatureFlagService] Initialized successfully");
        } catch (Exception e) {
            System.err.println("[TrainTicket][Order][FeatureFlagService] Failed to initialize: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public boolean isEnabled(String flagName) {
        try {
            if (client == null) {
                return false;
            }
            
            boolean isEnabled = client.getBooleanValue(flagName, false);
            System.out.println("[TrainTicket][Order][FeatureFlagService] Flag '" + flagName + "' status: " + isEnabled);
            return isEnabled;
            
        } catch (Exception e) {
            System.err.println("[TrainTicket][Order][FeatureFlagService] Error checking flag '" + flagName + "': " + e.getMessage());
            return false;
        }
    }
}
