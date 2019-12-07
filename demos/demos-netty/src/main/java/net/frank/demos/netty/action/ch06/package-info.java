/**
 * @author zhaofeng
 *
 */
package net.frank.demos.netty.action.ch06;


/**
 * Channel的生命周期
 * ChannnelUnregistered					已经被创建，但还未注册到EventLoop
 * ChannelRegistered					已经被注册到EventLoop
 * ChannelActive						处于活动状态。可以接收和发送数据
 * ChannelInactive						没有连接到远程节点
 * 
 * ChannelHandler的生命周期
 * handlerAdded							添加到ChannelPipeline中调用
 * handlerRemoved						移除时被调用
 * exceptionCaught						出现错误时被调用
 * 
 * ChannelInboundHandler的方法
 * channelRegistered
 * channelUnregistered
 * channelActive
 * channelInactive
 * channelReadComplete					
 * channelRead
 * ChannelWritabilityChanged
 * userEventTriggered
 * 
 * ChannelOutboundHandler的方法
 * bind(ChannelHandlerContext, SocketAddress, ChannelPromise)
 * connect(ChannelHandlerContext, SocketAddress, SocketAddress, ChannelPromise)
 * disconnect(ChannelHandlerContext, ChannelPromise)
 * close(ChannelHandlerContext, ChannelPromise)
 * read(ChannelHandlerContext)
 * flush(ChannelHandlerContext)
 * write(ChannelHandlerContext, Object, ChannelPromise)
 * 
 * ChannelPipeline入站操作
 * fireChannelRegistered
 * fireChannelUnregistered
 * fireChannelAction
 * fireChannelInaction
 * fireExceptionCaught
 * fireUserEventTriggered
 * fireChannelRead
 * fireChannelReadComplete
 * fireConnelWritabilityChanged
 * 
 * ChannelPipeline出站操作
 * bind
 * connect
 * disconnect
 * close
 * deregister
 * flush
 * write
 * writeAndFlush
 * read
 * 
 * ChannelHandlerContext的api
 * alloc
 * bind
 * channel
 * close
 * connect
 * deregister
 * disconnect
 * executor
 * fireChannelActive
 * fireChannelInactive
 * fireChannelRead
 * fireChannelReadComplete
 * fireChannelRegistered
 * fireChannelUnregistered
 * fireChannelWritilityChanged
 * fireExceptionCaught
 * fireUserEventTriggered
 * handler
 * isRemove
 * name
 * pipeline
 * read
 * write
 * writeAndFlush
 * 
 * 
 * 
 * 
 */

