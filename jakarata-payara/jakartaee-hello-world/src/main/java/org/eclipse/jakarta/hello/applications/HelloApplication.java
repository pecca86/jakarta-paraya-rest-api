package org.eclipse.jakarta.hello.applications;

import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.ApplicationPath;

@ApplicationPath("rest")
// MicroProfile Config
//@DataSourceDefinition(
//        name = "java:app/jdbc/mylocal_postgres",
//        className = "org.postgresql.ds.PGSimpleDataSource",
//        serverName = "localhost",
//        user = "postgres",
//        password = "postgres",
//        portNumber = 5432
//)
public class HelloApplication extends Application {
    
}
