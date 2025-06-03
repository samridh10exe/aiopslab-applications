package cancel;

import dev.openfeature.sdk.OpenFeatureAPI;
import dev.openfeature.contrib.providers.flagd.FlagdProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableAsync
public class CancelApplication {

    public static void main(String[] args) {
        SpringApplication.run(CancelApplication.class, args);
    }

    @PostConstruct
    public void initializeFeatureFlags() {
        try {
            String flagdHost = System.getenv().getOrDefault("FLAGD_HOST", "flagd");
            int flagdPort = Integer.parseInt(System.getenv().getOrDefault("FLAGD_PORT", "8013"));
            
            FlagdProvider provider = new FlagdProvider(flagdHost, flagdPort);
            OpenFeatureAPI.getInstance().setProvider(provider);
            
            System.out.println("[TrainTicket][Cancel][Feature Flags] Connected to flagd at " + flagdHost + ":" + flagdPort);
            
        } catch (Exception e) {
            System.err.println("[TrainTicket][Cancel][Feature Flags] Failed to initialize: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
