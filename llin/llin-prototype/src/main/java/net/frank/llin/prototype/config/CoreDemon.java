package net.frank.llin.prototype.config;


import java.util.Map;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.util.concurrent.GlobalEventExecutor;
import io.netty.util.internal.PlatformDependent;
import net.frank.llin.mqtt.MqttClient;
import net.frank.llin.prototype.Constant;
import net.frank.llin.server.SimpleChannelGroup;

public final class CoreDemon {

    private static SimpleChannelGroup channelGroup = new SimpleChannelGroup(GlobalEventExecutor.INSTANCE);

    private static Map<String, MqttClient> mqttMap = PlatformDependent.newConcurrentHashMap();

    private static Map<String,DeviceRuntime> runtimes = PlatformDependent.newConcurrentHashMap();

    private CoreDemon() {
    }

    public interface Constants {
        interface DELIMITER {
            String STRING = "\r";
            ByteBuf BYTEBUF = Unpooled.copiedBuffer(STRING.getBytes());
        }
        interface SPACE {
            String STRING = " ";
        }
        interface BLANK{
            String STRING = "";
            ByteBuf BYTEBUF = Unpooled.copiedBuffer(STRING.getBytes());
        }
    }


    public static void joinChannel(String key,Channel channel) {
        channelGroup.add(key, channel);
    }

    public static void removeChannel(String key) {
        channelGroup.remove(key);
    }

    public static Channel findChannel(String key) {
        return channelGroup.find(key);
    }

    public static Channel[] all(){
        Channel[] rt = new Channel[channelGroup.size()];
        channelGroup.toArray(rt);
        return rt;
    }

    public static MqttClient findMqttClient(String key) {
        return mqttMap.get(key);
    }

    public static void joinMqttClient(String key,MqttClient client) {
        mqttMap.put(key, client);
    }

    public static void removeMqttClient(String key) {
        mqttMap.remove(key);
    }


    public static void joinRuntime(String commId,DeviceRuntime deviceRuntime) {
        deviceRuntime.setStatus(Constant.DeviceStatus.on_line);
        runtimes.put(commId, deviceRuntime);
    }

    public static DeviceRuntime getRuntime(String commId) {
        return runtimes.get(commId);
    }

}