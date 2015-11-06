package io.pivotal.flyway;



import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;
import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.cloud.service.ServiceInfo;
import org.springframework.cloud.service.common.MysqlServiceInfo;



@SpringBootApplication
public class FlydbmigrateApplication {
	static Logger logger = Logger.getLogger(FlydbmigrateApplication.class);
    public static void main(String[] args) {
    	
    	Cloud cloud = new CloudFactory().getCloud();
    	Iterator<ServiceInfo> services = cloud.getServiceInfos().iterator();
    	//Map<String, Object> credentials = null;
    	String host ="";
    	String dbName = "";
    	String Uname = "";
    	String Pword = "";
    	
    	while (services.hasNext()){
    		ServiceInfo svc = services.next();
    		if (svc instanceof MysqlServiceInfo) {
    			MysqlServiceInfo service = (MysqlServiceInfo)svc;
    		 host = service.getHost();
    		 dbName = service.getPath();
    		 Uname = service.getUserName();
    		 Pword = service.getPassword();
    		 
    		// logger.info(service.getQuery());
    	//	 logger.info(service.getUri());
    //		 logger.info(service.getUriInfoFactory());
    		}
    		}
    	
    	Flyway flyway = new Flyway();
    	logger.info(dbName);
    	
    	String url = "jdbc:mysql://"+host+":3306/"+dbName;
    	logger.info(url);
    	
        

		// Point it to the database
		/*flyway.setDataSource("jdbc:mysql://10.68.52.27:3306/cf_d812368f_7b44_4c97_b956_30b0d4fc0369",
				"6tgNuwNxu81lrJ5y", "ZvmzHQsX9o35tnjh");*/
		flyway.setDataSource(url,Uname, Pword);
		
		
		// flyway.clean();
		flyway.setBaselineOnMigrate(true);
		// Start the migration

		flyway.migrate();
		
    }
}
