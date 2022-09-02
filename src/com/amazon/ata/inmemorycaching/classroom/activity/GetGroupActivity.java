package com.amazon.ata.inmemorycaching.classroom.activity;

import com.amazon.ata.inmemorycaching.classroom.dao.GroupCachingDao;
import com.amazon.ata.inmemorycaching.classroom.dao.GroupDao;
import com.amazon.ata.inmemorycaching.classroom.dao.models.Group;

import javax.inject.Inject;

// TODO 3 Solution
//          Modify the instance variable to a GroupCachingDao type.
//          Modify the parameter to the constructor to a GroupCachingDao type.

/**
 * Handles requests to get a group.
 */
public class GetGroupActivity {

    private final GroupCachingDao groupDao;

    /**
     * Constructs an Activity with the given DAO.
     * @param groupDao The GroupDao to get the group
     */
    @Inject
    public GetGroupActivity(final GroupCachingDao groupDao) {
        this.groupDao = groupDao;
    }

    /**
     * Returns the group with the provided groupId. Throws a GroupNotFoundException if no group is
     * found by the provided groupId.
     * @param groupId the id of the group to retrieve
     * @return the group with the provided groupId.
     */
    public Group handleRequest(final String groupId) {
        return groupDao.getGroup(groupId);
    }
}
