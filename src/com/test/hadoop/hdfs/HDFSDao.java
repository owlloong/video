package com.test.hadoop.hdfs;

import java.io.IOException;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.yarn.api.protocolrecords.StartContainerRequest;

public class HDFSDao {
	private static HDFSDao hdfsDao = null;

	private static final String HDFS_URI = "hdfs://master:9000/";

	static {
		System.setProperty("HADOOP_USER_NAME", "icss");
		// 判断是否运行在 Windows 上，如果是才设置
		if (System.getProperty("os.name").toLowerCase().indexOf("windows") != -1)
			System.setProperty("hadoop.home.dir", "c:/dev/hadoop");
	}
	
	public static Configuration config(){
		Configuration conf = new Configuration();
		return conf;
	}

	public static HDFSDao getInstance() {
		if (hdfsDao == null)
			hdfsDao = 	new HDFSDao(HDFS_URI, config());
		return hdfsDao;
	}
	public static HDFSDao getInstance(Configuration conf) {
		if (hdfsDao  == null)
			hdfsDao = new HDFSDao(conf);
		return hdfsDao;
	}
	public static HDFSDao getInstance(String hdfsURI, Configuration conf) {
		if (hdfsDao  == null)
			hdfsDao = new HDFSDao(hdfsURI, conf);
		return hdfsDao;
	}
	
	private  HDFSDao(Configuration conf) {
		this(HDFS_URI, conf);
	}

	private HDFSDao(String hdfsURI, Configuration conf) {
		this.hdfsPath = hdfsURI;
		this.conf = conf;
	}

	private String hdfsPath;
	private Configuration conf;


	public void mkdirs(String folder) throws IOException {
		Path path = new Path(folder);
		FileSystem fs = FileSystem.get(URI.create(hdfsPath), conf);
		if (!fs.exists(path)) {
			fs.mkdirs(path);
			System.out.println("Create: " + folder);
		}
		fs.close();
	}

	public void rmr(String folder) throws IOException {
		Path path = new Path(folder);
		FileSystem fs = FileSystem.get(URI.create(hdfsPath), conf);
		fs.deleteOnExit(path);
		System.out.println("Delete: " + folder);
		fs.close();
	}

	public void ls(String folder) throws IOException {
		Path path = new Path(folder);
		FileSystem fs = FileSystem.get(URI.create(hdfsPath), conf);
		FileStatus[] list = fs.listStatus(path);
		System.out.println("ls: " + folder);
		System.out.println("==========================================================");
		for (FileStatus f : list) {
			//System.out.printf("name: %s, folder: %s, size: %d\n", f.getPath(), f.isDirectory(), f.getLen());
			System.out.printf("userId: %s, parentId: %s, num: %d\n", f.getPath(), f.isDirectory(), f.getLen());
		}
		System.out.println("==========================================================");
		fs.close();
	}

	public void createFile(String file, String content) throws IOException {
		FileSystem fs = FileSystem.get(URI.create(hdfsPath), conf);
		byte[] buff = content.getBytes();
		FSDataOutputStream os = null;
		try {
			os = fs.create(new Path(file));
			os.write(buff, 0, buff.length);
			System.out.println("Create: " + file);
		} finally {
			if (os != null)
				os.close();
		}
		fs.close();
	}

	public void copyFile(String local, String remote) throws IOException {
		FileSystem fs = FileSystem.get(URI.create(hdfsPath), conf);
		fs.copyFromLocalFile(new Path(local), new Path(remote));
		System.out.println("copy from: " + local + " to " + remote);
		fs.close();
	}

	public void download(String remote, String local) throws IOException {
		Path path = new Path(remote);
		FileSystem fs = FileSystem.get(URI.create(hdfsPath), conf);
		fs.copyToLocalFile(path, new Path(local));
		System.out.println("download: from" + remote + " to " + local);
		fs.close();
	}

	public void cat(String remoteFile) throws IOException {
		Path path = new Path(remoteFile);
		FileSystem fs = FileSystem.get(URI.create(hdfsPath), conf);
		FSDataInputStream fsdis = null;
		System.out.println("cat: " + remoteFile);
		try {  
			fsdis =fs.open(path);
			IOUtils.copyBytes(fsdis, System.out, 4096, false);  
		} finally {  
			IOUtils.closeStream(fsdis);
			fs.close();
		}
	}

	public static void main(String[] args) throws IOException {
		HDFSDao hdfsDao =HDFSDao.getInstance();
		hdfsDao.ls("/");
	}     
	
	
	public void location() throws IOException {
		// String folder = hdfsPath + "create/";
		// String file = "t2.txt";
		// FileSystem fs = FileSystem.get(URI.create(hdfsPath), new
		// Configuration());
		// FileStatus f = fs.getFileStatus(new Path(folder + file));
		// BlockLocation[] list = fs.getFileBlockLocations(f, 0, f.getLen());
		//
		// System.out.println("File Location: " + folder + file);
		// for (BlockLocation bl : list) {
		// String[] hosts = bl.getHosts();
		// for (String host : hosts) {
		// System.out.println("host:" + host);
		// }
		// }
		// fs.close();
	}
}
