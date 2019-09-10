package net.frank.llin.prototype;

import net.frank.llin.prototype.config.NettyConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class MainStartup {
    private transient  static Logger logger = LoggerFactory.getLogger(MainStartup.class);
    public static void main(String[] args) {
//        //处理netty连接配置
//        NettyConfig<?> nettyConfig;
//        ObjectMapper objectMapper = new ObjectMapper();
//        String nettyConfigJson = CommonUtil.initConfig("c5c6-config.json");
//        try {
//            nettyConfig = objectMapper.readValue(nettyConfigJson, NettyConfig.class);
//        }catch (IOException e){
//            logger.error(e.getMessage(),e);
//            return;
//        }
//        //全局变量
//        ConfigAware.setConfig(nettyConfig);
//        if(StringUtils.isNotBlank(nettyConfig.getGatewayId())) {
//            Thread.currentThread().setName(nettyConfig.getGatewayId());
//        }




    }


    private static String readConfigFile(String configFile){
        String configContent = "";
        try (Reader r = new InputStreamReader(
                Thread.currentThread().getContextClassLoader().getResource(configFile).openStream())) {
            char[] buffer = new char[8196];
            StringBuilder sb = new StringBuilder(8196);
            int flag;
            while ((flag = r.read(buffer)) != -1) {
                sb.append(buffer, 0, flag);
            }
            configContent = sb.toString();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return configContent;
    }


}
