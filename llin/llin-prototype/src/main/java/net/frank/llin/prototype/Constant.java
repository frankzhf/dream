package net.frank.llin.prototype;

public interface Constant {

    interface Protocol{
        byte TCP = 0;
        byte UDP = 1;
    }
    //消息类型
    interface PacketType{
        int manage = 0;//管理消息 – 比如中控中的服务参数 ,暂保留
        int down = 1;//下行设备信息 是指云平台下放到mqtt服务器的消息，中控服务将解析这些消息后，转成设备协议，发给指的设备服务
        int up = 2;//上行设备信息 是指中控收到设备或设备服务发送来的消息后，转成mqtt消息发送给云平台，这类消息又分为正常消息和设备主动报警
    }

    //上行消息2的通知类别
    interface NoticeType{
        int heartbeat = 0;//设备心跳
        int normal = 1;//正常数据上报
        int alarm = 2;//设备警报
    }

    interface DeviceStatus{
        int init = -1;//初始化
        int on_line = 0;//在线
        int off_line = 1;//离线
    }
}
