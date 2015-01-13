package com.game.scoket.base;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class DiscardServerHandler extends ChannelInboundHandlerAdapter{

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
//		ByteBuf in = (ByteBuf) msg;
//	    try {
//	        while (in.isReadable()) { // (1)
//	            System.out.print((char) in.readByte());
//	            System.out.flush();
//	        }
//	    } finally {
//	        ReferenceCountUtil.release(msg); // (2)
//	    }
		ctx.write(msg); 
        ctx.flush(); 
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		// Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
	}

}
