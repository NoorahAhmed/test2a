package nl.multicode.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SplitStringFunction implements Function<String, Stream<String>> {

    @Override
    public Stream<String> apply(String numbers) {

        return Arrays.stream(numbers.split(","));
    }
}
