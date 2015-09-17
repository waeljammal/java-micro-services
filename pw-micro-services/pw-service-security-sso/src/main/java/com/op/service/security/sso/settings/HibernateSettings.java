package com.op.service.security.sso.settings;

public class HibernateSettings {
    private String dialect;
    private boolean show_sql;
    private HibernateHbm2Dll hbm2ddl;

    public String getDialect() {
        return dialect;
    }

    public void setDialect(String dialect) {
        this.dialect = dialect;
    }

    public boolean isShow_sql() {
        return show_sql;
    }

    public void setShow_sql(boolean show_sql) {
        this.show_sql = show_sql;
    }

    public HibernateHbm2Dll getHbm2ddl() {
        return hbm2ddl;
    }

    public void setHbm2ddl(HibernateHbm2Dll hbm2ddl) {
        this.hbm2ddl = hbm2ddl;
    }
}
