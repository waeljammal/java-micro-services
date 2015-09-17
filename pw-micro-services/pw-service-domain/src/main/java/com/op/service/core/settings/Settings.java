package com.op.service.core.settings;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public class Settings {
    private DatabaseSettings database = new DatabaseSettings();
    private HibernateSettings hibernate = new HibernateSettings();

    public DatabaseSettings getDatabase() {
        return database;
    }

    public void setDatabase(DatabaseSettings database) {
        this.database = database;
    }

    public HibernateSettings getHibernate() {
        return hibernate;
    }

    public void setHibernate(HibernateSettings hibernate) {
        this.hibernate = hibernate;
    }
}
