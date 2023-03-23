package goodman_screbber;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.*;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = """
                {
                            "equipment_type": [{
                                                    "equip_type_id": 2,
                                                    "equip_type_name": "rotary oven"
                                        },
                                        {
                                                    "equip_type_id": 25,
                                                    "equip_type_name": "thermopot"
                                        }
                            ]
                }
                            
                            
                """;

        ListOfEquipmentType menuItem = objectMapper.readValue(jsonString, ListOfEquipmentType.class);
        System.out.println();
//        for (MenuDishes menuDish : menuItem.menu_dishes) {
//            System.out.println(menuDish.getMenu_dish_card());
//        }
    }
}