package track.lessons.lesson3;

import java.util.NoSuchElementException;

/**
 * Должен наследовать List
 *
 * Должен иметь 2 конструктора
 * - без аргументов - создает внутренний массив дефолтного размера на ваш выбор
 * - с аргументом - начальный размер массива
 */
public class MyArrayList extends List {

    private int[] content;

    public MyArrayList() {
        this.content = new int[16];
    }

    public MyArrayList(int capacity) {
        this.content = new int[capacity];
    }

    @Override
    void add(int item) {
        if (this.size < this.content.length) {
            this.content[size++] = item;
        } else {
            int[] newContent = new int[content.length + 16];
            System.arraycopy(this.content,0,newContent,0,this.content.length);
            this.content = newContent;
            this.content[size++] = item;
        }
    }

    @Override
    int remove(int idx) throws NoSuchElementException {
        checkIndexRange(idx);
        int result = this.content[idx];
        if (this.size > 1) {
            System.arraycopy(this.content,idx + 1,this.content,idx,this.size - idx - 1);
        }
        this.size--;
        return result;
    }

    @Override
    int get(int idx) throws NoSuchElementException {
        checkIndexRange(idx);
        return this.content[idx];
    }
}
