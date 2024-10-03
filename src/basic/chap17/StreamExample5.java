package basic.chap17;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamExample5 {
    public static void main(String[] args) throws Exception {

        //파일로부터 스트림 받기
        Path path= Paths.get(StreamExample5.class.getResource("data.txt").toURI());
        Stream<String> stream= Files.lines(path, Charset.defaultCharset());
        stream.forEach(line -> System.out.println(line));
        stream.close();


    }
}
