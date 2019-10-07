import com.gurus.micro.ApiConfig;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

public class ApplicationMain {



  public static void main(String[] args) {

    String port = System.getenv("PORT");
    if (port == null || port.isEmpty()) {
      port = "8089";
    }

    Server server = new Server(Integer.valueOf(port));
    ServletContextHandler context = new ServletContextHandler(server, "/");

    ServletHolder servlet = new ServletHolder("RestTester ",
        new ServletContainer(new ApiConfig()));
    context.addServlet(servlet, "/api/*");


      try {
        server.start();
        server.join();
      } catch (Exception e) {
        e.printStackTrace();
      }
     finally {
      server.destroy();
    }

  }
}
