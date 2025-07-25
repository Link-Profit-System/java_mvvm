/*
 * This file is generated by jOOQ.
 */
package com.example.generated.tables.daos;


import com.example.generated.tables.JGroupsRoles;
import com.example.generated.tables.pojos.GroupsRolesVo;
import com.example.generated.tables.records.GroupsRolesRecord;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class GroupsRolesDao extends DAOImpl<GroupsRolesRecord, GroupsRolesVo, Integer> {

    /**
     * Create a new GroupsRolesDao without any configuration
     */
    public GroupsRolesDao() {
        super(JGroupsRoles.GROUPS_ROLES, GroupsRolesVo.class);
    }

    /**
     * Create a new GroupsRolesDao with an attached configuration
     */
    public GroupsRolesDao(Configuration configuration) {
        super(JGroupsRoles.GROUPS_ROLES, GroupsRolesVo.class, configuration);
    }

    @Override
    public Integer getId(GroupsRolesVo object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<GroupsRolesVo> fetchRangeOfJId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(JGroupsRoles.GROUPS_ROLES.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<GroupsRolesVo> fetchByJId(Integer... values) {
        return fetch(JGroupsRoles.GROUPS_ROLES.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public GroupsRolesVo fetchOneByJId(Integer value) {
        return fetchOne(JGroupsRoles.GROUPS_ROLES.ID, value);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public Optional<GroupsRolesVo> fetchOptionalByJId(Integer value) {
        return fetchOptional(JGroupsRoles.GROUPS_ROLES.ID, value);
    }

    /**
     * Fetch records that have <code>group_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<GroupsRolesVo> fetchRangeOfJGroupId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(JGroupsRoles.GROUPS_ROLES.GROUP_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>group_id IN (values)</code>
     */
    public List<GroupsRolesVo> fetchByJGroupId(Integer... values) {
        return fetch(JGroupsRoles.GROUPS_ROLES.GROUP_ID, values);
    }

    /**
     * Fetch records that have <code>role_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<GroupsRolesVo> fetchRangeOfJRoleId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(JGroupsRoles.GROUPS_ROLES.ROLE_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>role_id IN (values)</code>
     */
    public List<GroupsRolesVo> fetchByJRoleId(Integer... values) {
        return fetch(JGroupsRoles.GROUPS_ROLES.ROLE_ID, values);
    }

    /**
     * Fetch records that have <code>created_at BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<GroupsRolesVo> fetchRangeOfJCreatedAt(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(JGroupsRoles.GROUPS_ROLES.CREATED_AT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>created_at IN (values)</code>
     */
    public List<GroupsRolesVo> fetchByJCreatedAt(LocalDateTime... values) {
        return fetch(JGroupsRoles.GROUPS_ROLES.CREATED_AT, values);
    }

    /**
     * Fetch records that have <code>created_by BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<GroupsRolesVo> fetchRangeOfJCreatedBy(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(JGroupsRoles.GROUPS_ROLES.CREATED_BY, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>created_by IN (values)</code>
     */
    public List<GroupsRolesVo> fetchByJCreatedBy(Integer... values) {
        return fetch(JGroupsRoles.GROUPS_ROLES.CREATED_BY, values);
    }

    /**
     * Fetch records that have <code>updated_at BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<GroupsRolesVo> fetchRangeOfJUpdatedAt(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(JGroupsRoles.GROUPS_ROLES.UPDATED_AT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>updated_at IN (values)</code>
     */
    public List<GroupsRolesVo> fetchByJUpdatedAt(LocalDateTime... values) {
        return fetch(JGroupsRoles.GROUPS_ROLES.UPDATED_AT, values);
    }

    /**
     * Fetch records that have <code>updated_by BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<GroupsRolesVo> fetchRangeOfJUpdatedBy(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(JGroupsRoles.GROUPS_ROLES.UPDATED_BY, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>updated_by IN (values)</code>
     */
    public List<GroupsRolesVo> fetchByJUpdatedBy(Integer... values) {
        return fetch(JGroupsRoles.GROUPS_ROLES.UPDATED_BY, values);
    }
}
