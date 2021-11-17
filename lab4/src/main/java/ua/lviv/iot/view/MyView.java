package ua.lviv.iot.view;

import ua.lviv.iot.controller.impl.*;
import ua.lviv.iot.model.*;

import java.sql.SQLException;
import java.sql.Time;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MyView {
    private final Map<String, Printable> menu = new LinkedHashMap<>();
    private static final Scanner SCANNER = new Scanner(System.in);

    private final AnimatorControllerImpl animatorController = new AnimatorControllerImpl();
    private final AnimatorsAgencyControllerImpl animatorsAgencyController = new AnimatorsAgencyControllerImpl();
    private final BillControllerImpl billController = new BillControllerImpl();
    private final ClientAccountControllerImpl clientAccountController = new ClientAccountControllerImpl();
    private final CountryControllerImpl countryController = new CountryControllerImpl();
    private final EventControllerImpl eventController = new EventControllerImpl();
    private final FeedbackControllerImpl feedbackController = new FeedbackControllerImpl();
    private final OrderControllerImpl orderController = new OrderControllerImpl();

    public MyView() {
        menu.put("11", this::getAllAnimators);
        menu.put("12", this::getAnimatorById);
        menu.put("13", this::createAnimator);
        menu.put("14", this::updateAnimator);
        menu.put("15", this::deleteAnimator);

        menu.put("21", this::getAllAnimatorsAgencyInfo);
        menu.put("22", this::getAnimatorsAgencyByLogin);
        menu.put("23", this::createAnimatorsAgency);
        menu.put("24", this::updateAnimatorsAgency);
        menu.put("25", this::deleteAnimatorsAgency);

        menu.put("31", this::getAllBills);
        menu.put("32", this::getBillById);
        menu.put("33", this::createBill);
        menu.put("34", this::updateBill);
        menu.put("35", this::deleteBill);

        menu.put("41", this::getAllClientAccounts);
        menu.put("42", this::getClientAccountByID);
        menu.put("43", this::createClientAccount);
        menu.put("44", this::updateClientAccount);
        menu.put("45", this::deleteClientAccount);

        menu.put("51", this::getAllCountries);
        menu.put("52", this::getCountryById);
        menu.put("53", this::createCountry);
        menu.put("54", this::updateCountry);
        menu.put("55", this::deleteCountry);

        menu.put("61", this::getAllEvents);
        menu.put("62", this::getEventById);
        menu.put("63", this::createEvent);
        menu.put("64", this::updateEvent);
        menu.put("65", this::deleteEvent);

        menu.put("71", this::getAllFeedbacks);
        menu.put("72", this::getFeedbackById);
        menu.put("73", this::createFeedback);
        menu.put("74", this::updateFeedback);
        menu.put("75", this::deleteFeedback);

        menu.put("81", this::getAllOrders);
        menu.put("82", this::getOrderById);
        menu.put("83", this::createOrder);
        menu.put("84", this::updateOrder);
        menu.put("85", this::deleteOrder);
    }


    //#########################################################################

    private void outputMenu() {
        System.out.println("\nMENU:");
        for (Printable str : menu.values()) {
            System.out.println(str);
        }
    }

    public final void show() {
        String input;
        Menu showMenu = new Menu();
        showMenu.displayMenu();
        System.out.println("\nEnter numbers:\n");
        do {
            try {
                input = SCANNER.next();
                menu.get(input).print();
            } catch (Exception ignored) {
            }
        } while (SCANNER.hasNext());
    }

    //#########################################################################

    private void getAllAnimators() throws SQLException {
        System.out.println(animatorController.findAll() + "\n");
    }

    private void getAnimatorById() throws SQLException {
        System.out.println("Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(animatorController.findById(id) + "\n");
    }

    private AnimatorEntity getAnimatorInputs() {
        System.out.println("\nEnter name: ");
        String name = SCANNER.next();
        System.out.println("\nEnter surname: ");
        String surname = SCANNER.next();
        System.out.println("Enter expiration age: ");
        Integer age = SCANNER.nextInt();
        System.out.println("\nEnter gender: ");
        String gender = SCANNER.next();
        System.out.println("\nEnter character: ");
        String character = SCANNER.next();
        System.out.println("Enter salary: ");
        Integer salary = SCANNER.nextInt();
        System.out.println("Enter experience: ");
        Integer experience = SCANNER.nextInt();
        System.out.println("\nEnter phone: ");
        String phone = SCANNER.next();
        System.out.println("\nEnter email: ");
        String email = SCANNER.next();
        return new AnimatorEntity(name, surname, age, gender, character, salary, experience, phone, email);
    }

    private void createAnimator() throws SQLException {
        AnimatorEntity animator = getAnimatorInputs();
        animatorController.create(animator);
        System.out.println("Animator was successfully created!\n");
    }

    private void updateAnimator() throws SQLException {
        System.out.println("\nEnter ID to update: ");
        Integer id = SCANNER.nextInt();
        AnimatorEntity animator = getAnimatorInputs();
        animator.setId(id);
        animatorController.update(animator.getId(), animator);
        System.out.println("Animator with ID = " + id + " was updated\n");
    }

    private void deleteAnimator() throws SQLException {
        System.out.println("\nEnter ID to delete the animator: ");
        Integer id = SCANNER.nextInt();
        animatorController.delete(id);
    }

    //########################################################################

    private void getAllAnimatorsAgencyInfo() throws SQLException {
        System.out.println("\n" + animatorsAgencyController.findAll() + "\n");
    }

    private void getAnimatorsAgencyByLogin() throws SQLException {
        System.out.println("\nEnter login: ");
        Integer businessId = SCANNER.nextInt();
        System.out.println(animatorsAgencyController.findById(businessId) + "\n");
    }

    private AnimatorsAgencyEntity getAnimatorsAgencyInputs() {
        System.out.println("\nEnter name: ");
        String name = SCANNER.next();
        System.out.println("\nEnter address: ");
        String address = SCANNER.next();
        System.out.println("\nEnter workers number: ");
        Integer workersNumber = SCANNER.nextInt();
        System.out.println("\nEnter license: ");
        String license = SCANNER.next();
        System.out.println("\nEnter bank account: ");
        String bankAccount = SCANNER.next();
        System.out.println("\nEnter country: ");
        Integer country = SCANNER.nextInt();
        return new AnimatorsAgencyEntity(name, address, workersNumber, license, bankAccount, country);
    }

    private void createAnimatorsAgency() throws SQLException {
        System.out.println("\n");
        AnimatorsAgencyEntity animatorsAgency = getAnimatorsAgencyInputs();
        animatorsAgencyController.create(animatorsAgency);
        System.out.println("Security was successfully created!\n");
    }

    private void updateAnimatorsAgency() throws SQLException {
        System.out.println("\nEnter business ID to update: ");
        Integer businessId = SCANNER.nextInt();
        AnimatorsAgencyEntity animatorsAgency = getAnimatorsAgencyInputs();
        animatorsAgency.setBusinessId(businessId);
        animatorsAgencyController.update(animatorsAgency.getBusinessId(), animatorsAgency);
        System.out.println("Animators agency with business ID: " + businessId + "was updated\n");
    }

    private void deleteAnimatorsAgency() throws SQLException {
        System.out.println("\nEnter business ID to delete animators agency: ");
        Integer businessId = SCANNER.nextInt();
        animatorsAgencyController.delete(businessId);
    }

    //##################################################################################

    private void getAllBills() throws SQLException {
        System.out.println("\n" + billController.findAll() + "\n");
    }

    private void getBillById() throws SQLException {
        System.out.println("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(billController.findById(id) + "\n");
    }

    private BillEntity getBillInputs() {
        System.out.println("\nEnter a client: ");
        String client = SCANNER.next();
        System.out.println("\nEnter datetime of the bill: ");
        SCANNER.nextLine();
        String dateTime = SCANNER.nextLine();
        Timestamp timestamp = Timestamp.valueOf(dateTime);
        System.out.println("\nEnter animators number: ");
        Integer animatorsNumber = SCANNER.nextInt();
        System.out.println("\nEnter performance duration: ");
        Integer performanceDuration = SCANNER.nextInt();
        System.out.println("\nEnter a price: ");
        String price = SCANNER.next();
        System.out.println("\nEnter organizer: ");
        String organizer = SCANNER.next();
        System.out.println("\nEnter order ID: ");
        Integer orderId = SCANNER.nextInt();
        return new BillEntity(client, timestamp, animatorsNumber, performanceDuration, price, organizer, orderId);
    }

    private void createBill() throws SQLException {
        System.out.println("\n");
        BillEntity bill = getBillInputs();
        billController.create(bill);
        System.out.println("Bill was successfully created!\n");
    }

    private void updateBill() throws SQLException {
        System.out.println("\nEnter ID of the bill to update: ");
        Integer id = SCANNER.nextInt();
        BillEntity bill = getBillInputs();
        bill.setId(id);
        billController.update(bill.getId(), bill);
        System.out.println("Bill with ID = " + id + "was updated\n");
    }

    private void deleteBill() throws SQLException {
        System.out.println("\nEnter bill ID to delete: ");
        Integer id = SCANNER.nextInt();
        billController.delete(id);
    }

    //#############################################################################

    private void getAllClientAccounts() throws SQLException {
        System.out.println("\n" + clientAccountController.findAll() + "\n");
    }

    private void getClientAccountByID() throws SQLException {
        System.out.println("\nEnter ID of client account: ");
        Integer id = SCANNER.nextInt();
        System.out.println(clientAccountController.findById(id) + "\n");
    }

    private ClientAccountEntity getClientAccountInputs() {
        System.out.println("\nEnter name: ");
        String name = SCANNER.next();
        System.out.println("\nEnter surname: ");
        String surname = SCANNER.next();
        System.out.println("\nEnter age: ");
        Integer age = SCANNER.nextInt();
        System.out.println("\nEnter gender: ");
        String gender = SCANNER.next();
        System.out.println("\nEnter phone: ");
        String phone = SCANNER.next();
        System.out.println("\nEnter email: ");
        String email = SCANNER.next();
        System.out.println("\nEnter debt: ");
        Integer debt = SCANNER.nextInt();
        System.out.println("\nEnter bonuses: ");
        Integer bonuses = SCANNER.nextInt();
        System.out.println("\nEnter blacklist: ");
        Integer blacklist = SCANNER.nextInt();
        Byte blacklistPresence = blacklist.byteValue();
        System.out.println("\nEnter animatorAgencyBusinessId: ");
        Integer animatorsAgencyByAnimatorsAgencyBusinessId = SCANNER.nextInt();
        return new ClientAccountEntity(name, surname, age, gender, phone, email, debt, bonuses, blacklistPresence, animatorsAgencyByAnimatorsAgencyBusinessId);
    }

    private void createClientAccount() throws SQLException {
        System.out.println("\n");
        ClientAccountEntity clientAccount = getClientAccountInputs();
        clientAccountController.create(clientAccount);
        System.out.println("ClientAccount chat was successfully created!\n");
    }

    private void updateClientAccount() throws SQLException {
        System.out.println("\nEnter ID of a client account to update: ");
        Integer id = SCANNER.nextInt();
        System.out.println("Enter client account ID for updating chat: ");
        Integer clientAccountId = SCANNER.nextInt();
        ClientAccountEntity clientAccount = getClientAccountInputs();
        clientAccount.setId(id);
        clientAccountController.update(clientAccount.getId(), clientAccount);
        System.out.println("Client account with ID = " + id + "was updated\n");
    }

    private void deleteClientAccount() throws SQLException {
        System.out.println("\nEnter ID to delete a client account: ");
        Integer id = SCANNER.nextInt();
        clientAccountController.delete(id);
    }

    //#######################################################################################

    private void getAllCountries() throws SQLException {
        System.out.println("\n" + countryController.findAll() + "\n");
    }

    private void getCountryById() throws SQLException {
        System.out.println("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(countryController.findById(id) + "\n");
    }

    private CountryEntity getCountryInputs() {
        System.out.println("\nEnter a country: ");
        String country = SCANNER.next();
        return new CountryEntity(country);
    }

    private void createCountry() throws SQLException {
        System.out.println("\n");
        CountryEntity country = getCountryInputs();
        countryController.create(country);
        System.out.println("Country was successfully created!\n");
    }

    private void updateCountry() throws SQLException {
        System.out.println("\nEnter ID to update: ");
        Integer id = SCANNER.nextInt();
        CountryEntity country = getCountryInputs();
        country.setId(id);
        countryController.update(country.getId(), country);
        System.out.println("Country with ID = " + id + "was updated\n");
    }

    private void deleteCountry() throws SQLException {
        System.out.println("\nEnter ID to delete country: ");
        Integer id = SCANNER.nextInt();
        countryController.delete(id);
    }

    //################################################################################

    private void getAllEvents() throws SQLException {
        System.out.println("\n" + eventController.findAll() + "\n");
    }

    private void getEventById() throws SQLException {
        System.out.println("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(eventController.findById(id) + "\n");
    }

    private EventEntity getEventInputs() {
        System.out.println("\nEnter title: ");
        String title = SCANNER.next();
        System.out.println("\nEnter subject: ");
        String subject = SCANNER.next();
        System.out.println("\nEnter guests number: ");
        Integer guestsNumber = SCANNER.nextInt();
        System.out.println("\nEnter address: ");
        String address = SCANNER.next();
        System.out.println("\nEnter date start: ");
        SCANNER.nextLine();
        String dateTimeStart = SCANNER.nextLine();
        Timestamp timestampStart = Timestamp.valueOf(dateTimeStart);
        System.out.println("\nEnter date end: ");
        String dateTimeEnd = SCANNER.nextLine();
        Timestamp timestampEnd = Timestamp.valueOf(dateTimeEnd);
        System.out.println("\nEnter time start: ");
        String timeStart = SCANNER.nextLine();
        Time startTime = Time.valueOf(timeStart);
        System.out.println("\nEnter time end: ");
        String timeEnd = SCANNER.nextLine();
        Time endTime = Time.valueOf(timeEnd);
        return new EventEntity(title, subject, guestsNumber, address, timestampStart, timestampEnd, startTime, endTime);
    }

    private void createEvent() throws SQLException {
        System.out.println("\n");
        EventEntity event = getEventInputs();
        eventController.create(event);
        System.out.println("Event was successfully created!\n");
    }

    private void updateEvent() throws SQLException {
        System.out.println("\nEnter ID to update: ");
        Integer id = SCANNER.nextInt();
        EventEntity event = getEventInputs();
        event.setId(id);
        eventController.update(event.getId(), event);
        System.out.println("Event with ID = " + id + "was updated\n");
    }

    private void deleteEvent() throws SQLException {
        System.out.println("\nEnter ID to delete event: ");
        Integer id = SCANNER.nextInt();
        eventController.delete(id);
    }

    //####################################################################################

    private void getAllFeedbacks() throws SQLException {
        System.out.println("\n" + feedbackController.findAll() + "\n");
    }

    private void getFeedbackById() throws SQLException {
        System.out.println("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(feedbackController.findById(id) + "\n");
    }

    private FeedbackEntity getFeedbackInputs() {
        System.out.println("\nEnter client: ");
        String client = SCANNER.next();
        System.out.println("\nEnter date: ");
        SCANNER.nextLine();
        String date = SCANNER.nextLine();
        Date formattedDate = Date.valueOf(date);
        System.out.println("\nEnter text: ");
        String text = SCANNER.next();
        System.out.println("Enter rate: ");
        Integer rate = SCANNER.nextInt();
        System.out.println("Enter eventId: ");
        Integer eventId = SCANNER.nextInt();
        System.out.println("Enter clientAccountByClientAccountId: ");
        Integer clientAccountByClientAccountId = SCANNER.nextInt();
        return new FeedbackEntity(client, formattedDate, text, rate, eventId, clientAccountByClientAccountId);
    }

    private void createFeedback() throws SQLException {
        System.out.println("\n");
        FeedbackEntity feedback = getFeedbackInputs();
        feedbackController.create(feedback);
        System.out.println("Feedback was successfully created!\n");
    }

    private void updateFeedback() throws SQLException {
        System.out.println("\nEnter ID to update: ");
        Integer id = SCANNER.nextInt();
        FeedbackEntity feedback = getFeedbackInputs();
        feedback.setEventId(id);
        feedbackController.update(feedback.getEventId(), feedback);
        System.out.println("Feedback with ID = " + id + "was updated\n");
    }

    private void deleteFeedback() throws SQLException {
        System.out.println("\nEnter ID to delete feedback: ");
        Integer id = SCANNER.nextInt();
        feedbackController.delete(id);
    }

    //##############################################################################

    private void getAllOrders() throws SQLException {
        System.out.println("\n" + orderController.findAll() + "\n");
    }

    private void getOrderById() throws SQLException {
        System.out.println("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(orderController.findById(id) + "\n");
    }

    private OrderEntity getOrderInputs() {
        System.out.println("\nEnter orderDatetime : ");
        String orderDatetime = SCANNER.next();
        Timestamp timestamp = Timestamp.valueOf(orderDatetime);
        System.out.println("Enter client: ");
        String client = SCANNER.next();
        System.out.println("Enter price: ");
        Integer price = SCANNER.nextInt();
        System.out.println("Enter amountOfAnimators: ");
        Integer amountOfAnimators = SCANNER.nextInt();
        System.out.println("Enter subject: ");
        String subject = SCANNER.next();
        System.out.println("Enter eventId: ");
        Integer eventId = SCANNER.nextInt();
        System.out.println("Enter billId: ");
        Integer billId = SCANNER.nextInt();
        System.out.println("Enter animatorsAgencyByAnimatorsAgencyBusinessId: ");
        Integer animatorsAgencyByAnimatorsAgencyBusinessId = SCANNER.nextInt();
        return new OrderEntity(timestamp, client, price, amountOfAnimators, subject, eventId, billId, animatorsAgencyByAnimatorsAgencyBusinessId);
    }

    private void createOrder() throws SQLException {
        System.out.println("\n");
        OrderEntity order = getOrderInputs();
        orderController.create(order);
        System.out.println("Order was successfully created!\n");
    }

    private void updateOrder() throws SQLException {
        System.out.println("\nEnter ID to update: ");
        Integer id = SCANNER.nextInt();
        OrderEntity order = getOrderInputs();
        order.setId(id);
        orderController.update(order.getId(), order);
        System.out.println("Order with ID = " + id + "was updated\n");
    }

    private void deleteOrder() throws SQLException {
        System.out.println("\nEnter ID to delete user: ");
        Integer id = SCANNER.nextInt();
        orderController.delete(id);
    }
}
