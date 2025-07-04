/*
 * This file is generated by jOOQ.
 */
package com.example.generated.tables.records;


import com.example.generated.tables.JRolesPermissions;
import com.example.generated.tables.interfaces.IRolesPermissions;
import com.example.generated.tables.pojos.RolesPermissionsVo;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RolesPermissionsRecord extends UpdatableRecordImpl<RolesPermissionsRecord> implements Record7<Integer, Integer, Integer, LocalDateTime, Integer, LocalDateTime, Integer>, IRolesPermissions {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.roles_permissions.id</code>.
     */
    @Override
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.roles_permissions.id</code>.
     */
    @Override
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.roles_permissions.role_id</code>.
     */
    @Override
    public void setRoleId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.roles_permissions.role_id</code>.
     */
    @Override
    public Integer getRoleId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>public.roles_permissions.permission_id</code>.
     */
    @Override
    public void setPermissionId(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.roles_permissions.permission_id</code>.
     */
    @Override
    public Integer getPermissionId() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>public.roles_permissions.created_at</code>.
     */
    @Override
    public void setCreatedAt(LocalDateTime value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.roles_permissions.created_at</code>.
     */
    @Override
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(3);
    }

    /**
     * Setter for <code>public.roles_permissions.created_by</code>.
     */
    @Override
    public void setCreatedBy(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.roles_permissions.created_by</code>.
     */
    @Override
    public Integer getCreatedBy() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>public.roles_permissions.updated_at</code>.
     */
    @Override
    public void setUpdatedAt(LocalDateTime value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.roles_permissions.updated_at</code>.
     */
    @Override
    public LocalDateTime getUpdatedAt() {
        return (LocalDateTime) get(5);
    }

    /**
     * Setter for <code>public.roles_permissions.updated_by</code>.
     */
    @Override
    public void setUpdatedBy(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.roles_permissions.updated_by</code>.
     */
    @Override
    public Integer getUpdatedBy() {
        return (Integer) get(6);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row7<Integer, Integer, Integer, LocalDateTime, Integer, LocalDateTime, Integer> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    @Override
    public Row7<Integer, Integer, Integer, LocalDateTime, Integer, LocalDateTime, Integer> valuesRow() {
        return (Row7) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return JRolesPermissions.ROLES_PERMISSIONS.ID;
    }

    @Override
    public Field<Integer> field2() {
        return JRolesPermissions.ROLES_PERMISSIONS.ROLE_ID;
    }

    @Override
    public Field<Integer> field3() {
        return JRolesPermissions.ROLES_PERMISSIONS.PERMISSION_ID;
    }

    @Override
    public Field<LocalDateTime> field4() {
        return JRolesPermissions.ROLES_PERMISSIONS.CREATED_AT;
    }

    @Override
    public Field<Integer> field5() {
        return JRolesPermissions.ROLES_PERMISSIONS.CREATED_BY;
    }

    @Override
    public Field<LocalDateTime> field6() {
        return JRolesPermissions.ROLES_PERMISSIONS.UPDATED_AT;
    }

    @Override
    public Field<Integer> field7() {
        return JRolesPermissions.ROLES_PERMISSIONS.UPDATED_BY;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public Integer component2() {
        return getRoleId();
    }

    @Override
    public Integer component3() {
        return getPermissionId();
    }

    @Override
    public LocalDateTime component4() {
        return getCreatedAt();
    }

    @Override
    public Integer component5() {
        return getCreatedBy();
    }

    @Override
    public LocalDateTime component6() {
        return getUpdatedAt();
    }

    @Override
    public Integer component7() {
        return getUpdatedBy();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public Integer value2() {
        return getRoleId();
    }

    @Override
    public Integer value3() {
        return getPermissionId();
    }

    @Override
    public LocalDateTime value4() {
        return getCreatedAt();
    }

    @Override
    public Integer value5() {
        return getCreatedBy();
    }

    @Override
    public LocalDateTime value6() {
        return getUpdatedAt();
    }

    @Override
    public Integer value7() {
        return getUpdatedBy();
    }

    @Override
    public RolesPermissionsRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public RolesPermissionsRecord value2(Integer value) {
        setRoleId(value);
        return this;
    }

    @Override
    public RolesPermissionsRecord value3(Integer value) {
        setPermissionId(value);
        return this;
    }

    @Override
    public RolesPermissionsRecord value4(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public RolesPermissionsRecord value5(Integer value) {
        setCreatedBy(value);
        return this;
    }

    @Override
    public RolesPermissionsRecord value6(LocalDateTime value) {
        setUpdatedAt(value);
        return this;
    }

    @Override
    public RolesPermissionsRecord value7(Integer value) {
        setUpdatedBy(value);
        return this;
    }

    @Override
    public RolesPermissionsRecord values(Integer value1, Integer value2, Integer value3, LocalDateTime value4, Integer value5, LocalDateTime value6, Integer value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IRolesPermissions from) {
        setId(from.getId());
        setRoleId(from.getRoleId());
        setPermissionId(from.getPermissionId());
        setCreatedAt(from.getCreatedAt());
        setCreatedBy(from.getCreatedBy());
        setUpdatedAt(from.getUpdatedAt());
        setUpdatedBy(from.getUpdatedBy());
        resetChangedOnNotNull();
    }

    @Override
    public <E extends IRolesPermissions> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RolesPermissionsRecord
     */
    public RolesPermissionsRecord() {
        super(JRolesPermissions.ROLES_PERMISSIONS);
    }

    /**
     * Create a detached, initialised RolesPermissionsRecord
     */
    public RolesPermissionsRecord(Integer id, Integer roleId, Integer permissionId, LocalDateTime createdAt, Integer createdBy, LocalDateTime updatedAt, Integer updatedBy) {
        super(JRolesPermissions.ROLES_PERMISSIONS);

        setId(id);
        setRoleId(roleId);
        setPermissionId(permissionId);
        setCreatedAt(createdAt);
        setCreatedBy(createdBy);
        setUpdatedAt(updatedAt);
        setUpdatedBy(updatedBy);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised RolesPermissionsRecord
     */
    public RolesPermissionsRecord(RolesPermissionsVo value) {
        super(JRolesPermissions.ROLES_PERMISSIONS);

        if (value != null) {
            setId(value.getId());
            setRoleId(value.getRoleId());
            setPermissionId(value.getPermissionId());
            setCreatedAt(value.getCreatedAt());
            setCreatedBy(value.getCreatedBy());
            setUpdatedAt(value.getUpdatedAt());
            setUpdatedBy(value.getUpdatedBy());
            resetChangedOnNotNull();
        }
    }
}
