package ua.lviv.iot.view;

import ua.lviv.iot.controller.*;
import ua.lviv.iot.controller.impl.*;
import ua.lviv.iot.model.*;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class View {

    private static final String KEY_EXIT = "Q";
    private static final String TEXT_GO_BACK = "Go back or quit";
    private static final String TEXT_SELECT_MENU_OPTION = "Please choose menu option: ";
    private static final String ERROR_NO_SUCH_OPTION = "No such option found. Try again.";

    private static final Scanner input = new Scanner(System.in, StandardCharsets.UTF_8);

    public void show() {
        showTablesMenu();
    }

    /**
     * Show general tables MENU
     */
    private void showTablesMenu() {
        Map<String, String> tablesMenu = generateTablesMenu();
        Map<String, Printable> tablesMenuMethods = generateTablesMenuMethods();
        showMenuFromMaps(tablesMenu, tablesMenuMethods);
    }

    /**
     * Generate general tables MENU and MENU METHODS
     */
    private Map<String, String> generateTablesMenu() {
        Map<String, String> tablesMenu = new LinkedHashMap<>();
        tablesMenu.put("1", "Table: AnimatorsAgency");
        tablesMenu.put("2", "Table: ClientAccount");
        tablesMenu.put("3", "Table: Feedback");
        tablesMenu.put("4", "Table: Event");
        tablesMenu.put("5", "Table: Order");
        tablesMenu.put("6", "Table: Country");
        tablesMenu.put("7", "Table: Animator");
        tablesMenu.put("8", "Table: Bill");
        return tablesMenu;
    }

    private Map<String, Printable> generateTablesMenuMethods() {
        Map<String, Printable> tablesMenuMethods = new LinkedHashMap<>();
        tablesMenuMethods.put("1", this::showAnimatorsAgencyMenu);
        tablesMenuMethods.put("2", this::showClientAccountMenu);
        tablesMenuMethods.put("3", this::showFeedbackMenu);
        tablesMenuMethods.put("4", this::showEventMenu);
        tablesMenuMethods.put("5", this::showOrderMenu);
        tablesMenuMethods.put("6", this::showCountryMenu);
        tablesMenuMethods.put("7", this::showAnimatorMenu);
        tablesMenuMethods.put("8", this::showBillMenu);
        return tablesMenuMethods;
    }

    /**
     * Show single table MENU
     */
    private void showAnimatorsAgencyMenu() {
        Map<String, String> menu = generateMenu();
        Map<String, Printable> menuMethods = generateAnimatorsAgencyMenuMethods();
        showMenuFromMaps(menu, menuMethods);
    }

    private void showClientAccountMenu() {
        Map<String, String> menu = generateMenu();
        Map<String, Printable> menuMethods = generateClientAccountMenuMethods();
        showMenuFromMaps(menu, menuMethods);
    }

    private void showFeedbackMenu() {
        Map<String, String> menu = generateMenu();
        Map<String, Printable> menuMethods = generateFeedbackMenuMethods();
        showMenuFromMaps(menu, menuMethods);
    }

    private void showEventMenu() {
        Map<String, String> menu = generateMenu();
        Map<String, Printable> menuMethods = generateEventMenuMethods();
        showMenuFromMaps(menu, menuMethods);
    }

    private void showOrderMenu() {
        Map<String, String> menu = generateMenu();
        Map<String, Printable> menuMethods = generateOrderMenuMethods();
        showMenuFromMaps(menu, menuMethods);
    }

    private void showCountryMenu() {
        Map<String, String> menu = generateMenu();
        Map<String, Printable> menuMethods = generateCountryMenuMethods();
        showMenuFromMaps(menu, menuMethods);
    }

    private void showAnimatorMenu() {
        Map<String, String> menu = generateMenu();
        Map<String, Printable> menuMethods = generateAnimatorMenuMethods();
        showMenuFromMaps(menu, menuMethods);
    }

    private void showBillMenu() {
        Map<String, String> menu = generateMenu();
        Map<String, Printable> menuMethods = generateBillMenuMethods();
        showMenuFromMaps(menu, menuMethods);
    }

    /**
     * Generate single table MENU
     */
    private Map<String, String> generateMenu() {
        Map<String, String> menu = new LinkedHashMap<>();
        menu.put("1", "Select all");
        menu.put("2", "Select");
        menu.put("3", "Create");
        menu.put("4", "Update");
        menu.put("5", "Delete");
        return menu;
    }

    /**
     * Generate single table MENU METHODS
     */
    private Map<String, Printable> generateAnimatorsAgencyMenuMethods() {
        AbstractController<AnimatorsAgency, Integer> animatorsAgencyController = new AnimatorsAgencyControllerImpl();
        Formatter<AnimatorsAgency, Integer> formatter = new Formatter<>(AnimatorsAgency.class);
        ViewOperations<AnimatorsAgency, Integer> animatorsAgencyOperation = new ViewOperations<>(animatorsAgencyController, formatter, AnimatorsAgency.class);

        Map<String, Printable> menuMethods = new LinkedHashMap<>();
        menuMethods.put("1", animatorsAgencyOperation::findAll);
        menuMethods.put("2", animatorsAgencyOperation::findById);
        menuMethods.put("3", animatorsAgencyOperation::create);
        menuMethods.put("4", animatorsAgencyOperation::update);
        menuMethods.put("5", animatorsAgencyOperation::delete);
        return menuMethods;
    }



    private Map<String, Printable> generateClientAccountMenuMethods() {
        AbstractController<ClientAccount, Integer> clientAccountController = new ClientAccountControllerImpl();
        Formatter<ClientAccount, Integer> formatter = new Formatter<>(ClientAccount.class);
        ViewOperations<ClientAccount, Integer> clientAccountOperation = new ViewOperations<>(clientAccountController, formatter, ClientAccount.class);

        Map<String, Printable> menuMethods = new LinkedHashMap<>();
        menuMethods.put("1", clientAccountOperation::findAll);
        menuMethods.put("2", clientAccountOperation::findById);
        menuMethods.put("3", clientAccountOperation::create);
        menuMethods.put("4", clientAccountOperation::update);
        menuMethods.put("5", clientAccountOperation::delete);
        return menuMethods;
    }

    private Map<String, Printable> generateFeedbackMenuMethods() {
        AbstractController<Feedback, Integer> feedbackController = new FeedbackControllerImpl();
        Formatter<Feedback, Integer> formatter = new Formatter<>(Feedback.class);
        ViewOperations<Feedback, Integer> feedbackOperation = new ViewOperations<>(feedbackController, formatter, Feedback.class);

        Map<String, Printable> menuMethods = new LinkedHashMap<>();
        menuMethods.put("1", feedbackOperation::findAll);
        menuMethods.put("2", feedbackOperation::findById);
        menuMethods.put("3", feedbackOperation::create);
        menuMethods.put("4", feedbackOperation::update);
        menuMethods.put("5", feedbackOperation::delete);
        return menuMethods;
    }

    private Map<String, Printable> generateEventMenuMethods() {
        AbstractController<Event, String> eventController = new EventControllerImpl();
        Formatter<Event, String> formatter = new Formatter<>(Event.class);
        ViewOperations<Event, String> eventOperation = new ViewOperations<>(eventController, formatter, Event.class);

        Map<String, Printable> menuMethods = new LinkedHashMap<>();
        menuMethods.put("1", eventOperation::findAll);
        menuMethods.put("2", eventOperation::findById);
        menuMethods.put("3", eventOperation::create);
        menuMethods.put("4", eventOperation::update);
        menuMethods.put("5", eventOperation::delete);
        return menuMethods;
    }

    private Map<String, Printable> generateOrderMenuMethods() {
        AbstractController<Order, String> orderController = new OrderControllerImpl();
        Formatter<Order, String> formatter = new Formatter<>(Order.class);
        ViewOperations<Order, String> orderOperation = new ViewOperations<>(orderController, formatter, Order.class);

        Map<String, Printable> menuMethods = new LinkedHashMap<>();
        menuMethods.put("1", orderOperation::findAll);
        menuMethods.put("2", orderOperation::findById);
        menuMethods.put("3", orderOperation::create);
        menuMethods.put("4", orderOperation::update);
        menuMethods.put("5", orderOperation::delete);
        return menuMethods;
    }

    private Map<String, Printable> generateCountryMenuMethods() {
        AbstractController<Country, Integer> countryController = new CountryControllerImpl();
        Formatter<Country, Integer> formatter = new Formatter<>(Country.class);
        ViewOperations<Country, Integer> countryOperation = new ViewOperations<>(countryController, formatter, Country.class);

        Map<String, Printable> menuMethods = new LinkedHashMap<>();
        menuMethods.put("1", countryOperation::findAll);
        menuMethods.put("2", countryOperation::findById);
        menuMethods.put("3", countryOperation::create);
        menuMethods.put("4", countryOperation::update);
        menuMethods.put("5", countryOperation::delete);
        return menuMethods;
    }

    private Map<String, Printable> generateAnimatorMenuMethods() {
        AbstractController<Animator, Integer> animatorController = new AnimatorControllerImpl();
        Formatter<Animator, Integer> formatter = new Formatter<>(Animator.class);
        ViewOperations<Animator, Integer> animatorOperation = new ViewOperations<>(animatorController, formatter, Animator.class);

        Map<String, Printable> menuMethods = new LinkedHashMap<>();
        menuMethods.put("1", animatorOperation::findAll);
        menuMethods.put("2", animatorOperation::findById);
        menuMethods.put("3", animatorOperation::create);
        menuMethods.put("4", animatorOperation::update);
        menuMethods.put("5", animatorOperation::delete);
        return menuMethods;
    }

    private Map<String, Printable> generateBillMenuMethods() {
        AbstractController<Bill, Integer> billController = new BillControllerImpl();
        Formatter<Bill, Integer> formatter = new Formatter<>(Bill.class);
        ViewOperations<Bill, Integer> billOperations = new ViewOperations<>(billController, formatter, Bill.class);

        Map<String, Printable> menuMethods = new LinkedHashMap<>();
        menuMethods.put("1", billOperations::findAll);
        menuMethods.put("2", billOperations::findById);
        menuMethods.put("3", billOperations::create);
        menuMethods.put("4", billOperations::update);
        menuMethods.put("5", billOperations::delete);
        return menuMethods;
    }

    /**
     * Show menu from Maps
     */
    private void showMenuFromMaps(Map<String, String> keyName, Map<String, Printable> keyMethod) {
        String keyMenu;
        do {
            printMenu(keyName);
            System.out.println(TEXT_SELECT_MENU_OPTION);
            keyMenu = input.nextLine().toUpperCase();
            Printable method = keyMethod.get(keyMenu);
            if (method != null) {
                method.print();
            } else if (!keyMenu.equals(KEY_EXIT)) {
                System.out.println(ERROR_NO_SUCH_OPTION);
            }
        } while (!keyMenu.equals(KEY_EXIT));
    }

    private void printMenu(Map<String, String> keyName) {
        keyName.entrySet().stream()
                .forEach(es -> System.out.printf("%3s - %s%n", es.getKey(), es.getValue()));
        System.out.printf("%3s - %s%n", KEY_EXIT, TEXT_GO_BACK);
    }
}
