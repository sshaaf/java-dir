package org.acme;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.InputStream;



@Path("/files")
public class FileRecieverResource {

    @ConfigProperty(name = "upload.path")
    public String PATH;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }

    @POST
    @Path("upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public String getFile(InputStream inputStream) throws Exception{

        System.out.println(new String(inputStream.readAllBytes()));
        return "File uploaded";
    }


}