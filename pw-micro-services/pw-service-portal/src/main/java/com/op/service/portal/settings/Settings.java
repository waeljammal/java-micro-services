package com.op.service.portal.settings;


import com.op.service.core.settings.SettingsBase;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public class Settings extends SettingsBase {
    private ProxySettings proxy;

    public ProxySettings getProxy() {
        return proxy;
    }

    public void setProxy(ProxySettings proxy) {
        this.proxy = proxy;
    }
}
