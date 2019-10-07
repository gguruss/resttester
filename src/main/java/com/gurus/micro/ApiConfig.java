package com.gurus.micro;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;


public class ApiConfig extends ResourceConfig {

  public ApiConfig()
  {
    packages("com.gurus.micro");
  }
}
