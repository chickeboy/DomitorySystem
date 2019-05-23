package Dormitory.Util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Close {
	ObjectInputStream objectInputStream ;
	ObjectOutputStream objectOutputStream;
	
	public Close(ObjectInputStream objectInputStream, ObjectOutputStream objectOutputStream) {
		super();
		this.objectInputStream = objectInputStream;
		this.objectOutputStream = objectOutputStream;
	}

	public void close() {
		if (objectInputStream != null) {
			try {
				objectInputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (objectOutputStream != null) {
			try {
				objectOutputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
