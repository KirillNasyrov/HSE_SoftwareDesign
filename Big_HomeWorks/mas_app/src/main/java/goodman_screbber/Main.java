package goodman_screbber;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Dish;
import model.Menu;
import model.MenuDishes;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = """
                {
                            "dish_cards": [{
                                        "card_id": 518,
                   "dish_name": "Princess Nuri tea bag in a paper cup",
                                     "card_descr": "pouring boiled water into a paper cup + 2 bags of sugar",
                                        "card_time": 0.15,
                                        "equip_type": 25,
                                        "operations": [{
                                                    "oper_type": 17,
                			    "oper_time": 0.15,
                                                    "oper_async_point": 0,
                                                    "oper_products": [{
                                                                            "prod_type": 18,
                                                                            "prod_quantity": 1
                                                                },
                                                                {
                                                                            "prod_type": 23,
                                                                            "prod_quantity": 2
               
                                                                },
                                                                {
                                                                            "prod_type": 24,
                                                                            "prod_quantity": 0.2
                                                                },
                     {
                                                                            "prod_type": 12,
                                                                            "prod_quantity": 1
                                                                },
                                                                {
                                                                            "prod_type": 19,
                                                                            "prod_quantity": 1
                                                                }
                                                    ]
                                        }]
                            }]
                }
                                
                                
                """;

        Dish menuItem = objectMapper.readValue(jsonString, Dish.class);
//        for (MenuDishes menuDish : menuItem.menu_dishes) {
//            System.out.println(menuDish.getMenu_dish_card());
//        }
    }
}