package support;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;



public class TestDataManager {
    public static Map<String, Object> getMapFromYamlFile(String fileName) {
        String path = System.getProperty("user.dir") + "/src/test/resources/data/" + fileName + ".yml";
        try (InputStream stream = new FileInputStream(path)) {
            Yaml yaml = new Yaml();
            return yaml.load(stream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + path, e);
        } catch (IOException e) {
            throw new Error("Error reading the file", e);
        }
    }

    public static Map<String, String> getDataFromFile (String entityName, String fileName) {
// "information", "test_data"
        Map<String, Object> testData = getMapFromYamlFile(fileName);
        Map<String, String> data = (Map<String, String>) testData.get(entityName);

        System.out.println(data);
        return data;
    }
}
