package com.sunan.logutils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sunan.logutils.bean.LogLine;
import com.sunan.logutils.bean.SourceLine;
import com.sunan.logutils.filter.FileTypeLogFilter;
import com.sunan.logutils.filter.FilterChain;
import com.sunan.logutils.filter.UrlStatusLogFilter;
import com.sunan.logutils.storage.LogStatisticsStorage;
import com.sunan.logutils.storage.LogStatisticsStorage4Mysql;


public class LogMain {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		FilterChain<LogLine> filterChain = new FilterChain<LogLine>();
		filterChain.add(new FileTypeLogFilter());
		filterChain.add(new UrlStatusLogFilter());
		
		LogProcess<SourceLine> process = new IISLogProcess();
		
		Date date = null;
		SimpleDateFormat sdf  =   new  SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ); 
		long start = System.currentTimeMillis();

		String fileName = "D:\\work\\dbn\\log\\u_ex140320.log";
		long index = 0;

		/**
		 * 使用缓冲流
		 */
		BufferedReader buffer = null;

		/**
		 * 每行字符的临时存储
		 */
		String line = null;
		/**
		 * 读取文件
		 */
		buffer = new BufferedReader(new FileReader(fileName));

		/**
		 * 循环按行读取数据
		 */
		while ((line = buffer.readLine()) != null) {
			LogLine logLine = null;
			try {
				if(index == 2){
					String[] lineArray = line.split(" ");
					date = sdf.parse(lineArray[1] + " " + lineArray[2]);
				}
				logLine = process.process(new SourceLine(index++, line));
				filterChain.doFilter(logLine);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		LogStatisticsStorage lsStorage = new LogStatisticsStorage4Mysql();
		lsStorage.storage(date);
		

	}

}
