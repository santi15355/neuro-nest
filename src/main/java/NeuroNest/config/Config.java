package NeuroNest.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@Data
@PropertySource("classpath:application.yml")
public class Config {

    @Value("${token_proxy_api}")
    String tokenProxyApi;

    @Value("${token_ya_api}")
    String tokenYaApi;

    @Value("${ya_folder_id}")
    String yaFolderId;
}
