package net.frank.demos.netty.action.ch11;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.ContinuationWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;

/***
 * BinaryWebSocketFrame             数据帧，二进制数据
 * TextWebSocketFrame               数据帧，文本数据
 * ContinuationWebSocketFrame       数据帧，属于上一个BinaryWebSocketFrame或者TextWebSocketFrame的文本或二制度数据
 * CloseWebSocketFrame              控制帧，一个CLOSE请求、关闭的新动态码以及关闭原因
 * PingWebSocketFrame               控制帧，请求一个PongWebSocketFrame
 * PongWebSocketFrame               控制帧，对PingWebSocketFrame请求响应
 */

public class WebSocketServerInitializer extends ChannelInitializer<Channel> {

    @Override
    protected void initChannel(Channel ch) {
        ch.pipeline().addLast(
                new HttpServerCodec(),
                new HttpObjectAggregator(65536),
                new WebSocketServerProtocolHandler("/websocket"),
                new TextFrameHandler(),
                new BinaryFrameHandler(),
                new ContinuationFrameHandler()
        );
    }


    public static final class TextFrameHandler extends SimpleChannelInboundHandler<TextWebSocketFrame>{
        @Override
        public void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg){

        }
    }

    public static final class BinaryFrameHandler extends  SimpleChannelInboundHandler<BinaryWebSocketFrame>{
        @Override
        public void channelRead0(ChannelHandlerContext ctx, BinaryWebSocketFrame msg){

        }
    }

    public static final class ContinuationFrameHandler extends SimpleChannelInboundHandler<ContinuationWebSocketFrame>{
        @Override
        public void channelRead0(ChannelHandlerContext ctx,ContinuationWebSocketFrame msg){

        }
    }


}
