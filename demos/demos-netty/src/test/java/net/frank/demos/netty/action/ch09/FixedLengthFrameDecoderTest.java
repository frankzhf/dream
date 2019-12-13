package net.frank.demos.netty.action.ch09;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import org.junit.Assert;
import org.junit.Test;

public class FixedLengthFrameDecoderTest {

    /***
     * EmbeddedChannel主要方法
     *
     * writeInbound(Object... msgs)          将入站消息写到EmbeddedChannel中。如果可以通过readInbound()方法从EmbeddedChannel中读取数据，则返回true
     *
     * readInbound()                         从EmbeddedChannel中读取一个入站消息。任何返回的东西都穿越整个ChannelPipeline。如果没有任何可供读取的，则返回null
     *
     * writeOutbound(Object... msgs)         将出站消息写到EmbeddedChannel中。如果现在可以通过readOutbound()方法从EmbeddedChannel中读到什么东西，则返回true
     *
     * readOutbound();                       从EmbeddedChannel中读取一个出站消息。任务返回的东西都穿越整个ChannelPipeline。如果没有任何可供读取的，则返回null
     *
     * finish()                              将EmbeddedChannel标记为完成，并且如果有可被读取的入站数据或出站数据，则返回true.这个方法还会调用EmbeddedChannel上的close()方法
     *
     *
     */


    @Test
    public void testFramesDecoder(){
        ByteBuf buf = Unpooled.buffer();
        for(int i=0;i<9;i++){
            buf.writeByte(i);
        }

        ByteBuf input = buf.duplicate();
        EmbeddedChannel channel = new EmbeddedChannel(
                new FixedLengthFremeDecoder(3)
        );

        Assert.assertTrue(channel.writeInbound(input.retain()));
        Assert.assertTrue(channel.finish());

        ByteBuf read = (ByteBuf) channel.readInbound();
        Assert.assertEquals(buf.readSlice(3),read);
        read.release();

        read = (ByteBuf) channel.readInbound();
        Assert.assertEquals(buf.readSlice(3),read);
        read.release();

        read = (ByteBuf) channel.readInbound();
        Assert.assertEquals(buf.readSlice(3),read);
        read.release();

        Assert.assertNull(channel.readInbound());
        buf.release();
    }

    @Test
    public void testFramesDecoder2(){
        ByteBuf buf = Unpooled.buffer();
        for(int i=0;i<9;i++){
            buf.writeByte(i);
        }

        ByteBuf input = buf.duplicate();

        EmbeddedChannel channel = new EmbeddedChannel(
                new FixedLengthFremeDecoder(3));
        Assert.assertFalse(channel.writeInbound(input.readBytes(2)));
        Assert.assertTrue(channel.writeInbound(input.readBytes(7)));

        Assert.assertTrue(channel.finish());

        ByteBuf read = (ByteBuf) channel.readInbound();
        Assert.assertEquals(buf.readSlice(3),read);
        read.release();

        read = (ByteBuf) channel.readInbound();
        Assert.assertEquals(buf.readSlice(3),read);
        read.release();

        read = (ByteBuf) channel.readInbound();
        Assert.assertEquals(buf.readSlice(3),read);
        read.release();

        Assert.assertNull(channel.readInbound());
        buf.release();


    }

}
