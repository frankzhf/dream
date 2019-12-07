package io.netty.channel;

import io.netty.util.concurrent.EventExecutor;

public class DummyChannelHandlerContext extends AbstractChannelHandlerContext {


    public static ChannelHandlerContext DUMMY_INSTANCE = new DummyChannelHandlerContext(
            null,null,"dummy",true,true
    );

    public DummyChannelHandlerContext(DefaultChannelPipeline pipeline,
                                      EventExecutor executor,
                                      String name, boolean inbound, boolean outbound){
        super(pipeline,executor,name,inbound,outbound);
    }

    @Override
    public ChannelHandler handler(){
        return null;
    }

}