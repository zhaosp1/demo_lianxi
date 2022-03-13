package com.example.springboot.repository.util.cache;//package com.example.alice.yibao.util;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.script.DefaultRedisScript;
//import org.springframework.data.redis.core.script.RedisScript;
//
//import java.util.*;
//import java.util.concurrent.TimeUnit;
//
///**
// * Redis工具类
// *
// * @author: tongxj
// * @date: 2020/6/16 11:19
// * @version: 1.0
// */
//public class RedisUtils {
//
//    private RedisUtils() {
//
//    }
//
//    private static Logger logger = LoggerFactory.getLogger(RedisUtils.class);
//    private static final Long SUCCESS = 1L;
//    private static RedisTemplate<String, Object> redisTemplate = null;
//
//    static {
//        redisTemplate = (RedisTemplate<String, Object>) ServiceFactory.getBean("redisTemplate");
//    }
//
//    /**
//     * 设置有效时间
//     *
//     * @param key     Redis键
//     * @param timeout 超时时间
//     * @return true=设置成功；false=设置失败
//     */
//    public static boolean expire(final String key, final long timeout) {
//
//        return expire(key, timeout, TimeUnit.SECONDS);
//    }
//
//    /**
//     * @description: 更新超时时间
//     * @param: [key, timeout]
//     * @return: boolean
//     * @author huangwei
//     * @date: 2021/11/25 15:58
//     */
//    public static boolean updateExpire(final String key, final long timeout,final TimeUnit unit) {
//        if(exists(key)){
//            return expire(key, timeout, unit);
//        }
//        return false;
//    }
//    /**
//     * 设置有效时间
//     *
//     * @param key     Redis键
//     * @param timeout 超时时间
//     * @param unit    时间单位
//     * @return true=设置成功；false=设置失败
//     */
//    public static boolean expire(final String key, final long timeout, final TimeUnit unit) {
//
//        Boolean ret = redisTemplate.expire(key, timeout, unit);
//        return ret != null && ret;
//    }
//
//    /**
//     * 删除单个key
//     *
//     * @param key 键
//     */
//    public static void del(final String key) {
//        redisTemplate.delete(key);
//    }
//
//    /**
//     * 删除多个key
//     *
//     * @param keys 键集合
//     */
//    public static void del(final Collection<String> keys) {
//        redisTemplate.delete(keys);
//    }
//
//    /**
//     * 存入普通对象
//     *
//     * @param key   Redis键
//     * @param value 值
//     */
//    public static void set(final String key, final Object value) {
//
//        redisTemplate.opsForValue().set(key, value);
//    }
//
//    // 存储普通对象操作
//
//    /**
//     * 存入普通对象
//     *
//     * @param key     键
//     * @param value   值
//     * @param timeout 有效期，单位秒
//     */
//    public static void set(final String key, final Object value, final long timeout) {
//
//        redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
//    }
//
//    /**
//     * 获取普通对象
//     *
//     * @param key 键
//     * @return 对象
//     */
//    public static Object get(final String key) {
//        return redisTemplate.opsForValue().get(key);
//    }
//
//    /**
//     * 判断key是否存在
//     * @param key
//     * @return
//     */
//    public static boolean exists(String key) {
//        return redisTemplate.hasKey(key);
//    }
//
//    /**
//     * 获取普通对象
//     *
//     * @param key 键
//     * @return 对象
//     */
//    public static String getString(final String key) {
//
//        return (String) redisTemplate.opsForValue().get(key);
//    }
//    // 存储Hash操作
//
//    /**
//     * 往Hash中存入数据
//     *
//     * @param key   Redis键
//     * @param hKey  Hash键
//     * @param value 值
//     */
//    public static void hPut(final String key, final String hKey, final Object value) {
//        redisTemplate.opsForHash().put(key, hKey, value);
//    }
//
//    /**
//     * 往Hash中存入数据,带超时时间
//     *
//     * @param key   Redis键
//     * @param hKey  Hash键
//     * @param value 值
//     */
//    public static void hPut(final String key, final String hKey, final Object value, long time) {
//        redisTemplate.opsForHash().put(key, hKey, value);
//        if(time > 0){
//            // 单位秒
//            expire(key, time);
//        }
//    }
//
//    /**
//     * Hash删除数据
//     *
//     * @param key  Redis键
//     * @param hKey Hash键
//     */
//    public static void hDel(final String key, final String... hKey) {
//        redisTemplate.opsForHash().delete(key, hKey);
//    }
//
//    /**
//     * 往Hash中存入多个数据
//     *
//     * @param key    Redis键
//     * @param values Hash键值对
//     */
//    public static void hPutAll(final String key, final Map<String, Object> values) {
//
//        redisTemplate.opsForHash().putAll(key, values);
//    }
//
//    /**
//     * 获取Hash中的数据
//     *
//     * @param key  Redis键
//     * @param hKey Hash键
//     * @return Hash中的对象
//     */
//    public static Object hGet(final String key, final String hKey) {
//
//        return redisTemplate.opsForHash().get(key, hKey);
//    }
//
//    /**
//     * 获取多个Hash中的数据
//     *
//     * @param key   Redis键
//     * @param hKeys Hash键集合
//     * @return Hash对象集合
//     */
//    public static List<Object> hMultiGet(final String key, final Collection<Object> hKeys) {
//        return redisTemplate.opsForHash().multiGet(key, hKeys);
//    }
//
//    public static Set<Object> hKeys(final String key) {
//        return redisTemplate.opsForHash().keys(key);
//    }
//
//    public static Map<Object, Object> hEntries(final String key) {
//        return redisTemplate.opsForHash().entries(key);
//    }
//
//    // 存储Set相关操作
//
//    /**
//     * 往Set中存入数据
//     *
//     * @param key    Redis键
//     * @param values 值
//     * @return 存入的个数
//     */
//    public static long sSet(final String key, final Object... values) {
//        Long count = redisTemplate.opsForSet().add(key, values);
//        return count == null ? 0 : count;
//    }
//
//    /**
//     * 删除Set中的数据
//     *
//     * @param key    Redis键
//     * @param values 值
//     * @return 移除的个数
//     */
//    public static long sDel(final String key, final Object... values) {
//        Long count = redisTemplate.opsForSet().remove(key, values);
//        return count == null ? 0 : count;
//    }
//
//    /**
//     * 求两个set集合的差集
//     * @param setKey
//     * @param otherSetKey
//     * @return
//     */
//    public static Set<Object> sdiff(String setKey, String otherSetKey) {
//        return redisTemplate.opsForSet().difference(setKey, otherSetKey);
//    }
//
//    // 存储List相关操作
//
//    /**
//     * 往List中存入数据
//     *
//     * @param key   Redis键
//     * @param value 数据
//     * @return 存入的个数
//     */
//    public static long lPush(final String key, final Object value) {
//        Long count = redisTemplate.opsForList().leftPush(key, value);
//        return count == null ? 0 : count;
//    }
//
//    /**
//     * 往List中存入多个数据
//     *
//     * @param key    Redis键
//     * @param values 多个数据
//     * @return 存入的个数
//     */
//    public static long lPushAll(final String key, final Collection<Object> values) {
//        Long count = redisTemplate.opsForList().leftPushAll(key, values);
//        return count == null ? 0 : count;
//    }
//
//    /**
//     * 往List中存入多个数据
//     *
//     * @param key    Redis键
//     * @param values 多个数据
//     * @return 存入的个数
//     */
//    public static long lPushAll(final String key, final Object... values) {
//        Long count = redisTemplate.opsForList().leftPushAll(key, values);
//        return count == null ? 0 : count;
//    }
//
//    public static Object brPop(final String key){
//        Object object = redisTemplate.opsForList().rightPop(key);
//        return object;
//    }
//
//    public static Object brPop(final String key,final long l,final TimeUnit timeUnit){
//        Object object = redisTemplate.opsForList().rightPop(key,l,timeUnit);
//        return object;
//    }
//    /**
//     * 从List中获取begin到end之间的元素
//     *
//     * @param key   Redis键
//     * @param start 开始位置
//     * @param end   结束位置（start=0，end=-1表示获取全部元素）
//     * @return List对象
//     */
//    public static List<Object> lGet(final String key, final int start, final int end) {
//        return redisTemplate.opsForList().range(key, start, end);
//    }
//
//    /**
//     * 移除集合中右边的元素，同时在左边加入一个元素。
//     *
//     * @param srcList
//     * @param destList
//     * @return
//     */
//    public static Object rPopLPush(final String srcList, final String destList) {
//        return redisTemplate.opsForList().rightPopAndLeftPush(srcList, destList);
//    }
//
//    /**
//     * 移除所有前缀匹配key的数据
//     *
//     * @param frontName
//     * @return
//     */
//    public static Long delKeysByFrontName(String frontName){
//        Set<String> keys = redisTemplate.keys(frontName + "*");
//        if (ArrayUtil.isNotEmpty(keys)) {
//            return redisTemplate.delete(keys);
//        }else {
//            return null;
//        }
//    }
//
//    /**
//     * 删除等于从左到右移动的值的第一个元素
//     *
//     * @param key
//     * @param value
//     * @return
//     */
//    public static long lDel(final String key, final Object value) {
//        return redisTemplate.opsForList().remove(key, 1, value);
//    }
//
//    /**
//     * 判断redis中key 对应的value是否存在，如果key不存在返回false，在set值时使用sSet方法，避免WRONGTYPE Operation against a key holdin错误
//     * key存在 value不存在 false，key存在 value存在返回true
//     *
//     * @param key    建
//     * @param member 值
//     * @return true or false
//     */
//    public static Boolean isMember(final String key, final String member) {
//        return redisTemplate.opsForSet().isMember(key, member);
//    }
//
//    /**
//     * 获取分布式锁
//     *
//     * @param lockKey     锁
//     * @param requestId   请求标识
//     * @param expireTime  单位秒
//     * @param waitTimeout 单位毫秒
//     * @return 是否获取成功
//     */
//    public static boolean tryLock(String lockKey, String requestId, int expireTime, long waitTimeout) {
//        // 当前时间
//        long nanoTime = System.nanoTime();
//        try {
//            String script = "if redis.call('setNx',KEYS[1],ARGV[1]) " +
//                    "then if redis.call('get',KEYS[1])==ARGV[1] " +
//                    "then return redis.call('expire',KEYS[1],ARGV[2]) " +
//                    "else return 0 end end";
//            logger.info("开始获取分布式锁-key[{}]", lockKey);
//            int count = 0;
//            do {
//                RedisScript<Long> redisScript = new DefaultRedisScript<>(script, Long.class);
//                logger.debug("尝试获取分布式锁-key[{}]requestId[{}]count[{}] lockKey:" + lockKey, requestId, count);
//                Object result = redisTemplate.execute(redisScript, Collections.singletonList(lockKey), requestId, expireTime);
//
//                if (SUCCESS.equals(result)) {
//                    logger.debug("尝试获取分布式锁-key[{}]成功", lockKey);
//                    return true;
//                }
//                //休眠500毫秒
//                Thread.sleep(500L);
//                count++;
//            } while ((System.nanoTime() - nanoTime) < TimeUnit.MILLISECONDS.toNanos(waitTimeout));
//
//        } catch (Exception e) {
//            logger.error("尝试获取分布式锁-key[{}]异常", lockKey);
//            logger.error(e.getMessage(), e);
//        }
//        return false;
//    }
//
//    public static boolean setKey(String lockKey, String requestId,int expireTime){
//       try {
//           String script = "if redis.call('setNx',KEYS[1],ARGV[1]) then if redis.call('get',KEYS[1])==ARGV[1] then return redis.call('expire',KEYS[1],ARGV[2]) else return 0 end end";
//           RedisScript<Long> redisScript = new DefaultRedisScript<>(script, Long.class);
//           Object result = redisTemplate.execute(redisScript, Collections.singletonList(lockKey), requestId, expireTime);
//           return SUCCESS.equals(result);
//       }catch (Exception e){
//           logger.error("redis set key error",e);
//           return false;
//       }
//    }
//
//    /**
//     * 释放锁
//     *
//     * @param lockKey   锁
//     * @param requestId 请求标识
//     * @return 是否释放成功
//     */
//    public static boolean releaseLock(String lockKey, String requestId) {
//        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
//        RedisScript<Long> redisScript = new DefaultRedisScript<>(script, Long.class);
//        Object result = redisTemplate.execute(redisScript, Collections.singletonList(lockKey), requestId);
//        return SUCCESS.equals(result);
//    }
//
//    public static void convertAndSend(String channel, String message){
//        redisTemplate.convertAndSend(channel,message);
//    }
//
//    public static void leftPush(String query, Object message){
//        redisTemplate.opsForList().leftPush(query, message);
//    }
//
//    public static long hincrby(String key,String feildName,long value){
//        return redisTemplate.opsForHash().increment(key, feildName, value);
//    }
//
//    public static Object execute(RedisScript<Long> script, List<String> keys, Object... args){
//        return redisTemplate.execute(script,keys ,args);
//    }
//
//    public static Boolean setIfAbsent(String key, String value, long var3, TimeUnit var5){
//       return redisTemplate.opsForValue().setIfAbsent(key, value, var3, var5);
//    }
//
//}
