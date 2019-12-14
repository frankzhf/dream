package net.frank.demos.netty.action.ch10;

import io.netty.channel.CombinedChannelDuplexHandler;

public class CombinedByteCharCodec extends CombinedChannelDuplexHandler<ByteToCharDecoder,CharToByteEncoder> {

    public CombinedByteCharCodec(){
        super(new ByteToCharDecoder(), new CharToByteEncoder());
    }

}
