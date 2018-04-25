package utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;

import org.omg.CORBA.portable.InputStream;

public class StreamUtil {

	public static void copy(InputStream is,ByteArrayOutputStream baos) {
		byte[] buffer = new byte[4096];
		try {
			for(int n = 0; -1 !=(n = is.read(buffer));) {
				baos.write(buffer,0,n);
			}
		}catch(IOException e) {
			throw new IORuntimeException();
		}
	}

	public static void copy1(InputStream is, ByteArrayOutputStream baos) {


	}

	public static void copy(ByteArrayInputStream bais, ServletOutputStream outputStream) {

	}

	public static void copy1(ByteArrayInputStream bais, ServletOutputStream outputStream) {

	}

}
