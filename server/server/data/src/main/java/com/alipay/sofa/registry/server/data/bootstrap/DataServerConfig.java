/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alipay.sofa.registry.server.data.bootstrap;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.boot.context.properties.ConfigurationProperties;

import com.alipay.sofa.registry.net.NetUtil;

/**
 *
 *
 * @author qian.lqlq
 * @version $Id: DataServerBootstrapConfig.java, v 0.1 2017-12-06 20:50 qian.lqlq Exp $
 */
@ConfigurationProperties(prefix = DataServerConfig.PRE_FIX)
public class DataServerConfig {

    public static final String PRE_FIX                                      = "data.server";

    public static final String IP                                           = NetUtil
                                                                                .getLocalAddress()
                                                                                .getHostAddress();

    private int                port;

    private int                syncDataPort;

    private int                metaServerPort;

    private int                httpServerPort;

    private int                queueCount;

    private int                queueSize;

    private int                notifyIntervalMs;

    private int                clientOffDelayMs;

    private int                notifyTempDataIntervalMs;

    private int                rpcTimeout;

    private CommonConfig       commonConfig;

    private Set<String>        metaIps                                      = null;

    private int                storeNodes                                   = 3;

    private int                numberOfReplicas                             = 1000;

    private long               localDataServerCleanDelay                    = 1000 * 60 * 30;

    private int                getDataExecutorMinPoolSize                   = 80;

    private int                getDataExecutorMaxPoolSize                   = 400;

    private int                getDataExecutorQueueSize                     = 10000;

    private long               getDataExecutorKeepAliveTime                 = 60;

    private int                notifyDataSyncExecutorMinPoolSize            = 80;

    private int                notifyDataSyncExecutorMaxPoolSize            = 400;

    private int                notifyDataSyncExecutorQueueSize              = 700;

    private long               notifyDataSyncExecutorKeepAliveTime          = 60;

    private long               notifySessionRetryFirstDelay                 = 3000;

    private long               notifySessionRetryIncrementDelay             = 3000;

    private int                notifySessionRetryTimes                      = 5;

    private int                publishExecutorMinPoolSize                   = 200;

    private int                publishExecutorMaxPoolSize                   = 400;

    private int                publishExecutorQueueSize                     = 10000;

    private int                datumTimeToLiveSec                           = 900;

    private int                datumLeaseManagerExecutorThreadSize          = 1;

    private int                datumLeaseManagerExecutorQueueSize           = 1000000;

    private int                sessionServerNotifierRetryExecutorThreadSize = 10;

    private int                sessionServerNotifierRetryExecutorQueueSize  = 10000;

    private int                dataSyncDelayTimeout                         = 1000;

    private int                dataSyncNotifyRetry                          = 3;

    private int                sessionDisconnectDelayMs                     = 30000;

    private int                slotMigratingExecutorThreadSize              = 8;

    private int                slotLeaderSyncSessionExecutorThreadSize      = 12;
    private int                slotLeaderSyncSessionExecutorQueueSize       = 30000;
    private volatile int       slotLeaderSyncSessionIntervalSec             = 10;
    private volatile int       slotLeaderDatumExpireSec                     = 30;

    private int                slotFollowerSyncLeaderExecutorThreadSize     = 4;
    private int                slotFollowerSyncLeaderExecutorQueueSize      = 10000;
    private volatile int       slotFollowerSyncLeaderIntervalMs             = 60000;

    // the publisher.digest if len(registerId/uuid+long), 50bytes
    private volatile int       slotSyncPublisherDigestMaxNum                = 10000;

    private volatile int       slotSyncPublisherMaxNum                      = 512;

    private int                slotSyncRequestExecutorMinPoolSize           = 32;

    private int                slotSyncRequestExecutorMaxPoolSize           = 32;

    private int                slotSyncRequestExecutorQueueSize             = 1000;

    /**
     * constructor
     * @param commonConfig
     */
    public DataServerConfig(CommonConfig commonConfig) {
        this.commonConfig = commonConfig;
    }

    public boolean isLocalDataCenter(String dataCenter) {
        return commonConfig.getLocalDataCenter().equals(dataCenter);
    }

    public String getLocalDataCenter() {
        return commonConfig.getLocalDataCenter();
    }

    /**
     * Getter method for property <tt>port</tt>.
     *
     * @return property value of port
     */
    public int getPort() {
        return port;
    }

    /**
     * Setter method for property <tt>port</tt>.
     *
     * @param port  value to be assigned to property port
     */
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * Getter method for property <tt>syncDataPort</tt>.
     *
     * @return property value of syncDataPort
     */
    public int getSyncDataPort() {
        return syncDataPort;
    }

    /**
     * Setter method for property <tt>syncDataPort</tt>.
     *
     * @param syncDataPort  value to be assigned to property syncDataPort
     */
    public void setSyncDataPort(int syncDataPort) {
        this.syncDataPort = syncDataPort;
    }

    /**
     * Getter method for property <tt>metaServerPort</tt>.
     *
     * @return property value of metaServerPort
     */
    public int getMetaServerPort() {
        return metaServerPort;
    }

    /**
     * Setter method for property <tt>metaServerPort</tt>.
     *
     * @param metaServerPort  value to be assigned to property metaServerPort
     */
    public void setMetaServerPort(int metaServerPort) {
        this.metaServerPort = metaServerPort;
    }

    /**
     * Getter method for property <tt>httpServerPort</tt>.
     *
     * @return property value of httpServerPort
     */
    public int getHttpServerPort() {
        return httpServerPort;
    }

    /**
     * Setter method for property <tt>httpServerPort</tt>.
     *
     * @param httpServerPort  value to be assigned to property httpServerPort
     */
    public void setHttpServerPort(int httpServerPort) {
        this.httpServerPort = httpServerPort;
    }

    /**
     * Getter method for property <tt>queueCount</tt>.
     *
     * @return property value of queueCount
     */
    public int getQueueCount() {
        return queueCount;
    }

    /**
     * Setter method for property <tt>queueCount</tt>.
     *
     * @param queueCount  value to be assigned to property queueCount
     */
    public void setQueueCount(int queueCount) {
        this.queueCount = queueCount;
    }

    /**
     * Getter method for property <tt>queueSize</tt>.
     *
     * @return property value of queueSize
     */
    public int getQueueSize() {
        return queueSize;
    }

    /**
     * Setter method for property <tt>queueSize</tt>.
     *
     * @param queueSize  value to be assigned to property queueSize
     */
    public void setQueueSize(int queueSize) {
        this.queueSize = queueSize;
    }

    /**
     * Getter method for property <tt>notifyIntervalMs</tt>.
     *
     * @return property value of notifyIntervalMs
     */
    public int getNotifyIntervalMs() {
        return notifyIntervalMs;
    }

    /**
     * Setter method for property <tt>notifyIntervalMs</tt>.
     *
     * @param notifyIntervalMs  value to be assigned to property notifyIntervalMs
     */
    public void setNotifyIntervalMs(int notifyIntervalMs) {
        this.notifyIntervalMs = notifyIntervalMs;
    }

    /**
     * Getter method for property <tt>notifyTempDataIntervalMs</tt>.
     *
     * @return property value of notifyTempDataIntervalMs
     */
    public int getNotifyTempDataIntervalMs() {
        return notifyTempDataIntervalMs;
    }

    /**
     * Setter method for property <tt>notifyTempDataIntervalMs</tt>.
     *
     * @param notifyTempDataIntervalMs  value to be assigned to property notifyTempDataIntervalMs
     */
    public void setNotifyTempDataIntervalMs(int notifyTempDataIntervalMs) {
        this.notifyTempDataIntervalMs = notifyTempDataIntervalMs;
    }

    /**
     * Getter method for property <tt>rpcTimeout</tt>.
     *
     * @return property value of rpcTimeout
     */
    public int getRpcTimeout() {
        return rpcTimeout;
    }

    /**
     * Setter method for property <tt>rpcTimeout</tt>.
     *
     * @param rpcTimeout  value to be assigned to property rpcTimeout
     */
    public void setRpcTimeout(int rpcTimeout) {
        this.rpcTimeout = rpcTimeout;
    }

    /**
     * Getter method for property <tt>storeNodes</tt>.
     *
     * @return property value of storeNodes
     */
    public int getStoreNodes() {
        return storeNodes;
    }

    /**
     * Setter method for property <tt>storeNodes</tt>.
     *
     * @param storeNodes value to be assigned to property storeNodes
     */
    public void setStoreNodes(int storeNodes) {
        this.storeNodes = storeNodes;
    }

    /**
     * Getter method for property <tt>numberOfReplicas</tt>.
     *
     * @return property value of numberOfReplicas
     */
    public int getNumberOfReplicas() {
        return numberOfReplicas;
    }

    /**
     * Setter method for property <tt>numberOfReplicas</tt>.
     *
     * @param numberOfReplicas  value to be assigned to property numberOfReplicas
     */
    public void setNumberOfReplicas(int numberOfReplicas) {
        this.numberOfReplicas = numberOfReplicas;
    }

    /**
     * Getter method for property <tt>localDataServerCleanDelay</tt>.
     *
     * @return property value of localDataServerCleanDelay
     */
    public long getLocalDataServerCleanDelay() {
        return localDataServerCleanDelay;
    }

    /**
     * Setter method for property <tt>localDataServerCleanDelay</tt>.
     *
     * @param localDataServerCleanDelay  value to be assigned to property localDataServerCleanDelay
     */
    public void setLocalDataServerCleanDelay(long localDataServerCleanDelay) {
        this.localDataServerCleanDelay = localDataServerCleanDelay;
    }

    /**
     * Getter method for property <tt>getDataExecutorMinPoolSize</tt>.
     *
     * @return property value of getDataExecutorMinPoolSize
     */
    public int getGetDataExecutorMinPoolSize() {
        return getDataExecutorMinPoolSize;
    }

    /**
     * Getter method for property <tt>getDataExecutorMaxPoolSize</tt>.
     *
     * @return property value of getDataExecutorMaxPoolSize
     */
    public int getGetDataExecutorMaxPoolSize() {
        return getDataExecutorMaxPoolSize;
    }

    /**
     * Getter method for property <tt>getDataExecutorQueueSize</tt>.
     *
     * @return property value of getDataExecutorQueueSize
     */
    public int getGetDataExecutorQueueSize() {
        return getDataExecutorQueueSize;
    }

    /**
     * Getter method for property <tt>getDataExecutorKeepAliveTime</tt>.
     *
     * @return property value of getDataExecutorKeepAliveTime
     */
    public long getGetDataExecutorKeepAliveTime() {
        return getDataExecutorKeepAliveTime;
    }

    /**
     * Setter method for property <tt>getDataExecutorMinPoolSize</tt>.
     *
     * @param getDataExecutorMinPoolSize  value to be assigned to property getDataExecutorMinPoolSize
     */
    public void setGetDataExecutorMinPoolSize(int getDataExecutorMinPoolSize) {
        this.getDataExecutorMinPoolSize = getDataExecutorMinPoolSize;
    }

    /**
     * Setter method for property <tt>getDataExecutorMaxPoolSize</tt>.
     *
     * @param getDataExecutorMaxPoolSize  value to be assigned to property getDataExecutorMaxPoolSize
     */
    public void setGetDataExecutorMaxPoolSize(int getDataExecutorMaxPoolSize) {
        this.getDataExecutorMaxPoolSize = getDataExecutorMaxPoolSize;
    }

    /**
     * Setter method for property <tt>getDataExecutorQueueSize</tt>.
     *
     * @param getDataExecutorQueueSize  value to be assigned to property getDataExecutorQueueSize
     */
    public void setGetDataExecutorQueueSize(int getDataExecutorQueueSize) {
        this.getDataExecutorQueueSize = getDataExecutorQueueSize;
    }

    /**
     * Setter method for property <tt>getDataExecutorKeepAliveTime</tt>.
     *
     * @param getDataExecutorKeepAliveTime  value to be assigned to property getDataExecutorKeepAliveTime
     */
    public void setGetDataExecutorKeepAliveTime(long getDataExecutorKeepAliveTime) {
        this.getDataExecutorKeepAliveTime = getDataExecutorKeepAliveTime;
    }

    /**
     * Getter method for property <tt>notifyDataSyncExecutorMinPoolSize</tt>.
     *
     * @return property value of notifyDataSyncExecutorMinPoolSize
     */
    public int getNotifyDataSyncExecutorMinPoolSize() {
        return notifyDataSyncExecutorMinPoolSize;
    }

    /**
     * Setter method for property <tt>notifyDataSyncExecutorMinPoolSize</tt>.
     *
     * @param notifyDataSyncExecutorMinPoolSize  value to be assigned to property notifyDataSyncExecutorMinPoolSize
     */
    public void setNotifyDataSyncExecutorMinPoolSize(int notifyDataSyncExecutorMinPoolSize) {
        this.notifyDataSyncExecutorMinPoolSize = notifyDataSyncExecutorMinPoolSize;
    }

    /**
     * Getter method for property <tt>notifyDataSyncExecutorMaxPoolSize</tt>.
     *
     * @return property value of notifyDataSyncExecutorMaxPoolSize
     */
    public int getNotifyDataSyncExecutorMaxPoolSize() {
        return notifyDataSyncExecutorMaxPoolSize;
    }

    /**
     * Setter method for property <tt>notifyDataSyncExecutorMaxPoolSize</tt>.
     *
     * @param notifyDataSyncExecutorMaxPoolSize  value to be assigned to property notifyDataSyncExecutorMaxPoolSize
     */
    public void setNotifyDataSyncExecutorMaxPoolSize(int notifyDataSyncExecutorMaxPoolSize) {
        this.notifyDataSyncExecutorMaxPoolSize = notifyDataSyncExecutorMaxPoolSize;
    }

    /**
     * Getter method for property <tt>notifyDataSyncExecutorQueueSize</tt>.
     *
     * @return property value of notifyDataSyncExecutorQueueSize
     */
    public int getNotifyDataSyncExecutorQueueSize() {
        return notifyDataSyncExecutorQueueSize;
    }

    /**
     * Setter method for property <tt>notifyDataSyncExecutorQueueSize</tt>.
     *
     * @param notifyDataSyncExecutorQueueSize  value to be assigned to property notifyDataSyncExecutorQueueSize
     */
    public void setNotifyDataSyncExecutorQueueSize(int notifyDataSyncExecutorQueueSize) {
        this.notifyDataSyncExecutorQueueSize = notifyDataSyncExecutorQueueSize;
    }

    /**
     * Getter method for property <tt>notifyDataSyncExecutorKeepAliveTime</tt>.
     *
     * @return property value of notifyDataSyncExecutorKeepAliveTime
     */
    public long getNotifyDataSyncExecutorKeepAliveTime() {
        return notifyDataSyncExecutorKeepAliveTime;
    }

    /**
     * Setter method for property <tt>notifyDataSyncExecutorKeepAliveTime</tt>.
     *
     * @param notifyDataSyncExecutorKeepAliveTime  value to be assigned to property notifyDataSyncExecutorKeepAliveTime
     */
    public void setNotifyDataSyncExecutorKeepAliveTime(long notifyDataSyncExecutorKeepAliveTime) {
        this.notifyDataSyncExecutorKeepAliveTime = notifyDataSyncExecutorKeepAliveTime;
    }

    /**
     * Getter method for property <tt>notifySessionRetryFirstDelay</tt>.
     *
     * @return property value of notifySessionRetryFirstDelay
     */
    public long getNotifySessionRetryFirstDelay() {
        return notifySessionRetryFirstDelay;
    }

    /**
     * Setter method for property <tt>notifySessionRetryFirstDelay</tt>.
     *
     * @param notifySessionRetryFirstDelay  value to be assigned to property notifySessionRetryFirstDelay
     */
    public void setNotifySessionRetryFirstDelay(long notifySessionRetryFirstDelay) {
        this.notifySessionRetryFirstDelay = notifySessionRetryFirstDelay;
    }

    /**
     * Getter method for property <tt>notifySessionRetryIncrementDelay</tt>.
     *
     * @return property value of notifySessionRetryIncrementDelay
     */
    public long getNotifySessionRetryIncrementDelay() {
        return notifySessionRetryIncrementDelay;
    }

    /**
     * Setter method for property <tt>notifySessionRetryIncrementDelay</tt>.
     *
     * @param notifySessionRetryIncrementDelay  value to be assigned to property notifySessionRetryIncrementDelay
     */
    public void setNotifySessionRetryIncrementDelay(long notifySessionRetryIncrementDelay) {
        this.notifySessionRetryIncrementDelay = notifySessionRetryIncrementDelay;
    }

    /**
     * Getter method for property <tt>clientOffDelayMs</tt>.
     *
     * @return property value of clientOffDelayMs
     */
    public int getClientOffDelayMs() {
        return clientOffDelayMs;
    }

    /**
     * Setter method for property <tt>clientOffDelayMs</tt>.
     *
     * @param clientOffDelayMs  value to be assigned to property clientOffDelayMs
     */
    public void setClientOffDelayMs(int clientOffDelayMs) {
        this.clientOffDelayMs = clientOffDelayMs;
    }

    /**
     * Getter method for property <tt>publishExecutorMinPoolSize</tt>.
     *
     * @return property value of publishExecutorMinPoolSize
     */
    public int getPublishExecutorMinPoolSize() {
        return publishExecutorMinPoolSize;
    }

    /**
     * Setter method for property <tt>publishExecutorMinPoolSize</tt>.
     *
     * @param publishExecutorMinPoolSize  value to be assigned to property publishExecutorMinPoolSize
     */
    public void setPublishExecutorMinPoolSize(int publishExecutorMinPoolSize) {
        this.publishExecutorMinPoolSize = publishExecutorMinPoolSize;
    }

    /**
     * Getter method for property <tt>publishExecutorMaxPoolSize</tt>.
     *
     * @return property value of publishExecutorMaxPoolSize
     */
    public int getPublishExecutorMaxPoolSize() {
        return publishExecutorMaxPoolSize;
    }

    /**
     * Setter method for property <tt>publishExecutorMaxPoolSize</tt>.
     *
     * @param publishExecutorMaxPoolSize  value to be assigned to property publishExecutorMaxPoolSize
     */
    public void setPublishExecutorMaxPoolSize(int publishExecutorMaxPoolSize) {
        this.publishExecutorMaxPoolSize = publishExecutorMaxPoolSize;
    }

    /**
     * Getter method for property <tt>publishExecutorQueueSize</tt>.
     *
     * @return property value of publishExecutorQueueSize
     */
    public int getPublishExecutorQueueSize() {
        return publishExecutorQueueSize;
    }

    /**
     * Setter method for property <tt>publishExecutorQueueSize</tt>.
     *
     * @param publishExecutorQueueSize  value to be assigned to property publishExecutorQueueSize
     */
    public void setPublishExecutorQueueSize(int publishExecutorQueueSize) {
        this.publishExecutorQueueSize = publishExecutorQueueSize;
    }

    /**
     * Getter method for property <tt>metaServerIpAddress</tt>.
     *
     * @return property value of metaServerIpAddress
     */
    public Set<String> getMetaServerIpAddresses() {
        if (metaIps != null && !metaIps.isEmpty()) {
            return metaIps;
        }
        metaIps = new HashSet<>();
        if (commonConfig != null) {
            Map<String, Collection<String>> metaMap = commonConfig.getMetaNode();
            if (metaMap != null && !metaMap.isEmpty()) {
                String localDataCenter = commonConfig.getLocalDataCenter();
                if (localDataCenter != null && !localDataCenter.isEmpty()) {
                    Collection<String> metas = metaMap.get(localDataCenter);
                    if (metas != null && !metas.isEmpty()) {
                        metaIps = metas.stream().map(NetUtil::getIPAddressFromDomain).collect(Collectors.toSet());
                    }
                }
            }
        }
        return metaIps;
    }

    /**
     * Getter method for property <tt>notifySessionRetryTimes</tt>.
     *
     * @return property value of notifySessionRetryTimes
     */
    public int getNotifySessionRetryTimes() {
        return notifySessionRetryTimes;
    }

    /**
     * Setter method for property <tt>notifySessionRetryTimes </tt>.
     *
     * @param notifySessionRetryTimes  value to be assigned to property notifySessionRetryTimes
     */
    public void setNotifySessionRetryTimes(int notifySessionRetryTimes) {
        this.notifySessionRetryTimes = notifySessionRetryTimes;
    }

    /**
     * Getter method for property <tt>datumTimeToLiveSec</tt>.
     *
     * @return property value of datumTimeToLiveSec
     */
    public int getDatumTimeToLiveSec() {
        return datumTimeToLiveSec;
    }

    /**
     * Setter method for property <tt>datumTimeToLiveSec </tt>.
     *
     * @param datumTimeToLiveSec  value to be assigned to property datumTimeToLiveSec
     */
    public void setDatumTimeToLiveSec(int datumTimeToLiveSec) {
        this.datumTimeToLiveSec = datumTimeToLiveSec;
    }

    /**
     * Getter method for property <tt>datumLeaseManagerExecutorQueueSize</tt>.
     *
     * @return property value of datumLeaseManagerExecutorQueueSize
     */
    public int getDatumLeaseManagerExecutorQueueSize() {
        return datumLeaseManagerExecutorQueueSize;
    }

    /**
     * Setter method for property <tt>datumLeaseManagerExecutorQueueSize </tt>.
     *
     * @param datumLeaseManagerExecutorQueueSize  value to be assigned to property datumLeaseManagerExecutorQueueSize
     */
    public void setDatumLeaseManagerExecutorQueueSize(int datumLeaseManagerExecutorQueueSize) {
        this.datumLeaseManagerExecutorQueueSize = datumLeaseManagerExecutorQueueSize;
    }

    /**
     * Getter method for property <tt>datumLeaseManagerExecutorThreadSize</tt>.
     *
     * @return property value of datumLeaseManagerExecutorThreadSize
     */
    public int getDatumLeaseManagerExecutorThreadSize() {
        return datumLeaseManagerExecutorThreadSize;
    }

    /**
     * Setter method for property <tt>datumLeaseManagerExecutorThreadSize </tt>.
     *
     * @param datumLeaseManagerExecutorThreadSize  value to be assigned to property datumLeaseManagerExecutorThreadSize
     */
    public void setDatumLeaseManagerExecutorThreadSize(int datumLeaseManagerExecutorThreadSize) {
        this.datumLeaseManagerExecutorThreadSize = datumLeaseManagerExecutorThreadSize;
    }

    /**
     * Getter method for property <tt>sessionServerNotifierRetryExecutorThreadSize</tt>.
     *
     * @return property value of sessionServerNotifierRetryExecutorThreadSize
     */
    public int getSessionServerNotifierRetryExecutorThreadSize() {
        return sessionServerNotifierRetryExecutorThreadSize;
    }

    /**
     * Setter method for property <tt>sessionServerNotifierRetryExecutorThreadSize </tt>.
     *
     * @param sessionServerNotifierRetryExecutorThreadSize  value to be assigned to property sessionServerNotifierRetryExecutorThreadSize
     */
    public void setSessionServerNotifierRetryExecutorThreadSize(int sessionServerNotifierRetryExecutorThreadSize) {
        this.sessionServerNotifierRetryExecutorThreadSize = sessionServerNotifierRetryExecutorThreadSize;
    }

    /**
     * Getter method for property <tt>sessionServerNotifierRetryExecutorQueueSize</tt>.
     *
     * @return property value of sessionServerNotifierRetryExecutorQueueSize
     */
    public int getSessionServerNotifierRetryExecutorQueueSize() {
        return sessionServerNotifierRetryExecutorQueueSize;
    }

    /**
     * Setter method for property <tt>sessionServerNotifierRetryExecutorQueueSize </tt>.
     *
     * @param sessionServerNotifierRetryExecutorQueueSize  value to be assigned to property sessionServerNotifierRetryExecutorQueueSize
     */
    public void setSessionServerNotifierRetryExecutorQueueSize(int sessionServerNotifierRetryExecutorQueueSize) {
        this.sessionServerNotifierRetryExecutorQueueSize = sessionServerNotifierRetryExecutorQueueSize;
    }

    /**
     * Getter method for property <tt>dataSyncDelayTimeout</tt>.
     *
     * @return property value of dataSyncDelayTimeout
     */
    public int getDataSyncDelayTimeout() {
        return dataSyncDelayTimeout;
    }

    /**
     * Setter method for property <tt>dataSyncDelayTimeout </tt>.
     *
     * @param dataSyncDelayTimeout  value to be assigned to property dataSyncDelayTimeout
     */
    public void setDataSyncDelayTimeout(int dataSyncDelayTimeout) {
        this.dataSyncDelayTimeout = dataSyncDelayTimeout;
    }

    /**
     * Getter method for property <tt>dataSyncNotifyRetry</tt>.
     *
     * @return property value of dataSyncNotifyRetry
     */
    public int getDataSyncNotifyRetry() {
        return dataSyncNotifyRetry;
    }

    /**
     * Setter method for property <tt>dataSyncNotifyRetry </tt>.
     *
     * @param dataSyncNotifyRetry  value to be assigned to property dataSyncNotifyRetry
     */
    public void setDataSyncNotifyRetry(int dataSyncNotifyRetry) {
        this.dataSyncNotifyRetry = dataSyncNotifyRetry;
    }

    /**
     * Getter method for property <tt>sessionDisconnectDelayMs</tt>.
     *
     * @return property value of sessionDisconnectDelayMs
     */
    public int getSessionDisconnectDelayMs() {
        return sessionDisconnectDelayMs;
    }

    /**
     * Setter method for property <tt>sessionDisconnectDelayMs</tt>.
     *
     * @param sessionDisconnectDelayMs value to be assigned to property sessionDisconnectDelayMs
     */
    public void setSessionDisconnectDelayMs(int sessionDisconnectDelayMs) {
        this.sessionDisconnectDelayMs = sessionDisconnectDelayMs;
    }

    /**
     * Getter method for property <tt>slotMigratingExecutorThreadSize</tt>.
     * @return property value of slotMigratingExecutorThreadSize
     */
    public int getSlotMigratingExecutorThreadSize() {
        return slotMigratingExecutorThreadSize;
    }

    /**
     * Setter method for property <tt>slotMigratingExecutorThreadSize</tt>.
     * @param slotMigratingExecutorThreadSize value to be assigned to property slotMigratingExecutorThreadSize
     */
    public void setSlotMigratingExecutorThreadSize(int slotMigratingExecutorThreadSize) {
        this.slotMigratingExecutorThreadSize = slotMigratingExecutorThreadSize;
    }

    /**
     * Getter method for property <tt>slotSyncPublisherDigestMaxNum</tt>.
     * @return property value of slotSyncPublisherDigestMaxNum
     */
    public int getSlotSyncPublisherDigestMaxNum() {
        return slotSyncPublisherDigestMaxNum;
    }

    /**
     * Setter method for property <tt>slotSyncPublisherDigestMaxNum</tt>.
     * @param slotSyncPublisherDigestMaxNum value to be assigned to property slotSyncPublisherDigestMaxNum
     */
    public void setSlotSyncPublisherDigestMaxNum(int slotSyncPublisherDigestMaxNum) {
        this.slotSyncPublisherDigestMaxNum = slotSyncPublisherDigestMaxNum;
    }

    /**
     * Getter method for property <tt>slotSyncPublisherMaxNum</tt>.
     * @return property value of slotSyncPublisherMaxNum
     */
    public int getSlotSyncPublisherMaxNum() {
        return slotSyncPublisherMaxNum;
    }

    /**
     * Setter method for property <tt>slotSyncPublisherMaxNum</tt>.
     * @param slotSyncPublisherMaxNum value to be assigned to property slotSyncPublisherMaxNum
     */
    public void setSlotSyncPublisherMaxNum(int slotSyncPublisherMaxNum) {
        this.slotSyncPublisherMaxNum = slotSyncPublisherMaxNum;
    }

    /**
     * Getter method for property <tt>slotLeaderSyncSessionExecutorThreadSize</tt>.
     * @return property value of slotLeaderSyncSessionExecutorThreadSize
     */
    public int getSlotLeaderSyncSessionExecutorThreadSize() {
        return slotLeaderSyncSessionExecutorThreadSize;
    }

    /**
     * Setter method for property <tt>slotLeaderSyncSessionExecutorThreadSize</tt>.
     * @param slotLeaderSyncSessionExecutorThreadSize value to be assigned to property slotLeaderSyncSessionExecutorThreadSize
     */
    public void setSlotLeaderSyncSessionExecutorThreadSize(int slotLeaderSyncSessionExecutorThreadSize) {
        this.slotLeaderSyncSessionExecutorThreadSize = slotLeaderSyncSessionExecutorThreadSize;
    }

    /**
     * Getter method for property <tt>slotLeaderSyncSessionIntervalMs</tt>.
     * @return property value of slotLeaderSyncSessionIntervalMs
     */
    public int getSlotLeaderSyncSessionIntervalSec() {
        return slotLeaderSyncSessionIntervalSec;
    }

    /**
     * Setter method for property <tt>slotLeaderSyncSessionIntervalSec</tt>.
     * @param slotLeaderSyncSessionIntervalSec value to be assigned to property slotLeaderSyncSessionIntervalSec
     */
    public void setSlotLeaderSyncSessionIntervalSec(int slotLeaderSyncSessionIntervalSec) {
        this.slotLeaderSyncSessionIntervalSec = slotLeaderSyncSessionIntervalSec;
    }

    /**
     * Getter method for property <tt>slotFollowerSyncLeaderExecutorThreadSize</tt>.
     * @return property value of slotFollowerSyncLeaderExecutorThreadSize
     */
    public int getSlotFollowerSyncLeaderExecutorThreadSize() {
        return slotFollowerSyncLeaderExecutorThreadSize;
    }

    /**
     * Setter method for property <tt>slotFollowerSyncLeaderExecutorThreadSize</tt>.
     * @param slotFollowerSyncLeaderExecutorThreadSize value to be assigned to property slotFollowerSyncLeaderExecutorThreadSize
     */
    public void setSlotFollowerSyncLeaderExecutorThreadSize(int slotFollowerSyncLeaderExecutorThreadSize) {
        this.slotFollowerSyncLeaderExecutorThreadSize = slotFollowerSyncLeaderExecutorThreadSize;
    }

    /**
     * Getter method for property <tt>slotFollowerSyncLeaderIntervalMs</tt>.
     * @return property value of slotFollowerSyncLeaderIntervalMs
     */
    public int getSlotFollowerSyncLeaderIntervalMs() {
        return slotFollowerSyncLeaderIntervalMs;
    }

    /**
     * Setter method for property <tt>slotFollowerSyncLeaderIntervalMs</tt>.
     * @param slotFollowerSyncLeaderIntervalMs value to be assigned to property slotFollowerSyncLeaderIntervalMs
     */
    public void setSlotFollowerSyncLeaderIntervalMs(int slotFollowerSyncLeaderIntervalMs) {
        this.slotFollowerSyncLeaderIntervalMs = slotFollowerSyncLeaderIntervalMs;
    }

    /**
     * Getter method for property <tt>slotLeaderSyncSessionExecutorQueueSize</tt>.
     * @return property value of slotLeaderSyncSessionExecutorQueueSize
     */
    public int getSlotLeaderSyncSessionExecutorQueueSize() {
        return slotLeaderSyncSessionExecutorQueueSize;
    }

    /**
     * Setter method for property <tt>slotLeaderSyncSessionExecutorQueueSize</tt>.
     * @param slotLeaderSyncSessionExecutorQueueSize value to be assigned to property slotLeaderSyncSessionExecutorQueueSize
     */
    public void setSlotLeaderSyncSessionExecutorQueueSize(int slotLeaderSyncSessionExecutorQueueSize) {
        this.slotLeaderSyncSessionExecutorQueueSize = slotLeaderSyncSessionExecutorQueueSize;
    }

    /**
     * Getter method for property <tt>slotFollowerSyncLeaderExecutorQueueSize</tt>.
     * @return property value of slotFollowerSyncLeaderExecutorQueueSize
     */
    public int getSlotFollowerSyncLeaderExecutorQueueSize() {
        return slotFollowerSyncLeaderExecutorQueueSize;
    }

    /**
     * Setter method for property <tt>slotFollowerSyncLeaderExecutorQueueSize</tt>.
     * @param slotFollowerSyncLeaderExecutorQueueSize value to be assigned to property slotFollowerSyncLeaderExecutorQueueSize
     */
    public void setSlotFollowerSyncLeaderExecutorQueueSize(int slotFollowerSyncLeaderExecutorQueueSize) {
        this.slotFollowerSyncLeaderExecutorQueueSize = slotFollowerSyncLeaderExecutorQueueSize;
    }

    /**
     * Getter method for property <tt>slotSyncRequestExecutorMinPoolSize</tt>.
     * @return property value of slotSyncRequestExecutorMinPoolSize
     */
    public int getSlotSyncRequestExecutorMinPoolSize() {
        return slotSyncRequestExecutorMinPoolSize;
    }

    /**
     * Setter method for property <tt>slotSyncRequestExecutorMinPoolSize</tt>.
     * @param slotSyncRequestExecutorMinPoolSize value to be assigned to property slotSyncRequestExecutorMinPoolSize
     */
    public void setSlotSyncRequestExecutorMinPoolSize(int slotSyncRequestExecutorMinPoolSize) {
        this.slotSyncRequestExecutorMinPoolSize = slotSyncRequestExecutorMinPoolSize;
    }

    /**
     * Getter method for property <tt>slotSyncRequestExecutorMaxPoolSize</tt>.
     * @return property value of slotSyncRequestExecutorMaxPoolSize
     */
    public int getSlotSyncRequestExecutorMaxPoolSize() {
        return slotSyncRequestExecutorMaxPoolSize;
    }

    /**
     * Setter method for property <tt>slotSyncRequestExecutorMaxPoolSize</tt>.
     * @param slotSyncRequestExecutorMaxPoolSize value to be assigned to property slotSyncRequestExecutorMaxPoolSize
     */
    public void setSlotSyncRequestExecutorMaxPoolSize(int slotSyncRequestExecutorMaxPoolSize) {
        this.slotSyncRequestExecutorMaxPoolSize = slotSyncRequestExecutorMaxPoolSize;
    }

    /**
     * Getter method for property <tt>slotSyncRequestExecutorQueueSize</tt>.
     * @return property value of slotSyncRequestExecutorQueueSize
     */
    public int getSlotSyncRequestExecutorQueueSize() {
        return slotSyncRequestExecutorQueueSize;
    }

    /**
     * Setter method for property <tt>slotSyncRequestExecutorQueueSize</tt>.
     * @param slotSyncRequestExecutorQueueSize value to be assigned to property slotSyncRequestExecutorQueueSize
     */
    public void setSlotSyncRequestExecutorQueueSize(int slotSyncRequestExecutorQueueSize) {
        this.slotSyncRequestExecutorQueueSize = slotSyncRequestExecutorQueueSize;
    }

    /**
     * Getter method for property <tt>slotLeaderDatumExpireSec</tt>.
     * @return property value of slotLeaderDatumExpireSec
     */
    public int getSlotLeaderDatumExpireSec() {
        return slotLeaderDatumExpireSec;
    }

    /**
     * Setter method for property <tt>slotLeaderDatumExpireSec</tt>.
     * @param slotLeaderDatumExpireSec value to be assigned to property slotLeaderDatumExpireSec
     */
    public void setSlotLeaderDatumExpireSec(int slotLeaderDatumExpireSec) {
        this.slotLeaderDatumExpireSec = slotLeaderDatumExpireSec;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
