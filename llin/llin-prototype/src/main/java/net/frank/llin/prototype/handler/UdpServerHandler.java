package net.frank.llin.prototype.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import net.frank.llin.prototype.Constant;
import net.frank.llin.prototype.config.ConfigHolder;
import net.frank.llin.prototype.config.CoreDemon;
import net.frank.llin.prototype.config.DeviceRuntime;
import net.frank.llin.prototype.config.NettyConfig;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.util.List;

public abstract class UdpServerHandler extends SimpleChannelInboundHandler<DatagramPacket>{

    protected transient Logger log = LoggerFactory.getLogger(getClass());

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket packet) throws Exception {
        InetSocketAddress address = packet.sender();
        String socketAddress = address.toString();
        if(StringUtils.isNotBlank(socketAddress)) {
            if(CoreDemon.getRuntime(socketAddress) == null) {
                synchronized (this) {
                    log.debug("Device ["+socketAddress+"] 's device first sent message!");
                    //Warehouse warehouse = ConfigHolder.getConfig().getModel();
                    List<DeviceRuntime> runtimes =  ConfigHolder.getConfig().getRuntimes();
                    DeviceRuntime selected = null;
                    if(runtimes!=null &&
                            !runtimes.isEmpty()) {
                        for(int i=0;i<runtimes.size();i++) {
                            DeviceRuntime item = runtimes.get(i);
                            if(socketAddress.equals(item.getSocketAddress())) {
                                selected = item;
                                break;
                            }
                        }
                    }
                    if(selected !=null) {
                        CoreDemon.joinRuntime(socketAddress, selected);
                        registHocker(socketAddress,ConfigHolder.getConfig(),selected,ctx);
                    }else {
                        log.warn("Not config the device. its socket address is " +  socketAddress);
                    }
                }
            }
            DeviceRuntime runtime = CoreDemon.getRuntime(socketAddress);
            if(runtime!=null) {//没有注册的设备 就不处理
                runtime.setUpdated(System.currentTimeMillis());
                if(runtime.getStatus() == Constant.DeviceStatus.off_line ) {//实时离线，现在又信息发来了
                    DeviceRuntime clone  = null;
                    synchronized (runtime) {
                        runtime.setStatus(Constant.DeviceStatus.on_line);
                        clone  = runtime.clone();
                    }

                    /*** 重连
                    runtime.setPrevAlarmId(null);
                    if(clone!= null) {

                        AlarmResolveTask runnable = new AlarmResolveTask(clone);
                        new Thread(runnable).start();
                    }
                     **/
                }
                byte[] msg = new byte[packet.content().readableBytes()];
                packet.content().readBytes(msg);
                handleMessage(ctx,runtime,msg,address);
            }
        }
    }

    //注册后的进一步处理，不是每种设备都需要，门磁要重写
    protected void registHocker(String socketAddress, NettyConfig config, DeviceRuntime runtime, ChannelHandlerContext ctx) {

    }

    public abstract void handleMessage(ChannelHandlerContext ctx, DeviceRuntime runtime, byte[] msg,InetSocketAddress address);
}
