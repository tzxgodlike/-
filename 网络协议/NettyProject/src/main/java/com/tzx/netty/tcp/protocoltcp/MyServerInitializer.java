package com.tzx.netty.tcp.protocoltcp;


import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

public class MyServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();

        pipeline.addLast(new MyMessageDecoder());  //解码器
        pipeline.addLast(new MyMessageEncoder());  //编码器
        pipeline.addLast(new MyServerHandler());
    }


}
