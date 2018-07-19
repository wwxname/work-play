package cn.plus.framework.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class NettyServer {

    public static final Log log = LogFactory.getLog(NettyServer.class);
    private final int port = 8082; //设置服务端端口
    private final EventLoopGroup group = new NioEventLoopGroup();   // 通过nio方式来接收连接和处理连接
    private final ServerBootstrap bootstrap = new ServerBootstrap();

    /**
     * Netty创建全部都是实现自AbstractBootstrap。
     * 客户端的是Bootstrap，服务端的则是	ServerBootstrap。
     **/
    public void init(String[] args) throws InterruptedException {
        bootstrap.group(group);
        bootstrap.channel(NioServerSocketChannel.class);
        bootstrap.childHandler(new NettyServerFilter()); //设置过滤器
        // 服务器绑定端口监听
        ChannelFuture future = bootstrap.bind(port).sync();
        log.info("服务端启动成功,端口是:" + port);
        // 监听服务器关闭监听
        future.channel().closeFuture().sync();
    }

    public void shutDown() {
        //关闭EventLoopGroup，释放掉所有资源包括创建的线程
        this.group.shutdownGracefully();
    }
}
