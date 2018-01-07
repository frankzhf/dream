package net.frank.corejava0.netty.ch08;

import java.util.ArrayList;
import java.util.List;

import com.google.protobuf.InvalidProtocolBufferException;

import net.frank.corejava0.netty.ch08.protobuf.SubscribeProto.SubscribeReq;

public class TestSubscribeReqProto {

	public static void main(String[] args) throws InvalidProtocolBufferException{
		SubscribeReq req = createSubscribeReq();
		System.out.println("Before encode:" + req.toString());
		SubscribeReq req2 = decode(encode(req));
		System.out.println("Before encode:" + req.toString());
		System.out.println("Assert equal: --> " + req2.equals(req));
		
	}
	
	private static byte[] encode(SubscribeReq req) {
		return req.toByteArray();
	}
	
	private static SubscribeReq decode(byte[] body)
		throws InvalidProtocolBufferException {
		return SubscribeReq.parseFrom(body);
	}
	
	private static SubscribeReq createSubscribeReq() {
		List<String> address = new ArrayList<String>();
		address.add("NanJing YuHuaTai");
		address.add("BeiJing LiuliChang");
		address.add("ShenZhen HongShuLin");
		return 
		SubscribeReq.newBuilder().setSubReqId(1)
			.setUserName("frank")
			.setProductName("Netty")
			.addAllAddress(address)
			.build();
		
	}
	
}
