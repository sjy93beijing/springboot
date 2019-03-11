package com.sjy.springboot.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.util.Date;


/**
 * @author sjy on 2019/3/11
 * @version 1.0
 */
public class TcpServerHandler extends ChannelInboundHandlerAdapter {
    private final static Logger logger = LoggerFactory.getLogger(TcpServerHandler.class);

    /**
     * 收到消息后，返回信息
     * @param channelHandlerContext
     * @param s
     * @throws Exception
     */
    private int counter;

//    @Override
//    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
//        System.out.println("服务端接受的消息 : " + msg);
//        if("quit".equals(msg)){//服务端断开的条件
//            ctx.close();
//        }
//        Date date=new Date();
//        // 返回客户端消息
//        ctx.writeAndFlush(date+"\n");
//    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf result = (ByteBuf) msg;
        byte[] result1 = new byte[result.readableBytes()];
        result.readBytes(result1);
        String resultStr = new String(result1);
        String data = resultStr; //接受并打印客户端的消息
        logger.info("客户端开始读数据"+data);
        result.release();
        if("quit".equals(msg)){//服务端断开的条件
            ctx.close();
        }
        Date date=new Date();
        // 返回客户端消息
        ctx.writeAndFlush(date+"\n");
    }



    /**
     * 建立连接时，返回消息
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        logger.info("连接的客户端地址："+ctx.channel().remoteAddress());
        ctx.writeAndFlush("客户端"+ InetAddress.getLocalHost().getHostName() + "成功与服务端建立连接！ \n");
        super.channelActive(ctx);
    }

    /**
     * 连接不活跃的时候
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        logger.info("连接不活跃的设备"+ctx.channel().remoteAddress()+"name:"+InetAddress.getLocalHost().getHostName());
        super.channelInactive(ctx);
    }
}