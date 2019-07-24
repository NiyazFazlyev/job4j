package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Random;

public class Tracker {
    /**
     * Объект класса Random используется для генерации id.
     */
    private static final Random RN = new Random();
    /**
     * Массив для хранение заявок.
     */
    private ArrayList<Item> items = new ArrayList<>();

    /**
     * Метод реализаущий добавление заявки в хранилище.
     *
     * @param item новая заявка.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }

    /**
     * Метод реализует замену заявки по id.
     *
     * @param id   id заявки, которую нужно заменить.
     * @param item Новая заявка.
     * @return true если операция прошла успешно, иначе false.
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        int pos = findPosition(id);
        item.setId(id);
        if (pos != -1) {
            this.items.set(pos, item);
            //this.items[pos] = item;
            result = true;
        }
        return result;
    }

    /**
     * Метод реализует удаление заявки по id.
     *
     * @param id id заявки, которую нужно удалить.
     * @return true если операция прошла успешно, иначе false.
     */
    public boolean delete(String id) {
        boolean result = false;
        int pos = this.findPosition(id);
        if (pos != -1) {
            this.items.remove(pos);
            result = true;
        }
        return result;
    }

    /**
     * Метод возвращает все имеющиеся заявки.
     *
     * @return Массив заявок.
     */
    public ArrayList<Item> findAll() {
        return this.items;
    }

    /**
     * Метод реализует поиск заявок по имени.
     *
     * @param key Имя заявки.
     * @return Массив заявок с именем key.
     */
    ArrayList<Item> findByName(String key) {
        ArrayList<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item != null && item.getName().equals(key)) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Метод реализует поиск заявки по id.
     *
     * @param id id заявки, которую нужно найти.
     * @return Заявка с указанным id, null если такой заявки нет.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    private int findPosition(String id) {
        int result = -1;
//        for (int i = 0; i != items.length; i++) {
//            if (items[i] != null && items[i].getId().equals(id)) {
//                result = i;
//                break;
//            }
//        }
        int index = 0;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = index;
                break;
            }
            index++;
        }
        return result;
    }

}
