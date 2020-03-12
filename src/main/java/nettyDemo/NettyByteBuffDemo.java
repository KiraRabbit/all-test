package nettyDemo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class NettyByteBuffDemo {
    public static void main(String[] args) {
        ByteBuf buf = Unpooled.buffer(15);
        String content = "1234567890";
        buf.writeBytes(content.getBytes());
        byte b = buf.readByte();
        System.out.println(b);
        byte c = buf.readByte();
        System.out.println(c);
        byte d = buf.readByte();
        System.out.println(d);

    }
}
