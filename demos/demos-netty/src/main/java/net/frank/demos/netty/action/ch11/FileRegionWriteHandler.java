package net.frank.demos.netty.action.ch11;

import io.netty.channel.*;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.File;
import java.io.FileInputStream;

/***
 * 通道里传大文件
 */
public class FileRegionWriteHandler extends ChannelInboundHandlerAdapter {

    private static final Channel CHANNEL_FROM_SOMEWHERE = new NioSocketChannel();
    private static final File FILE_FROM_SOMEWHERE = new File("");

    @Override
    public void channelActive(final ChannelHandlerContext ctx)throws Exception{
        File file = FILE_FROM_SOMEWHERE;
        Channel channel = CHANNEL_FROM_SOMEWHERE;
        FileInputStream in = new FileInputStream(file);
        FileRegion region = new DefaultFileRegion(
                in.getChannel(),0,file.length());
        channel.writeAndFlush(region).addListener(
                (channelFuture) -> {
                   if(!channelFuture.isSuccess()){
                       Throwable cause = channelFuture.cause();

                   }
                });
    }
}
