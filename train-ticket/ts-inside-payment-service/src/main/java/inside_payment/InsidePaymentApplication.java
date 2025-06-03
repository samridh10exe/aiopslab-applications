package inside_payment;

import dev.openfeature.sdk.OpenFeatureAPI;
import dev.openfeature.contrib.providers.flagd.FlagdProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class InsidePaymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(InsidePaymentApplication.class, args);
    }

    @PostConstruct
    public void initializeFeatureFlags() {
        try {
            String flagdHost = System.getenv().getOrDefault("FLAGD_HOST", "flagd");
            int flagdPort = Integer.parseInt(System.getenv().getOrDefault("FLAGD_PORT", "8013"));
            
            FlagdProvider provider = new FlagdProvider();
            OpenFeatureAPI.getInstance().setProvider(provider);
            
            System.out.println("[TrainTicket][InsidePayment][Feature Flags] Connected to flagd at " + flagdHost + ":" + flagdPort);
            
        } catch (Exception e) {
            System.err.println("[TrainTicket][InsidePayment][Feature Flags] Failed to initialize: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
