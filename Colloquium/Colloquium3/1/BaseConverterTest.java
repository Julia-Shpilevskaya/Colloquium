import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.Locale;
import static org.junit.jupiter.api.Assertions.*;

public class BaseConverterTest {

    @Test
    public void testConvertCelsiusToFahrenheit() {
        BaseConverter converter = new BaseConverter(Locale.US);
        double celsius = 25;
        double expectedFahrenheit = 77;
        assertEquals(expectedFahrenheit, converter.convert(celsius, BaseConverter.TemperatureScale.FAHRENHEIT), 0.01);
    }

    @Test
    public void testConvertCelsiusToKelvin() {
        BaseConverter converter = new BaseConverter(Locale.getDefault());
        double celsius = 0;
        double expectedKelvin = 273.15;
        assertEquals(expectedKelvin, converter.convert(celsius, BaseConverter.TemperatureScale.KELVIN), 0.01);
    }

    @Test
    public void testIsFahrenheitCountry() {
        BaseConverter converter1 = new BaseConverter(Locale.US);
        assertTrue(converter1.isFahrenheitCountry());

        BaseConverter converter2 = new BaseConverter(Locale.UK);
        assertFalse(converter2.isFahrenheitCountry());
    }
}