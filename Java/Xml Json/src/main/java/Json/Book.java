package Json;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

public class Book {
    public long id;
    public String name;
    public String author;
    // 表示反序列化isbn时使用自定义的IsbnDeserializer:
    @JsonDeserialize(using = IsbnDeserializer.class)
    public BigInteger isbn;
    public List<String> tags;
    //    public String pubDate;
    public LocalDate pubDate;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", tags=" + tags +
                ", pubDate='" + pubDate + '\'' +
                '}';
    }
}
