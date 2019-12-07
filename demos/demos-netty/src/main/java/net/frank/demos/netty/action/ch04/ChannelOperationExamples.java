package net.frank.demos.netty.action.ch04;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ChannelOperationExamples {

    private static final Channel CHANNEL_FROM_SOMEWHERE =new NioSocketChannel();

    public static void writingToChannel(){
        Channel channel = CHANNEL_FROM_SOMEWHERE;
        ByteBuf buf = Unpooled.copiedBuffer("your data", CharsetUtil.UTF_8);
        ChannelFuture cf = channel.writeAndFlush(buf);
        cf.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                if(future.isSuccess()){
                    System.out.println("Write success");
                }else{
                    System.err.println("Write error");
                    future.cause().printStackTrace();
                }
            }
        });
    }

    public static void writingToChannelFromManyThreads(){
        final Channel channel = CHANNEL_FROM_SOMEWHERE;
        final ByteBuf buf = Unpooled.copiedBuffer("your data",CharsetUtil.UTF_8);
        Runnable writer = ()->
            channel.write(buf.duplicate());
        Executor executor = Executors.newCachedThreadPool();

        executor.execute(writer);

        executor.execute(writer);

    }


}
