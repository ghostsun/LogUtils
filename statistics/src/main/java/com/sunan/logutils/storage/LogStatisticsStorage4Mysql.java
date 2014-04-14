package com.sunan.logutils.storage;

import java.util.Date;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.sunan.common.db.C3P0Utils;
import com.sunan.logutils.LogStatistics;

public class LogStatisticsStorage4Mysql implements LogStatisticsStorage {
	
	
	private static String insertFileTypeSQL = "insert into oa_log_file_type (filetype, count, time, date) values (?, ?, ?, ?)";
	
	private static String insertUrlSQL = "insert into oa_log_file_url (url, status, count, time, date) values (?, ?, ?, ?, ?)";
	

	@Override
	public void storage(Date date) throws Exception {


	DataSource ds = C3P0Utils.getDateSource();
		
			QueryRunner runner = new QueryRunner(ds, true);
	
			for (String fileType : com.sunan.logutils.LogStatistics.getFiletypemap().keySet()) {
					long count = LogStatistics.getFiletypemap().get(fileType)[0];
					long time = LogStatistics.getFiletypemap().get(fileType)[1];
					runner.update(insertFileTypeSQL, new Object[]{fileType, count, time, date});

			}
	
			for (String url : LogStatistics.getUrlmap().keySet()) {
					Map<String, long[]> statusMap = LogStatistics.getUrlmap().get(url);
					if(url.length() > 500){
						System.out.println(url);
						continue;
					}
					for (String status : statusMap.keySet()) {
						long count = statusMap.get(status)[0];
						long time = statusMap.get(status)[1];
						runner.update(insertUrlSQL, new Object[]{url, status, count, time, date});
					}
			}
	}

}
