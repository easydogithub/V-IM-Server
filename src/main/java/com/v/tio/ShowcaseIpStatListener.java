/**
 *
 */
package com.v.tio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.ChannelContext;
import org.tio.core.GroupContext;
import org.tio.core.intf.Packet;
import org.tio.core.stat.IpStat;
import org.tio.core.stat.IpStatListener;
import org.tio.utils.json.Json;

/**
 * @author tanyaowu
 */
public class ShowcaseIpStatListener implements IpStatListener {
    private static Logger log = LoggerFactory.getLogger(ShowcaseIpStatListener.class);

    public static final ShowcaseIpStatListener me = new ShowcaseIpStatListener();

    /**
     *
     */
    private ShowcaseIpStatListener() {
    }

    @Override
    public void onExpired(GroupContext groupContext, IpStat ipStat) {
        //在这里把统计数据入库中或日志
//		if (log.isInfoEnabled()) {
//			log.debug("可以把统计数据入库\r\n{}", Json.toFormatedJson(ipStat));
//		}
    }

    @Override
    public void onAfterConnected(ChannelContext channelContext, boolean isConnected, boolean isReconnect, IpStat ipStat) throws Exception {
//		if (log.isInfoEnabled()) {
//			log.debug("onAfterConnected\r\n{}", Json.toFormatedJson(ipStat));
//		}
    }

    @Override
    public void onDecodeError(ChannelContext channelContext, IpStat ipStat) {
        if (log.isInfoEnabled()) {
            log.debug("onDecodeError\r\n{}", Json.toFormatedJson(ipStat));
        }
    }

    @Override
    public void onAfterSent(ChannelContext channelContext, Packet packet, boolean isSentSuccess, IpStat ipStat) throws Exception {
//		if (log.isInfoEnabled()) {
//			log.debug("onAfterSent\r\n{}\r\n{}", packet.logstr(), Json.toFormatedJson(ipStat));
//		}
    }

    @Override
    public void onAfterDecoded(ChannelContext channelContext, Packet packet, int packetSize, IpStat ipStat) throws Exception {
//		if (log.isInfoEnabled()) {
////			log.debug("onAfterDecoded\r\n{}\r\n{}", packet.logstr(), Json.toFormatedJson(ipStat));
//		}
    }

    @Override
    public void onAfterReceivedBytes(ChannelContext channelContext, int receivedBytes, IpStat ipStat) throws Exception {
//		if (log.isInfoEnabled()) {
//			log.debug("onAfterReceivedBytes\r\n{}", Json.toFormatedJson(ipStat));
//		}
    }

    @Override
    public void onAfterHandled(ChannelContext channelContext, Packet packet, IpStat ipStat, long cost) throws Exception {
//		if (log.isInfoEnabled()) {
//			log.debug("onAfterHandled\r\n{}\r\n{}", packet.logstr(), Json.toFormatedJson(ipStat));
//		}
    }

}
