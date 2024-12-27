package util;

import com.github.javafaker.Faker;
import constant.Constants;
import model.Player;

import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Util {
    private static Faker faker = new Faker(new Locale("ru"));
    private static Random random = new Random();

    private Util() {
        throw new IllegalStateException("Utility class");
    }

    public static String randomName() {
        return faker.name().fullName();
    }

    public static int randomInt() {
        return random.nextInt(Constants.MIN_SCORE, Constants.MAX_SCORE);
    }

    public static List<Player> playersList(int x) {
        return IntStream.range(0, x).mapToObj(q -> new Player(randomName(), randomInt())).collect(Collectors.toList());
    }
}
