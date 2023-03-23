package goodman_screbber;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Dish;
import model.ListOfKitchenEquipment;
import model.Menu;
import model.MenuDishes;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = """
                {
                            "equipment": [{
                                                    "equip_type": 2,
                                                    "equip_name": "LIDER 250",
                                                    "equip_active": true
                                        },
                  {
                                                    "equip_type": 2,
                                                    "equip_name": "LIDER 150",
                                                    "equip_active": false
                                        },
                                        {
                                                    "equip_type": 25,
                                                    "equip_name": "DAZHENG LOOKYAMI",
                                                    "equip_active": true
                                        }
                            ]
                }
                                
                            
                """;

        ListOfKitchenEquipment menuItem = objectMapper.readValue(jsonString, ListOfKitchenEquipment.class);
        System.out.println();
        System.out.println("fuck this shit");
//        for (MenuDishes menuDish : menuItem.menu_dishes) {
//            System.out.println(menuDish.getMenu_dish_card());
//        }
    }
}