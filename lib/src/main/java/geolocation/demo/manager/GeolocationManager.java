package geolocation.demo.manager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GaeRequestHandler;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.GeocodingApiRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;

import javax.ejb.Stateless;
import java.io.IOException;

@Stateless
public class GeolocationManager implements GeolocationManagerLocal {

    @Override
    public String getGeocode(GeoApiContext context, String address) throws ApiException, IOException, InterruptedException {

        GeocodingResult[] results = GeocodingApi.geocode(context, address).await();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        return gson.toJson(results[0].geometry.location);
    }

    @Override
    public GeocodingApiRequest getReversedGeocode(GeoApiContext context, LatLng location) {
        GeocodingApiRequest request = new GeocodingApiRequest(context);
        request.latlng(location);

        return request;
    }
}
