/*
 * This file is generated by jOOQ.
 */
package com.example.generated.tables.records;


import com.example.generated.tables.JGroups;
import com.example.generated.tables.interfaces.IGroups;
import com.example.generated.tables.pojos.GroupsVo;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class GroupsRecord extends UpdatableRecordImpl<GroupsRecord> implements Record6<Integer, String, LocalDateTime, Integer, LocalDateTime, Integer>, IGroups {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.groups.id</code>.
     */
    @Override
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.groups.id</code>.
     */
    @Override
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.groups.group_name</code>.
     */
    @Override
    public void setGroupName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.groups.group_name</code>.
     */
    @Override
    public String getGroupName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.groups.created_at</code>.
     */
    @Override
    public void setCreatedAt(LocalDateTime value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.groups.created_at</code>.
     */
    @Override
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(2);
    }

    /**
     * Setter for <code>public.groups.created_by</code>.
     */
    @Override
    public void setCreatedBy(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.groups.created_by</code>.
     */
    @Override
    public Integer getCreatedBy() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>public.groups.updated_at</code>.
     */
    @Override
    public void setUpdatedAt(LocalDateTime value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.groups.updated_at</code>.
     */
    @Override
    public LocalDateTime getUpdatedAt() {
        return (LocalDateTime) get(4);
    }

    /**
     * Setter for <code>public.groups.updated_by</code>.
     */
    @Override
    public void setUpdatedBy(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.groups.updated_by</code>.
     */
    @Override
    public Integer getUpdatedBy() {
        return (Integer) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row6<Integer, String, LocalDateTime, Integer, LocalDateTime, Integer> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    @Override
    public Row6<Integer, String, LocalDateTime, Integer, LocalDateTime, Integer> valuesRow() {
        return (Row6) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return JGroups.GROUPS.ID;
    }

    @Override
    public Field<String> field2() {
        return JGroups.GROUPS.GROUP_NAME;
    }

    @Override
    public Field<LocalDateTime> field3() {
        return JGroups.GROUPS.CREATED_AT;
    }

    @Override
    public Field<Integer> field4() {
        return JGroups.GROUPS.CREATED_BY;
    }

    @Override
    public Field<LocalDateTime> field5() {
        return JGroups.GROUPS.UPDATED_AT;
    }

    @Override
    public Field<Integer> field6() {
        return JGroups.GROUPS.UPDATED_BY;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getGroupName();
    }

    @Override
    public LocalDateTime component3() {
        return getCreatedAt();
    }

    @Override
    public Integer component4() {
        return getCreatedBy();
    }

    @Override
    public LocalDateTime component5() {
        return getUpdatedAt();
    }

    @Override
    public Integer component6() {
        return getUpdatedBy();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getGroupName();
    }

    @Override
    public LocalDateTime value3() {
        return getCreatedAt();
    }

    @Override
    public Integer value4() {
        return getCreatedBy();
    }

    @Override
    public LocalDateTime value5() {
        return getUpdatedAt();
    }

    @Override
    public Integer value6() {
        return getUpdatedBy();
    }

    @Override
    public GroupsRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public GroupsRecord value2(String value) {
        setGroupName(value);
        return this;
    }

    @Override
    public GroupsRecord value3(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public GroupsRecord value4(Integer value) {
        setCreatedBy(value);
        return this;
    }

    @Override
    public GroupsRecord value5(LocalDateTime value) {
        setUpdatedAt(value);
        return this;
    }

    @Override
    public GroupsRecord value6(Integer value) {
        setUpdatedBy(value);
        return this;
    }

    @Override
    public GroupsRecord values(Integer value1, String value2, LocalDateTime value3, Integer value4, LocalDateTime value5, Integer value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IGroups from) {
        setId(from.getId());
        setGroupName(from.getGroupName());
        setCreatedAt(from.getCreatedAt());
        setCreatedBy(from.getCreatedBy());
        setUpdatedAt(from.getUpdatedAt());
        setUpdatedBy(from.getUpdatedBy());
        resetChangedOnNotNull();
    }

    @Override
    public <E extends IGroups> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached GroupsRecord
     */
    public GroupsRecord() {
        super(JGroups.GROUPS);
    }

    /**
     * Create a detached, initialised GroupsRecord
     */
    public GroupsRecord(Integer id, String groupName, LocalDateTime createdAt, Integer createdBy, LocalDateTime updatedAt, Integer updatedBy) {
        super(JGroups.GROUPS);

        setId(id);
        setGroupName(groupName);
        setCreatedAt(createdAt);
        setCreatedBy(createdBy);
        setUpdatedAt(updatedAt);
        setUpdatedBy(updatedBy);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised GroupsRecord
     */
    public GroupsRecord(GroupsVo value) {
        super(JGroups.GROUPS);

        if (value != null) {
            setId(value.getId());
            setGroupName(value.getGroupName());
            setCreatedAt(value.getCreatedAt());
            setCreatedBy(value.getCreatedBy());
            setUpdatedAt(value.getUpdatedAt());
            setUpdatedBy(value.getUpdatedBy());
            resetChangedOnNotNull();
        }
    }
}
