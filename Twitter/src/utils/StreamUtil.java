package utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;

public class StreamUtil {

	public static void copy(java.io.InputStream binaryStream,ByteArrayOutputStream baos) {
		byte[] buffer = new byte[4096];
		try {
			for(int n = 0; -1 !=(n = binaryStream.read(buffer));) {
				baos.write(buffer,0,n);
			}
		}catch(IOException e) {
			throw new IORuntimeException();
		}
	}



	public static void copy(ByteArrayInputStream bais, ServletOutputStream outputStream) {

	}

	public static void copy1(java.io.InputStream binaryStream, ByteArrayOutputStream baos) {

	}

}
