package ru.sibtrans.test.testcases;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.sibtrans.main.rates.sbornyeavtozhdperevozki.SbornyeAvtoZhdPerevozki;

import java.io.IOException;

public class RatesSAZPTest {
    SbornyeAvtoZhdPerevozki sazp = new SbornyeAvtoZhdPerevozki();
        @Test
        @DisplayName("")
        void check() throws IOException, InterruptedException {
        String mainPrice = sazp.MAIN_PRICE.text();
        System.out.println(mainPrice);
        String cityPrice;
        String addPrice;
        // Assertions.assertTrue(("| 270.0 |  | 600.0 |  | 850.0 |  | 1050.0 |  | 1300.0 |  | 16.6 |").matches(readPrice(readMain)));
        // Assertions.assertTrue(readPrice(readMain).contains("| 270.0 |  | 600.0 |  | 850.0 |  | 1050.0 |  | 1300.0 |  | 16.6 |"));
//        Assertions.assertTrue(flowflow().contains(String.valueOf(Integer.parseInt("762"))));
//

            }
}
