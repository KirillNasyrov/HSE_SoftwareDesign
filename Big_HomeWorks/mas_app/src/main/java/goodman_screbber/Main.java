package goodman_screbber;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Restaurant;
import model.agents.AgentOfOperation;
import model.dishCards.ListOfDishCards;
import model.menu.ListOfMenuDishes;
import model.visitorOrders.ListOfVisitorOrders;
import model.visitorOrders.OrderDish;
import model.visitorOrders.VisitorOrder;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = """
                {
                               "visitors_orders": [{
                                                       "vis_name": " Visitor123",
                                                       "vis_ord_started": "2023-02-28T10:12:37",
                                                       "vis_ord_ended": "2023-02-28T10:13:05",
                                                       "vis_ord_total": 118,
                                                       "vis_ord_dishes": [{
                                                                               "ord_dish_id": 625,
                                                                               "menu_dish": 28
                                                                   },
                                                                   {
                                                                               "ord_dish_id": 626,
                                                                               "menu_dish": 28
                                                                   }
                                                       ]
                                           },
                                           {
                                                       "vis_name": " Visitor124",
                                                       "vis_ord_started": "2023-02-28T11:09:07",
                                                       "vis_ord_ended": "2023-02-28T11:12:51",
                                                       "vis_ord_total": 59,
                                                       "vis_ord_dishes": [{
                                                                   "ord_dish_id": 627,
                                                                   "menu_dish": 28
                                                       }]
                                           }
                               ]
                   }
                                       
                            
                """;

        JsonParser jsonParser = new JsonParser();
        ListOfVisitorOrders listOfVisitorOrders = jsonParser.getListOfVisitorOrdersFromJson();
        ListOfMenuDishes menuDishes = jsonParser.getListOfMenuDishesFromJson();
        ListOfDishCards listOfDishCards = jsonParser.getListOfDishCardsFromJson();
        Restaurant restaurant = new Restaurant(listOfVisitorOrders, menuDishes, listOfDishCards);
        restaurant.startCooking();
    }
}