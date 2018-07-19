package cn.plus.framework.netty;

import com.google.common.util.concurrent.AbstractIdleService;
import com.google.common.util.concurrent.AbstractIdleService;


class ServerService extends AbstractIdleService {

    public NettyServer nettyServer ;

    @Override
    protected void startUp() throws Exception {
        nettyServer = new NettyServer();
        nettyServer.init(null);
    }

    @Override
    protected void shutDown() throws Exception {
        nettyServer.shutDown();
    }
}
