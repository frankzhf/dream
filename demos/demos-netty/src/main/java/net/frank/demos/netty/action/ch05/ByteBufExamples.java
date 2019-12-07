package net.frank.demos.netty.action.ch05;

import io.netty.buffer.*;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.nio.NioSocketChannel;

import static  io.netty.channel.DummyChannelHandlerContext.DUMMY_INSTANCE;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Random;

public class ByteBufExamples {
    private final static Random random = new Random();
    private final static ByteBuf BYTE_BUF_FROM_SOMEWHERE = Unpooled.buffer(1024);
    private final static Channel CHANNEL_FROM_SOMEWHERE = new NioSocketChannel();
    private final static ChannelHandlerContext CHANNEL_HANDLER_CONTEXT_FROM_SOMEWHERE = DUMMY_INSTANCE;

    /**
     * 堆缓冲区
     */
    public static void heapBuffer(){
        ByteBuf heapBuf = BYTE_BUF_FROM_SOMEWHERE;
        if(heapBuf.hasArray()){//判断bytebuf是滞有一个数组支持
            byte[] array = heapBuf.array();
            int offset = heapBuf.arrayOffset() + heapBuf.readerIndex(); //计算第一个字节的偏移量
            int length = heapBuf.readableBytes();//获取可读的字节数
            handlerArray(array, offset,length);
        }
    }

    /**
     * 直接缓冲区
     */
    public static void directBuffer(){
        ByteBuf directBuf = BYTE_BUF_FROM_SOMEWHERE;
        if(!directBuf.hasArray()){
            int length = directBuf.readableBytes();
            byte[] array = new byte[length];
            directBuf.getBytes(directBuf.readerIndex(),array);
            handlerArray(array,0,length);
        }
    }

    /***
     * JDK复合缓冲区
     */
    public static void byteBufferComposite(ByteBuffer header, ByteBuffer body){
        ByteBuffer [] message = new ByteBuffer[]{header,body};

        ByteBuffer message2 = ByteBuffer.allocate(header.remaining() + body.remaining());
        message2.put(header);
        message2.put(body);
        message2.flip();//反转此缓冲区并丢弃标记

    }

    /***
     *  使用CompositeByteBuf的复合缓冲区模式
     */
    public static void byteBufComposite(){
        CompositeByteBuf messageBuf = Unpooled.compositeBuffer();
        ByteBuf headerBuf = BYTE_BUF_FROM_SOMEWHERE;
        ByteBuf bodyBuf = BYTE_BUF_FROM_SOMEWHERE;
        messageBuf.addComponents(headerBuf,bodyBuf);
        messageBuf.removeComponent(0);  //删除了header
        for(ByteBuf buf : messageBuf){
            System.out.println(buf.toString());
        }
    }

    /***
     * 复合缓冲区的访问
     */
    public static void byteBufCompositeArray(){
        CompositeByteBuf compBuf = Unpooled.compositeBuffer();
        int len = compBuf.readableBytes();
        byte[] array = new byte[len];
        compBuf.getBytes(compBuf.readerIndex(),array);
        handlerArray(array,0, array.length);
    }

    /**
     * ByteBuf所有的数据
     */
    public static void byteBufRelativeAccess(){
        ByteBuf buffer = BYTE_BUF_FROM_SOMEWHERE;
        for(int i=0;i<buffer.capacity();i++){
            byte b = buffer.getByte(i);
            //buffer.setByte(i, (byte) 0);
            System.out.println((char)b);
        }
    }

    /***
     * 读取所有数据
     */
    public static void readAllData(){
        ByteBuf buffer = BYTE_BUF_FROM_SOMEWHERE;
        while(buffer.isReadable()){
            System.out.println(buffer.readByte());
        }
    }

    /***
     * 只要还有大于等于4个字节的可写容量，就写一个随机int
     */
    public static void write(){
        ByteBuf buffer = BYTE_BUF_FROM_SOMEWHERE;
        while(buffer.writableBytes() >=4 ){
            buffer.writeInt(random.nextInt());
        }
    }


    /**
     * 查找 \r 字符的下标
     */
    public static void byteProcessor(){
        ByteBuf buffer = BYTE_BUF_FROM_SOMEWHERE;
        //4.1以下版本有  ByteProcessor.FIND_CR
        int index = buffer.forEachByte(ByteBufProcessor.FIND_CR);
    }

    /**
     * 缓冲区切片
     */
    public static void byteBufSlice(){
        Charset utf8 = Charset.forName("UTF-8");
        ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks!",utf8);
        ByteBuf sliced = buf.slice(0,15); //结果 sliced = "Netty in Action"
        System.out.println(sliced.toString(utf8));
        buf.setByte(0,(byte)'J');
        assert buf.getByte(0) == sliced.getByte(0); //数据是共享的，对一个一修改，会影响另一个
    }

    /**
     * 缓冲区复制
     */
    public static void byteBufCopy(){
        Charset utf8 = Charset.forName("UTF-8");
        ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks!",utf8);
        ByteBuf copy = buf.copy(0,15);
        System.out.println(copy.toString(utf8));
        buf.setByte(0,(byte)'J');
        assert buf.getByte(0)!=copy.getByte(0);
    }

    /**
     * get/set方法不会改变读写索引
     */
    public static void byteBufSetGet(){
        Charset utf8 = Charset.forName("UTF-8");
        ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks",utf8);
        System.out.println((char)buf.getByte(0));
        int readerIndex = buf.readerIndex();
        int writerIndex = buf.writerIndex();
        System.out.println("Variable [readerIndex] -> " + readerIndex);
        System.out.println("Variable [writerIndex] -> " + writerIndex);
        buf.setByte(0,(byte)'B');
        System.out.println((char)buf.getByte(0));
        assert readerIndex == buf.readerIndex();
        assert writerIndex == buf.writerIndex();
    }

    /**
     * read and write will change each index
     */
    public static void byteBufWriteRead(){
        Charset utf8 = Charset.forName("UTF-8");
        ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks",utf8);
        System.out.println((char)buf.readByte());
        int readerIndex = buf.readerIndex();
        int writerIndex = buf.writerIndex();

        buf.writeByte((byte)'?');
        assert readerIndex == buf.readerIndex();
        assert writerIndex != buf.writerIndex();
    }

    public static void handlerArray(byte[] array, int offset, int len){}


    /***
     * 获得ByteBuf分配器
     */
    public static void obtainingByteBufAllocatorReference(){
        Channel channel = CHANNEL_FROM_SOMEWHERE;
        ByteBufAllocator allocator0 = channel.alloc();
        ChannelHandlerContext ctx = CHANNEL_HANDLER_CONTEXT_FROM_SOMEWHERE;
        ByteBufAllocator allocator1 = ctx.alloc();
    }

    /***
     * 引用计数
     */
    public static void referenceCounting(){
        Channel channel = CHANNEL_FROM_SOMEWHERE;
        ByteBufAllocator allocator = channel.alloc();
        ByteBuf buffer = allocator.directBuffer();
        assert  buffer.refCnt() == 1;
    }

    public static void releaseReferenceCountedObject(){
        ByteBuf buffer = BYTE_BUF_FROM_SOMEWHERE;
        boolean released = buffer.release();
    }



    public static void main(String[] args){
        byteBufSetGet();
    }
}
