package com.test.hadoop.hdfs;

import java.io.IOException;


import org.apache.hadoop.conf.Configuration;

public class TestHDFSDao {

	public static void main(String[] args) throws IOException {
		HDFSDao hdfsDao = HDFSDao.getInstance();
		hdfsDao.ls("/user/icss/testdata");

	}

}
