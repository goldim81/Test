class ArrayList2 {
    private int capacity = 10;
    private Object[] arr;
    private int size = 0;

    public int getSize() {
        return size;
    }

    public ArrayList2() {
        arr = new Object[capacity];

    }

    public ArrayList2(int capacity) {
        if (capacity > 0) {
            this.capacity = capacity;
            arr = new Object[capacity];
        } else if (capacity == 0) {
            this.capacity = capacity;
            arr = new Object[]{};
        } else throw new IllegalArgumentException("Размер массива менее 0!");
    }

    private void checkAndEnlarge() {
        if (size==capacity) {
            int newCapacity = ((3*capacity)>>1) + 1;
            Object[] newArr = new Object[newCapacity];
            System.arraycopy(arr,0,newArr,0, size);
            arr = newArr;
        }
    }

    public void add(Object o) {
        checkAndEnlarge();
        arr[size++] = o;

    }

    public void add(int index, Object o) {
        checkIndexRange(index);
        checkAndEnlarge();
        System.arraycopy(arr, index, arr,index+1, size-index);
        size++;
        arr[index] = o;

    }

    public Object get(int index) {
        checkIndexRange(index);
        return arr[index];

    }

    public void set(int index, Object o) {
        checkIndexRange(index);
        arr[index] = o;
    }

    public void remove (int index) {
        checkIndexRange(index);
        System.arraycopy(arr, index+1, arr,index, size-index);

    }

    public boolean contains(Object o) {
        for (Object element:arr) {
            if (element.equals(o)) return true;
        }
        return false;
    }

    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(o)) return i;
        }
        return -1;
    }
    public int lastIndexOf (Object o) {
        for (int i = size-1; i >=0 ; i--) {
            if (arr[i].equals(o)) return i;
        }
        return -1;
    }

    private void checkIndexRange(int index) {
        if (index < 0 | index > size-1) throw new IllegalArgumentException("Индекс за границами массива.");
    }
}

class TestArrayList {
    public static void main(String[] args) {
        ArrayList2 list = new ArrayList2();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);

        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("добавляем элемент в позицию 3");
        list.add(3,11);
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("Удаляем элемент в позиции 3");
        list.remove(3);
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("Устанавливаем в позиции 3 новое значение");
        list.set(3, 11);
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("Ищем занчение 11 :" + list.contains(11));
        System.out.println("Ищем занчение 12 :" + list.contains(12));

        System.out.println("Индекс элемента со значением 11 с начала списка: " + list.indexOf(11));
        System.out.println("Индекс элемента со значением 11 с конца списка: " + list.lastIndexOf(11));



    }
}