package net.frank.demos.netty.action.ch09;

import org.junit.Test;
import org.junit.Assert;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;

public class AbsIntegerEncoderTest {

	@Test
	public void testEncoder() {
		ByteBuf buf = Unpooled.buffer();
		for(int i=1;i<10;i++) {
			buf.writeInt(i*-1);
		}
		
		EmbeddedChannel channel = new EmbeddedChannel(
				new AbsIntegerEncoder());
		
		Assert.assertTrue(channel.writeOutbound(buf));
		Assert.assertTrue(channel.finish());
		
		for(int i=1;i<10;i++) {
			Assert.assertEquals(i, channel.readOutbound());
		}
		
	}

}
