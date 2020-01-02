package net.frank.demos.netty.action.ch13;

import java.net.InetSocketAddress;

public final class LogMsg {

    public static final byte SEPARATOR = (byte) ':';

    private final InetSocketAddress source;

    private final String msg;

    private final long msgId;

    private final long time;

    public LogMsg(String msg){
        this(null,msg,-1,System.currentTimeMillis());
    }

    public LogMsg(InetSocketAddress source, long msgId, String msg){
        this(source,msg,msgId,System.currentTimeMillis());
    }


    public LogMsg(InetSocketAddress source, String msg, long msgId, long time){
        this.source = source;
        this.msg = msg;
        this.msgId = msgId;
        this.time = time;
    }

    public InetSocketAddress getSource() {
        return source;
    }

    public String getMsg() {
        return msg;
    }

    public long getMsgId() {
        return msgId;
    }

    public long getTime() {
        return time;
    }
}
