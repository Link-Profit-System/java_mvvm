/*
 * This file is generated by jOOQ.
 */
package com.example.generated.tables;


import com.example.generated.JPublic;
import com.example.generated.Keys;
import com.example.generated.tables.JGroups.GroupsPath;
import com.example.generated.tables.JRoles.RolesPath;
import com.example.generated.tables.records.GroupsRolesRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function7;
import org.jooq.Identity;
import org.jooq.InverseForeignKey;
import org.jooq.Name;
import org.jooq.Path;
import org.jooq.PlainSQL;
import org.jooq.QueryPart;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row7;
import org.jooq.SQL;
import org.jooq.Schema;
import org.jooq.Select;
import org.jooq.SelectField;
import org.jooq.Stringly;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JGroupsRoles extends TableImpl<GroupsRolesRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.groups_roles</code>
     */
    public static final JGroupsRoles GROUPS_ROLES = new JGroupsRoles();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<GroupsRolesRecord> getRecordType() {
        return GroupsRolesRecord.class;
    }

    /**
     * The column <code>public.groups_roles.id</code>.
     */
    public final TableField<GroupsRolesRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.groups_roles.group_id</code>.
     */
    public final TableField<GroupsRolesRecord, Integer> GROUP_ID = createField(DSL.name("group_id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.groups_roles.role_id</code>.
     */
    public final TableField<GroupsRolesRecord, Integer> ROLE_ID = createField(DSL.name("role_id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.groups_roles.created_at</code>.
     */
    public final TableField<GroupsRolesRecord, LocalDateTime> CREATED_AT = createField(DSL.name("created_at"), SQLDataType.LOCALDATETIME(6).defaultValue(DSL.field(DSL.raw("CURRENT_TIMESTAMP"), SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.groups_roles.created_by</code>.
     */
    public final TableField<GroupsRolesRecord, Integer> CREATED_BY = createField(DSL.name("created_by"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.groups_roles.updated_at</code>.
     */
    public final TableField<GroupsRolesRecord, LocalDateTime> UPDATED_AT = createField(DSL.name("updated_at"), SQLDataType.LOCALDATETIME(6).defaultValue(DSL.field(DSL.raw("CURRENT_TIMESTAMP"), SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.groups_roles.updated_by</code>.
     */
    public final TableField<GroupsRolesRecord, Integer> UPDATED_BY = createField(DSL.name("updated_by"), SQLDataType.INTEGER, this, "");

    private JGroupsRoles(Name alias, Table<GroupsRolesRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private JGroupsRoles(Name alias, Table<GroupsRolesRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>public.groups_roles</code> table reference
     */
    public JGroupsRoles(String alias) {
        this(DSL.name(alias), GROUPS_ROLES);
    }

    /**
     * Create an aliased <code>public.groups_roles</code> table reference
     */
    public JGroupsRoles(Name alias) {
        this(alias, GROUPS_ROLES);
    }

    /**
     * Create a <code>public.groups_roles</code> table reference
     */
    public JGroupsRoles() {
        this(DSL.name("groups_roles"), null);
    }

    public <O extends Record> JGroupsRoles(Table<O> path, ForeignKey<O, GroupsRolesRecord> childPath, InverseForeignKey<O, GroupsRolesRecord> parentPath) {
        super(path, childPath, parentPath, GROUPS_ROLES);
    }

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    public static class GroupsRolesPath extends JGroupsRoles implements Path<GroupsRolesRecord> {
        public <O extends Record> GroupsRolesPath(Table<O> path, ForeignKey<O, GroupsRolesRecord> childPath, InverseForeignKey<O, GroupsRolesRecord> parentPath) {
            super(path, childPath, parentPath);
        }
        private GroupsRolesPath(Name alias, Table<GroupsRolesRecord> aliased) {
            super(alias, aliased);
        }

        @Override
        public GroupsRolesPath as(String alias) {
            return new GroupsRolesPath(DSL.name(alias), this);
        }

        @Override
        public GroupsRolesPath as(Name alias) {
            return new GroupsRolesPath(alias, this);
        }

        @Override
        public GroupsRolesPath as(Table<?> alias) {
            return new GroupsRolesPath(alias.getQualifiedName(), this);
        }
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : JPublic.PUBLIC;
    }

    @Override
    public Identity<GroupsRolesRecord, Integer> getIdentity() {
        return (Identity<GroupsRolesRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<GroupsRolesRecord> getPrimaryKey() {
        return Keys.GROUPS_ROLES_PKEY;
    }

    @Override
    public List<UniqueKey<GroupsRolesRecord>> getUniqueKeys() {
        return Arrays.asList(Keys.UNIQUE_GROUP_ROLE);
    }

    @Override
    public List<ForeignKey<GroupsRolesRecord, ?>> getReferences() {
        return Arrays.asList(Keys.GROUPS_ROLES__FK_GROUP, Keys.GROUPS_ROLES__FK_ROLE);
    }

    private transient GroupsPath _groups;

    /**
     * Get the implicit join path to the <code>public.groups</code> table.
     */
    public GroupsPath groups() {
        if (_groups == null)
            _groups = new GroupsPath(this, Keys.GROUPS_ROLES__FK_GROUP, null);

        return _groups;
    }

    private transient RolesPath _roles;

    /**
     * Get the implicit join path to the <code>public.roles</code> table.
     */
    public RolesPath roles() {
        if (_roles == null)
            _roles = new RolesPath(this, Keys.GROUPS_ROLES__FK_ROLE, null);

        return _roles;
    }

    @Override
    public JGroupsRoles as(String alias) {
        return new JGroupsRoles(DSL.name(alias), this);
    }

    @Override
    public JGroupsRoles as(Name alias) {
        return new JGroupsRoles(alias, this);
    }

    @Override
    public JGroupsRoles as(Table<?> alias) {
        return new JGroupsRoles(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public JGroupsRoles rename(String name) {
        return new JGroupsRoles(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public JGroupsRoles rename(Name name) {
        return new JGroupsRoles(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public JGroupsRoles rename(Table<?> name) {
        return new JGroupsRoles(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public JGroupsRoles where(Condition condition) {
        return new JGroupsRoles(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public JGroupsRoles where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public JGroupsRoles where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public JGroupsRoles where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public JGroupsRoles where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public JGroupsRoles where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public JGroupsRoles where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public JGroupsRoles where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public JGroupsRoles whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public JGroupsRoles whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }

    // -------------------------------------------------------------------------
    // Row7 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row7<Integer, Integer, Integer, LocalDateTime, Integer, LocalDateTime, Integer> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function7<? super Integer, ? super Integer, ? super Integer, ? super LocalDateTime, ? super Integer, ? super LocalDateTime, ? super Integer, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function7<? super Integer, ? super Integer, ? super Integer, ? super LocalDateTime, ? super Integer, ? super LocalDateTime, ? super Integer, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
