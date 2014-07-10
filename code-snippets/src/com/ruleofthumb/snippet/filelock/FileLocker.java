package com.ruleofthumb.snippet.filelock;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLocker {
	public static void main(String args[]) throws Exception {
		// Get a file channel for the file
		File file = new File("C:\\MYFILELOCK.txt");
		FileChannel channel = new RandomAccessFile(file, "rw").getChannel();
		System.out.println("Channel initiated.");
		FileLock lock = channel.tryLock();
		if (lock != null) {
			System.out.println("File is locked now.");
			System.out.println("Lock acquired. Wait for 5 minutes ...");
			Thread.sleep(300000);
		}

		// Release the lock
		lock.release();
		System.out.println("Lock released.");
		channel.close();
	}
}
