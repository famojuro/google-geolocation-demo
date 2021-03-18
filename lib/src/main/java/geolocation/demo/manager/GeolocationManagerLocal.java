package geolocation.demo.manager;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApiRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.model.LatLng;

import java.io.IOException;

public interface GeolocationManagerLocal {

    String getGeocode(GeoApiContext context, String address) throws ApiException, IOException, InterruptedException;

    GeocodingApiRequest getReversedGeocode(GeoApiContext context, LatLng location);



}
