package ua.lviv.iot.view;

public class Menu {
    public void displayMenu() {
        System.out.println(
                "                Table                  |     Method    \n" +
                "---------------------------------------|---------------\n" +
                "  1: Animator                          |   1: GET ALL  \n" +
                "  2: Animators agency                  |   2: GET      \n" +
                "  3: Bill                              |   3: CREATE   \n" +
                "  4: Client account                    |   4: UPDATE   \n" +
                "  5: Country                           |   5: DELETE   \n" +
                "  6: Event                             |               \n" +
                "  7: Feedback                          |               \n" +
                "  8: Order                             |               \n"
        );
    }
}
