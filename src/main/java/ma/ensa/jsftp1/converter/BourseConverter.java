package ma.ensa.jsftp1.converter;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.ConverterException;
import jakarta.faces.convert.FacesConverter;

import java.text.NumberFormat;
import java.util.Locale;

@FacesConverter("bourseConverter")
public class BourseConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }

        try {
            Locale locale = context.getViewRoot().getLocale();
            NumberFormat format = NumberFormat.getNumberInstance(locale);
            Number number = format.parse(value);
            double amount = number.doubleValue();

            return amount / getPourcentage(locale.getCountry());

        } catch (Exception e) {
            throw new ConverterException("Invalid currency value: " + value);
        }
    }
    private double getPourcentage(String country) {
        switch (country) {
            case "US":
                return 0.1071; // MAD → USD
            case "ES":
            case "FR":
            case "DE":
            case "IT":
                return 0.0922; // MAD → EUR
            case "GB":
                return 0.0798; // MAD → GBP
            case "CN":
                return 0.7404; // MAD → CNY
            case "MA":
                return 1.0;

            default:
                return 1.0;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) return "";

        double amountInMAD;
        if (value instanceof Number) {
            amountInMAD = ((Number) value).doubleValue();
        } else {
            throw new ConverterException("Value is not a number: " + value);
        }

        Locale locale = context.getViewRoot().getLocale();

        double amountInLocalCurrency = amountInMAD * getPourcentage(locale.getCountry());

        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        return formatter.format(amountInLocalCurrency);
    }
}