package ibf2023ssf.day12workshop.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ibf2023ssf.day12workshop.Models.Item;
import ibf2023ssf.day12workshop.Utils.Utils;

import org.springframework.web.bind.annotation.GetMapping;



@Controller
@RequestMapping("/cart")
public class CartController {
    
    @GetMapping
    public ModelAndView getCart(@RequestParam String item,
        @RequestParam int quantity,
        @RequestParam(defaultValue="") String _cart) {

        ModelAndView mav =new ModelAndView("cart");
        Item newItem = new Item();

        //new item
        newItem.setName(item);
        newItem.setQuantity(quantity);

        //name|quantity,name|quantity,...
        List<Item> cart = Utils.deserializeCart(_cart);
        cart.add(newItem);

        String newCart = Utils.serialiser(cart);
        System.out.printf(">>> newCart:%s\n", newCart);

        mav.addObject("newCart", newCart); //hidden cart
        mav.addObject("cart", cart);

        return mav;
    }
}
