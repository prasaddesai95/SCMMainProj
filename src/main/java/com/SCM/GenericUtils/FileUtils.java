package com.SCM.GenericUtils;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtils {

	/**
	 * this method is used to read the data from property file
	 * @author Prasad
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromPropertyFile(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstant.FilePath);
		Properties pro = new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		return value;
		
	}
}
