package com.xyzcorp;

import jdk.internal.util.xml.impl.Input;
import org.junit.Test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.createMock;

public class LenderParserTest {

    @Test
    public void testParsePerfectLine() {
        LenderParser lenderParser = new LenderParser("~");
        assertThat(lenderParser.parse("a~b~2017-04-10"))
                .isEqualTo(new LenderRecord("a", "b", LocalDate.of(2017,4, 10)));
    }

    @Test
    public void testParsePerfectLineDifferentNameAndTitle() {
        LenderParser lenderParser = new LenderParser("~");
        assertThat(lenderParser.parse("d~e~2017-04-10"))
                .isEqualTo(new LenderRecord("d", "e", LocalDate.of(2017,4, 10)));
    }

    @Test
    public void testParsePerfectLineDifferentDate() {
        LenderParser lenderParser = new LenderParser("~");
        assertThat(lenderParser.parse("a~b~2017-04-15"))
                .isEqualTo(new LenderRecord("a", "b", LocalDate.of(2017,4, 15)));
    }
    //We are not done
    // a~b
    // blank line
    // bad date
    // more...

    @Test
    public void testStreamEmpty() {
         //If you are spending way too much time setting up your test, you are doing it wrong
         LenderParser lenderParser = new LenderParser("~");
         Stream<LenderRecord> stream = lenderParser.parse(Stream.empty());
         assertThat(stream).isEmpty();
    }

    @Test
    public void testStreamOneItem() {
        //If you are spending way too much time setting up your test, you are doing it wrong
        LenderParser lenderParser = new LenderParser("~");
        Stream<LenderRecord> stream = lenderParser.parse(Stream.of("Hao Guan~Ender's Game~2012-02-12"));
        assertThat(stream).hasSize(1).contains
                (new LenderRecord("Hao Guan", "Ender's Game",
                        LocalDate.of(2012, 2, 12)));
    }


    @Test
    public void testTheEntireComponentSuite() {
        LenderParser parser = new LenderParser("~");
        InputStream is = getClass().getResourceAsStream("/library.txt");
        InputStreamReader reader = new InputStreamReader(is);
        BufferedReader bufferedReader = new BufferedReader(reader);

        Stream<LenderRecord> records = parser.parse(bufferedReader.lines());
        records.sorted(Comparator.comparing(LenderRecord::getCheckoutDate))
               .map(r -> {
                   int penalty = PenaltyCalculator.calculate(LocalDate.now(), r.getCheckoutDate(), 10);
                   return r.getName() + " : " + penalty;
               }).limit(5).forEach(System.out::println);
    }

    @Test
    public void testTheEntireComponentSuiteWithURL() throws IOException {
        URL url = new URL("https://raw.githubusercontent.com/dhinojosa/tddinjava_2017-08-14/master/src/main/resources/library.txt");
        InputStream is = url.openConnection().getInputStream();

        LenderParser parser = new LenderParser("~");
        InputStreamReader reader = new InputStreamReader(is);
        BufferedReader bufferedReader = new BufferedReader(reader);

        Stream<LenderRecord> records = parser.parse(bufferedReader.lines());
        records.sorted(Comparator.comparing(LenderRecord::getCheckoutDate))
               .map(r -> {
                   int penalty = PenaltyCalculator.calculate(LocalDate.now(), r.getCheckoutDate(), 10);
                   return r.getName() + " : " + penalty;
               }).limit(5).forEach(System.out::println);
    }
}
