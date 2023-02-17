package com.example.englishstudybot.cache;

import com.example.englishstudybot.entity.CacheInfo;
import com.example.englishstudybot.entity.State;

public interface DataCache {
    void setCurrentState(long userId, State state);
    State getCurrentState(long userId);
    void setCacheInfo(long userId, CacheInfo cacheInfo);
    CacheInfo getCacheInfo(long userId);
    void clearCacheInfo(long userId);
}
