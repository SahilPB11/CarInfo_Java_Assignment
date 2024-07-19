package car.info;

import static org.junit.Assert.*;
import org.junit.Test;

public class ApiClientTest {

    @Test
    public void testFetchData() {
        ApiClient apiClient = new ApiClient("https://api.cuvora.com/car/partner/cricket-data", "test-creds@2320");
        String data = apiClient.fetchData();
        assertNotNull(data);
    }

}
