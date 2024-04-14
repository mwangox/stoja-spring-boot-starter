package io.github.mwangox;

import com.mwangox.stoja.StooClient;
import com.mwangox.stoja.config.StooConfig;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@ConditionalOnClass(StooClient.class)
@EnableConfigurationProperties(StojaProperties.class)
public class StojaAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public StooConfig stooConfig(StojaProperties stojaProperties){
        return StooConfig.newStooConfig(stojaProperties.getEndpoint())
                .defaultNamespace(stojaProperties.getDefaultNamespace())
                .defaultProfile(stojaProperties.getDefaultProfile())
                .useTls(stojaProperties.isUseTls())
                .tls(StooConfig.TLS.create()
                        .skipTlsVerification(stojaProperties.getTls().isSkipTlsVerification())
                        .serverNameOverride(stojaProperties.getTls().getServerNameOverride())
                        .caCertPath(stojaProperties.getTls().getCaCertPath()));
    }

    @Bean
    @ConditionalOnMissingBean
    public StooClient stooClient(StooConfig stooConfig){
        return StooClient.newStooClient(stooConfig);
    }
}
