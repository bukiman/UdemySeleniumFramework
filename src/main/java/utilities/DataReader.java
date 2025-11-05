package utilities;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class DataReader {

    public List<HashMap<Object, Object>> getJsonDataToMap() throws IOException {

        //read json to string
        String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                "\\src\\main\\resources\\PurchaseOrder.json"), StandardCharsets.UTF_8);

        //String to HaspMap with Jackson Databind
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonContent, new TypeReference<List<HashMap<Object, Object>>>() {});
    }
}
