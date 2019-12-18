package net.frank.demos.netty.action.ch11;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpContentCompressor;
import io.netty.handler.codec.http.HttpContentDecompressor;
import io.netty.handler.codec.http.HttpServerCodec;

public class HttpCompressionInitializer extends ChannelInitializer<Channel> {

    private final boolean isClient;

    public HttpCompressionInitializer(boolean isClient){
        this.isClient = isClient;
    }

    @Override
    protected void initChannel(Channel ch){
        ChannelPipeline pipeline = ch.pipeline();
        if(isClient){
            pipeline.addLast("codec",new HttpClientCodec());
            pipeline.addLast("decompressor",new HttpContentDecompressor());
        }else{
            pipeline.addLast("codec",new HttpServerCodec());
            pipeline.addLast("compressor",new HttpContentCompressor());
        }
        /**
         * 如果使用jdk1.6
         * 要加入
         * <dependency>
         *     <groupId>com.jcraft</groupId>
         *     <artifactId>jzlib</artifactId>
         *     <version>1.1.3</version>
         * </dependency>
         *
         *
         *  依赖
         *
         */
    }

}
