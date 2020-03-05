package Json;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.io.InputStream;

public class Jackson {
    public static void main(String[] args) throws IOException {
        InputStream input = Jackson.class.getResourceAsStream("/book.json");
        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
        //设置反序列化时忽略不存在的JavaBean属性
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //反序列化
        Book book = mapper.readValue(input, Book.class);
        System.out.println(book.toString());
        //序列化
        String json = mapper.writeValueAsString(book);
        System.out.println(json);
    }
}
