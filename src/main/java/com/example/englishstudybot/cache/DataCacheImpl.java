package com.example.englishstudybot.cache;

import com.example.englishstudybot.entity.CacheInfo;
import com.example.englishstudybot.entity.State;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DataCacheImpl implements DataCache {
    private final Map<Long, State> stateMap = new HashMap<>();
    private final Map<Long, CacheInfo> cacheInfoMap = new HashMap<>();

    @Override
    public void setCurrentState(long userId, State state) {
        stateMap.put(userId, state);
    }

    @Override
    public State getCurrentState(long userId) {
        return stateMap.get(userId);
    }

    @Override
    public void setCacheInfo(long userId, CacheInfo cacheInfo) {
        cacheInfoMap.put(userId, cacheInfo);
    }

    @Override
    public CacheInfo getCacheInfo(long userId) {
        return cacheInfoMap.get(userId);
    }

    @Override
    public void clearCacheInfo(long userId) {
        cacheInfoMap.remove(userId);
    }
}
