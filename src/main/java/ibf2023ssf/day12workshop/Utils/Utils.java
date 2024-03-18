package ibf2023ssf.day12workshop.Utils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import ibf2023ssf.day12workshop.Models.Item;

public class Utils {
    // name|quantity,name|quantity,...
    public static List<Item> deserializeCart(String cartStr) {
        if (cartStr.trim().length() <= 0) {
            return new LinkedList<>();
        }

        List<String> list = Arrays.asList(cartStr.split(","));
        List<Item> itemList = list.stream()
            .map(Item::toItem)
            .toList();
        return new LinkedList<>(itemList);
    }

    public static String serialiser (List<Item> cart) {
        return cart.stream()
            .map(item -> item.toItemString())
            .collect(Collectors.joining(","));
    }
}
