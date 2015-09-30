package com.op.service.portal.config;

import com.op.service.core.config.DatabaseConfigBase;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig extends DatabaseConfigBase {

}