package goodman_screbber;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.*;
import model.agents.AgentOfOperation;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = """
                {\s
                 "operation_log": [{
                                         "oper_id": 82325,
                                         "oper_proc": 434,
                                         "oper_card": 518,
                                         "oper_started": "2023-02-28T10:12:37",
                                         "oper_ended": "2023-02-28T10:12:49",
                                         "oper_coocker_id": 15,
                                         "oper_active": false
                             },
                  {
                                         "oper_id": 82326,
                                         "oper_proc": 435,
                                         "oper_card": 518,
                                         "oper_started": "2023-02-28T10:12:51",
                                         "oper_ended": "2023-02-28T10:13:04",
                                         "oper_coocker_id": 15,
                                         "oper_active": false
                             },
                  {
                                         "oper_id": 82327,
                                         "oper_proc": 436,
                                         "oper_card": 518,
                                         "oper_started": "2023-02-28T11:12:37",
                                         "oper_ended": "2023-02-28T11:12:49",
                                         "oper_coocker_id": 16,
                                         "oper_active": false
                             }]
                 }
                                
                                          
                            
                """;

        AgentOfOperation menuItem = objectMapper.readValue(jsonString, AgentOfOperation.class);
        System.out.println();
//        for (MenuDishes menuDish : menuItem.menu_dishes) {
//            System.out.println(menuDish.getMenu_dish_card());
//        }
    }
}