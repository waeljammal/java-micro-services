package com.op.service.core.util.hibernate;

import com.op.service.core.model.Size;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.type.StringType;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SizeType implements UserType {

    @Override
    public int[] sqlTypes() {
        return new int[]{
            StringType.INSTANCE.getSqlTypeDescriptor().getSqlType()
        };
    }

    @Override
    public Class returnedClass() {
        return Size.class;
    }

    @Override
    public boolean equals(final Object o, final Object o1) {
        return o != null && o.equals(o1);
    }

    @Override
    public int hashCode(final Object value) {
        return value.hashCode();
    }

    @Override
    public Size nullSafeGet(final ResultSet rs, final String[] names, final SessionImplementor session, final Object owner) throws SQLException {
        String value = (String) StringType.INSTANCE.get(rs, names[0], session);
        if (value != null) {
            return Size.parse(value);
        }

        return Size.megabytes(0);
    }

    @Override
    public void nullSafeSet(final PreparedStatement ps, final Object value, final int index, final SessionImplementor session) throws SQLException {
        if (value == null) {
            StringType.INSTANCE.set(ps, Size.megabytes(0).toString(), index, session);
        } else {
            StringType.INSTANCE.set(ps, value.toString(), index, session);
        }
    }

    private Size nullSafeToSize(final Object value) {
        if (value != null) {
            return Size.parse(value.toString());
        }

        return null;
    }

    @Override
    public Size deepCopy(final Object value) {
        return nullSafeToSize(value);
    }

    @Override
    public boolean isMutable() {
        return true;
    }

    @Override
    public String disassemble(final Object value) {
        return value.toString();
    }

    @Override
    public Size assemble(final Serializable srlzbl, final Object owner) {
        if (srlzbl instanceof String) {
            return Size.parse((String) srlzbl);
        }

        return null;
    }

    @Override
    public Size replace(final Object original, final Object target, final Object owner) {
        return nullSafeToSize(original);
    }
}