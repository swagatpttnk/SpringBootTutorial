package com.boot.poc.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Configuration
@ConfigurationProperties( prefix = "demo.dbproperties")
public class DBProperties {

    public String host;
    public String port;
    public String serviceName;
    public DBCredentials credentials;

    public List<String> admins;
    public Map<String,String> nlsParams;
}
