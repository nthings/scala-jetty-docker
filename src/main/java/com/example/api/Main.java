package com.example.api;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;


public class Main {

    public static void main(String[] args) {
        startServer();
    }

    public static void startServer() {
        System.out.println("<<<<< Starting Embedded Jetty Service >>>>>");

        Server server = new Server(8080);
        ServletContextHandler servletContextHandler = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);

        servletContextHandler.setContextPath("/");
        server.setHandler(servletContextHandler);

        ServletHolder servletHolder =
                servletContextHandler.addServlet(ServletContainer.class, "/rest/*");
        /* servlet init order - 0 refers init On Startup */
        servletHolder.setInitOrder(0);
        /* servlet init order - 0 refers init On Startup */
        servletHolder.setInitOrder(0);

        servletHolder.setInitParameter("jersey.config.server.provider.packages",
                "com.example.api");

        try {
            server.start();
            server.join();
        } catch (Exception ex) {
            System.out.println("Error occurred while starting Jetty" +ex);
        }

        finally {
            try {
                server.stop();
                server.destroy();
            } catch (Exception e) {
                System.out.println("Error during server starting " +e);
            }
        }

    }
}