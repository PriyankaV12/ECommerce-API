import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;

public class reader {
    public ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());

    public gettersSetters readData() throws Exception {
        File file = new File(System.getProperty("user.dir") + "/src/main/java/data.yaml");
        gettersSetters data = objectMapper.readValue(file, gettersSetters.class);
        return data;
    }
}
