package com.amazon.ata.inmemorycaching.classroom.dao;

import com.amazon.ata.inmemorycaching.classroom.dao.models.Group;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import javax.inject.Inject;
import java.util.concurrent.TimeUnit;

// TODO 1 Solution
//          Create the GroupCachingDao Class
public class GroupCachingDao {
    private LoadingCache<String, Group> theCache;

    @Inject
    public GroupCachingDao(final GroupDao delegateDao) {
        this.theCache = CacheBuilder.newBuilder()
                .maximumSize(20000)
                .expireAfterWrite(3, TimeUnit.HOURS)
                .build(CacheLoader.from(delegateDao::getGroup));
    }

    public Group getGroup(final String groupId) {
        // TODO 4 Solution
        //      Add a breakpoint to the next line.
        return theCache.getUnchecked(groupId);
    }

}
