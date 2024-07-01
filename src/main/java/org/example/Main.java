package org.example;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите дату в формате dd.MM.yyyy:");
        String dateString = scanner.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = null;

        try {
            date = dateFormat.parse(dateString);
        } catch (Exception e) {
            System.out.println("Неверный формат даты!");
            return;
        }

        System.out.println("Введенная дата: " + dateFormat.format(date));

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, 45);
        Date increasedDate = calendar.getTime();
        System.out.println("Увеличенная дата на 45 дней: " + dateFormat.format(increasedDate));

        calendar.set(Calendar.DAY_OF_YEAR, 1);
        Date startOfYearDate = calendar.getTime();
        System.out.println("Дата сдвинута на начало года: " + dateFormat.format(startOfYearDate));

        int workingDaysToAdd = 10;
        int daysAdded = 0;

        while (daysAdded < workingDaysToAdd) {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

            if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
                daysAdded++;
            }
        }

        Date increasedWorkingDaysDate = calendar.getTime();
        System.out.println("Увеличенная дата на 10 рабочих дней: " + dateFormat.format(increasedWorkingDaysDate));

        System.out.println("Введите вторую дату в формате dd.MM.yyyy:");
        String secondDateString = scanner.next();
        Date secondDate = null;

        try {
            secondDate = dateFormat.parse(secondDateString);
        } catch (Exception e) {
            System.out.println("Неверный формат второй даты!");
            return;
        }

        if (date.after(secondDate)) {
            Date temp = date;
            date = secondDate;
            secondDate = temp;
        }

        int workingDaysCount = 0;
        calendar.setTime(date);
        while (calendar.getTime().before(secondDate)) {
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

            if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
                workingDaysCount++;
            }

            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }

        System.out.println("Количество рабочих дней между первой и второй датами: " + workingDaysCount);

        scanner.close();
    }
}