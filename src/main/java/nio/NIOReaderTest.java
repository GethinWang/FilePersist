package nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Create by Gethin Wang on 2019/5/16
 * 读取，读取TXT文件
 */

public class NIOReaderTest {

    public static void main(String args[]) {
        try {
            RandomAccessFile aFile = new RandomAccessFile("C:\\Users\\10007886\\Desktop\\nio.txt", "rw");
            FileChannel inChannel = aFile.getChannel();

            //create buffer with capacity of 48 bytes
            ByteBuffer buf = ByteBuffer.allocate(48);

            int bytesRead = inChannel.read(buf); //read into buffer.
            while (bytesRead != -1) {

                buf.flip();  //make buffer ready for read

                while(buf.hasRemaining()){
                    System.out.print((char) buf.get()); // read 1 byte at a time
                }

                buf.clear(); //make buffer ready for writing
                bytesRead = inChannel.read(buf);
            }
            aFile.close();
        }catch (Exception e){
            System.err.println("NIN exception");
        }
    }
}


