package net.frank.demos.logback;

import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

/**
 * @author zhaofeng
 */

public class UpdAppender extends AppenderBase<ILoggingEvent> {
    private PatternLayoutEncoder encoder;
    private int port;
    //private String ip;
    private DatagramSocket socket;

    public UpdAppender(){
        //this.ip = "localhost";
        this.port = 5070;
    }

    @Override
    protected void append(ILoggingEvent event) {
        byte[] buf = encoder.getLayout().doLayout(event).trim().getBytes(StandardCharsets.UTF_8);
        try{
            InetAddress address = InetAddress.getByName("localhost");
            DatagramPacket packet = new DatagramPacket(buf,buf.length,
                    address,port);
            socket.send(packet);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public PatternLayoutEncoder getEncoder(){
        return encoder;
    }

    public void setPatternLayoutEncoder(PatternLayoutEncoder encoder){
        this.encoder = encoder;
    }

    public int getPort(){
        return port;
    }

    public void setPort(int port){
        this.port = port;
    }

    @Override
    public void start() {
        if(this.encoder == null){
            addError("No layout of udp appender");
            return;
        }
        if(socket == null){
            try{
                socket = new DatagramSocket(port);
            }catch (SocketException e){
                e.printStackTrace();
            }
        }
        super.start();
    }

    @Override
    public void stop() {
        if(socket!=null && !socket.isClosed()){
            socket.close();
        }
        super.stop();
    }
}