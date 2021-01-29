package com.boot.poc.models;

import com.boot.poc.configuration.DBCredentials;
import com.boot.poc.configuration.DBProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DBProfileResponse {
    public String dbVendor;
    public String host;
    public String port;
    public String serviceName;
    public DBCredentials credentials;

    public List<String> admins;
    public Map<String,String> nlsParams;
}
