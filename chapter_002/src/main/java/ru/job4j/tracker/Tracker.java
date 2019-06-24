package ru.job4j.tracker;

import java.util.Random;

public class Tracker {
    /**
     * Объект класса Random используется для генерации id.
     */
    private static final Random RN = new Random();
    /**
     * Массив для хранение заявок.
     */
    private Item[] items = new Item[100];
    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализаущий добавление заявки в хранилище.
     *
     * @param item новая заявка.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[position++] = item;
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
        if (pos != -1) {
            this.items[pos] = item;
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
        Item[] tmp = new Item[100];
        if (pos != -1) {
            System.arraycopy(this.items, 0, tmp, 0, pos);
            System.arraycopy(this.items, pos + 1, tmp, pos, 100 - pos - 1);
            System.arraycopy(tmp, 0, items, 0, 100);
            position--;
            result = true;
        }
        return result;
    }

    /**
     * Метод возвращает все имеющиеся заявки.
     *
     * @return Массив заявок.
     */
    public Item[] findAll() {
        Item[] result = new Item[this.position];
        System.arraycopy(this.items, 0, result, 0, position);
        return result;
    }

    /**
     * Метод реализует поиск заявок по имени.
     *
     * @param key Имя заявки.
     * @return Массив заявок с именем key.
     */
    Item[] findByName(String key) {
        Item[] tmp = new Item[100];
        int count = 0;
        for (Item item : items) {
            if (item != null && item.getName().equals(key)) {
                tmp[count++] = item;
            }
        }
        Item[] result = new Item[count];
        System.arraycopy(tmp, 0, result, 0, count);
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
        for (int i = 0; i != items.length; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                result = i;
                break;
            }
        }
        return result;
    }

}
