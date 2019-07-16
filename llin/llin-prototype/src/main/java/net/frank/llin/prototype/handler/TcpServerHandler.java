package net.frank.llin.prototype.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import net.frank.llin.prototype.Constant;
import net.frank.llin.prototype.config.ConfigHolder;
import net.frank.llin.prototype.config.CoreDemon;
import net.frank.llin.prototype.config.DeviceRuntime;
import net.frank.llin.prototype.config.NettyConfig;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public abstract class TcpServerHandler extends ChannelInboundHandlerAdapter {

    protected transient Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        String socketAddress = ctx.channel().remoteAddress().toString();
        socketAddress = socketAddress.substring(0, socketAddress.indexOf(":"));
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
                        registHocker(socketAddress,ConfigHolder.getConfig(),selected);
                    }else {
                        log.warn("Not config the device. its socket address is " +  socketAddress);
                    }
                }
            }
            DeviceRuntime runtime = CoreDemon.getRuntime(socketAddress);
            if(runtime!=null) {
                runtime.setStatus(Constant.DeviceStatus.on_line);
                runtime.setUpdated(System.currentTimeMillis());
            }
        }
    }

    protected void registHocker(String socketAddress, NettyConfig<?> config, DeviceRuntime runtime) {

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String socketAddress = ctx.channel().remoteAddress().toString();
        socketAddress = socketAddress.substring(0, socketAddress.indexOf(":"));
        DeviceRuntime runtime = CoreDemon.getRuntime(socketAddress);
        if(runtime!=null) {//没有注册的设备 就不处理
            runtime.setUpdated(System.currentTimeMillis());
            if(runtime.getStatus() == Constant.DeviceStatus.off_line ) {//实时离线，现在又信息发来了
                DeviceRuntime clone  = null;
                synchronized (runtime) {
                    runtime.setStatus(Constant.DeviceStatus.on_line);
                    clone  = runtime.clone();
                }
                runtime.setPrevAlarmId(null);
                if(clone!= null) {
                    /***
                    AlarmResolveTask runnable = new AlarmResolveTask(clone);
                    new Thread(runnable).start();
                     ***/
                }
            }
            handleMessage(ctx,msg,runtime);
        }
    }

    public abstract void handleMessage(ChannelHandlerContext ctx, Object msg, DeviceRuntime runtime);

}