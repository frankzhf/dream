package net.frank.demos.netty.action.ch13;

import java.util.Random;

public class LogConst {

    public final static int MONITOR_SIDE_PORT = 9998;

    private static final String[] LOG_INFOS = {
            "20180912:mark-machine: Send sms to 10001",
            "20180912:lison-machine: Send email to james@enjoyedu",
            "20180912:james-machine: Happen Exception",
            "20180912:peter-machine:人生不能象做菜，把所有的料都准备好了才下锅",
            "20180912:deer-machine: 牵着你的手，就象左手牵右手没感觉，但砍下去也会痛！"
    };

    private final static Random r = new Random();

    public static String getLogInfo(){
        return LOG_INFOS[r.nextInt(LOG_INFOS.length-1)];
    }

}
