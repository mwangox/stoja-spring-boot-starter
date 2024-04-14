package io.github.mwangox;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
@Data
@ConfigurationProperties(prefix = "stoja.config")
public class StojaProperties {
    private String defaultNamespace;
    private String defaultProfile;
    private boolean useTls = false;
    private String endpoint = "localhost:50051";
    private long timeoutAfterMs = 20000;
    private TLS tls = new TLS();

    @Data
    public static class TLS{
        private boolean skipTlsVerification = true;
        private String caCertPath;
        private String serverNameOverride;
    }
}
