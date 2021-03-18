package geolocation.demo.service;

import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import geolocation.demo.manager.GeolocationManagerLocal;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.google.maps.GaeRequestHandler;

import java.io.IOException;

@Path("/geocode")
public class GeolocationService {
    private static String GEO_CODE_API_KEY = "YOUR GOOGLE GEOCODE KEY";

    @Context
    HttpServletRequest request;
    @EJB
    GeolocationManagerLocal geolocationManager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGeocode(@QueryParam("address") String address) throws InterruptedException, ApiException, IOException {

        GeoApiContext context = new GeoApiContext.Builder().apiKey(GEO_CODE_API_KEY).build();

        String result = geolocationManager.getGeocode(context, address);

        return Response.ok(result).build();
    }

}
