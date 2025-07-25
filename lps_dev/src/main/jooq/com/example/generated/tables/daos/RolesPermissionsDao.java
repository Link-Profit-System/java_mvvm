/*
 * This file is generated by jOOQ.
 */
package com.example.generated.tables.daos;


import com.example.generated.tables.JRolesPermissions;
import com.example.generated.tables.pojos.RolesPermissionsVo;
import com.example.generated.tables.records.RolesPermissionsRecord;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RolesPermissionsDao extends DAOImpl<RolesPermissionsRecord, RolesPermissionsVo, Integer> {

    /**
     * Create a new RolesPermissionsDao without any configuration
     */
    public RolesPermissionsDao() {
        super(JRolesPermissions.ROLES_PERMISSIONS, RolesPermissionsVo.class);
    }

    /**
     * Create a new RolesPermissionsDao with an attached configuration
     */
    public RolesPermissionsDao(Configuration configuration) {
        super(JRolesPermissions.ROLES_PERMISSIONS, RolesPermissionsVo.class, configuration);
    }

    @Override
    public Integer getId(RolesPermissionsVo object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<RolesPermissionsVo> fetchRangeOfJId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(JRolesPermissions.ROLES_PERMISSIONS.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<RolesPermissionsVo> fetchByJId(Integer... values) {
        return fetch(JRolesPermissions.ROLES_PERMISSIONS.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public RolesPermissionsVo fetchOneByJId(Integer value) {
        return fetchOne(JRolesPermissions.ROLES_PERMISSIONS.ID, value);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public Optional<RolesPermissionsVo> fetchOptionalByJId(Integer value) {
        return fetchOptional(JRolesPermissions.ROLES_PERMISSIONS.ID, value);
    }

    /**
     * Fetch records that have <code>role_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<RolesPermissionsVo> fetchRangeOfJRoleId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(JRolesPermissions.ROLES_PERMISSIONS.ROLE_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>role_id IN (values)</code>
     */
    public List<RolesPermissionsVo> fetchByJRoleId(Integer... values) {
        return fetch(JRolesPermissions.ROLES_PERMISSIONS.ROLE_ID, values);
    }

    /**
     * Fetch records that have <code>permission_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<RolesPermissionsVo> fetchRangeOfJPermissionId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(JRolesPermissions.ROLES_PERMISSIONS.PERMISSION_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>permission_id IN (values)</code>
     */
    public List<RolesPermissionsVo> fetchByJPermissionId(Integer... values) {
        return fetch(JRolesPermissions.ROLES_PERMISSIONS.PERMISSION_ID, values);
    }

    /**
     * Fetch records that have <code>created_at BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<RolesPermissionsVo> fetchRangeOfJCreatedAt(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(JRolesPermissions.ROLES_PERMISSIONS.CREATED_AT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>created_at IN (values)</code>
     */
    public List<RolesPermissionsVo> fetchByJCreatedAt(LocalDateTime... values) {
        return fetch(JRolesPermissions.ROLES_PERMISSIONS.CREATED_AT, values);
    }

    /**
     * Fetch records that have <code>created_by BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<RolesPermissionsVo> fetchRangeOfJCreatedBy(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(JRolesPermissions.ROLES_PERMISSIONS.CREATED_BY, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>created_by IN (values)</code>
     */
    public List<RolesPermissionsVo> fetchByJCreatedBy(Integer... values) {
        return fetch(JRolesPermissions.ROLES_PERMISSIONS.CREATED_BY, values);
    }

    /**
     * Fetch records that have <code>updated_at BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<RolesPermissionsVo> fetchRangeOfJUpdatedAt(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(JRolesPermissions.ROLES_PERMISSIONS.UPDATED_AT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>updated_at IN (values)</code>
     */
    public List<RolesPermissionsVo> fetchByJUpdatedAt(LocalDateTime... values) {
        return fetch(JRolesPermissions.ROLES_PERMISSIONS.UPDATED_AT, values);
    }

    /**
     * Fetch records that have <code>updated_by BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<RolesPermissionsVo> fetchRangeOfJUpdatedBy(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(JRolesPermissions.ROLES_PERMISSIONS.UPDATED_BY, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>updated_by IN (values)</code>
     */
    public List<RolesPermissionsVo> fetchByJUpdatedBy(Integer... values) {
        return fetch(JRolesPermissions.ROLES_PERMISSIONS.UPDATED_BY, values);
    }
}
